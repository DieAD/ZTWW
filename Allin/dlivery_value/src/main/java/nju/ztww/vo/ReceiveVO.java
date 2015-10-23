package nju.ztww.vo;

import java.util.ArrayList;

public class ReceiveVO extends OrderVO{
	
	private int idOfOrde;
	private String data;
	private int receiveMoney;
	private String receiverName;
	private ArrayList<Integer> orderNumber;

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

	public int getReceiveMoney() {
		return receiveMoney;
	}

	public void setReceiveMoney(int receiveMoney) {
		this.receiveMoney = receiveMoney;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public ArrayList<Integer> getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(ArrayList<Integer> orderNumber) {
		this.orderNumber = orderNumber;
	}

}
