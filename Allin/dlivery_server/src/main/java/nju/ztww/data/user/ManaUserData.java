package nju.ztww.data.user;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import nju.ztww.DBHelper.DBHelper;
import nju.ztww.dao.UserDO;
import nju.ztww.po.ManaUserPO;

public class ManaUserData {
	
	DBHelper dbHelper = new DBHelper();
    ArrayList<UserDO> list ;   
    
	public boolean addUser(ManaUserPO user) {
		// TODO Auto-generated method stub
		list = new ArrayList<UserDO>();
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
		list.add(userDO);
		dbHelper.insert(list, "userstable");
		dbHelper.close();
		boolean result = true;
//		System.out.println("successful!!!!!!!!");
		return result;
	}
	
	public ArrayList<ManaUserPO> findAll(){
		ArrayList<ManaUserPO> list = new ArrayList<ManaUserPO>();
		dbHelper.init();
		list=dbHelper.queryAll("userstable");
		return list;
	}
	
	public ManaUserPO findByID(String ID){
		dbHelper.init();
		ArrayList<UserDO> list=dbHelper.queryByID(ID, "userstable");
		UserDO user=list.get(0);
		ManaUserPO userDO=new ManaUserPO();
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
		return userDO;
	}
	
	public String update(ManaUserPO user){
		list = new ArrayList<UserDO>();
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
		list.add(userDO);
		
		String result=dbHelper.updateByID(list, "userstable");
		return result;
	}

}
