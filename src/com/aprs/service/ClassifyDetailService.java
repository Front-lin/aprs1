package com.aprs.service;

import java.util.List;

import com.aprs.entity.ClassifyDetail;
import com.aprs.entity.DatatablesViewPage;

public interface ClassifyDetailService {
	public void delete(int cid);
	public void deleteDetail(int cid);
	public void add(ClassifyDetail classifyDetail );
	public DatatablesViewPage<ClassifyDetail> queryDetail(int id, int start, int end);
	public List<ClassifyDetail> getProductByNum(int cid);
	public List<ClassifyDetail> getSpec(int cid, String name);
}
