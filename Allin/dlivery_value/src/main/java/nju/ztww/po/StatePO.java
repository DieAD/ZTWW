package nju.ztww.po;

import java.io.Serializable;

public class StatePO extends OrderPO {
	public StatePO(int idOfOrder) {
		super(idOfOrder);
		// TODO Auto-generated constructor stub
	}
	private String currentPlace;
	private String historyPlace;
	
	public String getCurrentPlace() {
		return currentPlace;
	}
	public void setCurrentPlace(String currentPlace) {
		this.currentPlace = currentPlace;
	}
	public String getHistoryPlace() {
		return historyPlace;
	}
	public void setHistoryPlace(String historyPlace) {
		this.historyPlace = historyPlace;
	}
}
