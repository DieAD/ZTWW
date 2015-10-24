package nju.ztww.vo;

import java.util.ArrayList;

/**
 * 营业厅装车单
 * 
 * @author TQ
 * */

public class BusinessLoadingVO extends OrderVO{
	
	private int idOfOrde;
	private String data;
	private int YingYeNumber;
	private int QiYunNumber;
	private String arrive;
	private int carNumber;
	private String JianZhuangName;
	private String YaYunName;
	private ArrayList<Integer> orderNumber;
	private int money;

	public BusinessLoadingVO(int idOfOrder) {
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

	public int getYingYeNumber() {
		return YingYeNumber;
	}

	public void setYingYeNumber(int yingYeNumber) {
		YingYeNumber = yingYeNumber;
	}

	public int getQiYunNumber() {
		return QiYunNumber;
	}

	public void setQiYunNumber(int qiYunNumber) {
		QiYunNumber = qiYunNumber;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
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
