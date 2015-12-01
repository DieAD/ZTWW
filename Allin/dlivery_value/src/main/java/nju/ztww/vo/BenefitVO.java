package nju.ztww.vo;

public class BenefitVO {
   public double totalCollection;
   public double totalPayment;
   public double totalBenefit;
   
   public BenefitVO(double totalCollection,double totalPayment,double totalBenefit){
	   this.totalCollection =  totalCollection;
	   this.totalPayment  = totalPayment;
	   this.totalBenefit = totalBenefit;
   }
}
