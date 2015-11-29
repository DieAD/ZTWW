package nju.ztww.po;

import java.io.Serializable;
import java.util.ArrayList;
//wj  入库单的信息
public class StorageListodInPO implements Serializable  {
	ArrayList<StorageListLineofInPO> arraylist=null;
	boolean ischeck=false;
	public StorageListodInPO(ArrayList<StorageListLineofInPO> arraylist,boolean ischeck){
		// TODO Auto-generated constructor stub
		this.arraylist=arraylist;
		this.ischeck=ischeck;
	}
	public ArrayList<StorageListLineofInPO> getArraylist() {
		return arraylist;
	}
	public void setArraylist(ArrayList<StorageListLineofInPO> arraylist) {
		this.arraylist = arraylist;
	}
	public boolean isIscheck() {
		return ischeck;
	}
	public void setIscheck(boolean ischeck) {
		this.ischeck = ischeck;
	}
}
