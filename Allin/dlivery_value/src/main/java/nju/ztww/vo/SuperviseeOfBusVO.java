package nju.ztww.vo;

public class SuperviseeOfBusVO extends SuperviseeVO {
   public String id;//车辆代号
   public String idofplate;//车牌号
   public String idofchassis;//底盘号
   public String dataofbuy;//购买时间
   public String timeofduty;//服役时间
   public int numberofimage;//图片的号码（传给view一个图片号码值）
   public String idofengine;//发动机号
   
public SuperviseeOfBusVO(String id,String idofengine,String idofplate,String idofchassis,String dateofbuy,String timeofduty,int numberofimage) {
		super(id);
		this.idofengine=idofengine;
		this.idofplate=idofplate;
		this.idofchassis=idofchassis;
		this.dataofbuy=dateofbuy;
		this.timeofduty=timeofduty;
		this.numberofimage=numberofimage;
}
		// TODO Auto-generated constructor stub
   /**
 * 
 */
//所有成员变量的set和get方法
public String getId() {
	return id;
     }

public void setId(String id) {
	this.id = id;
        }
 public String getIdofengine() {
	   return idofengine;
}

public void setIdofengine(String idofengine) {
	this.idofengine = idofengine;
}

public String getIdofplate() {
	return idofplate;
}

public void setIdofplate(String idofplate) {
	this.idofplate = idofplate;
}

public String getIdofchassis() {
	return idofchassis;
}

public void setIdofchassis(String idofchassis) {
	this.idofchassis = idofchassis;
}

public String getDataofbuy() {
	return dataofbuy;
}

public void setDataofbuy(String dataofbuy) {
	this.dataofbuy = dataofbuy;
}

public String getTimeofduty() {
	return timeofduty;
}

public void setTimeofduty(String timeofduty) {
	this.timeofduty = timeofduty;
}

public int getNumberofimage() {
	return numberofimage;
}

public void setNumberofimage(int numberofimage) {
	this.numberofimage = numberofimage;
}


	
   

}
