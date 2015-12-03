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
	private String orderNumber;
	private String senderName;
	private String id;
	private int exe=0;
	private int state=1;

	public SendPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}
