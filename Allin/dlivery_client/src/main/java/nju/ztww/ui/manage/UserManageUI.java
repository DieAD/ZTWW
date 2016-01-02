package nju.ztww.ui.manage;
/**
 * 田琦
 * userManage panel
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import confligUI.MyButton;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.vo.ManaUserVO;

public class UserManageUI extends JPanel{
	int row=0;
	DefaultTableModel defaultTableModel ;
	MyDialog dlg;
	 MyTable table;
	 private MyButton addButton=new MyButton('b');
	 private MyButton deleteButton=new MyButton('c');
	 private MyButton changeButton=new MyButton('a');
	 MyButton sureAddButton = new MyButton();
	 MyButton sureChangeButton = new MyButton();
	 MyDialog addDlg;
	 
	 MyLabel IDLabel = new MyLabel("ID");
	 MyLabel nameLabel = new MyLabel("姓名");
	 MyLabel passwordLabel = new MyLabel("密码");
	 MyLabel authorityLabel = new MyLabel("权限");
	 MyLabel ageLabel = new MyLabel("年龄");
	 MyLabel IDCardLabel = new MyLabel("身份证");
	 MyLabel sexLabel = new MyLabel("性别");
	 MyLabel phoneLabel = new MyLabel("联系方式");
	 MyLabel positionLabel = new MyLabel("职位");
	 MyLabel timeLabel = new MyLabel("工作时间");
	 MyLabel onLineLabel = new MyLabel("是否离职");
	 
	 MyTextField ID = new MyTextField("");
	 MyTextField name = new MyTextField("");
	 MyTextField password = new MyTextField("");
	 MyTextField authority = new MyTextField("");
	 MyTextField age = new MyTextField("");
	 MyTextField IDCard = new MyTextField("");
	 MyTextField sex = new MyTextField("");
	 MyTextField phone = new MyTextField("");
	 MyTextField position = new MyTextField("");
	 MyTextField time = new MyTextField("");
	 MyTextField onLine = new MyTextField("");
	
	 private ArrayList<ManaUserVO> list = new ArrayList<ManaUserVO>();
	 private ManaUserVO user;
	 private UserService userService = new UserLoginImpl();
	 private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	 
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public UserManageUI(){
		
		ImageIcon save=new ImageIcon("photo/save.gif");
		this.setBackground(new Color(250, 240, 230));
//		
//		deleteButton.setBounds(350, 420, 110, 38);
//		changeButton.setBounds(200, 420, 110, 38);
		changeButton.setIcon(new ImageIcon("photo/modify.png"));

//		userButton.setIcon(save);
		addButton.addActionListener(add);
		changeButton.addActionListener(change);
		this.add(changeButton);
		this.add(addButton);
		this.add(deleteButton);
		Object[][] playerInfo =
			  {
			  };

			  //字段名称
			  String[] Names = { "姓名", "账号", "密码" , "职位", "权限级别"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new MyTable(defaultTableModel);
			  MyScrollPane scrollPane = new MyScrollPane(table);
			  init();
//			  table = new JTable( defaultTableModel);       //字段名称
//			  Dimension size = table.getTableHeader().getPreferredSize();
//			  init();
//			  size.height = 30;//设置新的表头高度40
//			  table.getTableHeader().setPreferredSize(size);
//			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
////			                60));
//			  
//			  //绑定滚动条
//			  JScrollPane scrollPane = new JScrollPane(table);
//		      table.setRowHeight(25);
//			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  this.setLayout(null);
			  deleteButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow()>=0){
					String id=(String) table.getValueAt(table.getSelectedRow(), 1);
					orderServiceImpl.deleteOrder(id, "userstable");
					defaultTableModel.removeRow(table.getSelectedRow());
					}
				}
				  
			  });
	}
	
	public void init(){


		ArrayList<ManaUserVO> list=userService.findAll();
		for(ManaUserVO temp:list){
			Vector<String> row = new Vector<String>();
			row.add(temp.getName());
			row.add(temp.getID());
			row.add(temp.getPassword());
			row.add(temp.getPosition());
			row.add(temp.getAuthority());
			defaultTableModel.addRow(row);
		}

	}


//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background2.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}
	
    ActionListener change = new ActionListener() {



		
		public void actionPerformed(ActionEvent e) {

			row=table.getSelectedRow();
			if(row>=0){
			ManaUserVO userVO=userService.findByID((String)table.getValueAt(row, 1));
			addDlg = new MyDialog();
			addDlg.setSize(new Dimension(600, 380));
            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
         
            IDLabel.setBounds(50, 20, 150, 25);
            ID.setBounds(100, 20, 100, 25);
            nameLabel.setBounds(300, 20, 150, 25);
            name.setBounds(370, 20, 100, 25);
            passwordLabel.setBounds(50, 75, 150, 25);
            password.setBounds(100, 75, 100, 25);
            authorityLabel.setBounds(300, 75, 150, 25);
            authority.setBounds(370, 75, 150, 25);
            ageLabel.setBounds(50, 110, 150, 25);
            age.setBounds(100, 110, 150, 25);
            IDCardLabel.setBounds(300, 110, 150, 25);
            IDCard.setBounds(370, 110, 150, 25);
            sexLabel.setBounds(50, 165, 150, 25);
            sex.setBounds(100, 165, 150, 25);
            phoneLabel.setBounds(300, 165, 150, 25);
            phone.setBounds(370, 165, 150, 25);
            timeLabel.setBounds(300, 200, 150, 25);
            time.setBounds(370, 200, 150, 25);
            onLineLabel.setBounds(300, 235, 150, 25);
            onLine.setBounds(370, 235, 150, 25);
            positionLabel.setBounds(50, 200, 150, 25);
            position.setBounds(100, 200, 150, 25);
            sureAddButton.setBounds(200, 280, 150, 40);
            sureAddButton.setIcon(new ImageIcon("photo/MSureAdd.png"));
//            IDLabel.setBounds(50, 20, 50, 20);
            ID.setText(userVO.getID());
//            ID.setBounds(100, 20, 100, 20);
//            nameLabel.setBounds(300, 20, 150, 20);
            name.setText(userVO.getName());
//            name.setBounds(370, 20, 100, 20);
//            passwordLabel.setBounds(50, 70, 150, 20);
            password.setText(userVO.getPassword());
//            password.setBounds(100, 70, 100, 20);
//            authorityLabel.setBounds(300, 70, 150, 20);
            authority.setText(userVO.getAuthority());
//            authority.setBounds(370, 70, 150, 20);
//            ageLabel.setBounds(50, 100, 150, 20);
            age.setText(Integer.toString(userVO.getAge()));
//            age.setBounds(100, 100, 150, 20);
//            IDCardLabel.setBounds(300, 100, 150, 20);
            IDCard.setText(userVO.getIDCard());
//            IDCard.setBounds(370, 100, 150, 20);
//            sexLabel.setBounds(50, 150, 150, 20);
            if(userVO.getSex()==0){
            	sex.setText("男");
            }else{
            	sex.setText("女");
            }
//            sex.setBounds(100, 150, 150, 20);
//            phoneLabel.setBounds(300, 150, 150, 20);
            phone.setText(userVO.getPhone());
//            phone.setBounds(370, 150, 150, 20);
//            timeLabel.setBounds(300, 180, 150, 20);
            time.setText(Integer.toString(userVO.getWorktime()));
//            time.setBounds(370, 180, 150, 20);
//            onLineLabel.setBounds(300, 210, 150, 20);
            if(userVO.getWetherwork()==0){
            	onLine.setText("否");
            }else{
            	onLine.setText("是");
            }
//            onLine.setBounds(370, 210, 150, 20);
//            positionLabel.setBounds(50, 180, 150, 20);
            position.setText(userVO.getPosition());
//            position.setBounds(100, 180, 150, 20);
            sureChangeButton.setBounds(200, 280, 150, 40);
            sureChangeButton.setIcon(new ImageIcon("photo/MSureModify.png"));
            sureChangeButton.addActionListener(sureChange);
            
            addDlg.add(onLineLabel);
            addDlg.add(onLine);
            addDlg.add(timeLabel);
            addDlg.add(time);
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
            addDlg.add(sureChangeButton);
            
            addDlg.setLayout(null);
			addDlg.setVisible(true);
			}
		}
    };
     ActionListener sureChange = new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			int SEX=0;
			if(sex.getText().equals("男")){
				SEX=0;
			}else{
				SEX=1;
			}
			int IF=0;
			if(onLine.getText().equals("是")){
				IF=1;
			}else{
				IF=0;
			}
			user = new ManaUserVO(ID.getText(), name.getText(), 
					password.getText(), authority.getText(), 
					Integer.valueOf(age.getText()), IDCard.getText()
							, SEX, phone.getText(), position.getText(),Integer.parseInt(time.getText()),IF);
			String result=userService.update(user);
			table.setValueAt(name.getText(), row, 0);
			table.setValueAt(ID.getText(), row, 1);
			table.setValueAt(password.getText(), row, 2);
			table.setValueAt(position.getText(), row, 3);
			table.setValueAt(authority.getText(), row, 4);
			
			addDlg.dispose();
			sureChangeButton.removeActionListener(sureChange);
		}
		}
    };
	
//    ActionListener change = new ActionListener() {
//
//
//		
//		public void actionPerformed(ActionEvent e) {
//
//
//			row=table.getSelectedRow();
//			ManaUserVO userVO=userService.findByID((String)table.getValueAt(row, 1));
//			addDlg = new MyDialog();
//			addDlg.setSize(new Dimension(600, 350));
//            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
//            
//            IDLabel.setBounds(50, 20, 150, 20);
//            IDLabel.setText(userVO.getID());
//            ID.setBounds(120, 20, 100, 20);
//            nameLabel.setBounds(300, 20, 150, 20);
//            nameLabel.setText(userVO.getName());
//            name.setBounds(350, 20, 100, 20);
//            passwordLabel.setBounds(50, 70, 150, 20);
//            passwordLabel.setText(userVO.getPassword());
//            password.setBounds(100, 70, 100, 20);
//            authorityLabel.setBounds(300, 70, 150, 20);
//            authorityLabel.setText(userVO.getAuthority());
//            authority.setBounds(350, 70, 150, 20);
//            ageLabel.setBounds(50, 100, 150, 20);
//            ageLabel.setText(Integer.toString(userVO.getAge()));
//            age.setBounds(100, 100, 150, 20);
//            IDCardLabel.setBounds(300, 100, 150, 20);
//            IDCardLabel.setText(userVO.getIDCard());
//            IDCard.setBounds(350, 100, 150, 20);
//            sexLabel.setBounds(50, 150, 150, 20);
//            if(userVO.getSex()==0){
//            	sexLabel.setText("男");
//            }else{
//            	sexLabel.setText("女");
//            }
//            sex.setBounds(100, 150, 150, 20);
//            phoneLabel.setBounds(300, 150, 150, 20);
//            phoneLabel.setText(userVO.getPhone());
//            phone.setBounds(350, 150, 150, 20);
//            timeLabel.setBounds(300, 180, 150, 20);
//            timeLabel.setText(Integer.toString(userVO.getWorktime()));
//            time.setBounds(350, 180, 150, 20);
//            onLineLabel.setBounds(300, 210, 150, 20);
//            if(userVO.getWetherwork()==0){
//            	onLineLabel.setText("否");
//            }else{
//            	onLineLabel.setText("是");
//            }
//            onLine.setBounds(350, 210, 150, 20);
//            positionLabel.setBounds(50, 180, 150, 20);
//            positionLabel.setText(userVO.getPosition());
//            position.setBounds(100, 180, 150, 20);
//            sureChangeButton.setBounds(200, 250, 150, 40);
//            sureChangeButton.addActionListener(sureChange);
//            
//            addDlg.add(onLineLabel);
//            addDlg.add(onLine);
//            addDlg.add(timeLabel);
//            addDlg.add(time);
//            addDlg.add(IDLabel);
//            addDlg.add(ID);
//            addDlg.add(nameLabel);
//            addDlg.add(name);
//            addDlg.add(passwordLabel);
//            addDlg.add(password);
//            addDlg.add(authorityLabel);
//            addDlg.add(authority);
//            addDlg.add(ageLabel);
//            addDlg.add(age);
//            addDlg.add(IDCardLabel);
//            addDlg.add(IDCard);
//            addDlg.add(sexLabel);
//            addDlg.add(sex);
//            addDlg.add(phoneLabel);
//            addDlg.add(phone);
//            addDlg.add(positionLabel);
//            addDlg.add(position);
//            addDlg.add(sureChangeButton);
//            
//            addDlg.setLayout(null);
//			addDlg.setVisible(true);
//            
//		}
//    };
//     ActionListener sureChange = new ActionListener() {
//
//		
//		public void actionPerformed(ActionEvent e) {
//			int SEX=0;
//			if(sex.getText().equals("男")){
//				SEX=0;
//			}else{
//				SEX=1;
//			}
//			int IF=0;
//			if(onLine.getText().equals("是")){
//				IF=1;
//			}else{
//				IF=0;
//			}
//			user = new ManaUserVO(ID.getText(), name.getText(), 
//					password.getText(), authority.getText(), 
//					Integer.valueOf(age.getText()), IDCard.getText()
//							, SEX, phone.getText(), position.getText(),Integer.parseInt(time.getText()),IF);
//			String result=userService.update(user);
//			table.setValueAt(name.getText(), row, 0);
//			table.setValueAt(ID.getText(), row, 1);
//			table.setValueAt(password.getText(), row, 2);
//			table.setValueAt(position.getText(), row, 3);
//			table.setValueAt(authority.getText(), row, 4);
//			
//			addDlg.dispose();
//			sureChangeButton.removeActionListener(sureChange);
//		}
//    };
//	
	ActionListener add = new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addDlg = new MyDialog();
			addDlg.setSize(new Dimension(600, 420));
            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            
//            IDLabel.setBounds(50, 20, 150, 25);
//            ID.setBounds(100, 20, 100, 25);
//            nameLabel.setBounds(300, 20, 150, 25);
//            name.setBounds(360, 20, 100, 25);
//            passwordLabel.setBounds(50, 75, 150, 25);
//            password.setBounds(100, 75, 100, 25);
//            authorityLabel.setBounds(300, 75, 150, 25);
//            authority.setBounds(360, 75, 150, 25);
//            ageLabel.setBounds(50, 110, 150, 25);
//            age.setBounds(100, 110, 150, 25);
//            IDCardLabel.setBounds(300, 110, 150, 25);
//            IDCard.setBounds(360, 110, 150, 25);
//            sexLabel.setBounds(50, 165, 150, 25);
//            sex.setBounds(100, 165, 150, 25);
//            phoneLabel.setBounds(300, 165, 150, 25);
//            phone.setBounds(360, 165, 150, 25);
//            timeLabel.setBounds(300, 200, 150, 25);
//            time.setBounds(360, 200, 150, 25);
//            onLineLabel.setBounds(300, 235, 150, 25);
//            onLine.setBounds(360, 235, 150, 25);
//            positionLabel.setBounds(50, 200, 150, 25);
//            position.setBounds(100, 200, 150, 25);
//            sureAddButton.setBounds(200, 280, 150, 40);
            IDLabel.setBounds(50, 20, 150, 25);
            ID.setBounds(100, 20, 100, 25);
            nameLabel.setBounds(300, 20, 150, 25);
            name.setBounds(370, 20, 100, 25);
            passwordLabel.setBounds(50, 75, 150, 25);
            password.setBounds(100, 75, 100, 25);
            authorityLabel.setBounds(300, 75, 150, 25);
            authority.setBounds(370, 75, 150, 25);
            ageLabel.setBounds(50, 110, 150, 25);
            age.setBounds(100, 110, 150, 25);
            IDCardLabel.setBounds(300, 110, 150, 25);
            IDCard.setBounds(370, 110, 150, 25);
            sexLabel.setBounds(50, 165, 150, 25);
            sex.setBounds(100, 165, 150, 25);
            phoneLabel.setBounds(300, 165, 150, 25);
            phone.setBounds(370, 165, 150, 25);
            timeLabel.setBounds(300, 200, 150, 25);
            time.setBounds(370, 200, 150, 25);
            onLineLabel.setBounds(300, 235, 150, 25);
            onLine.setBounds(370, 235, 150, 25);
            positionLabel.setBounds(50, 200, 150, 25);
            position.setBounds(100, 200, 150, 25);
            sureAddButton.setBounds(200, 290, 150, 40);
            sureAddButton.setIcon(new ImageIcon("photo/MSureAdd.png"));
            sureAddButton.addActionListener(sureAdd);
            
            addDlg.add(onLineLabel);
            addDlg.add(onLine);
            addDlg.add(timeLabel);
            addDlg.add(time);
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
			if(TestIfConnect.ifConnect()){
			// TODO Auto-generated method stub
			Vector<String> row = new Vector<String>();
			row.add(name.getText());
			row.add(ID.getText());
			row.add(password.getText());
			row.add(position.getText());
			row.add(authority.getText());
			defaultTableModel.addRow(row);
			int SEX=0;
			if(sex.getText().equals("男")){
				SEX=0;
			}else{
				SEX=1;
			}
			int IF=0;
			if(onLine.getText().equals("是")){
				IF=1;
			}else{
				IF=0;
			}
			user = new ManaUserVO(ID.getText(), name.getText(), 
					password.getText(), authority.getText(), 
					Integer.valueOf(age.getText()), IDCard.getText()
							, SEX, phone.getText(), position.getText(),Integer.parseInt(time.getText()),IF);
			
			userService.addUser(user);
			
			addDlg.dispose();
			sureAddButton.removeActionListener(sureAdd);
		}
		}
	};

}



