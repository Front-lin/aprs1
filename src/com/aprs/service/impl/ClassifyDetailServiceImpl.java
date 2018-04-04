package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ClassifyDetailDao;
import com.aprs.entity.ClassifyDetail;
import com.aprs.entity.DatatablesViewPage;
import com.aprs.service.ClassifyDetailService;
@Service("classifyDetailService")
public class ClassifyDetailServiceImpl implements ClassifyDetailService {

	@Resource
	private ClassifyDetailDao classifyDetailDao;

	


	@Override
	public void delete(int cid) {
		// TODO Auto-generated method stub
		classifyDetailDao.delete(cid);
		
	}




	@Override
	public DatatablesViewPage<ClassifyDetail> queryDetail(int id, int start,
			int end) {
		// TODO Auto-generated method stub
		List<ClassifyDetail> list = classifyDetailDao.queryDetail(id, start, end);
		DatatablesViewPage<ClassifyDetail> view = new DatatablesViewPage<ClassifyDetail>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(classifyDetailDao.selectNum(id));
		view.setiTotalRecords(5);
		return view;
	}




	@Override
	public void deleteDetail(int cid) {
		// TODO Auto-generated method stub
		classifyDetailDao.deleteDetail(cid);
	}




	@Override
	public void add(ClassifyDetail classifyDetail) {
		// TODO Auto-generated method stub
		classifyDetailDao.add(classifyDetail);
	}




	@Override
	public List<ClassifyDetail> getProductByNum(int cid) {
		// TODO Auto-generated method stub
		return classifyDetailDao.getProductByNum(cid);
	}



}
