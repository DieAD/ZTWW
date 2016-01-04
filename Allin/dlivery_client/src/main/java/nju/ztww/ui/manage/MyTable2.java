package nju.ztww.ui.manage;


import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import confligUI.Model;
import confligUI.MyTable.RowRenderer;

public class MyTable2 extends JPanel{
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	String[] head = {"  ", "单据号", "当前状态", "最后处理人", "详情"};
	Model tableModel;
	JTable table;
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
	table = new JTable(tableModel);
	table.setFont(myFont);
	//table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//	table.setBackground(new Color(208,168,125)); //226,203,170
//	Dimension size = table.getTableHeader().getPreferredSize();	
//	size.height = 30;
//	table.getTableHeader().setPreferredSize(size);
//	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
	JScrollPane scrollPane = new JScrollPane(table);
	//table.setRowHeight(25);
	scrollPane.setBounds(0, 0, 535, 370);
	scrollPane.getViewport().setOpaque(false);
	scrollPane.setOpaque(false);
//	scrollPane.getViewport().setOpaque(false);
//	scrollPane.setOpaque(false);
	this.add(scrollPane);
	TableColumn tc1 = table.getColumnModel().getColumn(0);
	
	checkBox = new JCheckBox();
	tc1.setCellEditor(new DefaultCellEditor(checkBox));
	Dimension size = table.getTableHeader().getPreferredSize();	
	size.height = 30;
	table.getTableHeader().setPreferredSize(size);
	table.getTableHeader().setFont(myFont);
	table.getTableHeader().setForeground(new Color(225,225,225));
	table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	
	table.setRowHeight(25);	
	table.getTableHeader().setBackground(new Color(44,76,120));//208,168,125
	//this.setBackground(new Color(208,168,125)); //226,203,170
	table.setFont(myFont);
//	this.setSelectionBackground(Color.black); 
//	this.setSelectionForeground(Color.blue);
	//this.setGridColor(Color.black);
	table.setBorder(null);
	table.setShowGrid(false);
	paintRow();
	}
	
	public void paintRow() 
    {
        TableColumnModel tcm =table.getColumnModel();
        for (int i = 1, n = tcm.getColumnCount(); i < n; i++) 
        {
            TableColumn tc = tcm.getColumn(i);
            tc.setCellRenderer(new RowRenderer());
        }
    }
 private class RowRenderer extends DefaultTableCellRenderer 
    {
        public Component getTableCellRendererComponent(JTable t, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) 
        {
            //设置奇偶行的背景色，可在此根据需要进行修改
            if (row % 2 == 0)
                setBackground(new Color(253,254,254));
            else
                setBackground(new Color(149,165,166));
    
            return super.getTableCellRendererComponent(t, value, isSelected,
                    hasFocus, row, column);
        }
    }
}


