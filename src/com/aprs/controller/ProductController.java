package com.aprs.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Product;
import com.aprs.service.ProductService;

@Controller
public class ProductController {
	
	private static Logger logger = Logger.getLogger(ProductController.class);
	
	@Resource
	private ProductService productService;

	@RequestMapping(value="/getAllProduct", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Product> getAllProduct(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
        String state = request.getParameter("state");
        List<Product> list = null;
        int num = 0;
        //显示所有农产品
        if (state.equals("0")){
        	list = productService.getAllProduct(start, length);
        	num = productService.getNum();
        } 
        //显示指定id农产品
        else if (state.equals("1")) {
        		int product_id = Integer.parseInt(request.getParameter("product_id"));
        		list = productService.getByNum(product_id);
        		num = 1;
        	 }
        //显示指定名称的农产品
        else if (state.equals("2")) {
        	request.setCharacterEncoding("utf-8");
        	String name =new String(request.getParameter("name").getBytes("iso8859-1"),"utf-8");
	        
	        	System.out.print(name);
	        	num = productService.getByArgNum(name);
	        	list = productService.getByArg(start, length, name);
        	}else {
        		return null;
        	}
        DatatablesViewPage<Product> view = new DatatablesViewPage<Product>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	

	@RequestMapping(value="addProduct", method=RequestMethod.POST)
	public void addProduct(Product product,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(product==null){
				out.print("false");
			}else {
				productService.add(product);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addProduct",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
	public void deleteProduct(int product_id,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
				productService.delete(product_id);
		} catch (Exception e) {
			logger.info("deleteStudents �����ˣ�",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/updateSale", method=RequestMethod.POST)
	public void updateSale(Product product,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//农产品信息为空不能修改
			if(product==null){
				out.print("false");
			}else {
				productService.updateSale(product);
			}	
		} catch (Exception e) {
			logger.info("updateSale �����ˣ�",e);
			out.print("false");
		}
	}
	
}
