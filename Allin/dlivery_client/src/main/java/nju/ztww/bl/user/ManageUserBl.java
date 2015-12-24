package nju.ztww.bl.user;

import java.util.ArrayList;

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
	private ManaUserVO userVO;
	ArrayList<ManaUserVO> list2=new ArrayList<ManaUserVO>();
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
		userPO.setSex(user.getSex());
		userPO.setPhone(user.getPhone());
		userPO.setPosition(user.getPosition());
		
		userPO.setWetherwork(user.getWetherwork());
		userPO.setWorktime(user.getWorktime());
		userPO.setSalarymethod(0);
		userPO.setSalary(0);
		userPO.setTimes(0);
		
		boolean result = userDataService.addUser(userPO);
		return result;
	}
	
	public ArrayList<ManaUserVO> findAll(){
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		ArrayList<ManaUserPO> list=userDataService.findAll();
		
		for(ManaUserPO temp:list){
			userVO=new ManaUserVO(temp.getId(),temp.getName(),temp.getPsw(),temp.getAuthority(),
					temp.getAge(),temp.getIdcard(),temp.getSex(),temp.getPhone(),temp.getPosition(),temp.getWorktime(),temp.getWetherwork());
		    list2.add(userVO);
		}
		return list2;
	}
	
	public ManaUserVO findByID(String ID){
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		ManaUserPO temp=userDataService.findByID(ID);
		ManaUserVO userVO=new ManaUserVO(temp.getId(),temp.getName(),temp.getPsw(),temp.getAuthority(),
				temp.getAge(),temp.getIdcard(),temp.getSex(),temp.getPhone(),temp.getPosition(),temp.getWorktime(),temp.getWetherwork());
		userVO.position = temp.getPosition();
		System.out.print(temp.getPosition());
		return userVO;
	}
	
	public String update(ManaUserVO user){
		rHelper = new RMIHelper(IP, port);
		userDataService = (UserDataService)rHelper.findService("UserDataService");
		
		
		userPO = new ManaUserPO();
		userPO.setId(user.getID());
		userPO.setName(user.getName());
		userPO.setPsw(user.getPassword());
		userPO.setAuthority(user.getAuthority());
		userPO.setAge(user.getAge());
		userPO.setIdcard(user.getIDCard());
		userPO.setSex(user.getSex());
		userPO.setPhone(user.getPhone());
		userPO.setPosition(user.getPosition());
		
		userPO.setWetherwork(user.getWetherwork());
		userPO.setWorktime(user.getWorktime());
		userPO.setSalarymethod(0);
		userPO.setSalary(0);
		userPO.setTimes(0);
		
		String result = userDataService.update(userPO);
		return result;
	}
}
