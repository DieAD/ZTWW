package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import nju.ztww.service.CommodityListService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

public class StorageCheckPanel extends JPanel {
 public JLabel label1=new JLabel("开始时间");//格式 YY/mm/RR
 public JLabel label2=new JLabel("截止时间");
 public JButton surebutton=new JButton("确定");
 public JLabel labelin=new JLabel("入库信息");
 public JLabel labelout=new JLabel("出库信息");
 public JLabel labelinnumber=new JLabel("入库数量");
 public JLabel labeloutnumber=new JLabel("出库数量");
 String idofcenter="0001";//需要根据中转中心人员身份来确定
 
 public JTextField  textfield1=new JTextField(10);
 public JTextField  textfield2=new JTextField(10);
 public JTextField  textfieldin=new JTextField(5);
 public JTextField  textfieldout=new JTextField(5);
 public JTextField  textfieldBegin=new JTextField(10);
 public JTextField  textfieldEnd=new JTextField(10);
 DefaultTableModel defaultTableModel1 ;
 DefaultTableModel defaultTableModel2;
 public ArrayList<StorageListLineofInVO>arraylistin;//盘点时所需的入库信息
 public ArrayList<StorageListLineofOutVO>arraylistout;
 public CommodityListService commoditylistservice=new CommodityListServiceImpl();
 
 public JTable table1;
 public JTable table2;
 public StorageCheckPanel() {
	// TODO Auto-generated constructor stub
	 setup();
 }
 public void setup(){
	   //入库的表格
	 this.setLayout(null);
	   label1.setBounds(0, 0, 70, 20);
	   textfieldBegin.setBounds(70, 0, 50, 20);
	   label2.setBounds(130, 0, 70, 20);
	   labelin.setBounds(300, 20, 100, 30);
	   textfieldEnd.setBounds(200, 0, 50, 20);
	   surebutton.setBounds(600,0, 70, 20);//确认时要加监听
	   surebutton.addActionListener(listener);
	   this.add(surebutton);
	   this.add(label1);
	   this.add(textfieldBegin);
	   this.add(label2);
	   this.add(labelin);
	   this.add(textfieldEnd);
	   labelinnumber.setBounds(500, 200, 60, 20);
	   this.add(labelinnumber);
	   textfieldin.setBounds(570, 200, 60, 20);
	   this.add(textfieldin);
	 Object[][] playerInfo =
			{
				
						  };

				//字段名称
			  String[] Names = { "快件编号",   "区号", "排号" ,"架号","位号"};

						  
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
				scrollPane.setBounds(0, 50, 700, 150);
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
						 
											  };

									//字段名称
					String[] Names1 = { "快件编号",   "日期", "到达地" ,"装运形式","号码"};

											  
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
 ActionListener listener=new ActionListener(){
   public void actionPerformed(ActionEvent e) {
	   arraylistin=commoditylistservice.getInListbytime(textfieldBegin.getText(), textfieldEnd.getText(),idofcenter);
	   for(int i=0;i<arraylistin.size();i++){
		   System.out.println(arraylistin.get(i).getDestination());
			Vector<String> row = new Vector<String>(5);
			row.add(arraylistin.get(i).getId());
			
			row.add(arraylistin.get(i).getQu());
			row.add(arraylistin.get(i).getPai());
			row.add(arraylistin.get(i).getJia());
			row.add(arraylistin.get(i).getWei());
			defaultTableModel1.addRow(row);
		    table1.revalidate();
		}
	   textfieldin.setText(String.valueOf(arraylistin.size()));
	   arraylistout=commoditylistservice.getOutListbytime(textfieldBegin.getText(), textfieldEnd.getText(),idofcenter);
	  
	   for(int i=0;i<arraylistout.size();i++){
		   Vector<String> row = new Vector<String>(5);
		   row.add(arraylistout.get(i).getId());
		   row.add(arraylistout.get(i).getData());
		   row.add(arraylistout.get(i).getDestination());
		   row.add(arraylistout.get(i).getWay());
		   row.add(arraylistout.get(i).getNumber());
		   defaultTableModel2.addRow(row);
		    table2.revalidate();
	   }
	   textfieldout.setText(String.valueOf(arraylistout.size()));
 }
   
	 };
}
	 
 
 
 
 
 
 
 
 
 
 

