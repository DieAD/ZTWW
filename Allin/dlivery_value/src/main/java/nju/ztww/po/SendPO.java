package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.vo.OrderVO;

/**
 * 派件单
 * 
 * @author TQ
 * 
 * */

public class SendPO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private String data;
	private int orderNumber;
	private String senderName;

	public SendPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
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

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}
