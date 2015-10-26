package nju.ztww.vo;

public class StateVO extends OrderVO{
	private String currentPlace;
	private String historyPlace;
	public StateVO(int idOfOrder) {
		super(idOfOrder);
		// TODO Auto-generated constructor stub
	}
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
