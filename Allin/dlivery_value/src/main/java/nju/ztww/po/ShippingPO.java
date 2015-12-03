package nju.ztww.po;

/**
 * 中转中心装车单
 * 
 * @author TQ
 * 
 * */

import java.io.Serializable;
import java.util.ArrayList;

public class ShippingPO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private String id;
	private String data;
	private String QiYunNumber;
	private String arrivePlace;
	private String carNumber;
	private String JianZhuangName;
	private String YaYunName;
	private String orderNumber;
	private double money;
	private int exe=0;
	private int state=1;

	public ShippingPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getQiYunNumber() {
		return QiYunNumber;
	}

	public void setQiYunNumber(String qiYunNumber) {
		QiYunNumber = qiYunNumber;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getJianZhuangName() {
		return JianZhuangName;
	}

	public void setJianZhuangName(String jianZhuangName) {
		JianZhuangName = jianZhuangName;
	}

	public String getYaYunName() {
		return YaYunName;
	}

	public void setYaYunName(String yaYunName) {
		YaYunName = yaYunName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

