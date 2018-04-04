package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Provider;

public interface ProviderDao {
	public int getNum();
	public List<Provider> getProvider(@Param("start")int start,@Param("end")int end);
	public void add(Provider provider);
	public void updateProvider(Provider provider);
	public void delete(int pid);
	public List<Provider> getProviderItem();
}
