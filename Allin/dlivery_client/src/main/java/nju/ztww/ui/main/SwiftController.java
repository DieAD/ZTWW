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
	private TipsUI tipsUI;
	private AnnounceUI otherAnnounceUI;
	private AnnounceForManageUI announceForManageUI;
	//
	private JFrame frame;
	private MemberVO member; 
	private String ID;
	private String password;
	private UserService userService = new UserLoginImpl();//by zyz
	private int id;
	private boolean jump = true;
//	Image icon2=new ImageIcon("photo2/bg.png").getImage();
	public static BGPanel bg = new BGPanel();
//	bg.setIcon(new ImageIcon("photo/bg.png"));
//	bg.setBounds(0, 0, 900, 600);
	public SwiftController(JFrame frame){
		this.frame = frame;
		
	}
	
	private void initPanel(){
//		courierUI = new TestCourierUI(frame);
//		businessUI = new TextBussinessUI(frame);
//		financeUI =  new FinanceUI(frame);
//		GMUI = new TestGManagerUI(frame);
//		storageUI = new StorageUi();
//		ccUI = new ClerkOfCenterUi();
//		MUI = new TextManageUI();
		
	}
	public void switchUI(){

//		panelList = GMUI.getPanelList();
		userInfoUI = new UserInfoUI(ID);
		initPanel();
//		panelList = courierUI.getPanelList();


		switch(id){
		case 0: jump = false;break;
		case 1: courierUI = new TestCourierUI(frame);;panelList = courierUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		case 2: businessUI = new TextBussinessUI(frame);panelList = businessUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		case 3:ccUI = new ClerkOfCenterUi(); panelList = ccUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		case 4:storageUI = new StorageUi(); panelList = storageUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		case 5:financeUI =  new FinanceUI(frame); panelList = financeUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		case 6:GMUI = new TestGManagerUI(frame); panelList = GMUI.getPanelList();
		announceForManageUI = new AnnounceForManageUI();panelList.add(announceForManageUI);break;
		case 7:MUI = new TextManageUI();
		 panelList = MUI.getPanelList();
		otherAnnounceUI=new AnnounceUI();panelList.add(otherAnnounceUI);break;
		default:{System.out.println("Switch UI error!");jump = false;}break;
		
		}
		
		panelList.add(userInfoUI);
		tipsUI = new TipsUI();
		panelList.add(tipsUI);
		
	}
	
	public void setUI(){
		getID();
		switchUI();
	   if(jump){ 
		   frame.getContentPane().removeAll();
		  // frame.add(icon2);
//		   bg.setIcon(new ImageIcon("photo2/bg.png"));
		   bg.setBounds(0, 0, 900, 600);
		   
		  
		  // frame.repaint();
		   for(JPanel panel : panelList){
	    //	panel.setVisible(true);
			   panel.setOpaque(false);
			   panel.setBorder(null);
			   bg.add(panel);
			   bg.repaint();
	    }
		  // userInfoUI.setOpaque(true);
		   frame.add(bg);
		   frame.repaint();
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
		}
}
