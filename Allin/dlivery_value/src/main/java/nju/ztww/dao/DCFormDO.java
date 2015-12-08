package nju.ztww.dao;

import java.io.Serializable;

public class DCFormDO {
	private int index;
	private String city1;
	private String city2;
	private double distance;
	private double eco;
	private double sta;
	private double fas;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getEco() {
		return eco;
	}

	public void setEco(double eco) {
		this.eco = eco;
	}

	public double getSta() {
		return sta;
	}

	public void setSta(double sta) {
		this.sta = sta;
	}

	public double getFas() {
		return fas;
	}

	public void setFas(double fas) {
		this.fas = fas;
	}
}
