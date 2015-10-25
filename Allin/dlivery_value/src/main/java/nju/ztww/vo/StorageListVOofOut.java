package nju.ztww.vo;

import java.util.ArrayList;

public class StorageListVOofOut extends StorageListVO {
	public String data;//出库单的日期
    public int number;//出库的数量
	public StorageListVOofOut(int idOfCenter, ArrayList<OrderVO> arraylist,String data,int number ){
		super(idOfCenter, arraylist);
		this.data=data;
		this.number=number;
		// TODO Auto-generated constructor stub
	}

}
