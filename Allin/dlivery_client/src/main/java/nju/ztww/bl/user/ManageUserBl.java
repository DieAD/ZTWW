package nju.ztww.bl.user;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.ManaUserPO;
import nju.ztww.service.UserDataService;
import nju.ztww.vo.ManaUserVO;

public class ManageUserBl {

	private static String IP = "127.0.0.1";
	private static String port = "1010";
	private RMIHelper rHelper;
	private UserDataService userDataService;
	private ManaUserPO userPO;
	
	public boolean addUser(ManaUserVO user) {
		// TODO Auto-generated method stub
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		
		
		userPO = new ManaUserPO();
		userPO.setId(user.getID());
		userPO.setName(user.getName());
		userPO.setPsw(user.getPassword());
		userPO.setAuthority(user.getAuthority());
		userPO.setAge(user.getAge());
		userPO.setIdcard(user.getIDCard());
		if(user.getSex().equals("男"))  userPO.setSex(0);
		else userPO.setSex(1);
		userPO.setPhone(user.getPhone());
		userPO.setPosition(user.getPosition());
		
		userPO.setWetherwork(0);
		userPO.setWorktime(0);
		userPO.setSalarymethod(0);
		userPO.setSalary(0);
		userPO.setTimes(0);
		
		boolean result = userDataService.addUser(userPO);
		return result;
	}
	
}
