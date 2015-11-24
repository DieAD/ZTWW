package nju.ztww.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import nju.ztww.vo.MemberVO;

public class ListenerUI implements MouseListener{
	private SwiftController swiftController;
	private JFrame frame;
	private Login login;
	private String ID;
	private String password;
	public ListenerUI(JFrame frame){ //改成Login类    By zyz
		this.frame = frame;		
		this.login = (Login)frame;
		this.swiftController = new SwiftController(frame);
		
	
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.swiftController.setMember(login.getID(), login.getPassword());
		swiftController.setUI();
		//by zyz  move here
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
