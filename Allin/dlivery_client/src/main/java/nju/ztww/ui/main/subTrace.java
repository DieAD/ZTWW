package nju.ztww.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import nju.ztww.ui.finance.EditSearch;
import confligUI.MyButton;

public class subTrace extends TracePanel{
    MyButton button1 = new MyButton();
	public subTrace(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		button1.setBounds(50, 50, 103, 30);
	
    	button1.setLayout(null);
    	button1.setIcon(new ImageIcon("photo2/back(2).png"));
    	button1.setOpaque(false);
    	this.add(button);
		title.setBounds(240, 50, 103, 30);
		this.remove(button);
		button1.addActionListener(new newListener());
		this.add(button1);
		this.setOpaque(false);
	}
	public void getPart(){
		this.setLayout(null);
		for(int i=0;i<trace.length;i++){
			if((i==0&&trace.length>1)){
			tracelist.add(new partTracePanel(1,trace[i]));}
			else if(i!=trace.length-1){
			tracelist.add(new partTracePanel(0,trace[i]));	
			}else if(trace.length>1&&i==trace.length-1){
				tracelist.add(new partTracePanel(2,trace[i]));	
			}
		}
		int count = 0;
		for(partTracePanel panel : tracelist){
			panel.setBounds(100, 100+30*count, 700, 30);
			count++;		//	this.add(panel);
		}
	}
	public void getImage(){
		 try {
		//	title =ImageIO.read(new FileInputStream("Trace/title2.png"));
			background = ImageIO.read(new FileInputStream("photo2/graybg.png"));
			//button = ImageIO.read(new FileInputStream("photo2/bg.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class newListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			subTrace.this.removeAll();
			EditSearch main = new EditSearch();
			main.setVisible(true);
			main.setBounds(0, 0, 670, 410);
			subTrace.this.add(main);
			//subTrace.this.repaint();
		}
		
	}
}