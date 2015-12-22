package nju.ztww.ui.order;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable{
	
	public MyTable(DefaultTableModel defaultTableModel){
		super(defaultTableModel);
		Dimension size = this.getTableHeader().getPreferredSize();	
		size.height = 30;
		this.getTableHeader().setPreferredSize(size);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		this.setRowHeight(25);	
		this.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
		this.setBackground(new Color(208,168,125)); //226,203,170

	}
	
}
