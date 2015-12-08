package nju.ztww.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.po.GeneratePO;
import nju.ztww.po.MUserPO;
import nju.ztww.po.SuperviseePO;
import nju.ztww.po.UserSalaryPO;

public interface ManageDataService {
	//TODO// 插入一个被管理者的信息
		public void insert(SuperviseePO po);
		//删除一个被管理者的信息
		public void delete(SuperviseePO po);
		//找到一个被管理者信息
		public SuperviseePO find(String id);
		//更新一个被管理者的具体信息
		public void update(SuperviseePO po);
		public ArrayList<GeneratePO> getCheckOrder(int index)throws RemoteException;
		
		public ArrayList<MUserPO> getItems(String index)throws RemoteException;
		public MUserPO getUserInfoById(String id)throws RemoteException;
		public void updateUserSalary(UserSalaryPO userinfo) throws RemoteException;
		public DCFormDO showD(String city1,String city2);
		public InsDO showInsInfo(String id)throws RemoteException;
		
		public void updateIns (InsDO ins)throws RemoteException;
}

