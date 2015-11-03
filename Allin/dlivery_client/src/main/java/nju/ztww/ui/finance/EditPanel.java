package nju.ztww.ui.finance;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EditPanel extends JPanel {
       protected DefaultTableModel tableModel; 
       protected JTable editTable;
       protected String[]  columnNames ={"账户名称","账户余额"};
       protected Object[][] initInfo = {{new String("000000001"),new Double(1000.23)}};
       protected int nodeHeight =30;
       protected int rowHeight  =25;
       java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
   			.getScreenSize();
       
       
       public EditPanel(){
    	  
    	   this.setUp();
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
		  
		  JScrollPane scrollPane = new JScrollPane(editTable);
	      
		  scrollPane.setBounds(0, 0, 690, 420);
		  this.add(scrollPane);
		  
       }
       
       
       public void paintComponent(Graphics g){
   		super.paintComponent(g);
   		
   		Image background=new ImageIcon("photo/background2.gif").getImage();
   		g.drawImage(background, 0,0,null);
   		
   	}
       
      

	


	
	
       
       
}
