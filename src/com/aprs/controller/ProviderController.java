package com.aprs.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.Provider;
import com.aprs.service.ProviderService;

@Controller
public class ProviderController {
	
	private static Logger logger = Logger.getLogger(ProviderController.class);
	
	@Resource
	private ProviderService providerService;

	@RequestMapping(value="/getProvider", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Provider> getProvider(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));
        List<Provider> list = null;
        int num = 0;
        list = providerService.getProvider(start, length);
        num = providerService.getNum();
       
        DatatablesViewPage<Provider> view = new DatatablesViewPage<Provider>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	
	@RequestMapping(value="/getProviderItem",method=RequestMethod.GET)
	@ResponseBody
	public List<Provider> getProviderItem(HttpServletRequest request,HttpServletResponse response) {
		response.reset();
        return providerService.getProviderItem(); 
	}

	@RequestMapping(value="addProvider", method=RequestMethod.POST)
	public void addProvider(Provider provider,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//供应商信息为空，添加失败
			if(provider==null){
				out.print("false");
			}else {
				providerService.add(provider);
				out.print("true");
			}	
		}
		catch (Exception e) {
			logger.info("addProvider",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/deleteProvider", method=RequestMethod.POST)
	public void deleteProvider(int pid,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
				providerService.delete(pid);
		} catch (Exception e) {
			logger.info("deleteprovider �����ˣ�",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/updateProvider", method=RequestMethod.POST)
	public void updateProvider(Provider provider,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			//供应商信息为空，修改失败
			if(provider==null){
				out.print("false");
			}else {
				providerService.updateProvider(provider);
			}	
		} catch (Exception e) {
			logger.info("updateProvider",e);
			out.print("false");
		}
	}
	

}
