package nju.ztww.ui.manage;

/**
 * 田琦
 * 
 * */
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.user.ThemeLabelUI;

public class TextManageUI {
	
	static JFrame frame=new JFrame();
	ThemeLabelUI lablePanel=new ThemeLabelUI();
	ManageUI panel=new ManageUI();
	UserManageUI userManagePanel=new UserManageUI();
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	
	public void init(){
        //注掉
//		frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);

		//
		panel.setBounds(0, 0, 210, 600);
		lablePanel.setBounds(210, 0, 690, 60);
		userManagePanel.setBounds(210,60,690,480);

//注掉
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(panel);
//		frame.getContentPane().add(userManagePanel);
//		frame.getContentPane().add(lablePanel);
//		frame.setVisible(true);
		//
	}
	
	public TextManageUI(){
		init();
		panel.setBounds(0, 100, 150, 500);
		lablePanel.setBounds(150, 0, 750, 60);
		userManagePanel.setBounds(150,100,750,450);
	}
	
	public ArrayList<JPanel> getPanelList(){
		panelList.add(lablePanel);
		panelList.add(panel);
		panelList.add(userManagePanel);
		return panelList;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		new TextManageUI().init();
//		
//	}

}
