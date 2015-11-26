package nju.ztww.po;

/**
 * 收款单
 * 
 * @author TQ
 * 
 * */

import java.io.Serializable;
import java.util.ArrayList;

public class ReceivePO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private String data;
	private double receiveMoney;
	private String receiverName;
	private ArrayList<String> orderNumber;
	private String id;
	private int exe=1;
	private int state=0;

	public ReceivePO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrder;
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

	public ArrayList<String> getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(ArrayList<String> orderNumber) {
		this.orderNumber = orderNumber;
	}

}
