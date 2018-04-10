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

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Expired;
import com.aprs.service.ExpiredService;
@Controller
public class ExpiredController {
	private static Logger logger = Logger.getLogger(ExpiredController.class);
	@Resource
	private ExpiredService expiredService;
	
	@RequestMapping(value="/getExpired", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Expired> getExpired(HttpServletResponse response,HttpServletRequest request){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
        List<Expired> list = null;
        int num = 0;
		list = expiredService.getExpired(start, length);
		num = expiredService.getExpiredNum();
        DatatablesViewPage<Expired> view = new DatatablesViewPage<Expired>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	@RequestMapping(value="/deleteExpired", method=RequestMethod.POST)
	public void deleteExpired(int product_id,String releasedate,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			expiredService.delete(product_id,releasedate);
		} catch (Exception e) {
			logger.info("deleteExpired",e);
			out.print("false");
		}
	}
}
