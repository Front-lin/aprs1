package com.aprs.dao;

import java.util.List;

import com.aprs.entity.ClassifyDetail;

public interface ClassifyDetailDao {
	public void delete(int cid);
	public void deleteDetail(int cid);
	public void add(ClassifyDetail classifyDetail);
	List<ClassifyDetail> queryDetail(int id, int start, int end);
	public int selectNum(int id);
	public List<ClassifyDetail> getProductByNum(int cid);
}
