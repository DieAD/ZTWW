package nju.ztww.vo;
// WJ  auther
//库存中记录order的类
public class StorageListLineofOutVO extends OrderVO {
	String id;//快递的编号
	String data;
	String way;
	String number;//具体实现时要分两种情况
  public StorageListLineofOutVO(String id,String data,String way,String number) {
	  super(idOfOrder);
	  this.id=id;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	// TODO Auto-generated constructor stub
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
public String getWay() {
	return way;
}
public void setWay(String way) {
	this.way = way;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
 
 
 
}
