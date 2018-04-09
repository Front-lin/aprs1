package com.aprs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprs.dao.ReleaseDao;
import com.aprs.dao.SaleDao;
import com.aprs.dao.SaleDetailDao;
import com.aprs.entity.Release;
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
	
	@Resource
	private ReleaseDao releaseDao;
	
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
	public void settle(int[] product_id, int[] quantity,String[] releasedate,double sum) throws MySQLIntegrityConstraintViolationException {
		Sale s = new Sale(sdf.format(new Date()), sum);
		saleDao.insert(s);
		System.out.println(s.getSale_id());
		List<SaleDetail> list1 = new ArrayList<SaleDetail>();
		for(int i=0;i<product_id.length;i++){
			list1.add(new SaleDetail(s.getSale_id(), product_id[i], quantity[i]));
			releaseDao.settle(product_id[i],quantity[i],releasedate[i]);
		}
		saleDetailDao.settle(list1);
	}

}
