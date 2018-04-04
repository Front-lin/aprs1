package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.SalerDao;
import com.aprs.entity.Saler;
import com.aprs.service.SalerService;

@Service("salerService")
public class SalerServiceImpl implements SalerService {

	@Resource
	private SalerDao salerDao;
	
	public Saler login(String id, String password) {
		// TODO Auto-generated method stub
		return salerDao.login(id,password);
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return salerDao.getNum();
	}


	@Override
	public void add(Saler saler) {
		// TODO Auto-generated method stub
		salerDao.add(saler);
		
	}

	@Override
	public void updateSaler(Saler saler) {
		// TODO Auto-generated method stub
		salerDao.updateSaler(saler);
		
	}

	@Override
	public void delete(int sid) {
		// TODO Auto-generated method stub
		salerDao.delete(sid);
		
	}


	@Override
	public List<Saler> getSaler(int start, int end) {
		// TODO Auto-generated method stub
		return salerDao.getSaler(start, end);
	}

}
