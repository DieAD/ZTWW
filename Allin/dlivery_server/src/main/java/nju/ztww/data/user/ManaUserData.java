package nju.ztww.data.user;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import nju.ztww.DBHelper.DBHelper;
import nju.ztww.dao.UserDO;
import nju.ztww.po.ManaUserPO;
import nju.ztww.po.UserPO;

public class ManaUserData {
	
	DBHelper dbHelper = new DBHelper();
    
	public boolean addUser(ManaUserPO user) {
		// TODO Auto-generated method stub
		 ArrayList<UserDO> 	list = new ArrayList<UserDO>();
		dbHelper.init();
		UserDO userDO = new UserDO();
		userDO.setId(user.getId());
		userDO.setName(user.getName());
		userDO.setPsw(user.getPsw());
		userDO.setAuthority(user.getAuthority());
		userDO.setAge(user.getAge());
		userDO.setWorktime(user.getWorktime());
		userDO.setIdcard(user.getIdcard());
		userDO.setSalarymethod(user.getSalarymethod());
		userDO.setSalary(user.getSalary());
		userDO.setWetherwork(user.getWetherwork());
		userDO.setSex(user.getSex());
		userDO.setPhone(user.getPhone());
		userDO.setTimes(user.getTimes());
		userDO.setPosition(user.getPosition());
		list.add(userDO);
		dbHelper.insert(list, "userstable");
		dbHelper.close();
		boolean result = true;
		return result;
	}

	public ArrayList<ManaUserPO> getUsers() {
		// TODO Auto-generated method stub
		//从数据库中得到所有用户信息的DO，并转化为PO输出
		//stub==假装传俩PO出去
		
		ArrayList<ManaUserPO> userPOs = new ArrayList<ManaUserPO>();
		dbHelper.init();
		ArrayList<UserDO> userDOs = dbHelper.queryAll("userstable");
		for(UserDO userDO : userDOs){
			ManaUserPO user = new ManaUserPO();
			user.setId(userDO.getId());
			user.setName(userDO.getName());
			user.setPsw(userDO.getPsw());
			user.setAuthority(userDO.getAuthority());
			user.setAge(userDO.getAge());
			user.setIdcard(userDO.getIdcard());
			user.setSex(userDO.getSex());
			user.setPhone(userDO.getPhone());
			user.setPosition(userDO.getPosition());
			userPOs.add(user);
		}
		dbHelper.close();
		return userPOs;
	}

	public boolean deleteUser(String deleteID) {
		// TODO Auto-generated method stub
		dbHelper.init();
		if(deleteID!=null){
			System.out.println("我要删除啦你啦——deleteID:"+deleteID);
			dbHelper.delete(deleteID, "userstable");
		}
		dbHelper.close();
		return true;
	}

	public boolean modifyUser(ManaUserPO user) {
		// TODO Auto-generated method stub
		
		dbHelper.init();
		ArrayList<UserDO> list = dbHelper.queryByID(user.getId(), "userstable");
		if(list.size()!=0){
			UserDO userDO = list.get(0);
			userDO.setId(user.getId());
			userDO.setName(user.getName());
			userDO.setPsw(user.getPsw());
			userDO.setAuthority(user.getAuthority());
			userDO.setAge(user.getAge());
//			userDO.setWorktime(user.getWorktime());
			userDO.setIdcard(user.getIdcard());
//			userDO.setWetherwork(user.getWetherwork());
			userDO.setSex(user.getSex());
			userDO.setPhone(user.getPhone());
			userDO.setPosition(user.getPosition());
			ArrayList<UserDO> list2 = new ArrayList<UserDO>();
			list2.add(userDO);
			dbHelper.updateByID(list2, "userstable");
			dbHelper.close();
			System.out.println("modify succeed!");
			return true;
		}else{
			dbHelper.close();
			return false;
		}
	}

}
