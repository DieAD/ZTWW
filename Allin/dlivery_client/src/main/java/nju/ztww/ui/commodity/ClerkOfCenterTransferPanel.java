package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClerkOfCenterTransferPanel extends JPanel {
	   public JTable table1;
	   public JTable table2;
	   public JTable table3;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel1;
	   DefaultTableModel defaultTableModel2;
	   DefaultTableModel defaultTableModel3;
	   public JButton addbutton;
	   public JLabel  plane=new JLabel("飞机运输");
	   public JLabel  train=new JLabel("火车运输");
	   public JLabel  bus=new JLabel("汽车运输");
	   public ClerkOfCenterTransferPanel() {
		   this.setLayout(null);
		   addbutton=new JButton();
		   ImageIcon add=new ImageIcon("photo/add.gif");
		   addbutton.setBounds(500, 420, 110, 38);
		   addbutton.setIcon(add);
		  
		   this.add(addbutton);
		   plane.setBounds(250, 0, 80, 20);
		   this.add(plane);
		// TODO Auto-generated constructor stub
		   Object[][] playerInfo1 =
	{
		{ "2014年11月12日", "555", "02", "上海","南京",2,"sb","sss","00000000004",150},
		
				  };

		
	  String[] Names1 = { "中转单编号", "航班号", "出发地", "到达地", "货柜号" ,"监装员","单号","运费"};
        defaultTableModel1 = new DefaultTableModel( playerInfo1,Names1); 
		table1 = new JTable( defaultTableModel1);      
		Dimension size = table1.getTableHeader().getPreferredSize();
		size.height = 20;
		table1.getTableHeader().setPreferredSize(size);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JScrollPane scrollPane1 = new JScrollPane(table1);
		 table1.setRowHeight(25);
		scrollPane1.setBounds(0, 20, 690, 120);
		this.add(scrollPane1); 
		
		
		//火车运输
		train.setBounds(250, 140, 80, 20);
		this.add(train);
		Object[][] playerInfo2 =
			{
				{ "2014年11月12日", "555", "02", "上海","南京",2,"sb","sss","00000000004",150},
				
						  };

				
			  String[] Names2 = { "中转单编号", "航班号", "出发地", "到达地", "货柜号" ,"监装员","单号","运费"};
		        defaultTableModel2 = new DefaultTableModel( playerInfo2,Names2); 
				table2 = new JTable( defaultTableModel2);      
				Dimension size1 = table1.getTableHeader().getPreferredSize();
				size1.height = 20;
				table2.getTableHeader().setPreferredSize(size1);
				table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				
				JScrollPane scrollPane2 = new JScrollPane(table2);
				 table2.setRowHeight(25);
				scrollPane2.setBounds(0, 160, 690, 120);
				this.add(scrollPane2); 
				
				//火车运输
				bus.setBounds(250, 280, 80, 20);
				this.add(bus);
				Object[][] playerInfo3 =
					{
						{ "2014年11月12日", "555", "02", "上海","南京",2,"sb","sss","00000000004",150},
						
								  };

						
					  String[] Names3 = { "中转单编号", "航班号", "出发地", "到达地", "货柜号" ,"监装员","单号","运费"};
				        defaultTableModel3 = new DefaultTableModel( playerInfo3,Names3); 
						table3 = new JTable( defaultTableModel3);      
						Dimension size2 = table3.getTableHeader().getPreferredSize();
						size2.height = 20;
						table3.getTableHeader().setPreferredSize(size2);
						table3.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
						
						JScrollPane scrollPane3 = new JScrollPane(table3);
						 table3.setRowHeight(25);
						scrollPane3.setBounds(0, 300, 690, 120);
						this.add(scrollPane3); 
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		defaultTableModel1.addRow(new Vector());
			table1.revalidate();
					}
				});
		   
	}
	   
	   public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
			g.drawImage(background, 0,0,null);
			
		}
}
