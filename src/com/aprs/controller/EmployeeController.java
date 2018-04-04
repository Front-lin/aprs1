package com.aprs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aprs.entity.Employee;
import com.aprs.service.EmployeeService;
import com.aprs.service.SalerService;

@Controller
public class EmployeeController {
private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Resource
	private EmployeeService employeeService;
	@Resource
	private SalerService salerService;
	
	@RequestMapping(value="employeeLogin",method=RequestMethod.POST)
	public void employeeLogin(String id,String password,int value,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object obj = null;
		String key = null;
		try {
			//系统管理员登录
			if(value==1){
				obj = employeeService.login(id, password);
				key = "manager";
			}
			//收银员登录
			if(value==2){
				obj = salerService.login(id, password);
				key = "saler";
			}
		} catch (Exception e) {
			logger.info("login");
			e.printStackTrace();
		}finally{
			//返回登录身份给前端，前端跳转到对应的页面
			if(key!=null&&obj!=null){
				session.setAttribute(key, obj);
				out.print(key);
			}else {
				out.print("false");
			}
		}
	}
	@RequestMapping(value="/unlogin",method=RequestMethod.POST)
	public void unlogin(HttpServletRequest request){
		System.out.println("t");
		request.getSession().invalidate();
	}
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	public void adminpwd(String opwd,String npwd,HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Employee admin = (Employee)session.getAttribute("manager");
		System.out.println(admin);
		//判断信息不为空
		if(admin==null){
			out.print("false");
			return;
		}
		//判断旧密码是否一致
		if(!admin.getPassword().equals(opwd)){
			out.print("worng");
			return;
		}
		try {
			//更改密码
			admin.setPassword(npwd);
			employeeService.change(admin);
			out.print("true");
		} catch (Exception e) {
			logger.info("admin", e);
			out.print("false");
		}
	}
}
