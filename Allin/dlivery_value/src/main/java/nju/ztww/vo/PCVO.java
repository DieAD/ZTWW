package nju.ztww.vo;

public class PCVO {
    public String pdate;
    public double pmoney;
    public String pmen;
    public String paccount;
    public String pcat;
    public String ps;
    public String cdate;
    public double cmoney;
    public String cid;
    public String goodsid;
    
    public PCVO(String pdate,double pmoney,String pmen,String paccount,String pacat,
    		String ps,String cdate,double cmoney,String cid,String goodsid){
    	this.pdate = pdate;
    	this.pmoney = pmoney;
    	this.pmen = pmen;
    	this.paccount = paccount;
    	this.pcat = pcat;
    	this.ps = ps;
    	this.cmoney = cmoney;
    	this.cdate = cdate;
    	this.cid = cid;
    	this.goodsid = goodsid;
    }
    
}
