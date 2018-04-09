package com.aprs.service;

import java.util.List;

import com.aprs.entity.Stock;

public interface StockService {
	public List<Stock> getStock(int start, int end);

	public int getStockNum();
}
