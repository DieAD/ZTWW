package nju.ztww.ui.user;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestCourierUI{
	
	JFrame frame = new JFrame();
	CourierMenuUI MenuPanel = new CourierMenuUI();
	ThemeLabelUI Theme = new ThemeLabelUI();
	Courier_AcceptUI OrderInput = new Courier_AcceptUI();
	

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
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(MenuPanel);
		frame.getContentPane().add(Theme);
		frame.getContentPane().add(OrderInput);
		frame.setVisible(true);
	}
	
public static void main(String[] args){
		new TestCourierUI().init();
	}
	
}
