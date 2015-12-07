package nju.ztww.ui.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener_Trace implements MouseListener {
	Login frame;
	TracePanel panel = new TracePanel();
	public Listener_Trace(Login frame){
		this.frame = frame;
		panel.setBounds(0,0,900,600);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 
		 frame.getContentPane().removeAll();
		 frame.getContentPane().add(panel);
		 frame.repaint();
		// panel.animate();
		 
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
