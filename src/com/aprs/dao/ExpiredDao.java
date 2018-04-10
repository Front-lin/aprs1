package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Expired;

public interface ExpiredDao {
	public List<Expired> getExpired(@Param("today")String today,@Param("start")int start,@Param("end")int end);
	public int getExpiredNum(@Param("today")String today);
	public void delete(@Param("product_id")int product_id,@Param("releasedate")String releasedate);
}
