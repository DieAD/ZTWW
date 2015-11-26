package nju.ztww.vo;

/**
 * 派件单
 * 
 * @author TQ
 * 
 * */

public class SendVO extends OrderVO{
	
	private int idOfOrde;
	private String id;
	private String data;
	private String orderNumber;
	private String senderName;

	public SendVO(int idOfOrder) {
		super(idOfOrder);
		this.idOfOrde=idOfOrde;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

}
