package nju.ztww.serviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import nju.ztww.data.finance.FinanceData;
import nju.ztww.po.AccountPO;
import nju.ztww.po.CollectionPO;
import nju.ztww.po.MemberPO;
import nju.ztww.po.OrderPO;
import nju.ztww.po.PaymentPO;
import nju.ztww.service.FinanceDataService;

public class FinanceDataServiceImpl extends UnicastRemoteObject implements FinanceDataService {
    private FinanceData financeData = new FinanceData();
	public FinanceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean update(MemberPO member, double salary, String pattern)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public AccountPO checkAccount(String accountID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkList(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(String diagram) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String diagram) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public double calcuIncome(ArrayList everyList) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<CollectionPO> queryCollection(String querydate,
			String queryholl) throws RemoteException {
		
		return financeData.queryByDate(querydate, queryholl);
	}

	public boolean addPaymentForm(ArrayList<PaymentPO> list)throws RemoteException {
		// TODO Auto-generated method stub
		financeData.addPaymentForm(list);
		return true;
	}
      
}
