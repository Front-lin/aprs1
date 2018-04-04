package com.aprs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.Classify;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Product;
import com.aprs.entity.Provider;
import com.aprs.service.ClassifyDetailService;
import com.aprs.service.ClassifyService;

@Controller
public class ClassifyController {
	@Resource
	private ClassifyService classifyService;
	@Resource
	private ClassifyDetailService classifyDetailService;
	
	private static Logger logger = Logger.getLogger(ClassifyController.class);
	@RequestMapping(value="/getClassify", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Classify> getClassify(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        List<Classify> list = null;
        int num = 0; //数据库中类别的数量
        list = classifyService.getClassify(start, length);
        num = classifyService.getNum();
      
        DatatablesViewPage<Classify> view = new DatatablesViewPage<Classify>();
        view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	@RequestMapping(value="/getClassifyItem", method=RequestMethod.GET)
	@ResponseBody
	public List<Classify> getClassifyItem(HttpServletRequest request,HttpServletResponse response){
		response.reset();
        int pid = Integer.parseInt(request.getParameter("pid"));
        return classifyService.getClassifyByNum(pid);
	}
	
	@RequestMapping(value="/deleteClassify", method=RequestMethod.POST)
	public void deleteClassify(int cid,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			classifyDetailService.delete(cid);
			classifyService.delete(cid);
				out.print("true");	
		} catch (Exception e) {
			logger.info("delete",e);
			out.print("false");
		}
	}
	@RequestMapping(value="addClassify", method=RequestMethod.POST)
	public void addClassify(Classify classify,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//类别信息为空，增加失败
			if(classify==null){
				out.print("false");
			}else {
				classifyService.add(classify);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addclassify",e);
			out.print("false");
		}
	}
}
