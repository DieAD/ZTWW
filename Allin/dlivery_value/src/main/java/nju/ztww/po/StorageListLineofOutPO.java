package nju.ztww.po;
//@WJ auther
//出库的行order对象
public class StorageListLineofOutPO { 
	// TODO Auto-generated constructor stub
	String idOfOrder;
	String data;
	String way;
	String number;//具体实现时要分两种情况
  public StorageListLineofOutPO(String idOfOrder,String data,String way,String number) {
	  this.idOfOrder=idOfOrder;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	// TODO Auto-generated constructor stub
}
public String getIdOfOrder() {
	return idOfOrder;
}
public void setIdOfOrder(String idOfOrder) {
	this.idOfOrder = idOfOrder;
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
