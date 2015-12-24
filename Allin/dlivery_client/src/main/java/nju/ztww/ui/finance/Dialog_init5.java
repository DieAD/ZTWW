package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import confligUI.MyButton;
import confligUI.MyTable;
import confligUI.MyTextField;

public class Dialog_init5 extends JDialog {
	MainPanel mainPanel = new MainPanel();
    EditPanel tablePanel;
	public Dialog_init5(EditPanel tablePanel) {
		this.getContentPane().setBackground(new Color(250, 240, 230));
		this.tablePanel= tablePanel;
		this.setLayout(null);
		mainPanel.setBounds(0,0,600,450);
		mainPanel.submit.addActionListener(new Listener(this));
		this.setContentPane(mainPanel);
		this.setTitle("账户建账");
		this.setSize(500, 350);
		this.setResizable(false);
		// this.pack();

		this.setVisible(false);
	}

	public class MainPanel extends JPanel {
         MyTextField accountId,accountId_input,accountName,accountName_input,accountRemain,accountRemain_input;
         MyButton submit = new MyButton('a');
         MyButton cancel  = new MyButton('c');
         private int height = 30;
         private int width = 150;
         private int margin1 = 50;
         private int margin2 = 250;
         private int margin3 = 50;
         private int margin4 =10;
         public void init(){
        	 this.setLayout(null);
        	 accountId = new MyTextField();
        	 accountId.setText("账户ID:");
        	 accountId.setHorizontalAlignment(JTextField.CENTER);
        	 accountId.setEditable(false);
        	 accountId.setBounds(margin1,margin3,width,height);
        	 this.add(accountId);
        	 
        	 accountId_input = new MyTextField();
        	 accountId_input.setBounds(margin2, margin3, width, height);
        	 this.add(accountId_input);
        	 
        	 accountName = new MyTextField();
        	 accountName.setText("账户名称");
        	 accountName.setHorizontalAlignment(JTextField.CENTER);
        	 accountName.setEditable(false);
        	 accountName.setBounds(margin1,margin3+height*1+margin4*1,width,height);
        	 this.add(accountName);
        	 
        	 accountName_input = new MyTextField();
        	 accountName_input.setBounds(margin2,margin3+height*1+margin4*1 , width, height);
        	 this.add(accountName_input);
        	 
        	 accountRemain = new MyTextField();
        	 accountRemain.setText("账户余额");
        	 _setBounds(accountRemain,2,1);
        	 accountRemain.setEditable(false);
        	 accountRemain.setHorizontalAlignment(JTextField.CENTER);
        	 this.add(accountRemain);
        	 
        	 accountRemain_input = new MyTextField();
        	 _setBounds(accountRemain_input,2,2);
        	 this.add(accountRemain_input);
        	 
        	 submit.setBounds(200,200,80,30);
        	// submit.addActionListener(new Listener(this));
        	// cancel.setBounds(270,400,100,30);
        	 this.add(submit);
        	 //this.add(cancel);
         }
         
         public MainPanel(){
        	 init();
         }
         
         public void _setBounds(MyTextField text,int index, int tag){
        	 if(tag ==1){
        		 text.setBounds(margin1,margin3+height*index+margin4*index,width,height);
        	 }else{
        		 text.setBounds(margin2,margin3+height*index+margin4*index , width, height);
        	 }
         }
	}
	
	public class Listener implements ActionListener{
        JDialog dia ;
        public Listener(JDialog dia){
        	this.dia = dia;
        }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		   String id = mainPanel.accountId_input.getText();
		   mainPanel.accountId_input.setText("");
		   String name = mainPanel.accountName_input.getText();
		   mainPanel.accountName_input.setText("");
		   String remain = mainPanel.accountRemain_input.getText();
		   mainPanel.accountRemain_input.setText("");
		   double remain_double  = Double.parseDouble(remain);
		   Object[] contain = new Object[]{new String(id),new String(name),new Double(remain_double)};
		   tablePanel.tableModel.addRow(contain);
		   dia.dispose();
		}
		
	}
}
