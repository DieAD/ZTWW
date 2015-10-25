package nju.ztww.po;

/**
 * 中转单
 * 
 * @author TQ
 * 
 * */

import java.io.Serializable;
import java.util.ArrayList;

public class TransferPO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private String method;
	private String carData;
	private int transferData;
	private int methodNumber;
	private String sendPlace;
	private String arrivePlace;
	private int counterNumber;
	private String JianZhuangName;
	private ArrayList<Integer> sendNumber;
	private int money;

	public TransferPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCarData() {
		return carData;
	}

	public void setCarData(String carData) {
		this.carData = carData;
	}

	public int getTransferData() {
		return transferData;
	}

	public void setTransferData(int transferData) {
		this.transferData = transferData;
	}

	public int getMethodNumber() {
		return methodNumber;
	}

	public void setMethodNumber(int methodNumber) {
		this.methodNumber = methodNumber;
	}

	public String getSendPlace() {
		return sendPlace;
	}

	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public int getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(int counterNumber) {
		this.counterNumber = counterNumber;
	}

	public String getJianZhuangName() {
		return JianZhuangName;
	}

	public void setJianZhuangName(String jianZhuangName) {
		JianZhuangName = jianZhuangName;
	}

	public ArrayList<Integer> getSendNumber() {
		return sendNumber;
	}

	public void setSendNumber(ArrayList<Integer> sendNumber) {
		this.sendNumber = sendNumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}

