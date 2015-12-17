package nju.ztww.dao;

public class OutStockFormDO {
	private int index;
	private String id;
	private String goodsid;
	private String time;
	private String address;
	private int transmethod;
	private int exe;
	private int state;
	private String number;
	private String idofcenter;

	public String getIdofcenter() {
		return idofcenter;
	}

	public void setIdofcenter(String idofcenter) {
		this.idofcenter = idofcenter;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTransmethod() {
		return transmethod;
	}

	public void setTransmethod(int i) {
		this.transmethod = i;
	}

	public int getExe() {
		return exe;
	}

	public void setExe(int exe) {
		this.exe = exe;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
