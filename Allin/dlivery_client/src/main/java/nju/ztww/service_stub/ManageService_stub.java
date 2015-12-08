package nju.ztww.service_stub;

import java.util.ArrayList;

import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.po.MUserPO;
import nju.ztww.service.ManageService;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;
import nju.ztww.vo.SuperviseeVO;
import nju.ztww.vo.UserSalaryVO;

public class ManageService_stub implements ManageService {
         String id;//id指的是营业厅的编号(末尾区分了不同的被管理者种类)
	public ArrayList<SuperviseeVO> getSuperviseeList(String id) {
		ArrayList<SuperviseeVO> arraylist=new ArrayList<SuperviseeVO>();
		// TODO Auto-generated method stub
		return arraylist;
	}
    //测试得到一个被管理者的信息
	public SuperviseeVO getSupervisee(String id) {
		// TODO Auto-generated method stub
		return new SuperviseeVO(id);
	}

	public void addSupervisee(String id) {
		System.out.println("增加了");
		// TODO Auto-generated method stub

	}

	public void deleteSupervisee(String id) {
		System.out.println("此被管理者的信息已经被删除");
		// TODO Auto-generated method stub

	}

	public void modifySupervisee(String id) {
		System.out.println("信息已经被修改");
		// TODO Auto-generated method stub

	}
	public ArrayList<GenerateVO> getCheckOrder(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateInformation(ArrayList<IDVO> list) {
		// TODO Auto-generated method stub
		
	}
//	public void updateInformation(ArrayList<IDVO> list, int index) {
//		// TODO Auto-generated method stub
//		
//	}
	public String[] getItem(String index) {
		// TODO Auto-generated method stub
		return null;
	}
	public MUserPO getUserInfo(String index, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateInformation(ArrayList<IDVO> list, int index) {
		// TODO Auto-generated method stub
		
	}
	public MUserPO getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateUserSalary(UserSalaryVO vo) {
		// TODO Auto-generated method stub
		
	}
	public DCFormDO showDC(String city1, String city2) {
		// TODO Auto-generated method stub
		return null;
	}
	public InsDO showInsInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateIns(InsDO ins) {
		// TODO Auto-generated method stub
		
	}

}
