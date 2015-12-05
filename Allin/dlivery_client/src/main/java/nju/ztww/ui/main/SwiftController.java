package nju.ztww.ui.main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.ui.commodity.ClerkOfCenterUi;
import nju.ztww.ui.commodity.StorageUi;
import nju.ztww.ui.finance.FinanceUI;
import nju.ztww.ui.manage.TestGManagerUI;
import nju.ztww.ui.manage.TextManageUI;
import nju.ztww.ui.order.TestCourierUI;
import nju.ztww.ui.user.TextBussinessUI;
import nju.ztww.vo.MemberVO;

public class SwiftController {
    
	private ArrayList<JPanel> panelList ;
	//
	private TestCourierUI courierUI;
	private TextBussinessUI businessUI;
	private StorageUi storageUI;
	private FinanceUI financeUI;
	private ClerkOfCenterUi ccUI;
	private TestGManagerUI GMUI;
	private TextManageUI   MUI;
	private UserInfoUI userInfoUI;
	//
	private JFrame frame;
	private MemberVO member; 
	private String ID;
	private String password;
	private UserService userService = new UserLoginImpl();//by zyz
	private int id;
	private boolean jump = true;
	public SwiftController(JFrame frame){
		this.frame = frame;
		courierUI = new TestCourierUI(frame);
		businessUI = new TextBussinessUI(frame);
		financeUI =  new FinanceUI(frame);
		GMUI = new TestGManagerUI(frame);
		storageUI = new StorageUi();
		ccUI = new ClerkOfCenterUi();
		MUI = new TextManageUI();
		
	}
	
	
	public void switchUI(){
		panelList = MUI.getPanelList();

//		switch(id){
//		case 0: jump = false;break;
//		case 1: panelList = courierUI.getPanelList();break;
//		case 2: panelList = businessUI.getPanelList();break;
//		case 3: panelList = ccUI.getPanelList();break;
//		case 4: panelList = storageUI.getPanelList();break;
//		case 5: panelList = financeUI.getPanelList();break;
//		case 6: panelList = GMUI.getPanelList();break;
//		case 7: panelList = MUI.getPanelList();break;
//		default:{System.out.println("Switch UI error!");jump = false;}break;
//		
//		}
		userInfoUI = new UserInfoUI(ID);
		panelList.add(userInfoUI);
		
	}
	
	public void setUI(){
//		getID();
		switchUI();
	   if(jump){ 
		   frame.getContentPane().removeAll();
		   for(JPanel panel : panelList){
	    //	panel.setVisible(true);
			   frame.add(panel);
			   frame.getContentPane().repaint();
	    }
	   }else{
		   jump = true;
	   }
	}
	
	public void getID(){
		member = userService.login(ID, password); //by zyz
		if(member!=null&&member.getRight()){
			System.out.println(member.getID());
			String str = member.getID().charAt(8)+"";
			this.id = Integer.valueOf(str)+1;	
			System.out.println("position = " + id);
		}else if(member==null){
			System.out.println("不存在该用户");
			this.id = 0;
		}else{
			System.out.println("用户密码不匹配");//by zyz
		}
	}
	
	public void setMember(String ID, String password){
		this.ID = ID;
		this.password = password;
		
		
	}	//by zyz
}
