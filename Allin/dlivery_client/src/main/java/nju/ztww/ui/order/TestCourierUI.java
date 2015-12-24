package nju.ztww.ui.order;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.user.CheckOrdersUI;
import nju.ztww.ui.user.PersonalMesageUI;
import nju.ztww.ui.user.ThemeLabelUI;

//最近修改  王焕 11-17；
public class TestCourierUI {
	// 添加一个ArrayList
	private ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	//
	static JFrame frame =null;
	CourierMenuUI MenuPanel = new CourierMenuUI();
	ThemeLabelUI Theme = new ThemeLabelUI();
	private static int type = 2;

	static Courier_OrderInputUI OrderInput = new Courier_OrderInputUI();
	static Courier_AcceptUI Accept = new Courier_AcceptUI();
	static PersonalMesageUI personalMessagePanel;
	
	static EditSearch editSearch=new EditSearch();
	public void init() {
		// frame.setSize(900, 600);
		// frame.setTitle("Courier");
		// int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		// int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		// frame.setLocation((width-900)/2, (height-600)/2);
		// frame.setResizable(false);

		MenuPanel.setBounds(0, 100, 150, 600);
		Theme.setBounds(150, 0, 750, 60);
		OrderInput.setBounds(150, 100, 750, 450);
		Accept.setBounds(150, 100, 750, 450);
		editSearch.setBounds(150, 100, 750, 450);
		

		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);
		// frame.getContentPane().add(MenuPanel);
		// frame.getContentPane().add(Theme);
		// frame.getContentPane().add(Accept);
		// frame.setVisible(true);
	}

	// public static void main(String[] args){
	// new TestCourierUI().init();
	// }

	public static void changePanel(int i) {
		removePanel();
		if (i == 1) {
			frame.getContentPane().add(OrderInput);
			OrderInput.setVisible(true);
			type = 1;
		} else if (i == 2) {
			frame.getContentPane().add(Accept);
			Accept.setVisible(true);
			type = 2;
		} else if (i == 3) {
			frame.getContentPane().add(editSearch);
			editSearch.setVisible(true);
			type = 3;
		} else if (i == 4) {
			personalMessagePanel = new PersonalMesageUI();
			personalMessagePanel.setBounds(150, 100, 750, 450);
			 frame.getContentPane().add(personalMessagePanel);	 
			type = 4;
		}
	}

	public static void removePanel() {
		if (type == 1) {
			OrderInput.setVisible(false);
			frame.remove(OrderInput);
		} else if (type == 2) {
			Accept.setVisible(false);
			frame.remove(Accept);
		} else if (type == 3) {
			editSearch.setVisible(false);
			frame.remove(editSearch);
		} else if (type == 4) {
			personalMessagePanel.setVisible(false);
			 frame.remove(personalMessagePanel);
		}
	}

	// 新建addArrayList()
	public ArrayList<JPanel> getPanelList() {
		
		panelList.add(MenuPanel);
		panelList.add(Theme);
		panelList.add(OrderInput);

		return panelList;
	}
  //新建一个构造方法
	public TestCourierUI(JFrame frame){
		this.frame  = frame;
		init();
	}
}
