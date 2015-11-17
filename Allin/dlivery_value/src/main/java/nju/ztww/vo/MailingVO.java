package nju.ztww.vo;

/**
 * 寄件单
 * 
 * @author TQ
 * 
 * */

import nju.ztww.common.Customer;
import nju.ztww.common.OrderInfo;

public class MailingVO extends OrderVO{
	
	private int idOfOrder;
	private String sendName;
	private String sendLocation;
	private String sendTelephone;
	private String receiveName;
	private String receiveLocation;
	private String receiveTelephone;
	private String infortation;
	private String method;
	private int count;
	private String StripNumber;

	public MailingVO(int idOfOrde) {
		super(idOfOrde);
		this.idOfOrder=idOfOrde;
	}

	public int getIdOfOrde() {
		return idOfOrder;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrder = idOfOrde;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendLocation() {
		return sendLocation;
	}

	public void setSendLocation(String sendLocation) {
		this.sendLocation = sendLocation;
	}

	public String getSendTelephone() {
		return sendTelephone;
	}

	public void setSendTelephone(String sendTelephone) {
		this.sendTelephone = sendTelephone;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceiveLocation() {
		return receiveLocation;
	}

	public void setReceiveLocation(String receiveLocation) {
		this.receiveLocation = receiveLocation;
	}

	public String getReceiveTelephone() {
		return receiveTelephone;
	}

	public void setReceiveTelephone(String receiveTelephone) {
		this.receiveTelephone = receiveTelephone;
	}

	public String getInfortation() {
		return infortation;
	}

	public void setInfortation(String infortation) {
		this.infortation = infortation;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStripNumber() {
		return StripNumber;
	}

	public void setStripNumber(String stripNumber) {
		StripNumber = stripNumber;
	}
	

}
