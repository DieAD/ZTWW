package nju.ztww.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.po.GeneratePO;
import nju.ztww.po.MUserPO;
import nju.ztww.po.SuperviseePO;
import nju.ztww.po.UserSalaryPO;

/*
 * Date:
 * Author:
 */

public interface ManageDataService extends Remote {
//TODO// 插入一个订单信息
	public void insert(SuperviseePO po) throws RemoteException;
	//删除一个订单信息
	public void delete(SuperviseePO po) throws RemoteException;
	//找到一个订单信息
	public SuperviseePO find(String id) throws RemoteException;
	//更新一个订单的具体信息
	public void update(SuperviseePO po) throws RemoteException;
	
	public ArrayList<GeneratePO> getCheckOrder(int index)throws RemoteException;
	
	public ArrayList<MUserPO> getItems(String index)throws RemoteException;
	
	public MUserPO getUserInfoById(String id)throws RemoteException;
	
	public void updateUserSalary(UserSalaryPO userinfo) throws RemoteException;
	
	public DCFormDO showD(String city1,String city2) throws RemoteException;
	
	public InsDO showInsInfo(String id)throws RemoteException;
	
	public void updateIns (InsDO ins)throws RemoteException;
	
	

}
