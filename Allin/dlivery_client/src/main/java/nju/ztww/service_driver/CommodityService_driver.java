package nju.ztww.service_driver;

import nju.ztww.service_stub.Commodity_stub;
/*
 * 
 * 驱动commodityService的部分方法；
 * 
 * 
 * 
 * 
 */

public class CommodityService_driver {
       public static void main(String[] args){
    	   Commodity_stub  commodity_stub = new Commodity_stub("00001", 1, 1, 1);
    	   commodity_stub.addOrder("0000000001");
    	   commodity_stub.deleteOrder("0000000001");
    	   
    	   commodity_stub.getOrder("000000000001");
    	   commodity_stub.getTotal(1);
       }
}
