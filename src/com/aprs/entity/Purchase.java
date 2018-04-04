package com.aprs.entity;

import java.sql.Date;

public class Purchase {
	
	private int purchaseOrder_id;
	private Date date;
	private String employee_name;
	private int product_id;
	private int purchase_quantity;
	private double price;
	private String name;
	private int product_spec;
	
	public int getPurchaseOrder_id() {
		return purchaseOrder_id;
	}
	public void setPurchaseOrder_id(int purchaseOrder_id) {
		this.purchaseOrder_id = purchaseOrder_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPurchase_quantity() {
		return purchase_quantity;
	}
	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProduct_spec() {
		return product_spec;
	}
	public void setProduct_spec(int product_spec) {
		this.product_spec = product_spec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
