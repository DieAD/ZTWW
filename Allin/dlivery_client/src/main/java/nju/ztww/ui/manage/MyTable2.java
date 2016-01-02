package nju.ztww.ui.manage;


import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;

import confligUI.Model;
import confligUI.MyScrollPane;
import confligUI.MyTable;

public class MyTable2 extends JPanel{
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	String[] head = {"  ", "单据号", "当前状态", "最后处理人", "详情"};
	Model tableModel;
	MyTable table;
	JCheckBox checkBox;
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	
	
	public MyTable2(Object[][] Orders){
		this.setBounds(0,0,535, 370);
		this.init(Orders);
		//this.setBackground(new Color(250, 240, 230));
        this.setOpaque(false);
        
	}
	
	
	
	public void init(Object[][] Orders){	
	this.setLayout(null);
	
//	tableModel = new DefaultTableModel(Orders, head);
	tableModel = new Model(Orders, head);
	table = new MyTable(tableModel);
	table.setFont(myFont);
	//table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//	table.setBackground(new Color(208,168,125)); //226,203,170
//	Dimension size = table.getTableHeader().getPreferredSize();	
//	size.height = 30;
//	table.getTableHeader().setPreferredSize(size);
//	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
	MyScrollPane scrollPane = new MyScrollPane(table);
	//table.setRowHeight(25);
	scrollPane.setBounds(0, 0, 535, 370);
//	scrollPane.getViewport().setOpaque(false);
//	scrollPane.setOpaque(false);
	this.add(scrollPane);
	TableColumn tc1 = table.getColumnModel().getColumn(0);
	
	checkBox = new JCheckBox();
	tc1.setCellEditor(new DefaultCellEditor(checkBox));
	}
	
	
}


