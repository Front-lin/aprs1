package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.PurchaseDetail;

public interface PurchaseDetailDao {
	List<PurchaseDetail> queryDetail(int id, int start, int end);
	public int selectNum(int id);
	public void purchase(@Param("purchaseDetails")List<PurchaseDetail> purchaseDetails);
}
