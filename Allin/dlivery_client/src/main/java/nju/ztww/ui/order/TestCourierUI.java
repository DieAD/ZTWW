package nju.ztww.ui.order;

import java.awt.Toolkit;

import javax.swing.JFrame;

import nju.ztww.ui.user.CheckOrdersUI;

import nju.ztww.ui.user.ThemeLabelUI;

public class TestCourierUI{
	
	static JFrame frame = new JFrame();
	CourierMenuUI MenuPanel = new CourierMenuUI();
	ThemeLabelUI Theme = new ThemeLabelUI();
	private static int type = 1;
	
	static Courier_OrderInputUI OrderInput = new Courier_OrderInputUI();
	static Courier_AcceptUI Accept = new Courier_AcceptUI();

	static CheckOrdersUI checkOrder = new CheckOrdersUI();
	
	public void init(){
		frame.setSize(900, 600);
		frame.setTitle("Courier");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((width-900)/2, (height-600)/2);
		frame.setResizable(false);
		
		MenuPanel.setBounds(0, 0, 210, 600);
		Theme.setBounds(210, 0, 690, 60);
		OrderInput.setBounds(210,60,690,480);
		Accept.setBounds(210,60,690,480);
	//	personalInformation.setBounds(210,60,690,480);
		checkOrder.setBounds(210,60,690,480);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(MenuPanel);
		frame.getContentPane().add(Theme);
		frame.getContentPane().add(Accept);
		frame.setVisible(true);
	}
	
public static void main(String[] args){
		new TestCourierUI().init();
	}
	
public static void changePanel(int i){
    removePanel();
    if(i == 1){
    	frame.getContentPane().add(OrderInput);
    	type = 1;
    }else if(i == 2){
    	frame.getContentPane().add(Accept);
    	type = 2;
    }else if(i == 3){
    	frame.getContentPane().add(checkOrder);
    	type = 3;
    }else if(i == 4){
    	//frame.getContentPane().add(personalInformation);
    	type = 4;
    }
}

public static void removePanel(){
	if(type==1){
		frame.remove(OrderInput);
	}
	else if(type == 2){
		frame.remove(Accept);
	}
	else if(type == 3){
		frame.remove(checkOrder);
	}else if (type == 4) {

		//frame.remove(personalInformation);
	}
}
}
