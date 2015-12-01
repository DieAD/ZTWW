package nju.ztww.bl.user;

import nju.ztww.RMI.RMIHelper;
import nju.ztww.po.UserPO;
import nju.ztww.service.UserDataService;
import nju.ztww.vo.UserVO;

public class GetUserBl {

	private static String IP = "127.0.0.1";
	private static String port = "1010";
	private RMIHelper rHelper;
	private UserDataService userDataService;
	
	
	public UserVO getUser(String ID) {
		// TODO Auto-generated method stub
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		UserPO userPO = userDataService.findUser(ID);
		UserVO user = new UserVO();
		user.setAge(userPO.getAge());
		user.setID(userPO.getID());
		user.setSex(userPO.getSex());
		user.setName(userPO.getName());
		user.setIDCard(userPO.getIDCard());
		user.setWorkTime(userPO.getWorkTime());
		user.setSalary(userPO.getSalary());
		
		
		return user;
	}
	
}
