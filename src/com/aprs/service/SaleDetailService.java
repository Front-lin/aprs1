package com.aprs.service;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.SaleDetail;

public interface SaleDetailService {
	public DatatablesViewPage<SaleDetail> queryDetail(int id, int start, int end);
}
