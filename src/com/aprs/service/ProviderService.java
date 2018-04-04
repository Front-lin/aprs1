package com.aprs.service;

import java.util.List;

import com.aprs.entity.Provider;

public interface ProviderService {
	public int getNum();
	public List<Provider> getProvider(int start,int end);
	public void add(Provider provider);
	public void updateProvider(Provider provider);
	public void delete(int pid);
	public List<Provider> getProviderItem();
}
