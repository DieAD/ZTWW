package nju.ztww.vo;

/**
 * 中转中心到达单
 * 
 * @author TQ
 * 
 * */

public class CenterReceiveVO extends OrderVO{
	
	private int idOfOrde;
	private String CenterNumber;
	private String data;
	private String transferNumber;
	private String sendPlace;
	private String state;

	public CenterReceiveVO(int idOfOrder) {
		super(idOfOrder);
	    this.idOfOrde=	idOfOrder;
	}

	public int getIdOfOrde() {
		return idOfOrde;
	}

	public void setIdOfOrde(int idOfOrde) {
		this.idOfOrde = idOfOrde;
	}

	public String getCenterNumber() {
		return CenterNumber;
	}

	public void setCenterNumber(String centerNumber) {
		CenterNumber = centerNumber;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getSendPlace() {
		return sendPlace;
	}

	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
