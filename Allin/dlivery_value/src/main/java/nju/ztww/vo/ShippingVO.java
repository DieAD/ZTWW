package nju.ztww.vo;

/**
 * 中转中心装车单
 * 
 * @author TQ
 * 
 * */

import java.util.ArrayList;

public class ShippingVO extends OrderVO{
	
	private int idOfOrde;
	private String id;
	private String data;
	private String transferNumber;
	private String arrivePlace;
	private String carNumber;
	private String JianZhuangName;
	private String YaYunName;
	private ArrayList<Integer> orderNumber;
	private int money;

	public ShippingVO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
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
