package nju.ztww.ui.manage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OrdersButton extends JButton{
	//starts from 0
	int gap = 0;
	int height = 30;
	public OrdersButton(int n){
		this.setIcon(new ImageIcon("photo/order"+n+".png"));
		this.setBorderPainted(false);
		int y = getLocate(n);
		this.setBounds(10, 10+y, 120, height);
	}
	
	private int getLocate(int n){
		int result;
		result = (height+gap)*(n-1);
		return result;
	}
}
