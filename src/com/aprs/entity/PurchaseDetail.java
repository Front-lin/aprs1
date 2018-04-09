package com.aprs.entity;

public class PurchaseDetail {
	private int product_id;
	private String name;
	private String cname;
	private int product_spec;
	private double price;
	private int quantity;
	private int purchaseOrder_id;
	public PurchaseDetail() {
		
	}
	public PurchaseDetail(int purchaseOrder_id, int product_id, int quantity,double price){
		setPurchaseOrder_id(purchaseOrder_id);
		setProduct_id(product_id);
		setQuantity(quantity);
		setPrice(price);
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getProduct_spec() {
		return product_spec;
	}
	public void setProduct_spec(int product_spec) {
		this.product_spec = product_spec;
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
	public int getPurchaseOrder_id() {
		return purchaseOrder_id;
	}
	public void setPurchaseOrder_id(int purchaseOrder_id) {
		this.purchaseOrder_id = purchaseOrder_id;
	}
	
	
}
