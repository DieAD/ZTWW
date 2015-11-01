package nju.ztww.ui.user;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkerOfCenterUI extends JPanel {
	JPanel labelpanel1;
	JPanel labelpanel2;
	public WorkerOfCenterUI(JFrame frame) {
		
		labelpanel1=new JPanel();
		JLabel ID =new JLabel("ID");
		
		ID.setBounds(0, 0, 150, 100);
		labelpanel1.add(ID);
		labelpanel1.setLayout(null);
		addLabel("出库",0,100);
		addLabel("入库",0,160);
		addLabel("库存盘点",0,220);
		addLabel("库存查看",0,280);
		frame.add(labelpanel1);
		JLabel Center =new JLabel("Welcome Worker of Center");
		Center.setBounds(150, 0, 750, 600);
		labelpanel1.setLayout(null);
		labelpanel2=new JPanel();
		labelpanel2.add(Center);
		
		
		frame.add(labelpanel2);
		frame.setBackground(Color.BLACK);
		
	}
	private void addLabel(String name,int x,int y) {
		
		JLabel label=new JLabel(name);
		
		label.setBounds(x, y, 150, 60);
		labelpanel1.setBounds(0, 0 ,150, 600);
		labelpanel1.add(label);
		// TODO Auto-generated method stub
		
	}
	// TODO Auto-generated constructor stub

	

}
