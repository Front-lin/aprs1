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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Purchase;
import com.aprs.service.PurchaseService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Controller
public class PurchaseController {
	@Resource
	private PurchaseService purchaseService;
	
	private static Logger logger = Logger.getLogger(PurchaseController.class);
	@RequestMapping(value="/getPurchase", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Purchase> getPurchase(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		System.out.println(123);
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Purchase> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = purchaseService.getAll(start, length);
        	num = purchaseService.getNum();
        } else if (state.equals("1")) {
			list = purchaseService.getByNo(Integer.parseInt(request.getParameter("purchaseOrder_id")));
			num = 1;
		}else if (state.equals("2")) {
			String date = request.getParameter("date");
			num = purchaseService.getNumByArgs(date);
			list = purchaseService.getByArg(date);
		}else {
			return null;
		}
        DatatablesViewPage<Purchase> view = new DatatablesViewPage<Purchase>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	
	@RequestMapping(value="/deletePurchase", method=RequestMethod.POST)
	public void deletePurchase(int purchaseOrder_id,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
				purchaseService.delete(purchaseOrder_id);
				out.print("true");	
		} catch (Exception e) {
			logger.info("delete",e);
			out.print("false");
		}
	}
	}/*@RequestMapping(value="/purchase", method=RequestMethod.POST)
	public void purchase(@RequestParam(value = "cid[]") int[] cid, @RequestParam(value = "name[]") int[] name,
			@RequestParam(value = "spec[]") int[] spec,@RequestParam(value = "date") int[] date,
			@RequestParam(value = "money[]") int[] money,@RequestParam(value = "quantity[]") int[] quantity,
			double sum, HttpServletResponse response) throws IOException{
		logger.info("采购");
		PrintWriter out = response.getWriter();
		try {
			purchaseService.settle(arr,count,sum);
			out.print("true");	
		}catch(MySQLIntegrityConstraintViolationException e) {
			out.print("none");
		}catch(Exception e) {
			System.out.print(e);
			out.print("false");
		
	}*/

