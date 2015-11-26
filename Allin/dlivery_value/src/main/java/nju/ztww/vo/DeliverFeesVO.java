package nju.ztww.vo;

public class DeliverFeesVO {
	public String place1;
	public String place2;
	public String type;
	public double packCost;
	public double cost;
	
	public DeliverFeesVO(String place1, String place2, String type, double packCost){
		this.place1 = place1;
		this.place2 = place2;
		this.type = type;
		this.packCost = packCost;
	}
	
	public String getPlace1(){
		return place1;
	}
	
	public String getPlace2(){
		return place2;
	}
	
	public String getType(){
		return type;
	}
	
	public double getPackCost(){
		return packCost;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public double getCost(){
		return cost;
	}
}
