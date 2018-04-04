package com.aprs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprs.dao.SaleDao;
import com.aprs.dao.SaleDetailDao;
import com.aprs.entity.Sale;
import com.aprs.entity.SaleDetail;
import com.aprs.service.SaleService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
@Service("saleService")
public class SaleServiceImpl implements SaleService {

	@Resource
	private SaleDao saleDao;
	
	@Resource
	private SaleDetailDao saleDetailDao;
	
	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
	
	@Override
	public List<Sale> getAll(int start, int end) {
		// TODO Auto-generated method stub

		return saleDao.getAll(start, end);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub

		return saleDao.getNum();
	}

	@Override
	public List<Sale> getByNo(int sale_id) {
		// TODO Auto-generated method stub

		return saleDao.getByNo(sale_id);
	}

	@Override
	public int getNumByArgs(String date) {
		// TODO Auto-generated method stub

		return saleDao.getNumByArgs(date);
		
	}

	@Override
	public List<Sale> getByArg(String date) {
		// TODO Auto-generated method stub
		return saleDao.getByArg(date);
	}

	@Override
	public void delete(int sale_id) {
		// TODO Auto-generated method stub

		saleDao.delete(sale_id);
	}

	@Override
	@Transactional
	public void settle(int[] arr, int[] num,double sum) throws MySQLIntegrityConstraintViolationException {
		Sale s = new Sale(sdf.format(new Date()), sum);
		saleDao.insert(s);
		System.out.println(s.getSale_id());
		List<SaleDetail> list = new ArrayList<SaleDetail>();
		for(int i=0;i<arr.length;i++){
			list.add(new SaleDetail(s.getSale_id(), arr[i], num[i]));
		}
		saleDetailDao.settle(list);
		
	}

}
