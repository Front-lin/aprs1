package com.aprs.controller;

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
import com.aprs.entity.Stock;
import com.aprs.service.StockService;
@Controller
public class StockController {
	private static Logger logger = Logger.getLogger(StockController.class);
	@Resource
	private StockService stockService;
	
	@RequestMapping(value="/getStock", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Stock> getStock(HttpServletResponse response,HttpServletRequest request){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
        List<Stock> list = null;
        int num = 0;
		list = stockService.getStock(start, length);
		num = stockService.getStockNum();
        DatatablesViewPage<Stock> view = new DatatablesViewPage<Stock>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
}
