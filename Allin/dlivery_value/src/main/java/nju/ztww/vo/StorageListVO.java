package nju.ztww.vo;

import java.util.ArrayList;

public class StorageListVO {
    public final int idOfCenter;//中转中心的编号
    public ArrayList<OrderVO>arraylist;//这个OrderVO指的是订单进入库存需要的状态
   
   
    
    public StorageListVO(int idOfCenter,ArrayList<OrderVO>arraylist){
    	this.idOfCenter = idOfCenter;
        this.arraylist=arraylist;
    }
}
