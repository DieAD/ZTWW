package nju.ztww.ui.order;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.main.SwiftController;
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
	private static int type = 1;

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

		MenuPanel.setBounds(25, 150, 150, 320);
		Theme.setBounds(200, 0, 670, 120);
		OrderInput.setBounds(200,120,670,410);
		Accept.setBounds(200,120,670,410);
		editSearch.setBounds(200,120,670,410);
		Accept.setOpaque(false);
		

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
			SwiftController.bg.add(OrderInput);
			OrderInput.setVisible(true);
			type = 1;
		} else if (i == 2) {
			SwiftController.bg.add(Accept);
			Accept.setVisible(true);
			type = 2;
		} else if (i == 3) {
			SwiftController.bg.add(editSearch);
			editSearch.setVisible(true);
			type = 3;
		} else if (i == 4) {
			personalMessagePanel = new PersonalMesageUI();
			personalMessagePanel.setBounds(200,120,670,410);
			SwiftController.bg.add(personalMessagePanel);	 
			type = 4;
		}
		SwiftController.bg.repaint();
	}

	public static void removePanel() {
//		OrderInput.setVisible(false);
//		Accept.setVisible(false);
//		editSearch.setVisible(false);
//		personalMessagePanel.setVisible(false);
		if (type == 1) {
			OrderInput.setVisible(false);
			SwiftController.bg.remove(OrderInput);
		} else if (type == 2) {
			Accept.setVisible(false);
			SwiftController.bg.remove(Accept);
		} else if (type == 3) {
			editSearch.setVisible(false);
			SwiftController.bg.remove(editSearch);
		} else if (type == 4) {
			personalMessagePanel.setVisible(false);
			SwiftController.bg.remove(personalMessagePanel);
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
