package nju.ztww.po;

import java.io.Serializable;

public class TrackPO implements Serializable{
	public String ID;
	public String track;
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setTrack(String track){
		this.track = track;
	}
	
	public String getTrack(){
		return track;
	}
}
