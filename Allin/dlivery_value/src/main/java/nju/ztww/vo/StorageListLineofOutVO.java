package nju.ztww.vo;

import nju.ztww.po.StorageListLineofOutPO;

// WJ  auther
//库存中记录order的类
public class StorageListLineofOutVO extends OrderVO {
	String idofdanzi;
	String id;//快递的编号
	String data;
	int way;
	String destination;
	String number;//具体实现时要分两种情况
  public StorageListLineofOutVO(String idofdanzi,String id,String data,String destination,int way,String number) {
	  super(idOfOrder);
	  this.id=id;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	  this.destination=destination;
	  this.idofdanzi=idofdanzi;
	// TODO Auto-generated constructor stub
}
public String getIdofdanzi() {
	return idofdanzi;
}
public void setIdofdanzi(String idofdanzi) {
	this.idofdanzi = idofdanzi;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
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
public int getWay() {
	return way;
}
public void setWay(int way) {
	this.way = way;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
//将此vo装换成po
public StorageListLineofOutPO changetopo(){
	return new StorageListLineofOutPO(idofdanzi,id,data,destination,way,number);
}
 
 
 
}
