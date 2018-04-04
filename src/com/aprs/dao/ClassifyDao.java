package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Classify;

public interface ClassifyDao {
	public int getNum();
	public List<Classify> getClassify(@Param("start")int start,@Param("end")int end);
	public void add(Classify classify);
	public void delete(int cid);
	public List<Classify> getClassifyByNum(@Param("pid")int pid);
}
