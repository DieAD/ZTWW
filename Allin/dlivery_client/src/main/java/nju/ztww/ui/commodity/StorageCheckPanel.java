package nju.ztww.ui.commodity;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StorageCheckPanel extends JPanel {
 public JLabel label1=new JLabel("开始时间");
 public JLabel label2=new JLabel("截止时间");
 public JLabel labelin=new JLabel("入库信息");
 public JLabel labelout=new JLabel("出库信息");
 public JLabel labelinnumber=new JLabel("入库数量");
 public JLabel labeloutnumber=new JLabel("出库数量");
 public JTextField  textfield1=new JTextField(10);
 public JTextField  textfield2=new JTextField(10);
 public JTextField  textfieldin=new JTextField(5);
 public JTextField  textfieldout=new JTextField(5);
 DefaultTableModel defaultTableModel1 ;
 DefaultTableModel defaultTableModel2;
 public JTable table1;
 public JTable table2;
 public StorageCheckPanel() {
	// TODO Auto-generated constructor stub
	 setup();
 }
 public void setup(){
	   //入库的表格
	 this.setLayout(null);
	   labelin.setBounds(300, 0, 100, 30);
	   this.add(labelin);
	   labelinnumber.setBounds(500, 200, 60, 20);
	   this.add(labelinnumber);
	   textfieldin.setBounds(570, 200, 60, 20);
	   this.add(textfieldin);
	 Object[][] playerInfo =
			{
				{ "0000000003",  "A",14,2,4 ,250},
				{ "0000000004",   "B", 15 ,3,6,360}, 
						  };

				//字段名称
			  String[] Names = { "快件编号",   "区号", "排号" ,"架号","位号","金额"};

						  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				defaultTableModel1= new DefaultTableModel( playerInfo,Names); 
				table1 = new JTable( defaultTableModel1);       //字段名称
				Dimension size = table1.getTableHeader().getPreferredSize();
				size.height = 30;//设置新的表头高度40
				table1.getTableHeader().setPreferredSize(size);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				//绑定滚动条
				JScrollPane scrollPane = new JScrollPane(table1);
				 table1.setRowHeight(25);
				scrollPane.setBounds(0, 30, 700, 150);
				this.add(scrollPane); 
				
				
				//出库信息的表格
				labelout.setBounds(300, 240, 100, 30);
				this.add(labelout);
				labeloutnumber.setBounds(500, 430, 60, 20);
				this.add(labeloutnumber);
				textfieldout.setBounds(570, 430, 60, 20);
				this.add(textfieldout);
				Object[][] playerInfo1 =
					{
						{ "0000000003",  "A",14,2,4,100 },
						{ "0000000004",  "上海", "B", 15 ,3,6,100}, 
											  };

									//字段名称
					String[] Names1 = { "快件编号",   "区号", "排号" ,"架号","位号","金额"};

											  
			//创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				defaultTableModel2= new DefaultTableModel( playerInfo1,Names1); 
			    table2 = new JTable( defaultTableModel2);       //字段名称
				Dimension size1 = table2.getTableHeader().getPreferredSize();
				size.height = 30;//设置新的表头高度40
				table2.getTableHeader().setPreferredSize(size1);
				table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
									//绑定滚动条
				JScrollPane scrollPane1 = new JScrollPane(table2);
				table2.setRowHeight(25);
				scrollPane1.setBounds(0, 280, 700, 150);
				this.add(scrollPane1);
	
}
 
 
 
 
 
 
 
 
 
 
}
