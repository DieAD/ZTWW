package nju.ztww.ui.user;

import java.awt.TextArea;

import javax.swing.JPanel;

public class CarLoadingUI extends JPanel{
	
	private TextArea textArea=new TextArea("");
	
	public CarLoadingUI(){
		textArea.setSize(300, 500);
		this.setLayout(null);
		this.add(textArea);
	}

}
