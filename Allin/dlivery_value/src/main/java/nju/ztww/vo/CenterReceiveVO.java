package nju.ztww.vo;

/**
 * 中转中心到达单
 * 
 * @author TQ
 * 
 * */

public class CenterReceiveVO extends OrderVO{
	
	private int idOfOrde;
	private String id;
	private String CenterNumber;
	private String data;
	private String transferNumber;
	private String sendPlace;
	private String OrderState;
	private int exe=0;
	private int state=1;

	public CenterReceiveVO(int idOfOrder) {
		super(idOfOrder);
	    this.idOfOrde=	idOfOrder;
	}

	public int getExe() {
		return exe;
	}

	public void setExe(int exe) {
		this.exe = exe;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getOrderState() {
		return OrderState;
	}

	public void setOrderState(String orderState) {
		OrderState = orderState;
	}



}
