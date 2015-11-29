package nju.ztww.dao;

public class PayeeFormDO {
	private int index;
	private String id;
	private String goodsid;
	private String courierid;
	private double money;
	private int exe;
	private int state;
	private String date;
	private String holl;

	public String getHoll() {
		return holl;
	}

	public void setHoll(String holl) {
		this.holl = holl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getCourierid() {
		return courierid;
	}

	public void setCourierid(String courierid) {
		this.courierid = courierid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

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
}
