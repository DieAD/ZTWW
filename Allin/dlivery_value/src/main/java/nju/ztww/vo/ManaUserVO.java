package nju.ztww.vo;

public class ManaUserVO {
	public String ID;
	public String name;
	public String password;
	public String authority;
	public int age;
	public String IDCard;
	public int sex;
	public String phone;
	public String position;
    public int worktime;
    public int wetherwork;
	

	
	public ManaUserVO(String iD, String name, String password,
			String authority, int age, String iDCard, int sex, String phone,
			String position, int worktime, int wetherwork) {
		super();
		this.ID = iD;
		this.name = name;
		this.password = password;
		this.authority = authority;
		this.age = age;
		this.IDCard = iDCard;
		this.sex = sex;
		this.phone = phone;
		this.position = position;
		this.worktime = worktime;
		this.wetherwork = wetherwork;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}

	public void setWetherwork(int wetherwork) {
		this.wetherwork = wetherwork;
	}

	public int getWorktime() {
		return worktime;
	}

	public int getWetherwork() {
		return wetherwork;
	}

	public String getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getAuthority(){
		return authority;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getIDCard(){
		return IDCard;
	}
	
	public int getSex(){
		return sex;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getPosition(){
		return position;
	}
}
