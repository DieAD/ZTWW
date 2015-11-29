package nju.ztww.po;

import java.io.Serializable;



public class StorageListLinePO extends OrderPO implements Serializable{
	String id;//快递编号
    String data;//入库日期
    String destination;//目的地
    String qu;//区号
    String pai;//排号
    String jia;//架号
    String wei;//位号
	public StorageListLinePO(int idOfOrder,String id,String data,String destination, String qu,String pai, String jia,String wei) {
		super(idOfOrder);
		// TODO Auto-generated constructor stub
		this.id=id;
		this.data=data;
		this.destination=destination;
		this.jia=jia;
		this.pai=pai;
		this.qu=qu;
		this.wei=wei;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getJia() {
		return jia;
	}
	public void setJia(String jia) {
		this.jia = jia;
	}
	public String getWei() {
		return wei;
	}
	public void setWei(String wei) {
		this.wei = wei;
	}
	//数据操作时要注意 VO 的对象 int 参数
	
	

}
