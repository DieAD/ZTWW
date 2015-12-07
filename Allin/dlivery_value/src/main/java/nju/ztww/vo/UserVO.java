package nju.ztww.vo;

public class UserVO {
	public String name;
	public String ID;
	public int sex;
	public int age;
	public int worktime;
	public int wetherwork;
	public String IDCard;
	public String position;
	public double salary;
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWorkTime() {
		return worktime;
	}

	public void setWorkTime(int worktime) {
		this.worktime = worktime;
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
	
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	public double getSalary(){
		return salary;
	}
}
