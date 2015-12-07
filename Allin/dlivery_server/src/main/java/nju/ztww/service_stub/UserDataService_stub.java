package nju.ztww.service_stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.user.UserData;
import nju.ztww.po.ManaUserPO;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.UserPO;
import nju.ztww.service.UserDataService;
import nju.ztww.vo.ManaUserVO;

public class UserDataService_stub extends UnicastRemoteObject implements UserDataService {
    UserData userData = new UserData();
    /*
     * 测试实现远程方法的调用
     * 远程接口是否可以调用非接口方法？/貌似可以~
     * 10-26
     */
	public  UserDataService_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberPO checkMember(String id, String password)throws RemoteException {
		// TODO Auto-generated method stub		
		return null;
	}

	public OrderPO checkOrder(String id) throws RemoteException {
		// TODO Auto-generated method stub
		OrderPO orderPO = userData.findOrder(id);
		return orderPO;
	}

	public UserPO findUser(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addUser(ManaUserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ManaUserPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ManaUserPO findByID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String update(ManaUserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
