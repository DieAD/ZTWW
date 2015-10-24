package nju.ztww.vo;

public class SuperviseeofInstitutionVO extends SuperviseeVO {
      public String id;//机构的代号
      public String name;//机构名称
      public int numberofworkers;//机构的人数
	public SuperviseeofInstitutionVO(String id,String name,int numberofworkers) {
		super(id);
		this.name=name;
		this.numberofworkers=numberofworkers;
		// TODO Auto-generated constructor stub
	}

}
