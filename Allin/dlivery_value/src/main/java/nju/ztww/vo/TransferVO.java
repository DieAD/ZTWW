package nju.ztww.vo;

/**
 * 中转单
 * 
 * @author TQ
 * 
 * */

import java.util.ArrayList;

public class TransferVO extends OrderVO{
	
	private int idOfOrde;
	private String method;
	private String carData;
	private String transferData;
	private String methodNumber;
	private String sendPlace;
	private String arrivePlace;
	private String counterNumber;
	private String JianZhuangName;
	private ArrayList<Integer> sendNumber;
	private int money;

	public TransferVO(int idOfOrder) {
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

	public String getTransferData() {
		return transferData;
	}

	public void setTransferData(String transferData) {
		this.transferData = transferData;
	}

	public String getMethodNumber() {
		return methodNumber;
	}

	public void setMethodNumber(String methodNumber) {
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

	public String getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(String counterNumber) {
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
