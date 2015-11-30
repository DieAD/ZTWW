package nju.ztww.vo;

public class PaymentVO {
   public String date;
   public double money;
   public String paymen;
   public String payaccount;
   public String paycat;
   public String ps;
   
   public PaymentVO(String date,double money,String paymen,String payaccount,String paycat,String ps){
	   this.date = date;
	   this.money = money;
	   this.paymen = paymen;
	   this.payaccount = payaccount;
	   this.paycat = paycat;
	   this.ps = ps;
	   
   }
}
