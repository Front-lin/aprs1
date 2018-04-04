package com.aprs.entity;

public class Sale {
	private int sale_id;
	private String sale_date;
	private double sum;
	public Sale(){
		
	}
	public Sale(String sale_date, double sum){
		setSale_date(sale_date);
		setSum(sum);
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}
