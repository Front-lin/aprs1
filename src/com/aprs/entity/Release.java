package com.aprs.entity;

public class Release {
	private int product_id;
	private double price;
	private int quantity;
	private String releasedate;
	
	public Release() {
		
	}
	public Release(int product_id,int quantity,String releasedate) {
		setProduct_id(product_id);
		setQuantity(quantity);
		setRelease(releasedate);
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setRelease(String releasedate) {
		this.releasedate = releasedate;
	}
	
	
}
