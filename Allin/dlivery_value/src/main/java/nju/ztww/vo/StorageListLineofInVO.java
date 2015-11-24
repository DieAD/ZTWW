package nju.ztww.vo;

import nju.ztww.po.StorageListLineofInPO;

//WJ  入库单VO
public class StorageListLineofInVO extends OrderVO{
    String id;//快递编号
    String data;//入库日期
    String destination;//目的地
    String qu;//区号
    String pai;//排号
    String jia;//架号
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
	String wei;//位号
	public StorageListLineofInVO(int idOfOrder,String id,String data,String destination,String qu,String pai,String jia,String wei) {
		super(idOfOrder);
		this.id=id;
		this.data=data;
		this.destination=destination;
		this.qu=qu;
		this.pai=pai;
		this.wei=wei;
		this.jia=jia;
		// TODO Auto-generated constructor stub
	}
	public StorageListLineofInPO changetopo(){
		return new StorageListLineofInPO(idOfOrder, id, data, destination, qu, pai, jia, wei);
	}
	
	

}
