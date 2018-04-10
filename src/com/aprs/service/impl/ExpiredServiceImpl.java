package com.aprs.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ExpiredDao;
import com.aprs.entity.Expired;
import com.aprs.service.ExpiredService;
@Service("expiredService")
public class ExpiredServiceImpl implements ExpiredService {

	@Resource
	private ExpiredDao expiredDao;

	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
	String today = sdf.format(new Date());
	
	@Override
	public List<Expired> getExpired(int start, int end) {
		// TODO Auto-generated method stub
		System.out.print(today);
		return expiredDao.getExpired(today,start,end);
	}

	@Override
	public int getExpiredNum() {
		return expiredDao.getExpiredNum(today);
	}

	@Override
	public void delete(int product_id,String releasedate) {
		// TODO Auto-generated method stub
		expiredDao.delete(product_id,releasedate);
	}
}
