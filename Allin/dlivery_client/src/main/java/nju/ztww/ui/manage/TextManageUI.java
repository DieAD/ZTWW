package nju.ztww.ui.manage;

/**
 * 田琦
 * 
 * */
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.user.ManaUserControllerUI;
import nju.ztww.ui.user.PersonalMesageUI;
import nju.ztww.ui.user.ThemeLabelUI;

public class TextManageUI {

	static JFrame frame = new JFrame();
	ThemeLabelUI lablePanel = new ThemeLabelUI();
	EditSearch editSearch=new EditSearch();
	ManageUI panel = new ManageUI();
	UserManageUI userManagePanel = new UserManageUI();
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<JPanel> arraylist = new ArrayList<JPanel>();
	PersonalMesageUI personInfo;

	public void init() {
		// 注掉
		// frame.setSize(900, 600);
		// frame.setTitle("Bussiness");
		// int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		// int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		// frame.setLocation((width-900)/2, (height-600)/2);
		// frame.setResizable(false);

		//
		panel.setBounds(0, 100, 150, 500);
		lablePanel.setBounds(150, 0, 750, 60);
		userManagePanel.setBounds(150, 100, 750, 450);
		editSearch.setBounds(150, 100, 750, 450);
		personInfo = new PersonalMesageUI();
		personInfo.setBounds(150, 100, 750, 450);
		personInfo.setVisible(false);

		// 注掉
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);
		// frame.getContentPane().add(panel);
		// frame.getContentPane().add(userManagePanel);
		// frame.getContentPane().add(lablePanel);
		// frame.setVisible(true);
		//
	}

	public TextManageUI() {
		init();
		setController();
		// panel.setBounds(0, 100, 150, 500);
		// lablePanel.setBounds(150, 0, 750, 60);
		// userManagePanel.setBounds(150,100,750,450);
	}

	public ArrayList<JPanel> getPanelList() {
		panelList.add(lablePanel);
		panelList.add(panel);
		panelList.add(userManagePanel);
		panelList.add(personInfo);
		panelList.add(editSearch);
		return panelList;
	}

	public void setController() {
		arraylist.add(userManagePanel);
		arraylist.add(personInfo);
		arraylist.add(editSearch);
		panel.UserManageButton.addActionListener(new ManaUserControllerUI(
				frame, userManagePanel, arraylist));
		panel.YourMessageButton.addActionListener(new ManaUserControllerUI(
				frame, personInfo, arraylist));
		panel.CheckOrderButton.addActionListener(new ManaUserControllerUI(
				frame, editSearch, arraylist));
	}
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// new TextManageUI().init();
	//
	// }

}
