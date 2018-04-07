package com.aprs.service;

import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.PurchaseDetail;

public interface PurchaseDetailService {
	public DatatablesViewPage<PurchaseDetail> queryDetail(int id, int start, int end);
}
