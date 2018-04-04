package com.aprs.service;

import java.util.List;

import com.aprs.entity.Classify;

public interface ClassifyService {
	public List<Classify> getClassify(int start,int end);
	public int getNum();
	public void delete(int cid);
	public void add(Classify classify);
	public List<Classify> getClassifyByNum(int pid);
}
