package nju.ztww.service_stub;

import java.util.ArrayList;

import nju.ztww.bl.user.UserBlTest;
import nju.ztww.service.UserService;
import nju.ztww.ui.finance.Position;
import nju.ztww.vo.ManaUserVO;
import nju.ztww.vo.MemberVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.UserVO;

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
	public UserVO getUser(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean addUser(ManaUserVO user) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<ManaUserVO> getManaUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean deleteUser(String deleteID) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean modify(ManaUserVO userNew) {
		// TODO Auto-generated method stub
		return false;
	}

}
