package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Release;

public interface ReleaseDao {
	public void purchase(@Param("releases")List<Release> releases);

	public void settle(@Param("product_id")int product_id,@Param("quantity")int quantity,@Param("releasedate")String releasedate);
}
