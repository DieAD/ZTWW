package nju.ztww.ui.finance;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DaccountPanel extends DialogPaneledit{
   JLabel lDate = new JLabel("付款日期");
   JTextField tDate = new JTextField();
   
   JLabel lAmount = new JLabel("付款金额");
   JTextField tAmount = new JTextField();
   
   JLabel lPeople = new JLabel("付款人");
   JTextField tPeople = new JTextField();
   
   JLabel lAccount = new JLabel("付款账户");
   JTextField tAccount = new JTextField();
   
   JLabel lName = new JLabel("条目");
   JTextField tName = new JTextField();
   
   JLabel lEx = new JLabel("备注");
   JTextField tEx = new JTextField();
   public int width=280;
   public int height=100;
	
   public DaccountPanel(){
	   this.setLayout(new GridLayout(3,4));
	   //this.setSize(width,height);
	   this.add(lDate);
	   this.add(tDate);
	   
	   this.add(lAmount);
	   this.add(tAmount);
	   
	   this.add(lPeople);
	   this.add(tPeople);
	  
	  
	  
	   this.add(lAccount);
	   this.add(tAccount);
	   
	   this.add(lName);
	   this.add(tName);
	   
	   this.add(lEx);
	   this.add(tEx);
   }
   
   public void init(){
	   tDate.setText("");
	   tAmount.setText("");
	   tPeople.setText("");
	   tAccount.setText("");
	   tName.setText("");
	   tEx.setText("");
	   
   }
}
