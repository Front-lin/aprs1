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
import com.aprs.entity.PurchaseDetail;
import com.aprs.service.PurchaseDetailService;
@Controller
public class PurchaseDetailController {
	private static Logger logger = Logger.getLogger(PurchaseDetailController.class);
	@Resource
	private PurchaseDetailService purchaseDetailService;
	
	@RequestMapping(value="/getPurchaseDetail", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<PurchaseDetail> getPurchaseDetail(int id,HttpServletResponse response,HttpServletRequest request){
		response.reset();
		try {
			int start =Integer.parseInt(request.getParameter("start"));    
	        int length = Integer.parseInt(request.getParameter("length"));
			DatatablesViewPage<PurchaseDetail> view = purchaseDetailService.queryDetail(id, start, length);
			return view;
		} catch (Exception e) {
			logger.info("saleDetail",e);
			return null;
		}
	}
}
