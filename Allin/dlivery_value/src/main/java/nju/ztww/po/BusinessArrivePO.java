package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.vo.OrderVO;


/**
 * 营业厅到达单
 * 
 * @author TQ
 * 
 * */

public class BusinessArrivePO extends OrderPO implements Serializable{
	
	private String id;
	private int idOfOrde;
	private String data;
	private String number;
	private String Send;
	private String orderState;
	private int exe=0;
	private int state=1;

	public BusinessArrivePO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSend() {
		return Send;
	}

	public void setSend(String send) {
		Send = send;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}