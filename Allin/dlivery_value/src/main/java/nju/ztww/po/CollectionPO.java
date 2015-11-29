package nju.ztww.po;

import java.io.Serializable;

public class CollectionPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public String getCourierid() {
		return courierid;
	}
	public void setCourierid(String courierid) {
		this.courierid = courierid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	private String date;
    private double money;
    private String courierid;
    private String goodsid;
    
    
}
