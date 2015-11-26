package nju.ztww.vo;

public class CollectionVO {
     public String date;
     public double money;
     public String courierid;
     public String orderid;
     
     public CollectionVO(String date,double money,String courierid,String orderid){
    	 this.date = date;
    	 this.money = money;
    	 this.courierid = courierid;
    	 this.orderid = orderid;
     }
}
