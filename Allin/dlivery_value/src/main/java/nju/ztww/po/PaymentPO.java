package nju.ztww.po;

import java.io.Serializable;

public class PaymentPO implements Serializable{
	private String date;
	private double money;
	private String paymen;
	private String payaccount;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPaymen() {
		return paymen;
	}
	public void setPaymen(String paymen) {
		this.paymen = paymen;
	}
	public String getPayaccount() {
		return payaccount;
	}
	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}
	public String getPaycat() {
		return paycat;
	}
	public void setPaycat(String paycat) {
		this.paycat = paycat;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	private String paycat;
	private String ps;
}
