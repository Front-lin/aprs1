package com.aprs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.aprs.dao.PurchaseDao;
import com.aprs.dao.PurchaseDetailDao;
import com.aprs.dao.ReleaseDao;
import com.aprs.entity.Purchase;
import com.aprs.entity.PurchaseDetail;
import com.aprs.entity.Release;
import com.aprs.service.PurchaseService;
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	@Resource
	private PurchaseDao purchaseDao;
	@Resource
	private PurchaseDetailDao purchaseDetailDao;
	@Resource
	private ReleaseDao releaseDao;
	
	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
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

	@Override
	public void purchase(String employee_id,int[] product_id, String[] releasedate, int[] price, int[] quantity, int pid, double sum) {
		// TODO Auto-generated method stub
		Purchase s = new Purchase(sdf.format(new Date()), employee_id,sum,pid);
		purchaseDao.insert(s);
		System.out.println(s.getPurchaseOrder_id());
		List<PurchaseDetail> list1 = new ArrayList<PurchaseDetail>();
		List<Release> list2 = new ArrayList<Release>();
		for(int i=0;i<product_id.length;i++){
			System.out.println(releasedate[i]);
			list1.add(new PurchaseDetail(s.getPurchaseOrder_id(), product_id[i], quantity[i], price[i]));
			list2.add(new Release(product_id[i], quantity[i], releasedate[i]));
			
		}
		purchaseDetailDao.purchase(list1);
		releaseDao.purchase(list2);
	}



}
