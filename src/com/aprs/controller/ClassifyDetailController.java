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
import com.aprs.entity.ClassifyDetail;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.service.ClassifyDetailService;
@Controller
public class ClassifyDetailController {
	private static Logger logger = Logger.getLogger(ClassifyDetailController.class);
	@Resource
	private ClassifyDetailService classifyDetailService;
	
	@RequestMapping(value="/getClassifyDetail", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<ClassifyDetail> getClassifyDetail(int id,HttpServletResponse response,HttpServletRequest request){
		response.reset();
		try {
			int start =Integer.parseInt(request.getParameter("start"));    
	        int length = Integer.parseInt(request.getParameter("length"));
			DatatablesViewPage<ClassifyDetail> view = classifyDetailService.queryDetail(id, start, length);
			return view;
		} catch (Exception e) {
			logger.info("classifyDetail",e);
			return null;
		}
	}
	@RequestMapping(value="/getProductItem", method=RequestMethod.GET)
	@ResponseBody
	public List<ClassifyDetail> getProductItem(HttpServletRequest request,HttpServletResponse response){
		response.reset();
        int cid = Integer.parseInt(request.getParameter("cid"));
        return classifyDetailService.getProductByNum(cid);
	}
	@RequestMapping(value="/deleteClassifyDetail", method=RequestMethod.POST)
	public void deleteClassifyDetail(int did,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			classifyDetailService.deleteDetail(did);
				out.print("true");	
		} catch (Exception e) {
			logger.info("delete",e);
			out.print("false");
		}
	}
	@RequestMapping(value="addClassifyDetail", method=RequestMethod.POST)
	public void addClassifyDetail(ClassifyDetail classifyDetail,HttpServletResponse response) throws IOException{
		System.out.println(111);
		PrintWriter out = response.getWriter();
		try {
			if(classifyDetail==null){
				out.print("false");
			}else {
				classifyDetailService.add(classifyDetail);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addclassifyDetail",e);
			out.print("false");
		}
	}
}
