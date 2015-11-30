package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogPanelmain extends JPanel {
	 DaccountPanel componentPanel1 = new DaccountPanel();
	 JButton addButton = new JButton("添加");
	 EditPanel panel;
	 JDialog dialog;
     public DialogPanelmain(JPanel panel,JDialog dialog){
    	 this.dialog = dialog;
    	 this.panel =(EditPanel)panel;
    	 this.setLayout(null);
    	 //this.setSize(100, 450);
    	 componentPanel1.setBorder(BorderFactory.createTitledBorder("付款单信息输入"));
    	 componentPanel1.setBounds(0, 150, 295, 100);
    	 this.add(componentPanel1);
    	 
    	 addButton.setBounds(100, 350, 100, 20);
    	 addButton.addActionListener(new Listener(this.dialog));
    	 this.add(addButton);
    	// this.setBounds(x, y, width, height);
    	 
     }
     
     public class Listener implements ActionListener{
        public JDialog jpanel;
        public Listener(JDialog dialog){
        	this.jpanel =dialog;
        	
        }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),
//		    	new String("000000001"),new String("人员工资"),new String("11月")}}
//			 JLabel lDate = new JLabel("付款日期");
//			   JTextField tDate = new JTextField();
//			   
//			   JLabel lAmount = new JLabel("付款金额");
//			   JTextField tAmount = new JTextField();
//			   
//			   JLabel lPeople = new JLabel("付款人");
//			   JTextField tPeople = new JTextField();
//			   
//			   JLabel lAccount = new JLabel("付款账户");
//			   JTextField tAccount = new JTextField();
//			   
//			   JLabel lName = new JLabel("条目");
//			   JTextField tName = new JTextField();
//			   
//			   JLabel lEx = new JLabel("备注");
//			   JTextField tEx = new JTextField();
			String tempAmount = componentPanel1.tAmount.getText();
			//System.out.print("temp ="+tempAmount);
			double amount =0;
			if(tempAmount!=""){
				//TO DO
				amount = Double.parseDouble(componentPanel1.tAmount.getText());
			}
			Object[] rowData = {new String(componentPanel1.tDate.getText()),new Double(amount),new String(componentPanel1.tPeople.getText()),new String(componentPanel1.tAccount.getText())
			                                    ,new String(componentPanel1.tName.getText()),new String(componentPanel1.tEx.getText())};
			panel.tableModel.addRow(rowData);
			componentPanel1.init();
			jpanel.dispose();
			
			
		}
    	 
     }
}
