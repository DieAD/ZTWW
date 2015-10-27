package nju.ztww.po;

public class MemberPO extends OrderPO {
	public final String id;
	public final String name;
	public final String position;

	public MemberPO(String id, String name, String position){
		super(1);
		this.id = id;
		this.name = name;
		this.position = position;
	}
}
