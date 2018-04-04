package com.aprs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.SaleDetail;
import com.aprs.service.SaleDetailService;
@Controller
public class SaleDetailController {
	private static Logger logger = Logger.getLogger(SaleDetailController.class);
	@Resource
	private SaleDetailService saleDetailService;
	
	@RequestMapping(value="/getSaleDetail", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<SaleDetail> getSaleDetail(int id,HttpServletResponse response,HttpServletRequest request){
		response.reset();
		try {
			int start =Integer.parseInt(request.getParameter("start"));    
	        int length = Integer.parseInt(request.getParameter("length"));
			DatatablesViewPage<SaleDetail> view = saleDetailService.queryDetail(id, start, length);
			return view;
		} catch (Exception e) {
			logger.info("saleDetail",e);
			return null;
		}
	}
}
