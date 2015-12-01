package nju.ztww.po;

import java.io.Serializable;

public class ManaUserPO implements Serializable{
	 private String id;
     private String name;
     private String psw;
     private String authority;
     private int age;
     private int worktime;
     private String idcard;
     private int salarymethod;
     private double salary;
     private int wetherwork;
     private int sex;
     private String phone;
     private int times;
     private double sp;
     private String position;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getSalarymethod() {
		return salarymethod;
	}
	public void setSalarymethod(int salarymethod) {
		this.salarymethod = salarymethod;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getWetherwork() {
		return wetherwork;
	}
	public void setWetherwork(int wetherwork) {
		this.wetherwork = wetherwork;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public double getSp() {
		return sp;
	}
	public void setSp(double sp) {
		this.sp = sp;
	}
}
