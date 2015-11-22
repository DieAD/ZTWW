package nju.ztww.serviceimpl;

import nju.ztww.bl.user.UserLogin;
import nju.ztww.service.UserService;
import nju.ztww.ui.finance.Position;
import nju.ztww.vo.MemberVO;
import nju.ztww.vo.OrderVO;

public class UserLoginImpl implements UserService{
	UserLogin login = new UserLogin();
	

	public MemberVO login(String id, String password) {
		// TODO Auto-generated method stub
		MemberVO Nmember = new MemberVO(id, password);
		MemberVO Rmember = login.checkMember(Nmember);
		return Rmember;
	}

	public OrderVO checkOrder(String order) {
		// TODO Auto-generated method stub
		return null;
	}

	public Position getState() {
		// TODO Auto-generated method stub
		return null;
	}
}
