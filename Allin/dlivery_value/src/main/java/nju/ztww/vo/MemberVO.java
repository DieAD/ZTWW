package nju.ztww.vo;


public class MemberVO {
	private final String id;
	private final String password;
	private boolean isRight;  //账号密码是否匹配
	private  String position;  

	public MemberVO(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public String getPosition(){
		return position;
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
