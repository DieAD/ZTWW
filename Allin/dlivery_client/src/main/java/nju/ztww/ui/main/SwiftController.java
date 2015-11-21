package nju.ztww.ui.main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.commodity.ClerkOfCenterUi;
import nju.ztww.ui.commodity.StorageUi;
import nju.ztww.ui.finance.FinanceUI;
import nju.ztww.ui.order.TestCourierUI;
import nju.ztww.ui.user.TextBussinessUI;

public class SwiftController {
    
	private ArrayList<JPanel> panelList ;
	//
	private TestCourierUI courierUI;
	private TextBussinessUI businessUI;
	private StorageUi storageUI;
	private FinanceUI financeUI;
	private ClerkOfCenterUi ccUI;
	//
	private JFrame frame;
	private int id;
	public SwiftController(JFrame frame){
		this.frame = frame;
		courierUI = new TestCourierUI(frame);
		businessUI = new TextBussinessUI(frame);
		financeUI =  new FinanceUI(frame);
		storageUI = new StorageUi();
		ccUI = new ClerkOfCenterUi();
	}
	
	
	public void switchUI(){
		if(true){
			
			panelList = ccUI.getPanelList();
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
