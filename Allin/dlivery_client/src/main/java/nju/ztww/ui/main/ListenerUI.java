package nju.ztww.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import nju.ztww.vo.MemberVO;

public class ListenerUI implements MouseListener{
	private SwiftController swiftController;
	private JFrame frame;
	private Login login;
	private String ID;
	private String password;
	ImageIcon l1 = new ImageIcon("photo/login1.png");
	ImageIcon l2 = new ImageIcon("photo/login2.png");
	Thread animate;
	public ListenerUI(JFrame frame){ //改成Login类    By zyz
		this.frame = frame;		
		this.login = (Login)frame;
		this.swiftController = new SwiftController(frame);
		
	
	}


	public void switchUI(){
		this.swiftController.setMember(login.getID(), login.getPassword());
		swiftController.setUI();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.switchUI();
		//by zyz  move here
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public SwiftController getSwiftController() {
		return swiftController;
	}


	public void setSwiftController(SwiftController swiftController) {
		this.swiftController = swiftController;
	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		login.loginbButton.setIcon(l2);
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		login.loginbButton.setIcon(l1);
	}
	
	
}
