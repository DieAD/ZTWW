package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.vo.OrderVO;

/**
 * 中转中心到达单
 * 
 * @author TQ
 * 
 * */

public class CenterReceivePO extends OrderPO implements Serializable{
	
	private int idOfOrde;
	private int CenterNumber;
	private String data;
	private int transferNumber;
	private String sendPlace;
	private String state;

	public CenterReceivePO(int idOfOrder) {
		super(idOfOrder);
	    this.idOfOrde=	idOfOrder;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
	}

	public int getCenterNumber() {
		return CenterNumber;
	}

	public void setCenterNumber(int centerNumber) {
		CenterNumber = centerNumber;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(int transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getSendPlace() {
		return sendPlace;
	}

	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
