package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.dao.OutStockFormDO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

//@WJ auther
//出库的行order对象
public class StorageListLineofOutPO extends OrderPO implements Serializable { 
	// TODO Auto-generated constructor stub
	String idofdanzi;
	String id;
	String data;
	int way;
	String number;//具体实现时要分两种情况
	String destination;
	String idofcenter;
  public StorageListLineofOutPO(String idofdanzi,String id,String data,String destination,int way,String number,String idofcenter) {
	  super(idOfOrder);
	  this.idofdanzi=idofdanzi;
	  this.id=id;
	  this.data=data;
	  this.way=way;
	  this.number=number;
	  this.destination=destination;
	  this.idofcenter=idofcenter;
	// TODO Auto-generated constructor stub
}
public String getIdofdanzi() {
	return idofdanzi;
}
public void setIdofdanzi(String idofdanzi) {
	this.idofdanzi = idofdanzi;
}
public String getIdofcenter() {
	return idofcenter;
}
public void setIdofcenter(String idofcenter) {
	this.idofcenter = idofcenter;
}
public String getId() {
	return id;
}
public int getWay() {
	return way;
}
public void setWay(int way) {
	this.way = way;
}
public void setId(String id) {
	this.id = id;
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
	return new StorageListLineofOutVO(idofdanzi,id,data,destination,way,number,idofcenter);
}
//差一个id 单子的   //差一个number
 public OutStockFormDO changetodo(){
	 OutStockFormDO outstockformdo=new OutStockFormDO();
	 outstockformdo.setId(idofdanzi);
	 outstockformdo.setExe(0);
	 outstockformdo.setState(1);
	 outstockformdo.setAddress(destination);
	 outstockformdo.setGoodsid(id);
	 outstockformdo.setTime(data);
	 outstockformdo.setNumber(number);
	 outstockformdo.setTransmethod(way);
	 outstockformdo.setIdofcenter(idofcenter);
	 return outstockformdo;
    
 }

	

}
