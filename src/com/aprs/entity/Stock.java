package com.aprs.entity;

public class Stock {
	private int product_id;
	private String name;
	private int product_spec;
	private int stock;
	private int saleNum;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProduct_spec() {
		return product_spec;
	}
	public void setProduct_spec(int product_spec) {
		this.product_spec = product_spec;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	
	
}
