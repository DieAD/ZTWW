package nju.ztww.ui.order;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import nju.ztww.ui.user.BusinessUI;



public class MyMouseListener implements MouseListener{
	
	MyButton myButton=null;
	
	public MyMouseListener(MyButton myButton){
		this.myButton=myButton;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		String photo = myButton.getIcon().toString();
		if(!photo.contains("Logout")){
		if(!photo.contains("2")){
		System.out.println(photo);
		photo = photo.substring(0, photo.length()-4)+"2.png";
		myButton.setIcon(new ImageIcon(photo));
		}
		}
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(BusinessUI.panel!=myButton.ID){
		String photo = myButton.getIcon().toString();
		if(!photo.contains("Logout")){
		photo = photo.substring(0, photo.length()-5)+".png";
		myButton.setIcon(new ImageIcon(photo));
		}
		}
	}

}
