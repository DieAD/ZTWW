package nju.ztww.ui.finance;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditPanel extends JPanel {
       public DefaultTableModel tableModel; 
       public JTable editTable;
       protected String[]  columnNames ={"账户名称","账户余额"};
       protected Object[][] initInfo = {{new String("000000001"),new Double(1000.23)}};
       protected int nodeHeight =30;
       protected int rowHeight  =25;
       protected JButton button1 = new JButton("提交");
       public JButton button2 = new JButton("保存");
       protected JButton button3 = new JButton("添加");
       protected JScrollPane scrollPane;
       
       java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
   			.getScreenSize();
       
       
       public EditPanel(){
    	  
    	   this.setUp();
    	   //this.setButton();
       }
       public EditPanel(String[] columnNames,Object[][] initInfo){
    	   this.columnNames = columnNames;
    	   this.initInfo = initInfo;
    	   this.setUp();
       }
       public void setUp(){
    	 /*
    	  * set up model tabel;
    	  */
    	 this.setLayout(null);
    	 tableModel = new DefaultTableModel(initInfo,columnNames);
    	 editTable = new JTable(tableModel);
    	 Dimension size = editTable.getTableHeader().getPreferredSize();
 		
		  size.height = nodeHeight;//设置新的表头高度40
		  editTable.getTableHeader().setPreferredSize(size);
		  editTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		  editTable.setRowHeight( rowHeight);
		  
		  scrollPane = new JScrollPane(editTable);
	      
		  scrollPane.setBounds(0, 0, 690, 420);
		  this.add(scrollPane);
		  this.setButton();
		  
		  
       }
       
       public void setButton(){
    	   this.setLayout(null);
    	   button1.setBounds(145,450,100,20);
    	   button2.setBounds(295,450, 100, 20);
    	   button3.setBounds(445,450, 100, 20);
    	   this.add(button1);
    	   this.add(button2);
    	   this.add(button3);
       }
       
       
       public void paintComponent(Graphics g){
   		super.paintComponent(g);
   		
   		//Image background=new ImageIcon("photo/background2.gif").getImage();
   		//g.drawImage(background, 0,0,null);
   		
   	}
       
      

	


	
	
       
       
}
