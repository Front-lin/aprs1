package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Purchase;

public interface PurchaseDao {
	public int getNum();
	public int getNumByArgs(@Param("date")String date);
	public List<Purchase> getAll(int start,int end);
	public List<Purchase> getByNo(int purchaesOrder_id);
	public List<Purchase> getByArg(@Param("date")String date);
	public void delete(int purchaesOrder_id);
	public int insert(Purchase s);
}
