package nju.ztww.po;

import java.io.Serializable;

import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.StockDO;
import nju.ztww.vo.StorageListLineofInVO;

public class StorageListLineofInPO extends OrderPO implements Serializable {
	String id;//快递编号
    String data;//入库日期
    String destination;//目的地
    String qu;//区号
    String pai;//排号
    String jia;//架号
    String wei;//位号
	public StorageListLineofInPO(int idOfOrder,String id,String data,String destination,String qu,String pai,String jia,String wei) {
		super(idOfOrder);
		this.id=id;
		this.data=data;
		this.destination=destination;
		this.qu=qu;
		this.pai=pai;
		this.jia=jia;
		this.wei=wei;
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
	public StorageListLineofInVO changetovo() {
		// TODO Auto-generated method stub
		return new StorageListLineofInVO(idOfOrder, id, data, destination, qu, pai, jia, wei);
		
	}
	public EntryFormDO changetoIndo(){
		EntryFormDO entryformdo=new EntryFormDO();
		entryformdo.setGoodsid(id);
		entryformdo.setEntrytime(data);
		entryformdo.setAddress(destination);
		entryformdo.setQu(qu);
		entryformdo.setJia(jia);
		entryformdo.setPai(pai);
		entryformdo.setWei(wei);
		entryformdo.setExe(0);
		entryformdo.setState(1);
		return entryformdo;
	}
   public StockDO  changetoSdo(){
	   StockDO stockdo=new StockDO();
	 
	   stockdo.setEntrytime(data);
	   stockdo.setGoodsid(id);
	   stockdo.setAddress(destination);
	   stockdo.setJia(jia);
	   stockdo.setPai(pai);
	   stockdo.setQu(qu);
	   stockdo.setWei(wei);
	   return stockdo;
   }

}
