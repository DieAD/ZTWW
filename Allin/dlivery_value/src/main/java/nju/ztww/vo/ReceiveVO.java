package nju.ztww.vo;

/**
 * 收款单
 * 
 * @author TQ
 * 
 * */

import java.util.ArrayList;

public class ReceiveVO extends OrderVO{
	
	private int idOfOrde;
	private String id;
	private String data;
	private double receiveMoney;
	private String receiverName;
	private String orderNumber;
	private String Holl;
	private int exe=0;
	private int state=1;

	public ReceiveVO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
	}

	public String getHoll() {
		return Holl;
	}

	public void setHoll(String holl) {
		Holl = holl;
	}

	public void setExe(int exe) {
		this.exe = exe;
	}

	public int getExe() {
		return exe;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getReceiveMoney() {
		return receiveMoney;
	}

	public void setReceiveMoney(double receiveMoney) {
		this.receiveMoney = receiveMoney;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}
