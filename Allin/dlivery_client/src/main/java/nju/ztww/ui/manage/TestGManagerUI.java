package nju.ztww.ui.manage;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.user.PersonalMesageUI;
import nju.ztww.ui.user.ThemeLabelUI;

public class TestGManagerUI {
	JFrame frame;
	GManagerMenuUI MenuPanel = new GManagerMenuUI();
	ThemeLabelUI Theme = new ThemeLabelUI();
	GManager_ViewFormsUI viewFormsUI = new GManager_ViewFormsUI();
	GManager_CheckOrders checkOrdersUI = new GManager_CheckOrders();
	GManager_ManageOrgaUI manageOrgaUI = new GManager_ManageOrgaUI();
	GManager_ManageSalaryUI manageSalaryUI = new GManager_ManageSalaryUI();
	EditSearch editSearch=new EditSearch();
	PersonalMesageUI personInfo = new PersonalMesageUI();
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	private ArrayList<JPanel> list = new ArrayList<JPanel>();
	

	public void init(){
//		frame.setSize(900, 600);
//		frame.setTitle("Courier");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);
		
		MenuPanel.setBounds(0, 100, 150, 500);
		Theme.setBounds(150, 0, 750, 60);
		personInfo.setVisible(false);
//		manageSalaryUI.setBounds(210,60,690,480)
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(MenuPanel);
//		frame.getContentPane().add(Theme);
//		frame.getContentPane().add(manageSalaryUI);
		setListener();
//		frame.setVisible(true);
	}
	
	
	public void setListener(){
		panelList.add(viewFormsUI);
		panelList.add(checkOrdersUI);
		panelList.add(manageOrgaUI);
		panelList.add(manageSalaryUI);
		panelList.add(editSearch);
		panelList.add(personInfo);
	//	panelList.add(viewFormsUI);
		
		for(JPanel p : panelList){
			p.setBounds(150,100,750,450);
			p.setVisible(false);
// 			frame.add(p);
//			p.setVisible(false);
		}
		MenuPanel.CheckOrderButton.addActionListener(new GManager_Listener(frame,editSearch,panelList));
		MenuPanel.CheckOrdersButton.addActionListener(new GManager_Listener(frame,checkOrdersUI,panelList));
		MenuPanel.ManageOrgaButton.addActionListener(new GManager_Listener(frame,manageOrgaUI,panelList));
		MenuPanel.ManageSalaryButton.addActionListener(new GManager_Listener(frame,manageSalaryUI,panelList));
		MenuPanel.ViewFormsButton.addActionListener(new GManager_Listener(frame,viewFormsUI,panelList));
		MenuPanel.YourMessageButton.addActionListener(new GManager_Listener(frame, personInfo, panelList));
	}
	
	public TestGManagerUI(JFrame frame){
		this.frame  = frame;
		init();
	}
	
	public ArrayList<JPanel> getPanelList(){
		list.add(MenuPanel);
		list.add(Theme);
		for(JPanel p : panelList){
			list.add(p);
			//p.setVisible(false);
		}
		return list;
	}
//public static void main(String[] args){
//		new TestGManagerUI().init();
//	}
}
