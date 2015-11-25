package nju.ztww.po;

/**
 * 寄件单
 * 
 * @author TQ
 * 
 * */

import java.io.Serializable;

import nju.ztww.common.Customer;
import nju.ztww.common.OrderInfo;

public class MailingPO extends OrderPO implements Serializable{
	
	private String businID;
	private String sendOrga;
	private String sendTEL;
	private int time;
	private int state;
	private int exe;
	
	
	private int idOfOrder;
	private String sendName;
	private String sendLocation;
	private String sendTelephone;
	private String receiveName;
	private String receiveLocation;
	private String receiveTelephone;
	private String infortation;
	private String method;
	private double count;
	private String StripNumber;

	
	
	public void setBusinID(String businID){
		this.businID = businID;
	}
	
	public String getBusinID(){
		return businID;
	}
	
	public void setSendOrga(String sendOrga){
		this.sendOrga = sendOrga;
	}
	
	public String getSendOrga(){
		return sendOrga;
	}
	
	public void setSendTEL(String sendTEL){
		this.sendTEL = sendTEL;
	}
	
	public String getSendTEL(){
		return sendTEL;
	}
	
	public void setTime(int time){
		this.time  = time;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	
	public void setExe(int exe){
		this.exe = exe;
	}
	
	public int getExe(){
		return exe;
	}

	private String arriveDate;


	public MailingPO(int idOfOrde) {
		super(idOfOrde);
		this.idOfOrder=idOfOrde;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
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

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getStripNumber() {
		return StripNumber;
	}

	public void setStripNumber(String stripNumber) {
		StripNumber = stripNumber;
	}
	

}

