package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.data.user.ManaUserData;
import nju.ztww.data.user.UserData;
import nju.ztww.po.ManaUserPO;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.UserPO;
import nju.ztww.service.UserDataService;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {
	UserData userData = new UserData();
	ManaUserData manaUserData = new ManaUserData();
	public UserDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberPO checkMember(String id, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		MemberPO member;
		System.out.println("id = "+id+"  password = "+password);

		member = userData.checkMember(id, password);
		return member;
	}

	public OrderPO checkOrder(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO findUser(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO user = userData.findUser(ID);
		return user;
	}

	public boolean addUser(ManaUserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = manaUserData.addUser(user);
		return result;
	}

}
