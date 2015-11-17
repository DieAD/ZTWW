package nju.ztww.ui.main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.order.TestCourierUI;
import nju.ztww.ui.user.TextBussinessUI;

public class SwiftController {
    
	private ArrayList<JPanel> panelList ;
	//
	private TestCourierUI courierUI;
	private TextBussinessUI businessUI;
	//
	private JFrame frame;
	private int id;
	public SwiftController(JFrame frame){
		this.frame = frame;
		courierUI = new TestCourierUI(frame);
		businessUI = new TextBussinessUI(frame);
	}
	
	
	public void switchUI(){
		if(true){
			//panelList = courierUI.getPanelList();
			panelList = businessUI.getPanelList();
		}
	}
	
	public void setUI(){
		getID();
		switchUI();
	    frame.getContentPane().removeAll();
	    for(JPanel panel : panelList){
	    	panel.setVisible(true);
	    	frame.add(panel);
	    	frame.getContentPane().repaint();
	    }
	}
	
	public void getID(){
		this.id = 0;
	}
}
