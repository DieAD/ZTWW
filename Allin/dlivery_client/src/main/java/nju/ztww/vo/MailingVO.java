package nju.ztww.vo;

import nju.ztww.common.Customer;
import nju.ztww.common.OrderInfo;

/**
 * 寄件单
 * 
 * @author TQ
 * */

public class MailingVO extends OrderVO{
	
	private int idOfOrde;
	private String sendName;
	private String sendLocation;
	private int sendTelephone;
	private String receiveName;
	private String receiveLocation;
	private int receiveTelephone;
	private String infortation;
	private String method;
	private int count;
	private int StripNumber;

	public MailingVO(int idOfOrde) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
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

	public int getSendTelephone() {
		return sendTelephone;
	}

	public void setSendTelephone(int sendTelephone) {
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

	public int getReceiveTelephone() {
		return receiveTelephone;
	}

	public void setReceiveTelephone(int receiveTelephone) {
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

	public int getStripNumber() {
		return StripNumber;
	}

	public void setStripNumber(int stripNumber) {
		StripNumber = stripNumber;
	}
	

}
