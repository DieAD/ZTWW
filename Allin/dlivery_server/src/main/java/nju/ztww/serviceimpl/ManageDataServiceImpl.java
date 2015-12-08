package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.data.manage.ManageData;
import nju.ztww.po.GeneratePO;
import nju.ztww.po.MUserPO;
import nju.ztww.po.SuperviseePO;
import nju.ztww.po.UserSalaryPO;
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

	public ArrayList<MUserPO> getItems(String index) throws RemoteException {
		// TODO Auto-generated method stub
		return md.getItems(index);
	}

	public MUserPO getUserInfoById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return md.getUserInfoById(id);
	}

	public void updateUserSalary(UserSalaryPO userinfo) throws RemoteException {
		// TODO Auto-generated method stub
		md.upDateSalary(userinfo);
	}

	public DCFormDO showD(String city1, String city2) throws RemoteException {
		// TODO Auto-generated method stub
		return md.showDC(city1, city2);
	}

	public InsDO showInsInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return md.showInsInfo(id);
	}

	public void updateIns(InsDO ins) throws RemoteException {
		// TODO Auto-generated method stub
		md.updateIns(ins);
	}

}
