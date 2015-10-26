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
	
	private int idOfOrde;
	private String data;
	private int number;
	private String Send;
	private String state;

	public BusinessArrivePO(int idOfOrder) {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSend() {
		return Send;
	}

	public void setSend(String send) {
		Send = send;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}