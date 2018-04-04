package com.aprs.service;

import java.util.List;

import com.aprs.entity.Saler;

public interface SalerService {
	public Saler login(String id,String password);
	public int getNum();
	public List<Saler> getSaler(int start,int end);
	public void add(Saler saler);
	public void updateSaler(Saler saler);
	public void delete(int sid);
}
