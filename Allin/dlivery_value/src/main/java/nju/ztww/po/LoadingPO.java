package nju.ztww.po;

/**
 * 营业厅装车单
 * 
 * @author TQ
 * 
 * */

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingPO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private String data;
	private String YingYeNumber;
	private String QiYunNumber;
	private String arrive;
	private String carNumber;
	private String JianZhuangName;
	private String YaYunName;
	private ArrayList<Integer> orderNumber;
	private int money;

	public LoadingPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getYingYeNumber() {
		return YingYeNumber;
	}

	public void setYingYeNumber(String yingYeNumber) {
		YingYeNumber = yingYeNumber;
	}

	public String getQiYunNumber() {
		return QiYunNumber;
	}

	public void setQiYunNumber(String qiYunNumber) {
		QiYunNumber = qiYunNumber;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
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

	public ArrayList<Integer> getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(ArrayList<Integer> orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
