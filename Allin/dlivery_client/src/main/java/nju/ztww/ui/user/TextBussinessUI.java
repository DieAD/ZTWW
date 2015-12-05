package nju.ztww.ui.user;

import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
//最近修改 王焕 11-17
public class TextBussinessUI {
	
	static JFrame frame=new JFrame();
	BusinessUI panel =new BusinessUI();
	ThemeLabelUI lablePanel=new ThemeLabelUI();

	static CarLoadingUI carLoadingPanel=new CarLoadingUI();
	static ReceiveAndSendUI receiveAndSendPabel=new ReceiveAndSendUI();
	static RecieiveMoneyUI recieveMoneyUI=new RecieiveMoneyUI();
	static CarManageUI carManageUI=new CarManageUI();
	static DriverManageUI driverManageUI=new DriverManageUI();

	static ResultMessageUI resultMessageUI=new ResultMessageUI();

	static PersonalMesageUI personalMessagePanel;

	private static int type=1;
	
	private ArrayList<JPanel> panelList  = new ArrayList<JPanel>();

	public void init(){

//		frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);
		
		panel.setBounds(0, 100, 150, 500);
		resultMessageUI.setBounds(210, 540, 690, 30);
		lablePanel.setBounds(150, 0, 750, 60);
		
		carLoadingPanel.setBounds(150, 100, 750, 450);
		receiveAndSendPabel.setBounds(150, 100, 750, 450);
		recieveMoneyUI.setBounds(150, 100, 750, 450);
		carManageUI.setBounds(150, 100, 750, 450);
		driverManageUI.setBounds(150, 100, 750, 450);
	
	

//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//	    frame.getContentPane().add(panel);
//	    frame.getContentPane().add(carLoadingPanel);
//	    frame.getContentPane().add(lablePanel);
//	    frame.getContentPane().add(resultMessageUI);
//    	frame.setVisible(true);
//	}
//
//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	new TextBussinessUI().init();
	
	}
	
	public static void changePanel(int i){
		removePanel();
		if(i==1){
			carLoadingPanel.setVisible(true);
			frame.getContentPane().add(carLoadingPanel);

			type=1;
		}else if(i==2){
			receiveAndSendPabel.setVisible(true);
			frame.getContentPane().add(receiveAndSendPabel);
			type=2;
		}else if(i==3){
			recieveMoneyUI.setVisible(true);
			frame.getContentPane().add(recieveMoneyUI);
			type=3;
		}else if(i==4){
			carManageUI.setVisible(true);
			frame.getContentPane().add(carManageUI);
			type=4;
		}else if(i==5){
			driverManageUI.setVisible(true);
			frame.getContentPane().add(driverManageUI);
			type=5;
		}else if(i==6){
			personalMessagePanel.setVisible(true);
			frame.getContentPane().add(personalMessagePanel);
			type=6;
		}
	
	}
	
	public static void removePanel(){
		if(type==1){
			carLoadingPanel.setVisible(false);
		}else if(type==2){
			receiveAndSendPabel.setVisible(false);
		}else if(type==3){
			recieveMoneyUI.setVisible(false);
		}else if(type==4){
			carManageUI.setVisible(false);
		}else if(type==5){
			driverManageUI.setVisible(false);
		}else if(type==6){
			personalMessagePanel.setVisible(false);
		}
	}
	
	// 新建addArrayList()
		public ArrayList<JPanel> getPanelList() {
			
			panelList.add(panel);
			panelList.add(carLoadingPanel);
			panelList.add(lablePanel);
			panelList.add(resultMessageUI);
			return panelList;
		}
		
		public TextBussinessUI(JFrame frame){
			this.frame = frame;
			init();
		}

}
