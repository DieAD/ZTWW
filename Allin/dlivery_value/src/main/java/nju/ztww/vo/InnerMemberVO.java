package nju.ztww.vo;

public class InnerMemberVO {
	private String name;
	private String id;
	private int age;
	private char sex;
	private String password;
	private String phone;
	private char whetherWorking;
	private int workTime;
	private String IDCard;
	private char SalaryMethod;
	private double salary;
	
	public InnerMemberVO(String name, String id, int age, char sex, String password,
			String phone, char whetherWorking, int workTime, String IDCard,
			char SalaryMethod, double salary) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.whetherWorking = whetherWorking;
		this.workTime = workTime;
		this.IDCard = IDCard;
		this.SalaryMethod = SalaryMethod;
		this.salary = salary;
	}
}
