package nju.ztww.serviceimpl;

import java.util.ArrayList;

import nju.ztww.bl.manage.ManageBL;
import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.po.MUserPO;
import nju.ztww.service.ManageService;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;
import nju.ztww.vo.SuperviseeVO;
import nju.ztww.vo.UserSalaryVO;

public class ManageServiceImpl implements ManageService {
    private ManageBL manageBL = new ManageBL();
	public ArrayList<SuperviseeVO> getSuperviseeList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperviseeVO getSupervisee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addSupervisee(String id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSupervisee(String id) {
		// TODO Auto-generated method stub
		
	}

	public void modifySupervisee(String id) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<GenerateVO> getCheckOrder(int index) {
		// TODO Auto-generated method stub
		return manageBL.getCheckOrder(index);
	}

	public void updateInformation(ArrayList<IDVO> list,int index) {
		// TODO Auto-generated method stub
		manageBL.updateInfo(list, index);
		
	}

	public String[] getItem(String index) {
		// TODO Auto-generated method stub
		return manageBL.getItems(index);
	}

	public MUserPO getUserInfo(String index, String name) {
		// TODO Auto-generated method stub
		return manageBL.getUserInfo(index, name);
	}

	public MUserPO getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return manageBL.getUserInfoById(id);
	}

	public void updateUserSalary(UserSalaryVO vo) {
		// TODO Auto-generated method stub
		manageBL.updateUserSalary(vo);
	}

	public DCFormDO showDC(String city1, String city2) {
		// TODO Auto-generated method stub
		return manageBL.showDC(city1, city2);
	}

	public InsDO showInsInfo(String id) {
		// TODO Auto-generated method stub
		return manageBL.showInsInfo(id);
	}

	public void updateIns(InsDO ins) {
		// TODO Auto-generated method stub
		manageBL.updateIns(ins);
	}

}
