package com.aprs.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Saler;
import com.aprs.service.SalerService;

@Controller
public class SalerController {
	
	private static Logger logger = Logger.getLogger(SalerController.class);
	
	@Resource
	private SalerService salerService;

	@RequestMapping(value="/getSaler", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Saler> getSaler(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
        List<Saler> list = null;
        int num = 0;
        list = salerService.getSaler(start, length);
        num = salerService.getNum();
       
        DatatablesViewPage<Saler> view = new DatatablesViewPage<Saler>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	

	@RequestMapping(value="addSaler", method=RequestMethod.POST)
	public void addSaler(Saler saler,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//收银员信息为空，添加失败
			if(saler==null){
				out.print("false");
			}else {
				salerService.add(saler);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addSaler",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/deleteSaler", method=RequestMethod.POST)
	public void deleteSaler(int sid,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
				salerService.delete(sid);
		} catch (Exception e) {
			logger.info("delete �����ˣ�",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/updateSaler", method=RequestMethod.POST)
	public void updateSaler(Saler saler,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//收银员信息为空，修改失败
			if(saler==null){
				out.print("false");
			}else {
				salerService.updateSaler(saler);
			}	
		} catch (Exception e) {
			logger.info("update",e);
			out.print("false");
		}
	}
	
}
