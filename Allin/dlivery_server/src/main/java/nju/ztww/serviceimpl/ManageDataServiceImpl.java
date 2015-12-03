package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.manage.ManageData;
import nju.ztww.po.GeneratePO;
import nju.ztww.po.SuperviseePO;
import nju.ztww.service.ManageDataService;

public class ManageDataServiceImpl extends UnicastRemoteObject implements ManageDataService{
    private ManageData md  = new ManageData();
	public ManageDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert(SuperviseePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(SuperviseePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public SuperviseePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(SuperviseePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GeneratePO> getCheckOrder(int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		return md.getCheckOrder(index);
	}

}
