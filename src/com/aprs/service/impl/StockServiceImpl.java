package com.aprs.service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.StockDao;
import com.aprs.entity.Stock;
import com.aprs.service.StockService;
@Service("stockService")
public class StockServiceImpl implements StockService {

	@Resource
	private StockDao stockDao;

	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
	
	
	@Override
	public List<Stock> getStock(int start, int end) {
		// TODO Auto-generated method stub
		
		String today = sdf.format(new Date());
	    // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
	    Date date = sdf.parse(today, new ParsePosition(0));
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
	    calendar.add(Calendar.DATE, -4);
	    Date date1 = calendar.getTime();
	    String before = sdf.format(date1);
		return stockDao.getStock(before,today,start,end);
	}

	@Override
	public int getStockNum() {
		// TODO Auto-generated method stub
		String today = sdf.format(new Date());
	    // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
	    Date date = sdf.parse(today, new ParsePosition(0));
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
	    calendar.add(Calendar.DATE, -4);
	    Date date1 = calendar.getTime();
	    String before = sdf.format(date1);
		return stockDao.getStockNum(before,today);
	}
}
