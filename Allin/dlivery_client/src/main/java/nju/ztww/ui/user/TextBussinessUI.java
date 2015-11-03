package nju.ztww.ui.user;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TextBussinessUI {
	
	static JFrame frame=new JFrame();
	BusinessUI panel =new BusinessUI();
	ThemeLabelUI lablePanel=new ThemeLabelUI();

//	static CarLoadingUI carLoadingPanel=new CarLoadingUI();
//	static ReceiveAndSendUI receiveAndSendPabel=new ReceiveAndSendUI();
//	static RecieiveMoneyUI recieveMoneyUI=new RecieiveMoneyUI();
//	static CarManageUI carManageUI=new CarManageUI();
//	static DriverManage driverManageUI=new DriverManage();
//	static PersonalInformationUI personalInformation=new PersonalInformationUI();
//	private static int type=1;

	public void init(){

		frame.setSize(900, 600);
		frame.setTitle("Bussiness");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((width-900)/2, (height-600)/2);
		frame.setResizable(false);
		
		panel.setBounds(0, 0, 210, 600);

		lablePanel.setBounds(210, 0, 690, 60);
		carLoadingPanel.setBounds(210,60,690,480);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(carLoadingPanel);
		frame.getContentPane().add(lablePanel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TextBussinessUI().init();
		
	}
	
	public static void changePanel(int i){
		removePanel();
		if(i==1){
			frame.getContentPane().add(carLoadingPanel);
			type=1;
		}else if(i==2){
			frame.getContentPane().add(receiveAndSendPabel);
			type=2;
		}else if(i==3){
			frame.getContentPane().add(recieveMoneyUI);
			type=3;
		}else if(i==4){
			frame.getContentPane().add(carManageUI);
			type=4;
		}else if(i==5){
			frame.getContentPane().add(driverManageUI);
			type=5;
		}else{
			frame.getContentPane().add(personalInformation);
			type=6;
		}
	
	}
	
	public static void removePanel(){
		if(type==1){
			frame.remove(carLoadingPanel);
		}else if(type==2){
			frame.remove(receiveAndSendPabel);
		}else if(type==3){
			frame.remove(recieveMoneyUI);
		}else if(type==4){
			frame.remove(carManageUI);
		}else if(type==5){
			frame.remove(driverManageUI);
		}else{
			frame.remove(personalInformation);
		}
	}

}
