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
	private String data;
	private double receiveMoney;
	private String receiverName;
	private ArrayList<String> orderNumber;

	public ReceiveVO(int idOfOrder) {
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

	public ArrayList<String> getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(ArrayList<String> orderNumber) {
		this.orderNumber = orderNumber;
	}

}
