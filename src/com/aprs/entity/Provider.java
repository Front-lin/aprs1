package com.aprs.entity;

public class Provider {
	private int pid;
	private String pname;
	private String ptel;
	private String paddress;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	@Override
	public String toString() {
		return "Provider [pid=" + pid + ", pname=" + pname  + ", ptel=" + ptel + ", paddress=" + paddress
				+  "]";
	}
	
	
}
