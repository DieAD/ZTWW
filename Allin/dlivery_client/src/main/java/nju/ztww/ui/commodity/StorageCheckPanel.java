package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nju.ztww.bl.commodity.DateChooser;
import nju.ztww.bl.commodity.WayToString;
import nju.ztww.service.CommodityListService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;

public class StorageCheckPanel extends JPanel {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
 public MyLabel label1=new MyLabel("开始时间");//格式 YY/mm/RR
 public MyLabel label2=new MyLabel("截止时间");
 public JButton surebutton=new JButton();

// public JLabel labelin=new JLabel("入库信息");
// public JLabel labelout=new JLabel("出库信息");
// public JLabel labelinnumber=new JLabel("入库数量");
// public JLabel labeloutnumber=new JLabel("出库数量");
 

 public MyLabel labelin=new MyLabel("入库信息");
 public MyLabel labelout=new MyLabel("出库信息");
 public MyLabel labelinnumber=new MyLabel("入库数量");
 public MyLabel labeloutnumber=new MyLabel("出库数量");
 String idofcenter="0001";//需要根据中转中心人员身份来确定

 
 public MyTextField  textfield1=new MyTextField(10);
 public MyTextField  textfield2=new MyTextField(10);
 public MyTextField  textfieldin=new MyTextField(5);
 public MyTextField  textfieldout=new MyTextField(5);
 public MyTextField  textfieldBegin=new MyTextField(10);
 public MyTextField  textfieldEnd=new MyTextField(10);
 DefaultTableModel defaultTableModel1 ;
 DefaultTableModel defaultTableModel2;
 public ArrayList<StorageListLineofInVO>arraylistin;//盘点时所需的入库信息
 public ArrayList<StorageListLineofOutVO>arraylistout;
 public CommodityListService commoditylistservice=new CommodityListServiceImpl();
 public DateChooser chos1=new DateChooser("yy/MM/dd");
 public DateChooser chos2=new DateChooser("yy/MM/dd");
 public MyTable table1;
 public MyTable table2;
 public StorageCheckPanel() {
	// TODO Auto-generated constructor stub
	 setup();
 }
 public void setup(){
	   //入库的表格
	 this.setBackground(new Color(250, 240, 230));
	 this.setLayout(null);
	 //
	  label1.setForeground(new Color(255,255,255));
	  label2.setForeground(new Color(255,255,255));
	  labelin.setForeground(new Color(255,255,255));
	  labelout.setForeground(new Color(255,255,255));
	  labelinnumber.setForeground(new Color(255,255,255));
	  labeloutnumber.setForeground(new Color(255,255,255));
	 //
	   label1.setBounds(0, 0, 70, 20);
	   
	   //textfieldBegin.setBounds(70, 0, 70, 20);
	   chos1.setBounds(70, 0, 70, 20);
	   label2.setBounds(160, 0, 70, 20);
	   labelin.setBounds(300, 20, 100, 30);
	   chos2.setBounds(240, 0, 70, 20);
	   //textfieldEnd.setBounds(240, 0, 80, 20);
	   surebutton.setBounds(400,0, 70, 20);//确认时要加监听
	   surebutton.setIcon(new ImageIcon("photo/Sure.png"));
	   surebutton.addActionListener(listener);
	   surebutton.setBorderPainted(false);
	   this.add(surebutton);
	   this.add(chos1);
	   this.add(label1);
	   //this.add(textfieldBegin);
	   this.add(label2);
	   this.add(labelin);
	   this.add(chos2);
	   //this.add(textfieldEnd);
	   labelinnumber.setBounds(500, 200, 60, 20);
	   this.add(labelinnumber);
	   textfieldin.setBounds(570, 200, 60, 20);
	   textfieldin.setEditable(false);
	   this.add(textfieldin);
	 Object[][] playerInfo =
			{
				
						  };

				//字段名称
			  String[] Names = { "快件编号",   "区号", "排号" ,"架号","位号"};

						  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				defaultTableModel1= new DefaultTableModel( playerInfo,Names); 
				table1 = new MyTable( defaultTableModel1);       //字段名称
//				Dimension size = table1.getTableHeader().getPreferredSize();
				table1.setFont(myFont);
//				size.height = 30;//设置新的表头高度40
//				table1.getTableHeader().setPreferredSize(size);
//				table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//				//绑定滚动条
				MyScrollPane scrollPane = new MyScrollPane(table1);
//				 table1.setRowHeight(25);
//				 //
				scrollPane.setBounds(0, 50, 670, 150);//——by zyz
//				scrollPane.getViewport().setOpaque(false);
//				scrollPane.setOpaque(false);
//				table1.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//				table1.setBackground(new Color(208,168,125)); //226,203,170
				//
				this.add(scrollPane); 
				
				
				//出库信息的表格
				labelout.setBounds(300, 200, 100, 30);
				this.add(labelout);
				labeloutnumber.setBounds(500, 390, 60, 20);
				this.add(labeloutnumber);
				textfieldout.setBounds(570, 390, 60, 20);
				textfieldout.setEditable(false);
				this.add(textfieldout);
				Object[][] playerInfo1 =
					{
						 
											  };

									//字段名称
					String[] Names1 = { "快件编号",   "日期", "到达地" ,"装运形式","号码"};

											  
			//创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				defaultTableModel2= new DefaultTableModel( playerInfo1,Names1); 
			    table2 = new MyTable( defaultTableModel2);       //字段名称
//				Dimension size1 = table2.getTableHeader().getPreferredSize();
//				size.height = 30;//设置新的表头高度40
//				table2.getTableHeader().setPreferredSize(size);
//				table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				table2.setFont(myFont);
									//绑定滚动条
				MyScrollPane scrollPane1 = new MyScrollPane(table2);
//				table2.setRowHeight(25);
				//
				scrollPane1.setBounds(0, 230, 670, 150);
//				scrollPane1.getViewport().setOpaque(false);
//				scrollPane1.setOpaque(false);
//				table2.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//				table2.setBackground(new Color(208,168,125)); //226,203,170
				//
				
				this.add(scrollPane1);
				
	
}
 ActionListener listener=new ActionListener(){
   public void actionPerformed(ActionEvent e) {
	   if(TestIfConnect.ifConnect()){
	   defaultTableModel1.setRowCount(0);
	   System.out.println(chos1.getTime());
	   System.out.println(chos2.getTime());
	   String idofcenter=UserInfoUI.getUserID().substring(0,5);
	   arraylistin=commoditylistservice.getInListbytime(chos1.getTime(), chos2.getTime(),idofcenter);
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
	   //arraylistout.clear();
	   defaultTableModel2.setRowCount(0);
	   textfieldin.setText(String.valueOf(arraylistin.size()));
	   arraylistout=commoditylistservice.getOutListbytime(chos1.getTime(), chos2.getTime(),idofcenter);
	  WayToString way=new WayToString();
	  
	   for(int i=0;i<arraylistout.size();i++){
		   Vector<String> row = new Vector<String>(5);
		   row.add(arraylistout.get(i).getId());
		   row.add(arraylistout.get(i).getData());
		   row.add(arraylistout.get(i).getDestination());
		   row.add(way.changetostring(arraylistout.get(i).getWay()));
		   row.add(arraylistout.get(i).getNumber());
		   defaultTableModel2.addRow(row);
		    table2.revalidate();
	   }
	   textfieldout.setText(String.valueOf(arraylistout.size()));
 }
   }
	 };
}
	 
 
 
 
 
 
 
 
 
 
 

