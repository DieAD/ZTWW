package nju.ztww.ui.manage;
/**
 * 田琦
 * 
 * */

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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserManageUI extends JPanel{
	DefaultTableModel defaultTableModel ;
	JDialog dlg;
	 JTable table;
	 private JButton addButton=new JButton();
	 
	 JButton sureAddButton = new JButton("确认添加");
	 JDialog addDlg;
	 
	 JLabel IDLabel = new JLabel("ID");
	 JLabel nameLabel = new JLabel("姓名");
	 JLabel passwordLabel = new JLabel("密码");
	 JLabel authorityLabel = new JLabel("权限");
	 JLabel ageLabel = new JLabel("年龄");
	 JLabel IDCardLabel = new JLabel("身份证");
	 JLabel sexLabel = new JLabel("性别");
	 JLabel phoneLabel = new JLabel("联系方式");
	 JLabel positionLabel = new JLabel("职位");
	 
	 JTextField ID = new JTextField("id");
	 JTextField name = new JTextField("姓名");
	 JTextField password = new JTextField("密码");
	 JTextField authority = new JTextField("权限");
	 JTextField age = new JTextField("年龄");
	 JTextField IDCard = new JTextField("身份证");
	 JTextField sex = new JTextField("性别");
	 JTextField phone = new JTextField("联系方式");
	 JTextField position = new JTextField("快递员");
	
	 
	 
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public UserManageUI(){
		
		ImageIcon save=new ImageIcon("photo/save.gif");
		
		addButton.setBounds(500, 420, 110, 38);
//		userButton.setIcon(save);
		addButton.setText("添加");
		addButton.addActionListener(add);
		this.add(addButton);
		
		Object[][] playerInfo =
			  {
			    { "阿呆", new Integer(66), new Integer(32), new Integer(98),  new Boolean(false)},
			    { "阿呆", new Integer(82), new Integer(69), new Integer(128), new Boolean(true)}, 
			  };

			  //字段名称
			  String[] Names = { "姓名", "账号", "密码" , "职位", "权限级别"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new JTable( defaultTableModel);       //字段名称
			  Dimension size = table.getTableHeader().getPreferredSize();
		
			  size.height = 30;//设置新的表头高度40
			  table.getTableHeader().setPreferredSize(size);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //绑定滚动条
			  JScrollPane scrollPane = new JScrollPane(table);
		      table.setRowHeight(25);
			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  this.setLayout(null);
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
	
	ActionListener add = new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addDlg = new JDialog();
			addDlg.setSize(new Dimension(600, 350));
            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            
            IDLabel.setBounds(50, 20, 150, 20);
            ID.setBounds(120, 20, 100, 20);
            nameLabel.setBounds(300, 20, 150, 20);
            name.setBounds(350, 20, 100, 20);
            passwordLabel.setBounds(50, 70, 150, 20);
            password.setBounds(100, 70, 100, 20);
            authorityLabel.setBounds(300, 70, 150, 20);
            authority.setBounds(350, 70, 150, 20);
            ageLabel.setBounds(50, 100, 150, 20);
            age.setBounds(100, 100, 150, 20);
            IDCardLabel.setBounds(300, 100, 150, 20);
            IDCard.setBounds(350, 100, 150, 20);
            sexLabel.setBounds(50, 150, 150, 20);
            sex.setBounds(100, 150, 150, 20);
            phoneLabel.setBounds(300, 150, 150, 20);
            phone.setBounds(350, 150, 150, 20);
            positionLabel.setBounds(50, 180, 150, 20);
            position.setBounds(100, 180, 150, 20);
            sureAddButton.setBounds(200, 250, 150, 40);
            sureAddButton.addActionListener(sureAdd);
            
            
            addDlg.add(IDLabel);
            addDlg.add(ID);
            addDlg.add(nameLabel);
            addDlg.add(name);
            addDlg.add(passwordLabel);
            addDlg.add(password);
            addDlg.add(authorityLabel);
            addDlg.add(authority);
            addDlg.add(ageLabel);
            addDlg.add(age);
            addDlg.add(IDCardLabel);
            addDlg.add(IDCard);
            addDlg.add(sexLabel);
            addDlg.add(sex);
            addDlg.add(phoneLabel);
            addDlg.add(phone);
            addDlg.add(positionLabel);
            addDlg.add(position);
            addDlg.add(sureAddButton);
            
            addDlg.setLayout(null);
			addDlg.setVisible(true);
		}
	};

	ActionListener sureAdd = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Vector<String> row = new Vector<String>();
			row.add(name.getText());
			row.add(ID.getText());
			row.add(password.getText());
			row.add(position.getText());
			row.add(authority.getText());
			defaultTableModel.addRow(row);
			addDlg.dispose();
			sureAddButton.removeActionListener(sureAdd);
		}
	};
}



