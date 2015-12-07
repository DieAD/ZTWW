package nju.ztww.vo;

import java.io.Serializable;

public class IDVO implements Serializable{
	public String id;
	public IDVO(String id){
		this.id = id;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
