package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.PurchaseDao;
import com.aprs.entity.Purchase;
import com.aprs.service.PurchaseService;
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	@Resource
	private PurchaseDao purchaseDao;
	
	@Override
	public List<Purchase> getAll(int start, int end) {
		// TODO Auto-generated method stub

		return purchaseDao.getAll(start, end);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub

		return purchaseDao.getNum();
	}

	@Override
	public List<Purchase> getByNo(int purchaseOrder_id) {
		// TODO Auto-generated method stub

		return purchaseDao.getByNo(purchaseOrder_id);
	}

	@Override
	public int getNumByArgs(String date) {
		// TODO Auto-generated method stub

		return purchaseDao.getNumByArgs(date);
		
	}

	@Override
	public List<Purchase> getByArg(String date) {
		// TODO Auto-generated method stub
		return purchaseDao.getByArg(date);
	}

	@Override
	public void delete(int purchaseOrder_id) {
		// TODO Auto-generated method stub

		purchaseDao.delete(purchaseOrder_id);
	}

}
