package nju.ztww.po;

import java.io.Serializable;

public class MUserPO implements Serializable{
	private String name;
	private String id;
	private int number;
	private double sp;
	private double salary;
	private int salarymethod;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getSp() {
		return sp;
	}

	public void setSp(double sp) {
		this.sp = sp;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSalarymethod() {
		return salarymethod;
	}

	public void setSalarymethod(int salarymethod) {
		this.salarymethod = salarymethod;
	}

}
