package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.data.user.UserData;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.UserDataService;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {
	UserData userData = new UserData();
	public UserDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberPO checkMember(String id, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		MemberPO member;
		member = userData.checkMember(id, password);
		return member;
	}

	public OrderPO checkOrder(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
