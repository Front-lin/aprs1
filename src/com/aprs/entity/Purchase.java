package com.aprs.entity;

import java.sql.Date;

public class Purchase {
	
	private int purchaseOrder_id;
	private String date;
	private String employee_id;
	private int product_id;
	private int purchase_quantity;
	private double price;
	private String name;
	private int product_spec;
	private int pid;
	private String provider;
	private String pname;
	private int quantity;
	private double release;
	public Purchase() {
		
	}
	public Purchase(String date, String employee_id,double sum,int pid){
		setDate(date);
		setEmployee_id(employee_id);
		setPrice(sum);
		setPid(pid);
	}
	public int getPurchaseOrder_id() {
		return purchaseOrder_id;
	}
	public void setPurchaseOrder_id(int purchaseOrder_id) {
		this.purchaseOrder_id = purchaseOrder_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_name(String employee_id) {
		this.employee_id = employee_id;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRelease() {
		return release;
	}
	public void setRelease(double release) {
		this.release = release;
	}
	
	
}
