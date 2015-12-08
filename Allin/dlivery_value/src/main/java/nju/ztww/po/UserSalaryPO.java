package nju.ztww.po;

import java.io.Serializable;

public class UserSalaryPO implements Serializable{
   private String id;
   private double sp;
   private double sumSalary;
   
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public double getSp() {
	return sp;
}
public void setSp(double sp) {
	this.sp = sp;
}
public double getSumSalary() {
	return sumSalary;
}
public void setSumSalary(double sumSalary) {
	this.sumSalary = sumSalary;
}
   
}
