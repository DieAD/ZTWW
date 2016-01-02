package confligUI;

import java.awt.Font;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane{
	public MyScrollPane(MyTable table){
		super(table);
		//this.setLayout(null);
		this.setBounds(0, 0, 670, 350);
		this.getViewport().setOpaque(false);
		this.setOpaque(false);
		this.setBorder(null);
		//this.setO
		
	}

	public MyScrollPane(StyleTabel table) {
		// TODO Auto-generated constructor stub
		super(table);
		this.setBounds(0, 0, 700, 400);
		this.getViewport().setOpaque(false);
		this.setOpaque(false);
	}
}
