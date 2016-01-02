package nju.ztww.ui.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import nju.ztww.ui.main.TracePanel.partTracePanel;

public class subTrace extends TracePanel{

	public subTrace(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		button.setBounds(50, 50, 103, 30);
		title.setBounds(240, 50, 103, 30);
		this.setOpaque(false);
	}
	public void getPart(){
		this.setLayout(null);
		for(int i=0;i<trace.length;i++){
			if((i==0&&trace.length<1)||i==trace.length-1){
			tracelist.add(new partTracePanel(1,trace[i]));}
			else {
			tracelist.add(new partTracePanel(0,trace[i]));	
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
			background = ImageIO.read(new FileInputStream("photo2/bg2(2).png"));
			//button = ImageIO.read(new FileInputStream("photo2/bg.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}