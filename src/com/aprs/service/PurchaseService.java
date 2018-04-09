package com.aprs.service;

import java.util.List;

import com.aprs.entity.Purchase;

public interface PurchaseService {
	public List<Purchase> getAll(int start,int end);
	public int getNum();
	public List<Purchase> getByNo(int purchaseOrder_id);
	public int getNumByArgs(String date);
	public List<Purchase> getByArg(String date);
	public void delete(int purchaseOrder_id);
	public void purchase(String employee_id, int[] product_id, String[] release, int[] price, int[] quantity, int pid, double sum);
}
