package nju.ztww.dao;

import java.io.Serializable;

public class StockDO implements Serializable{
	
	private int index;
	private String goodsid;
    private String entrytime;
    private String address;
    private String qu;
    private String pai;
    private String jia;
    private String wei;
    private int state;
    private String idofcenter;
	public String getIdofcenter() {
		return idofcenter;
	}
	public void setIdofcenter(String idofcenter) {
		this.idofcenter = idofcenter;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

}
