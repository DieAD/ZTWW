package nju.ztww.ui.manage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GManager_ViewFormsUI extends JPanel{
	public String[] Year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016"};
	public final String[] Month = {"1", "2", "3", "4", "5","6", "7", "8", "9", "10", "11", "12"};
	JLabel state = new JLabel();
	ImageIcon state1 = new ImageIcon("photo/state1.gif");
	ImageIcon state2 = new ImageIcon("photo/state2.gif");;
	JLabel cost  = new JLabel();
	ImageIcon cost1 = new ImageIcon("photo/cost1.gif");
	ImageIcon cost2 = new ImageIcon("photo/cost2.gif");;
	JLabel year   = new JLabel();
	JLabel month  = new JLabel();
	JComboBox monthBox = new JComboBox(Month);
	JComboBox yearBox = new JComboBox(Year);
	JButton sureButton = new JButton();
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public GManager_ViewFormsUI(){;
		
		this.setLayout(null);
		sureButton.setText("确定");
		sureButton.setBounds(500, 400, 120, 40);
		yearBox.setBounds(330, 10, 60, 20);
		year.setText("年");
		year.setBounds(400, 10, 20, 20);
		monthBox.setBounds(460, 10, 50, 20);
		month.setText("月");
		month.setBounds(520, 10, 20, 20);
		state.setIcon(state2);
		state.setBounds(20, 10, 100, 20);
		state.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				state.setIcon(state2);
				cost.setIcon(cost1);
			}
		});
		
		cost.setIcon(cost1);
		cost.setBounds(120, 10, 100, 20);
		cost.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				cost.setIcon(cost2);
				state.setIcon(state1);
			}
		});
		this.add(state);
		this.add(cost);
		this.add(year);
		this.add(month);
		this.add(sureButton);
		this.add(yearBox);
		this.add(monthBox);
	}
}
