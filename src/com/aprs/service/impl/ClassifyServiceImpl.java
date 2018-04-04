package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ClassifyDao;
import com.aprs.entity.Classify;
import com.aprs.service.ClassifyService;
@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {

	@Resource
	private ClassifyDao classifyDao;

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return classifyDao.getNum();
	}

	@Override
	public List<Classify> getClassify(int start, int end) {
		// TODO Auto-generated method stub
		return classifyDao.getClassify(start, end);
	}

	@Override
	public void add(Classify classify) {
		// TODO Auto-generated method stub
		classifyDao.add(classify);
	}


	@Override
	public void delete(int cid) {
		// TODO Auto-generated method stub
		classifyDao.delete(cid);
		
	}

	@Override
	public List<Classify> getClassifyByNum(int pid) {
		// TODO Auto-generated method stub
		return classifyDao.getClassifyByNum(pid);
	}



}
