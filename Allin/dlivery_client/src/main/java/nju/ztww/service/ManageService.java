package nju.ztww.service;

import java.util.ArrayList;

import nju.ztww.dao.DCFormDO;
import nju.ztww.dao.InsDO;
import nju.ztww.po.MUserPO;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;
import nju.ztww.vo.SuperviseeVO;
import nju.ztww.vo.UserSalaryVO;

public interface ManageService {
	//通过id（指的是区别车辆信息，司机以及机构的编号）来获取一张信息表
	//id的末尾几位标识标记处被管理者的不同类型
     public ArrayList<SuperviseeVO> getSuperviseeList(String id);
     
    //通过id（指的是具体的某个被管理者的身份编号）得到原有被管理者的信息
     public SuperviseeVO getSupervisee(String id);
     
     //通过id（指的是具体的某个被管理者的身份编号）在被管理者信息列表中增加此信息
     public void addSupervisee(String id);
     
     //通过id（指的是具体的某个被管理者的身份编号）在被管理者信息列表中删除此信息
     public void deleteSupervisee(String id);
     
   //通过id（指的是具体的某个被管理者的身份编号）在被管理者信息列表中删除此信息
     public void modifySupervisee(String id);
     
     public ArrayList<GenerateVO> getCheckOrder(int index);
        
     public void  updateInformation(ArrayList<IDVO> list,int index);
     
     public String[] getItem(String index);
     
     public MUserPO getUserInfo(String index,String name);
     
     public MUserPO getUserInfoById(String id);
     
     public void updateUserSalary(UserSalaryVO vo);
     
     public DCFormDO showDC(String city1,String city2);
     
     public InsDO showInsInfo(String id);
     
     public void updateIns(InsDO ins);
     
     
}
