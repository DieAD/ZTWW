package nju.ztww.ui.user;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class TextBussinessUI {
	
	JFrame frame=new JFrame();
	BusinessUI panel =new BusinessUI();
	CarLoadingUI carLoadingPanel=new CarLoadingUI();
	
	public void init(){

		frame.setSize(900, 600);
		frame.setTitle("Bussiness");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((width-900)/2, (height-600)/2);
		frame.setResizable(false);
		
		panel.setBounds(0, 0, 210, 600);
		carLoadingPanel.setBounds(210,60,900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(carLoadingPanel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TextBussinessUI().init();
		
	}

}
