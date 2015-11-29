package nju.ztww.po;

import java.io.Serializable;
import java.util.ArrayList;

//WJ 单个出库单 
public class StorageListodOutPO implements Serializable {
	public ArrayList<StorageListLineofOutPO> arraylist=null;
	public boolean ischeck=false;
  public StorageListodOutPO(ArrayList<StorageListLineofOutPO> arraylist,boolean ischeck) {
	// TODO Auto-generated constructor stub
	  this.arraylist=arraylist;
	  this.ischeck=ischeck;
}
public ArrayList<StorageListLineofOutPO> getArraylist() {
	return arraylist;
}
public void setArraylist(ArrayList<StorageListLineofOutPO> arraylist) {
	this.arraylist = arraylist;
}
public boolean isIscheck() {
	return ischeck;
}
public void setIscheck(boolean ischeck) {
	this.ischeck = ischeck;
}
  
}
