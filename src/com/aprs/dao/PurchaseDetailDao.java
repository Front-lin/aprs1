package com.aprs.dao;

import java.util.List;

import com.aprs.entity.PurchaseDetail;

public interface PurchaseDetailDao {
	List<PurchaseDetail> queryDetail(int id, int start, int end);
	public int selectNum(int id);
}
