package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class INIT extends JPanel{
//   JButton button1  = new JButton("机构建账");
//   JButton button2  = new JButton("人员建账");
//   JButton button3  = new JButton("车辆建账");
//   JButton button4  = new JButton("库存建账");
//   JButton button5  = new JButton("银行账户建账");
//   JPanel home = new EditInit(new String[]{"账号","创建时间","创建人","是否使用中"},new Object[][]{{new String("000001"),new String("2014/1"),new String("manager"),new String("是")}});
   JPanel home;
   INIT mainPanel ;
   ButtonPanel buttonPanel = new ButtonPanel();
   
   //String[] position = { "快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员",
	//"总经理", "管理员" };
   INIT_Table1 table1 = new INIT_Table1(new String[]{"机构编号","机构名称","快递员人数","营业厅业务员人数", "中转中心业务员人数", "中转中心仓库管理人员人数", "财务人员人数","总经理人数", "管理员人数"},new Object[][]{{new String(""),new String(""),new Integer(0),
	   new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0)}});
   INIT_Table2 table2 = new INIT_Table2(new String[]{"ID","姓名","年龄","职务","性别"},new Object[][]{{new String(""),new String(""),new String(""),new String(""),new String("")}} );
   ///INIT_Table3 table3 = new 
   public INIT(JPanel home){
	   this.home = home;
	   setUp();
   }
   
   public void setUp(){
	   
	   mainPanel = this;
//	   button1.setBounds(10,10,100,50);
//	   button2.setBounds(10,70,100,50);
//	   button3.setBounds(10,130,100,50);
//	   button4.setBounds(10,190,100,50);
//	   button5.setBounds(10,250,100,50);
//	   
//	   buttonPanel.add(button1);
//	   buttonPanel.add(button2);
//	   buttonPanel.add(button3);
//	   buttonPanel.add(button4);
//	   buttonPanel.add(button5);
	   //
	   buttonPanel.setBounds(0,0,750,450);
	   this.add(buttonPanel);
	   buttonPanel.button1.addActionListener(new Listener(table1));
	   buttonPanel.button2.addActionListener(new Listener(table2));
///	   buttonPanel.button6.addActionListener(new Listener(home));
	   table1.button3.addActionListener(new Listener(buttonPanel));
	  
   }
   
   public class Listener implements ActionListener{
	JPanel panel;
	public Listener(JPanel panel){
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainPanel.removeAll();
		table1.setBounds(0, 0, 750, 450);
		mainPanel.add(panel);
		mainPanel.repaint();
	}
	   
   }
   
   public class ButtonPanel extends JPanel{
	   JButton button1  = new JButton("机构建账");
	   JButton button2  = new JButton("人员建账");
	   JButton button3  = new JButton("车辆建账");
	   JButton button4  = new JButton("库存建账");
	   JButton button5  = new JButton("银行账户建账");
	   JButton button6  = new JButton("返回");
	   public ButtonPanel(){
		   this.setLayout(null);
		   button1.setBounds(10,10,100,50);
		   button2.setBounds(10,70,100,50);
		   button3.setBounds(10,130,100,50);
		   button4.setBounds(10,190,100,50);
		   button5.setBounds(10,250,100,50);
		   button6.setBounds(10,310,100,50);
		   
		   this.add(button1);
		   this.add(button2);
		   this.add(button3);
		   this.add(button4);
		   this.add(button5);
		   this.add(button6);
	   }
   }
}
