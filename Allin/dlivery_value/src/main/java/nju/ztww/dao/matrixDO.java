package nju.ztww.dao;

import java.io.Serializable;

public class matrixDO implements Serializable{
	private int index;
	private String id;
	private String men;
	private String time;
	private String state;

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

	public String getMen() {
		return men;
	}

	public void setMen(String men) {
		this.men = men;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
