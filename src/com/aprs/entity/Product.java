package com.aprs.entity;

public class Product {
	private int product_id;
	private String name;
	private int product_spec;
	private double sale_price;
	private int quantity;
	public Product(){
		
	}
	public Product(int product_id,String name,int product_spec,double sale_price,int quantity){
		this.product_id = product_id;
		this.name = name;
		this.product_spec = product_spec;
		this.sale_price = sale_price;
		this.quantity = quantity;
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
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
