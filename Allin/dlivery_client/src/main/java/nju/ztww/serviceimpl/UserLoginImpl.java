package nju.ztww.serviceimpl;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import nju.ztww.bl.user.GetUserBl;
import nju.ztww.bl.user.ManageUserBl;
import nju.ztww.bl.user.UserLogin;
import nju.ztww.service.UserService;
import nju.ztww.ui.finance.Position;
import nju.ztww.vo.ManaUserVO;
import nju.ztww.vo.MemberVO;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.UserVO;

public class UserLoginImpl implements UserService{
	UserLogin login = new UserLogin();
	GetUserBl getUserBl = new GetUserBl();
	ManageUserBl manageUser = new ManageUserBl();

	public MemberVO login(String id, String password) {
		// TODO Auto-generated method stub
		MemberVO Nmember = new MemberVO(id, password);
		MemberVO Rmember = login.checkMember(Nmember);
//		System.out.println(Rmember.getID());
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

	public UserVO getUser(String ID) {
		// TODO Auto-generated method stub
		UserVO user = getUserBl.getUser(ID);
		return user;
	}

	public boolean addUser(ManaUserVO user) {
		// TODO Auto-generated method stub
		boolean result = manageUser.addUser(user);
		return result;
	}

	public ArrayList<ManaUserVO> getManaUsers() {
		// TODO Auto-generated method stub
		ArrayList<ManaUserVO> users = manageUser.getUsers();
		return users;
	}

	public boolean deleteUser(String deleteID) {
		// TODO Auto-generated method stub
		boolean whetherDelete = manageUser.deleteUser(deleteID);
		return whetherDelete;
	}

	public boolean modify(ManaUserVO userNew) {
		// TODO Auto-generated method stub
		boolean result = manageUser.modifyUser(userNew);
		return result;
	}
}
