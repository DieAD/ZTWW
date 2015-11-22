package nju.ztww.ui.manage;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.MenuePanel;
import nju.ztww.ui.user.ThemeLabelUI;

public class TestGManagerUI {
	JFrame frame;
	GManagerMenuUI MenuPanel = new GManagerMenuUI();
	ThemeLabelUI Theme = new ThemeLabelUI();
	GManager_ViewFormsUI viewFormsUI = new GManager_ViewFormsUI();
	GManager_CheckOrders checkOrdersUI = new GManager_CheckOrders();
	GManager_ManageOrgaUI manageOrgaUI = new GManager_ManageOrgaUI();
	GManager_ManageSalaryUI manageSalaryUI = new GManager_ManageSalaryUI();
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	private ArrayList<JPanel> list = new ArrayList<JPanel>();
	

	public void init(){
//		frame.setSize(900, 600);
//		frame.setTitle("Courier");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);
		
		MenuPanel.setBounds(0, 0, 210, 600);
		Theme.setBounds(210, 0, 690, 60);
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
	//	panelList.add(viewFormsUI);
		
		for(JPanel p : panelList){
			p.setBounds(210,60,690,480);
			p.setVisible(false);
// 			frame.add(p);
//			p.setVisible(false);
		}
		MenuPanel.CheckOrdersButton.addActionListener(new GManager_Listener(frame,checkOrdersUI,panelList));
		MenuPanel.ManageOrgaButton.addActionListener(new GManager_Listener(frame,manageOrgaUI,panelList));
		MenuPanel.ManageSalaryButton.addActionListener(new GManager_Listener(frame,manageSalaryUI,panelList));
		MenuPanel.ViewFormsButton.addActionListener(new GManager_Listener(frame,viewFormsUI,panelList));
		
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
