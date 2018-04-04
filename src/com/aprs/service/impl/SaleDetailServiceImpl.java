package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.SaleDetailDao;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.entity.SaleDetail;
import com.aprs.service.SaleDetailService;
@Service("saleDetailService")
public class SaleDetailServiceImpl implements SaleDetailService {

	@Resource
	private SaleDetailDao saleDetailDao;

	@Override
	public DatatablesViewPage<SaleDetail> queryDetail(int id, int start, int end) {
		// TODO Auto-generated method stub
		List<SaleDetail> list = saleDetailDao.queryDetail(id, start, end);
		DatatablesViewPage<SaleDetail> view = new DatatablesViewPage<SaleDetail>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(saleDetailDao.selectNum(id));
		view.setiTotalRecords(5);
		return view;
	}

	
	

}
