package nju.ztww.vo;

public class StorageListVO {
    public final int idOfCenter;
    public final String date;
    public final String location;
    
    public StorageListVO(int idOfCenter,String date,String location){
    	this.idOfCenter = idOfCenter;
    	this.date = date;
    	this.location = location;
    }
}
