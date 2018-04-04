package com.aprs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aprs.entity.Product;

public interface ProductDao {
	public int getNum();
	public List<Product> getAllProduct(@Param("start")int start,@Param("end")int end);
	public List<Product> getProductByName(@Param("name")String name);
	public void add(Product product);
	public void updateSale(Product product);
	public void updateQuantity(Product product);
	public void delete(int product_id);
	public List<Product> getByNum(int product_id);
	public int getByNameNum(String name);
	public List<Product> getByName(@Param("start")int start,@Param("end")int end,@Param("name")String name);
}
