package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Saler;


public interface SalerDao {
	public Saler login(@Param("sid")String id,@Param("spassword")String password);
	public int getNum();
	public List<Saler> getSaler(@Param("start")int start,@Param("end")int end);
	public void add(Saler saler);
	public void updateSaler(Saler saler);
	public void delete(int sid);
}
