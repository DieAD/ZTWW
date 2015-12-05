package nju.ztww.ui.order;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	int width = 40;
	public MyButton(){
		this.setBorderPainted(false);
	}
	public MyButton(char a){
		this.setBorderPainted(false);
		switch (a) {
		case 'a':
			this.setIcon(new ImageIcon("photo/submit.png"));
			this.setBounds(650, 400, 80, 30);
			break;
		case 'b':
			this.setIcon(new ImageIcon("photo/add.png"));
			this.setBounds(560, 400, 80, 30);
			break;
		case 'c':
			this.setIcon(new ImageIcon("photo/delete.png"));
			this.setBounds(470, 400, 80, 30);
			break;
		case 'd':
			this.setIcon(new ImageIcon("photo/search.png"));
			this.setBounds(380, 400, 80, 30);
		default:
			break;
		}
	}
	
	public MyButton(int n){
		this.setBorderPainted(false);
		int locate = setLocate(width, n);
		this.setBounds(0, locate, 150, width);
	}
	
	private int setLocate(int width, int n){
		return n*width;
	}
}
