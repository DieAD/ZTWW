package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.dao.OutStockFormDO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

//@WJ auther
//出库的行order对象
public class StorageListLineofOutPO extends OrderPO implements Serializable { 
	// TODO Auto-generated constructor stub
	String id;
	String data;
	String way;
	String number;//具体实现时要分两种情况
	String destination;
  public StorageListLineofOutPO(String id,String data,String way,String number,String destination) {
	  super(idOfOrder);
	  this.id=id;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	  this.destination=destination;
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

public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
//这个change to vo 要分情况讨论
public StorageListLineofOutVO changetovo() {
	// TODO Auto-generated method stub
	return null;
}
//差一个id 单子的   //差一个number
 public OutStockFormDO changetodo(){
	 OutStockFormDO outstockformdo=new OutStockFormDO();
	 outstockformdo.setExe(0);
	 outstockformdo.setState(1);
	 outstockformdo.setAddress(destination);
	 outstockformdo.setGoodsid(id);
	 outstockformdo.setTime(data);
	 //outstockformdo.setTransmethod(way);
	 return outstockformdo;
    
 }

	

}
