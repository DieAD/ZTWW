package nju.ztww.bl.user;

import java.rmi.Naming;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.MemberPO;
import nju.ztww.service.UserDataService;
//import nju.ztww.serviceimpl.UserLoginDataImpl;
import nju.ztww.vo.MemberVO;

//专用于登录时鉴定账号和密码
public class UserLogin {
	private static String IP = "127.0.0.1";
	private static String port = "1020";
	private RMIHelper rHelper;
	private String id;
	private String password;
	private boolean isLegal;   //PO中有VO种没有 仅用于判断
	private boolean isRight;   //账户密码是否匹配
	private String position;
	private UserDataService userDataService;
	private MemberPO mem;
	
	public MemberVO checkMember(MemberVO member){  //先从ui层得到一个只含id和password的MemberVO
		this.id = member.getID();
		this.password = member.getPassword(); //从传过来的MemberVO中得到id和password
//		MemberPO mem = new MemberPO(id, password);    //新建一个MemberPO对象，把id和password传过去，让数据层做判断
		//TODO
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		mem = userDataService.checkMember(id, password);
		if(mem==null) System.out.println("!!!!!!!!!!!!!!");
		this.isLegal = mem.getLegal();
		this.isRight = mem.getRight();     //判断这个账号是否存在、账户密码是否匹配、职位
		return this.returnMember();
	}
	
	public MemberVO returnMember(){
		MemberVO myMember = new MemberVO(id, password);
		if(isLegal){        //判断是否存在该账户
			myMember.setPosition(position);
			myMember.setRight(isRight);
			return myMember;
		}
		else{
			return null;
		}
	}
	
}
