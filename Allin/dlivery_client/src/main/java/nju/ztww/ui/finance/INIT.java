package nju.ztww.ui.finance;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import confligUI.MyButton;

public class INIT extends JPanel {

	JPanel home;
	INIT mainPanel;
	ButtonPanel buttonPanel = new ButtonPanel();
	Image background = new ImageIcon("photo/PersonInfoBG.png").getImage();

	// String[] position = { "快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员",
	// "总经理", "管理员" };
	INIT_Table1 table1 = new INIT_Table1(new String[] { "机构编号", "机构名称",
			"快递员人数", "营业厅业务员人数", "中转中心业务员人数", "中转中心仓库管理人员人数", "财务人员人数",
			"总经理人数", "管理员人数" }, null);

	INIT_Table2 table2 = new INIT_Table2(new String[] { "ID", "姓名", "年龄", "职务",
			"性别" }, null);
	// /INIT_Table3 table3 = new
	INIT_Table3 table3 = new INIT_Table3(new String[] { "ID", "车辆代号", "车牌号",
			"车辆状态", "服役时间", "备注" }, null);
	INIT_Table4 table4 = new INIT_Table4(new String[] { "快件编号", "入库日期", "目的地",
			"区号", "排号", "架号", "位号" }, null);
	INIT_Table5 table5 = new INIT_Table5(
			new String[] { "账户id", "账户名称", "账户余额" }, null);

	public INIT(JPanel home) {
		this.setLayout(null);
		this.home = home;
		setUp();
		this.setOpaque(false);
	}

	public void setUp() {

		mainPanel = this;

		buttonPanel.setBounds(0, 0, 750, 450);
		buttonPanel.setVisible(true);
		this.add(buttonPanel);
		buttonPanel.button1.addActionListener(new Listener(table1));
		buttonPanel.button2.addActionListener(new Listener(table2));
		buttonPanel.button3.addActionListener(new Listener(table3));
		buttonPanel.button4.addActionListener(new Listener(table4));
		buttonPanel.button5.addActionListener(new Listener(table5));
		buttonPanel.button6.addActionListener(new Listener3());
		table1.add.addActionListener(new Listener(buttonPanel));
		table2.add.addActionListener(new Listener(buttonPanel));
		table3.add.addActionListener(new Listener(buttonPanel));
		table4.add.addActionListener(new Listener(buttonPanel));
		table5.save.addActionListener(new Listener(buttonPanel));

	}

	public class Listener implements ActionListener {
		JPanel panel;

		public Listener(JPanel panel) {
			this.panel = panel;
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainPanel.setLayout(null);
			mainPanel.removeAll();
			panel.setBounds(0, 0, 750, 450);
			mainPanel.add(panel);
			mainPanel.repaint();
		}

	}

	public class ButtonPanel extends JPanel {
		MyButton button1 = new MyButton();
		MyButton button2 = new MyButton();
		MyButton button3 = new MyButton();
		MyButton button4 = new MyButton();
		MyButton button5 = new MyButton();
		MyButton button6 = new MyButton();

		public ButtonPanel() {
			this.setLayout(null);
			this.setOpaque(false);
			button1.setBounds(10, 10, 80, 30);
			button2.setBounds(10, 50, 80, 30);
			button3.setBounds(10, 90, 80, 30);
			button4.setBounds(10, 130, 80, 30);
			button5.setBounds(10, 170, 80, 30);
			button6.setBounds(10, 210, 80, 30);
			button1.setIcon(new ImageIcon("photo2/InitOrga.png"));
			button2.setIcon(new ImageIcon("photo2/InitStaff.png"));
			button3.setIcon(new ImageIcon("photo2/InitCars.png"));
			button4.setIcon(new ImageIcon("photo2/InitStorage.png"));
			button5.setIcon(new ImageIcon("photo2/InitAccount.png"));
			button6.setIcon(new ImageIcon("photo/InitReturn.png"));

			this.add(button1);
			this.add(button2);
			this.add(button3);
			this.add(button4);
			this.add(button5);
			//this.add(button6);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image background=new ImageIcon("photo2/graybg.png").getImage();
			g.drawImage(background, 0,0,null);
			//this.setOpaque(false);
		}
	}

	public class Listener3 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			EditInit init = new EditInit(new String[] { "账号", "创建时间", "创建人",
					"是否使用中" }, new Object[][] { { new String("000001"),
					new String("2014/1"), new String("manager"),
					new String("是") } });
			init.setBounds(0, 0, 750, 450);
			mainPanel.removeAll();
			mainPanel.add(init);
			mainPanel.repaint();

		}

	}

	// public void frame(){
	// JFrame frame = new JFrame();
	// frame.setLayout(null);
	// frame.setSize(900, 600);
	// frame.setVisible(true);;
	// frame.add(new INIT(new JPanel()));
	// }
	// public static void main(String[] args){
	// JFrame frame = new JFrame();
	// frame.setLayout(null);
	// frame.setSize(900, 600);
	//
	// INIT in = new INIT(new JPanel());
	// in.setBounds(0,0,750,450);
	// frame.getContentPane().add(in);
	// in.setVisible(true);
	// frame.setVisible(true);;
	// }
}
