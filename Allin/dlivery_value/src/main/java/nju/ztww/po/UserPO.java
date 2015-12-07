package nju.ztww.po;

import java.io.Serializable;

/*
 * 专用于个人信息的PO
 */

public class UserPO implements Serializable{
	public String name;
	public String ID;
	public int sex;
	public int age;
	public String IDCard;
	public String position;
	public int workTime;
	public double salary;
	public int wetherwork;
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWetherwork() {
		return wetherwork;
	}

	public void setWetherwork(int wetherwork) {
		this.wetherwork = wetherwork;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setSex(int sex){
		this.sex = sex;
	}
	
	public int getSex(){
		return sex;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setIDCard(String IDCard){
		this.IDCard = IDCard;
	}
	
	public String getIDCard(){
		return IDCard;
	}
	
	public void setWorkTime(int workTime){
		this.workTime = workTime;
	}
	
	public int getWorkTime(){
		return workTime;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public double getSalary(){
		return salary;
	}
}
