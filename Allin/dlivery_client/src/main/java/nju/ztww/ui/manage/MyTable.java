package nju.ztww.ui.manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MyTable extends JPanel{
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	String[] head = {"  ", "单据号", "当前状态", "最后处理人", "详情"};
	Model tableModel;
	JTable table = new JTable();
	JCheckBox checkBox;
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	
	
	public MyTable(Object[][] Orders){
		this.setBounds(0,0,600,400);
		this.init(Orders);
		this.setBackground(new Color(250, 240, 230));

	}
	
	
	
	public void init(Object[][] Orders){	
	this.setLayout(null);
	
//	tableModel = new DefaultTableModel(Orders, head);
	tableModel = new Model(Orders, head);
	table = new JTable(tableModel);
	table.setFont(myFont);
	table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
	table.setBackground(new Color(208,168,125)); //226,203,170
	Dimension size = table.getTableHeader().getPreferredSize();	
	size.height = 30;
	table.getTableHeader().setPreferredSize(size);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
	JScrollPane scrollPane = new JScrollPane(table);
	table.setRowHeight(25);
	scrollPane.setBounds(0, 0, 600, 400);
	scrollPane.getViewport().setOpaque(false);
	scrollPane.setOpaque(false);
	this.add(scrollPane);
	TableColumn tc1 = table.getColumnModel().getColumn(0);
	
	checkBox = new JCheckBox();
	tc1.setCellEditor(new DefaultCellEditor(checkBox));
	}
	
	
}

class Model extends AbstractTableModel{
	Object[][] orders = null;
	String[] head = null;
	 Class[] typeArray = { Boolean.class, String.class, String.class,  
			 String.class, String.class};
	
	Model(Object[][] orders, String[] head){
		this.orders = orders;
		this.head = head;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return orders.length;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return head.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		 return orders[rowIndex][columnIndex];
	}
	public Class getColumnClass(int columnIndex) {  
        return typeArray[columnIndex];// 返回每一列的数据类型  
    }  
	 public boolean isCellEditable(int rowIndex, int columnIndex) {  
	        return true;  
	    }  
	 @Override  
	    public String getColumnName(int column) {  
	        return head[column];  
	    }  
	 @Override  
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
	        orders[rowIndex][columnIndex] = aValue;  
	        fireTableCellUpdated(rowIndex, columnIndex);  
	    }  
}
