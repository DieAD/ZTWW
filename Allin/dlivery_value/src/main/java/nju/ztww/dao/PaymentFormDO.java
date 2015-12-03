package nju.ztww.dao;

public class PaymentFormDO {
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	private String id;
	private String date;

	public int getExe() {
		return exe;
	}

	public void setExe(int exe) {
		this.exe = exe;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private double money;
	private String paymen;
	private String payaccount;
	private String paycat;
	private String ps;
	private int exe;
	private int state;
}
