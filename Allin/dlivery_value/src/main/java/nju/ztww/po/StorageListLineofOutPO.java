package nju.ztww.po;
//@WJ auther
//出库的行order对象
public class StorageListLineofOutPO extends OrderPO { 
	// TODO Auto-generated constructor stub
	String id;
	String data;
	String way;
	String number;//具体实现时要分两种情况
  public StorageListLineofOutPO(String id,String data,String way,String number) {
	  super(idOfOrder);
	  this.idOfOrder=idOfOrder;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	// TODO Auto-generated constructor stub
}
public String getId() {
	return id;
}
public void setIdOfOrder(String id) {
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
