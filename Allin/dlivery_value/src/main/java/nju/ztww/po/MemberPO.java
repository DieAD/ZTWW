package nju.ztww.po;

import java.io.Serializable;

public class MemberPO implements Serializable{
	private final String id;
	private final String password;
	private String position;
	private boolean isRight;   //账户密码是否匹配
	private boolean isLegal;   //账户是否存在

	public MemberPO(String id, String password){
		this.id = id;
		this.password = password;
		
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPostion(){
		return position;
	}
	
	public void setLegal(boolean isLegal){
		this.isLegal = isLegal;
	}
	
	public boolean getLegal(){
		return isLegal;
	}
	
	public String getID(){
		return id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setRight(boolean isRight){
		this.isRight = isRight;
	}
	
	public boolean getRight(){
		return isRight;
	}
	
	
}
