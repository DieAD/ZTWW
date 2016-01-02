package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.ui.main.subTrace;

public class EditSearch extends EditPanel {
    JButton button1 =new JButton();
    JTextField text1 = new JTextField();
    JLabel label=new JLabel("请输入订单编号");
	public EditSearch(){
		this.removeAll();
		init();
		this.setVisible(false);
		this.setOpaque(false);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//this.setOpaque(false);
		Image lable=new ImageIcon("photo2/graybg.png").getImage();
		g.drawImage(lable, 0,0,null);
		
	}
	public void init(){
		ImageIcon sure = new ImageIcon("photo/Sure.png");
		label.setBounds(120, 150, 200, 30);
		label.setFont(new Font(Font.DIALOG,1,18));
		label.setForeground(new Color(255,255,255));
		//text1.setBackground(new Color(255,255,255));
		button1.setBounds(510, 150, 70, 30);
		button1.setIcon(sure);
		text1.setBounds(280, 150, 200, 30);
		button1.addActionListener(new Listener(this));
		this.add(label);
		this.add(button1);
		this.add(text1);
	}
	
	
	//------------------------------------------------------Listener
	public class Listener implements ActionListener{
        JPanel panel;
        String id;
        public Listener(JPanel panel){
        	this.panel = panel;
        	
        }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			id=text1.getText();
			panel.removeAll();
			subTrace p  = new subTrace(id);
			p.setBounds(0,0,750,450);
			panel.add(p);
			//p.animate();
			panel.repaint();
			
		}
		
	}
}
