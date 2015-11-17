package nju.ztww.serviceimpl;

import nju.ztww.bl.user.UserLogin;
import nju.ztww.vo.MemberVO;

public class UserLoginImpl {
	UserLogin login = new UserLogin();
	
	public MemberVO checkMember(MemberVO mem){
		MemberVO member = login.checkMember(mem);
		return member;
	}
}
