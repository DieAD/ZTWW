package nju.ztww.vo;

import java.util.ArrayList;

public class StorageListVO {
	String idOfCenter;
	ArrayList<OrderVO> arraylist;
	public StorageListVO(String idOfCenter, ArrayList<OrderVO> arraylist) {
		// TODO Auto-generated constructor stub
		this.arraylist=arraylist;
		this.idOfCenter=idOfCenter;
	}

}
