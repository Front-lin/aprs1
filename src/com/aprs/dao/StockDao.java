package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Stock;

public interface StockDao {
	public List<Stock> getStock(@Param("before")String before,@Param("today")String today,@Param("start")int start,@Param("end")int end);
	public int getStockNum(@Param("before")String before,@Param("today")String today);
}
