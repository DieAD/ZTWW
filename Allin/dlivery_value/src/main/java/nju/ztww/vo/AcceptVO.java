package nju.ztww.vo;

public class AcceptVO extends OrderVO{

	public int idOfOrder;
	public String businID;
	public String acceptID;
	public String accepter;
	public String acceptTime;
	public String courierID;
	public int state;
	public int exe;
	//
	
	
	public AcceptVO(int idOfOrder){
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
		this.acceptID = acceptID;
	}
	
	public String getAcceptID(){
		return acceptID;
	}
	
	public void setAccepter(String accepter){
		this.accepter = accepter;
	}
	
	public String getAccepter(){
		return accepter;
	}
	
	public void setAcceptTime(String acceptTime){
		this.acceptTime = acceptTime;
	}
	
	public String getAcceptTime(){
		return acceptTime;
	}
	
	public void setCourierID(String courierID){
		this.courierID = courierID;
	}
	
	public String getCourierID(){
		return courierID;
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
}

