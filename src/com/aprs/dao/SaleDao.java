package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Sale;

public interface SaleDao {
	public int getNum();
	public int getNumByArgs(@Param("sale_date")String sale_date);
	public List<Sale> getAll(int start,int end);
	public List<Sale> getByNo(int sale_id);
	public List<Sale> getByArg(@Param("sale_date")String sale_date);
	public void delete(int sale_id);
	public int insert(Sale sale);
}
