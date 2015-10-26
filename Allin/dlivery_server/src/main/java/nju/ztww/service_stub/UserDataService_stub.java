package nju.ztww.service_stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nju.ztww.data.user.UserData;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.service.UserDataService;

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

	//public MemberPO checkMember(String id, String password) {
		// TODO Auto-generated method stub
		//return null;
	//}

	public OrderPO checkOrder(String id) {
		// TODO Auto-generated method stub
		OrderPO orderPO = userData.findOrder(id);
		return orderPO;
	}

}
