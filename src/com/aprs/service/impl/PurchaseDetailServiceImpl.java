package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.PurchaseDetailDao;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.PurchaseDetail;
import com.aprs.service.PurchaseDetailService;
@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

	@Resource
	private PurchaseDetailDao purchaseDetailDao;

	@Override
	public DatatablesViewPage<PurchaseDetail> queryDetail(int id, int start, int end) {
		// TODO Auto-generated method stub
		List<PurchaseDetail> list = purchaseDetailDao.queryDetail(id, start, end);
		DatatablesViewPage<PurchaseDetail> view = new DatatablesViewPage<PurchaseDetail>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(purchaseDetailDao.selectNum(id));
		view.setiTotalRecords(5);
		return view;
	}

	
	

}
