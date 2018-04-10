package com.aprs.service;

import java.util.List;

import com.aprs.entity.Expired;

public interface ExpiredService {
	public List<Expired> getExpired(int start, int end);

	public int getExpiredNum();

	public void delete(int product_id, String releasedate);
}
