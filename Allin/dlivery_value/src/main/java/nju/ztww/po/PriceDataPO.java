package nju.ztww.po;

import java.io.Serializable;

public class PriceDataPO implements Serializable{
	public double priceConst;
	public double distance;
	public double typePrice;
	
	public PriceDataPO(double priceConst, double distance, double typePrice){
		this.priceConst = priceConst;
		this.distance = distance;
		this.typePrice = typePrice;
	}
	
	public double getPriceConst(){
		return priceConst;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public double getTypePrice(){
		return typePrice;
	}
}
