package nju.ztww.service_stub;

import nju.ztww.bl.user.UserBlTest;
import nju.ztww.service.UserService;
import nju.ztww.ui.finance.Position;
import nju.ztww.vo.MemberVO;
import nju.ztww.vo.OrderVO;

public class UserService_stub implements UserService {
	private UserBlTest UserBl;
    public UserService_stub(){
    	UserBl = new UserBlTest();
    }
	public MemberVO login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO checkOrder(String order) {
		// TODO Auto-generated method stub
		OrderVO orderVO = UserBl.checkOrder(order);
		
		return orderVO;
	}

	public Position getState() {
		// TODO Auto-generated method stub
		return null;
	}

}
