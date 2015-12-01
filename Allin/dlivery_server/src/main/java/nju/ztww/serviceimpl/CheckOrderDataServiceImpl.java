package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.commodity.CheckOrder;
import nju.ztww.service.CheckOrderDataService;

public class CheckOrderDataServiceImpl extends UnicastRemoteObject implements CheckOrderDataService {

	public CheckOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> findTrace(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> stringlist=new ArrayList<String>();
		CheckOrder checkorder=new CheckOrder();
		stringlist=checkorder.findTrace(id);
		return stringlist;
	}

}
