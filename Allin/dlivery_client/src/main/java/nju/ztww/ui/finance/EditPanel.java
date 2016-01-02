package nju.ztww.ui.finance;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import nju.ztww.dao.AccountDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import confligUI.MyButton;
import confligUI.MyScrollPane;
import confligUI.MyTable;

public class EditPanel extends JPanel {
       public DefaultTableModel tableModel; 
       public MyTable editTable;
       protected String[]  columnNames ={"账户名称","账户余额"};
       protected Object[][] initInfo = null;
       protected int nodeHeight =30;
       protected int rowHeight  =25;
       protected MyButton button1 = new MyButton('a');
       public MyButton button2 = new MyButton('a');
       protected MyButton button3 = new MyButton('b');
       public MyScrollPane scrollPane;
       private FinanceService fs = new FinanceServiceImpl();
       public Listener Accountlistener = new Listener();
       java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
   			.getScreenSize();
       
       
       public EditPanel(){
    	   this.setBackground(new Color(250, 240, 230));
    	   this.setUp();
    	   //this.setButton();
       }
       public EditPanel(String[] columnNames,Object[][] initInfo){
    	   this.setBackground(new Color(250, 240, 230));
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
    	 editTable = new MyTable(tableModel);
    	 scrollPane = new MyScrollPane(editTable);
//    	 editTable = new JTable(tableModel);
//    	 Dimension size = editTable.getTableHeader().getPreferredSize();
// 		
//		  size.height = nodeHeight;//设置新的表头高度40
//		  editTable.getTableHeader().setPreferredSize(size);
//		  editTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//		  editTable.setRowHeight( rowHeight);
//		  
//		  scrollPane = new JScrollPane(editTable);
//	      
//		  scrollPane.setBounds(0, 0, 690, 420);
		  this.add(scrollPane);
		  this.setButton();
		  
		  
       }
       
       public void setButton(){
    	   this.setLayout(null);
//    	   button1.setBounds(145,450,100,20);
//    	   button2.setBounds(295,350, 100, 20);
//    	   button3.setBounds(445,450, 100, 20);
    	   button1.setIcon(new ImageIcon("photo2/update.png"));
    	   this.add(button1);
//    	   this.add(button2);
//    	   this.add(button3);
       }
       
       
       public void paintComponent(Graphics g){
   		super.paintComponent(g);
   		
   		//Image background=new ImageIcon("photo/background2.gif").getImage();
   		//g.drawImage(background, 0,0,null);
   		
   	}
       
      
   public class Listener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	   int rowCount = tableModel.getRowCount();
	   for(int i=0;i<rowCount;i++){
		   tableModel.removeRow(0);
	   }
	   ArrayList<AccountDO> list=fs.getAllAccount();
	   for(AccountDO account : list){
		   String name = account.getName();
		   double remain = account.getRemain();
		   tableModel.addRow(new Object[]{new String(name),new Double(remain)});
	   }
	   
	}
	   
   }
	


	
	
       
       
}
