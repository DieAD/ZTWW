package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import confligUI.MyButton;
import confligUI.MyComboBox;
import confligUI.MyTextField;

public class Dialog_init2 extends JDialog {
   EditPanel tablePanel;
   MainPanel mainPanel = new MainPanel();
   public Dialog_init2(EditPanel tablePanel){
	   this.getContentPane().setBackground(new Color(250, 240, 230));
	    this.tablePanel = tablePanel;
		this.setLayout(null);
		mainPanel.setBounds(0,0,600,450);
		mainPanel.submit.addActionListener(new Listener(this));
		this.setContentPane(mainPanel);
		this.setTitle("机构建账");
		this.setSize(500, 370);
		this.setResizable(false);
		// this.pack();

		this.setVisible(false);
   }
   
   public class MainPanel extends JPanel{
	   private int height = 30;
       private int width = 150;
       private int margin1 = 50;
       private int margin2 = 250;
       private int margin3 = 50;
       private int margin4 =10;
      // "ID","姓名","年龄","职务","性别""快递员人数","营业厅业务员人数", "中转中心业务员人数", "中转中心仓库管理人员人数", "财务人员人数","总经理人数", "管理员人数"
       String[]  _position = {"快递员","营业厅业务员","中转中心业务员","中转中心仓库管理人员","财务人员","总经理","管理员"};
       String[] _sex = {"男","女"};
       MyTextField name1,name2,name3,name4,name5,input1,input2,input3,input4,input5;
       MyComboBox box1 = new MyComboBox(_position);
       MyComboBox box2 = new MyComboBox(_sex);
       MyButton submit = new MyButton('a');
       public MainPanel(){
      	 this.setLayout(null);
      	 input1 = new MyTextField();
      	 input2 = new MyTextField();
      	 input3 = new MyTextField();
      	 input4 = new MyTextField();
      	 input5 = new MyTextField();
      	// input6 = new MyTextField();
      	 //input7 = new MyTextField();
      	 _setBounds(name1,0,1,"ID");
      	 _setBounds(input1,0,2,"");
      	 _setBounds(name2,1,1,"姓名");
      	 _setBounds(input2,1,2,"");
      	 _setBounds(name3,2,1,"年龄");
      	 _setBounds(input3,2,2,"");
      	 _setBounds(name4,3,1,"职务");
      	 box1.setBounds(margin2,margin3+height*3+margin4*3 , width, height);
      	 this.add(box1);
      //	 _setBounds(input4,3,2,"");
      	 _setBounds(name5,4,1,"性别");
      	 box2.setBounds(margin2,margin3+height*4+margin4*4 , width, height);
      	 this.add(box2);
      	// _setBounds(input5,4,2,"");
      	
//      	
      	 submit.setBounds(200,290, 80, 30);
      	 this.add(submit);
      	 
       }
       public void _setBounds(MyTextField text,int index, int tag,String contain){
      	 if(tag ==1){
      		 text = new MyTextField();
      		 text.setBounds(margin1,margin3+height*index+margin4*index,width,height);
      		 text.setText(contain);
      		 text.setHorizontalAlignment(JTextField.CENTER);
      		 text.setEditable(false);
      		 this.add(text);
      	 }else{
      		// text = new MyTextField();
      		 text.setBounds(margin2,margin3+height*index+margin4*index , width, height);
      		 this.add(text);
      	 }
       }
       
   }
   public class Listener implements ActionListener{
       JDialog dia;
       public Listener(JDialog dia){
       	this.dia = dia;
       }
       
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 //"快件编号1", "入库日期2", "目的地3", "区号4", "排号5" ,"架号6","位号7"
			String id = mainPanel.input1.getText();
			String date = mainPanel.input2.getText();
			String address = mainPanel.input3.getText();
			String qu =(String) mainPanel.box1.getSelectedItem();
			String pai =(String) mainPanel.box2.getSelectedItem();
			//String jia = mainPanel.input6.getText();
			
			mainPanel.input1.setText("");
			mainPanel.input2.setText("");
			mainPanel.input3.setText("");
//			mainPanel.input4.setText("");
//			mainPanel.input5.setText("");
			///mainPanel.input6.setText("");
			
			//mainPanel.input1.setText("");
			Object[] contain = new Object[]{new String(id),new String(date),new String(address),new String(qu)
			,new String(pai)};
			
			tablePanel.tableModel.addRow(contain);
			dia.dispose();
		}
		
	}
}
