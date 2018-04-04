package com.aprs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aprs.dao.ProviderDao;
import com.aprs.entity.Provider;
import com.aprs.service.ProviderService;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

	@Resource
	private ProviderDao providerDao;

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return providerDao.getNum();
	}

	@Override
	public List<Provider> getProvider(int start, int end) {
		// TODO Auto-generated method stub
		return providerDao.getProvider(start, end);
	}

	@Override
	public void add(Provider provider) {
		// TODO Auto-generated method stub
		providerDao.add(provider);
	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerDao.updateProvider(provider);
		
	}

	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		providerDao.delete(pid);
		
	}

	@Override
	public List<Provider> getProviderItem() {
		// TODO Auto-generated method stub
		return providerDao.getProviderItem();
	}
	
	
}
