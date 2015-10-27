package nju.ztww.vo;

import java.util.ArrayList;

public class StorageListVOofIn extends StorageListVO {
     public String data;//入库单的日期
     public int number;//入库的数量
	public StorageListVOofIn( String idOfCenter, ArrayList<OrderVO> arraylist,String data,int number) {
		super(idOfCenter, arraylist);
		this.data=data;
		this.number=number;
		// TODO Auto-generated constructor stub
	}

}
