package nju.ztww.po;

import java.io.Serializable;
import java.util.Set;

public class AcceptPO extends OrderPO implements Serializable{

	public int idOfOrde;
	public String businID;
	public String AcceptID;
	public String Accepter;
	public String AcceptTime;
	public String courier;
	public int state;
	public int exe;
	
	public AcceptPO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrder = idOfOrder;
	}
	
	public void setBusinID(String businID){
		this.businID = businID;
	}
	
	public String getBusinID(){
		return businID;
	}

	public void setAcceptID(String acceptID){
		this.AcceptID = acceptID;
	}
	
	public String getAcceptID(){
		return AcceptID;
	}
	
	public void setAccepter(String accpter){
		this.Accepter = accpter;
	}
	
	public String getAccepter(){
		return Accepter;
	}
	
	public void setAcceptTime(String acceptTime){
		this.AcceptTime = acceptTime;
	}
	
	public String getAcceptTime(){
		return AcceptTime;
	}
	
	public void setCourier(String courier){
		this.courier = courier;
	}
	
	public String getCourier(){
		return courier;
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
	
	public void setIdOfOrder(int idOfOrde){
		this.idOfOrde = idOfOrde;
	}
	
	public int getIdOfOrder(){
		return idOfOrde;
	}
}
