package nju.ztww.ui.user;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.main.SwiftController;
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
	static SendUI sendUI=new SendUI();
	static EditSearch editSearch=new EditSearch();
	static ResultMessageUI resultMessageUI=new ResultMessageUI();

	static PersonalMesageUI personalMessagePanel;

	private static int type=1;
	
	private ArrayList<JPanel> panelList  = new ArrayList<JPanel>();

	public void init(){
		//注掉
//		frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);
		//
		panel.setBounds(25, 150, 150, 400);
		lablePanel.setBounds(200, 0, 670, 120);
		
		carLoadingPanel.setBounds(200,120,670,410);
		editSearch.setBounds(200,120,670,410);
		receiveAndSendPabel.setBounds(200,120,670,410);
		recieveMoneyUI.setBounds(200,120,670,410);
		carManageUI.setBounds(200,120,670,410);
		driverManageUI.setBounds(200,120,670,410);
		sendUI.setBounds(200,120,670,410);
//		personalMessagePanel.setBounds(200,120,670,410);
	    
		editSearch.setOpaque(false);
		receiveAndSendPabel.setOpaque(false);
		recieveMoneyUI.setOpaque(false);
		carManageUI.setOpaque(false);
		driverManageUI.setOpaque(false);
		sendUI.setOpaque(false);
//		personalMessagePanel.setOpaque(false);
		//注掉
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//	    frame.getContentPane().add(panel);
//	    frame.getContentPane().add(carLoadingPanel);
//	    frame.getContentPane().add(lablePanel);
//    	frame.setVisible(true);
//	}
//
//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	new TextBussinessUI().init();
	//
	}
	
	public static void changePanel(int i){
		removePanel();
		if(i==1){
			carLoadingPanel.setVisible(true);
			SwiftController.bg.add(carLoadingPanel);

			type=1;
		}else if(i==2){
			receiveAndSendPabel.setVisible(true);
			SwiftController.bg.add(receiveAndSendPabel);
			type=2;
		}else if(i==3){
			recieveMoneyUI.setVisible(true);
			SwiftController.bg.add(recieveMoneyUI);
			type=3;
		}else if(i==4){
			carManageUI.setVisible(true);
			SwiftController.bg.add(carManageUI);
			type=4;
		}else if(i==5){
			driverManageUI.setVisible(true);
			SwiftController.bg.add(driverManageUI);
			type=5;
		}else if(i==6){
			personalMessagePanel.setBounds(200,120,670,410);
			personalMessagePanel.setVisible(true);
			SwiftController.bg.add(personalMessagePanel);
			type=6;
		}else if(i==7){
			sendUI.setVisible(true);
			SwiftController.bg.add(sendUI);
			type=7;
		}else if(i==8){
			editSearch.setVisible(true);
			SwiftController.bg.add(editSearch);
			type=8;
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
		}else if(type==7){
			sendUI.setVisible(false);
		}else if(type==8){
			editSearch.setVisible(false);
		}
	}
	
	// 新建addArrayList()
		public ArrayList<JPanel> getPanelList() {
			
			panelList.add(panel);
			panelList.add(carLoadingPanel);
			panelList.add(lablePanel);
//			panelList.add(resultMessageUI);  //——by zyz
			return panelList;
		}
		
		public TextBussinessUI(JFrame frame){
			this.frame = frame;
			init();
		}

}
