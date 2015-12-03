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
	private String id;
	//运输方式
	private String method;
	//装车日期
	private String carData;
	//中转编号
	private String transferData;
	//航班（车次）号
	private String methodNumber;
	private String sendPlace;
	private String arrivePlace;
	private String counterNumber;
	private String JianZhuangName;
	private String sendNumber;
	private double money;
	private int exe=0;
	private int state=1;

	public TransferVO(int idOfOrde) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
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

	public String getSendNumber() {
		return sendNumber;
	}

	public void setSendNumber(String sendNumber) {
		this.sendNumber = sendNumber;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
