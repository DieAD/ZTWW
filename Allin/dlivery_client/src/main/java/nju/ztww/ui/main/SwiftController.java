package nju.ztww.ui.main;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

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
		panelList.add(0, new JPanel());
	}
	
	public void setUI(){
		getID();
		switchUI();
		JPanel tempP = new JPanel();
		tempP.setBounds(0, 0, 900, 600);
		tempP.setLayout(null);
		tempP.setOpaque(false);
		  
	   if(jump){ 
		   frame.getContentPane().removeAll();
		   bg.setBounds(0, 0, 900, 600);
		   frame.setContentPane(bg);
//		   bg.repaint();
//		   frame.repaint();
		  // frame.add(icon2);
//		   bg.setIcon(new ImageIcon("photo2/bg.png"));
		  // bg.setBounds(0, 0, 900, 600);
		   
		  
		  // frame.repaint();
		   for(JPanel panel : panelList){
	    //	panel.setVisible(true);
			   panel.setOpaque(false);
			   panel.setBorder(null);
			  // tempP.add(panel);
			   bg.add(panel);
//			   xiaoGuo(bg,panel);
			  // bg.repaint();
	    }
		   userInfoUI.setOpaque(true);
		  // bg.add(tempP);
		 bg.add(tipsUI);
		 xiaoGuo(bg,bg);
		  
		//   bg.add(tempP);
		 //  xiaoGuo(bg,tempP);
		  
		  // frame.add(bg);
		  // frame.repaint();
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
	//
	public void xiaoGuo(final JPanel panel,final JPanel centerPanel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 20) {
									// 设置面板位置
									currentPanel.setBounds(i, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									panel.setBounds(y, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 20;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}
//
//		if (!list.contains(panel)) {
//			centerPanel.add(panel);// 添加要切换的面板
//		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}
}
