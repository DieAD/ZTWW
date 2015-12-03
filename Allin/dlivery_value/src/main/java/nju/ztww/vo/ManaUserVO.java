package nju.ztww.vo;

public class ManaUserVO {
	public String ID;
	public String name;
	public String password;
	public String authority;
	public int age;
	public String IDCard;
	public String sex;
	public String phone;
	public String position;
	
	public ManaUserVO(String ID, String name,String password, String authority, int age
			, String IDCard, String sex, String phone, String position){
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.authority = authority;
		this.age = age;
		this.IDCard = IDCard;
		this.sex = sex;
		this.phone = phone;
		this.position = position;
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
	
	public String getSex(){
		return sex;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getPosition(){
		return position;
	}
}
