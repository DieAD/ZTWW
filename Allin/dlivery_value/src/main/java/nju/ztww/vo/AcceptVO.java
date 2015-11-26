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
		this.accepter
	}
}
