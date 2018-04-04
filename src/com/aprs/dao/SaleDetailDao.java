package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.SaleDetail;

public interface SaleDetailDao {
	List<SaleDetail> queryDetail(int id, int start, int end);
	public int selectNum(int id);
	public void settle(@Param("saleDetails")List<SaleDetail> saleDetails);
}
