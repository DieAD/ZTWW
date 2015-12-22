package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.DBHelper.DBForTraceForm;
import nju.ztww.data.commodity.CheckOrder;
import nju.ztww.po.TracePO;
import nju.ztww.service.CheckOrderDataService;

public class CheckOrderDataServiceImpl extends UnicastRemoteObject implements CheckOrderDataService {

	public CheckOrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<TracePO> findTrace(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<TracePO> stringlist=new ArrayList<TracePO>();
		CheckOrder checkorder=new CheckOrder();
		stringlist=checkorder.findTrace(id);
		return stringlist;
	}
	public static void main(String[]args) throws RemoteException{
		CheckOrderDataServiceImpl  co=new CheckOrderDataServiceImpl ();
		   DBForTraceForm  dbfortraceform=new DBForTraceForm ();
		   ArrayList<TracePO> stringist=new ArrayList<TracePO>();
		   stringist=co.findTrace("000000002") ;
	   }

	public void modifyBaoJing(String idofcenter, String number)
			throws RemoteException {
		// TODO Auto-generated method stub
		CheckOrder co=new CheckOrder();
		co.modifyBaoJing(idofcenter,number);
		
	}
// 找到这是当天第几次盘点
	public void modifyDao(String idofcenter, String number)
			throws RemoteException {
		// TODO Auto-generated method stub
		CheckOrder co=new CheckOrder();
		co.modifyDao(idofcenter,number);
		
		
		
	}

}
