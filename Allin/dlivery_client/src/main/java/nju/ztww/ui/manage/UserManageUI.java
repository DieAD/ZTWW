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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.vo.ManaUserVO;

public class UserManageUI extends JPanel {
	DefaultTableModel defaultTableModel;
	JDialog dlg;
	JTable table;
	private JButton addButton = new JButton();
	JButton deleteButton = new JButton("删除");
	JButton sureAddButton = new JButton("确认添加");
	JButton updateButton = new JButton("更新");
	JButton modifyButton = new JButton("修改");
	JDialog modifyDlg;
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

	JTextField ID = new JTextField("");
	JTextField name = new JTextField("");
	JTextField password = new JTextField("");
	JTextField authority = new JTextField("");
	JTextField age = new JTextField("");
	JTextField IDCard = new JTextField("");
	JTextField sex = new JTextField("");
	JTextField phone = new JTextField("");
	JTextField position = new JTextField("");

	private ManaUserVO user;
	private UserService userService = new UserLoginImpl();
	private ArrayList<ManaUserVO> userVOs;

	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();

	public UserManageUI() {

		ImageIcon save = new ImageIcon("photo/save.gif");

		addButton.setBounds(500, 420, 110, 38);

		// userButton.setIcon(save);
		addButton.setText("添加");
		addButton.addActionListener(add);
		deleteButton.setBounds(350, 420, 110, 38);
		deleteButton.addActionListener(delete);
		updateButton.setBounds(200, 420, 110, 38);
		updateButton.addActionListener(update);
		modifyButton.setBounds(50, 420, 110, 38);
		modifyButton.addActionListener(modify);
		this.add(addButton);
		this.add(deleteButton);
		this.add(updateButton);
		this.add(modifyButton);

		Object[][] playerInfo = {
				{ "阿呆", new String("66"), new Integer(32), new Integer(98),
						new Boolean(false) },
				{ "lalala", new String("82"), new Integer(69),
						new Integer(128), new Boolean(true) }, };

		// 字段名称
		String[] Names = { "姓名", "账号", "密码", "职位", "权限级别" };

		// 创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。
		defaultTableModel = new DefaultTableModel(playerInfo, Names);
		
		table = new JTable(defaultTableModel); // 字段名称
		Dimension size = table.getTableHeader().getPreferredSize();

		size.height = 30;// 设置新的表头高度40
		table.getTableHeader().setPreferredSize(size);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		// table.setPreferredScrollableViewportSize(new Dimension( 550,
		// 60));

		// 绑定滚动条
		JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(25);
		scrollPane.setBounds(0, 0, 690, 420);
		this.add(scrollPane);
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Image background = new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0, 0, null);

	}

	private void createDlg() {

		addDlg = new JDialog();
		addDlg.setSize(new Dimension(600, 350));
		addDlg.setLocation((screenSize.width - 700) / 2,
				(screenSize.height - 600) / 2);

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

	ActionListener add = new ActionListener() {


		public void actionPerformed(ActionEvent e) {


			// TODO Auto-generated method stub
			UserManageUI.this.createDlg();
			sureAddButton.addActionListener(sureAdd);
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

			user = new ManaUserVO(ID.getText(), name.getText(),
					password.getText(),
					authority.getText(),
					Integer.valueOf(age.getText()), 
					IDCard.getText(),
					sex.getText(), phone.getText(), position.getText());

			userService.addUser(user);

			ID.setText("");
			name.setText("");
			password.setText("");
			authority.setText("");
			age.setText("");
			IDCard.setText("");
			sex.setText("");
			phone.setText("");
			position.setText("");
			
			addDlg.dispose();
			sureAddButton.removeActionListener(sureAdd);
		}
	};

	ActionListener update = new ActionListener() {



		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			defaultTableModel.setRowCount(0);
			userVOs = null;
			userVOs = userService.getManaUsers();
			userVOs.remove(0);
			 System.out.println("size = "+userVOs.size());
			for (ManaUserVO user : userVOs) {
				Vector<String> row = new Vector<String>();
				row.add(user.getName());
				row.add(user.getID());
				row.add(user.getPassword());
				row.add(user.getPosition());
				row.add(user.getAuthority());
				defaultTableModel.addRow(row);
			}
		}
	};

	ActionListener delete = new ActionListener() {


	public void actionPerformed(ActionEvent e) {


			// TODO Auto-generated method stub
			int selected = table.getSelectedRow();
			String deleteID = (String) defaultTableModel
					.getValueAt(selected, 1);
			boolean whetherDelete = userService.deleteUser(deleteID);
			if (whetherDelete) {
				defaultTableModel.removeRow(selected);
			} else {
				System.out.println("用户信息无法删除！");
			}
		}
	};

	ActionListener modify = new ActionListener() {



		public void actionPerformed(ActionEvent e) {



			// TODO Auto-generated method stub
			int selectedRow = table.getSelectedRow();
			UserManageUI.this.createDlg();
			ManaUserVO user = userVOs.get(selectedRow);// ????????
			ID.setText(user.getID());
			name.setText(user.getName());
			password.setText(user.getPassword());
			authority.setText(user.getAuthority());
			age.setText(user.getAge() + "");
			IDCard.setText(user.getIDCard());
			sex.setText(user.getSex());
			phone.setText(user.getPhone());
			position.setText(user.getPosition());

			sureAddButton.addActionListener(sureModify);

		}
	};
	
	ActionListener sureModify = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ManaUserVO userNew = new ManaUserVO(ID.getText(), name.getText(),
					password.getText(), 
					authority.getText(),
					Integer.valueOf(age.getText()), 
					IDCard.getText(),
					sex.getText(), phone.getText(), position.getText());
			
			boolean whetherModify = userService.modify(userNew);
			ID.setText("");
			name.setText("");
			password.setText("");
			authority.setText("");
			age.setText("");
			IDCard.setText("");
			sex.setText("");
			phone.setText("");
			position.setText("");
			addDlg.dispose();
			sureAddButton.removeActionListener(sureModify);
		}
	};

}
