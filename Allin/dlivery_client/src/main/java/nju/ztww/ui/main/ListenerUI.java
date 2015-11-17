package nju.ztww.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ListenerUI implements MouseListener{
	private SwiftController swiftController;
	private JFrame frame;
	
	public ListenerUI(JFrame frame){
		this.frame = frame;
		this.swiftController = new SwiftController(frame);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		swiftController.setUI();
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
