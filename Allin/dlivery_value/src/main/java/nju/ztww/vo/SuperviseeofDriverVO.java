package nju.ztww.vo;

public class SuperviseeofDriverVO extends SuperviseeVO {
	public String id;//司机编号
	public String name;//司机姓名
	public String birth;//出生日期
	public String identifier;//身份证号码
	public String mobilephone;//手机
	public String LocationofBus;//车辆单位
	public String gender;//性别
	public String endofdata;//行驶证期限

	public SuperviseeofDriverVO(String id,String name,String birth,String identifier,String mobilephone,String LocationofBus,String gender,String endofdata) {
		super(id);
		this.id=id;
		this.name=name;
		this.birth=birth;
		this.endofdata=endofdata;
		this.identifier=identifier;
		this.mobilephone=mobilephone;
		this.LocationofBus=LocationofBus;
		this.gender=gender;
		// TODO Auto-generated constructor stub
	}

}
