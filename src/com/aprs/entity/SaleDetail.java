package com.aprs.entity;

public class SaleDetail {
	private int sale_id;
	private int product_id;
	private String name;
	private int product_spec;
	private int quantity;
	private double sale_price;
	public SaleDetail(){
		
	}
	public SaleDetail(int sale_id, int product_id, int quantity){
		setSale_id(sale_id);
		setProduct_id(product_id);
		setQuantity(quantity);
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	
}
