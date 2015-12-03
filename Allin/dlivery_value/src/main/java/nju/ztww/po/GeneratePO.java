package nju.ztww.po;

import java.io.Serializable;

public class GeneratePO implements Serializable{
	private String id ="0000001";
	private String state="未审批";
	private String dealmen="Administrator";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDealmen() {
		return dealmen;
	}
	public void setDealmen(String dealmen) {
		this.dealmen = dealmen;
	}
	
}
