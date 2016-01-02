package nju.ztww.ui.manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import nju.ztww.dao.InsDO;
import nju.ztww.service.ManageService;
import nju.ztww.serviceimpl.ManageServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import confligUI.MyComboBox;
import confligUI.MyLabel;
import confligUI.MyTextField;








public class GManager_ManageOrgaUI extends JPanel {
	String[] position = { "快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员",
			"总经理", "管理员" };
	JButton searchButton = new JButton();
	JButton modifyButton = new JButton();
	JButton deletebButton = new JButton();
	MyLabel nameLabel = new MyLabel();
	MyLabel idLabel = new MyLabel();
	MyLabel membersLabel = new MyLabel();
	MyTextField search = new MyTextField();
	MyTextField name = new MyTextField();
	MyTextField id = new MyTextField();
	MyTextField members1 = new MyTextField();
	MyTextField members2 = new MyTextField();
	MyTextField members3 = new MyTextField();
	JDialog delete;
	JButton yesButton = new JButton();
	JButton cancelButton = new JButton();
	MyLabel tips = new MyLabel();
	InsDO info;
	ManageService MS = new ManageServiceImpl();

	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();

	MyComboBox mem1 = new MyComboBox(position);
	MyComboBox mem2 = new MyComboBox(position);
	MyComboBox mem3 = new MyComboBox(position);

	public GManager_ManageOrgaUI() {
		this.setLayout(null);
		this.setBackground(new Color(250, 240, 230));
		search.setBounds(60, 20, 160, 30);
		searchButton.setIcon(new ImageIcon("photo/search.png"));
		searchButton.setBorderPainted(false);
		searchButton.setBounds(240, 20, 80, 30);

		nameLabel.setText("机构名称");
		nameLabel.setBounds(140, 100, 100, 30);
		name.setBounds(240, 100, 180, 30);

		idLabel.setText("机构编号");
		idLabel.setBounds(140, 150, 100, 30);
		id.setBounds(240, 150, 180, 30);

		membersLabel.setText("机构内部成员");
		membersLabel.setBounds(140, 200, 100, 30);
		mem1.setBounds(240, 200, 160, 30);
		members1.setBounds(440, 200, 100, 30);
		mem2.setBounds(240, 250, 160, 30);
		members2.setBounds(440, 250, 100, 30);
		mem3.setBounds(240, 300, 160, 30);
		members3.setBounds(440, 300, 100, 30);

		modifyButton.setIcon(new ImageIcon("photo/modify.png"));
		modifyButton.setBorderPainted(false);
		modifyButton.setBounds(540, 350, 80, 30);

		deletebButton.setIcon(new ImageIcon("photo/delete.png"));
		deletebButton.setBorderPainted(false);
		deletebButton.setBounds(430, 350, 80, 30);
		deletebButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				tips.setText("确定删除该机构吗？");
				tips.setBounds(50, 20, 150, 20);

				yesButton.setText("确定");
				yesButton.setBounds(130, 70, 60, 20);
				yesButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						delete.setVisible(false);
					}
				});
				cancelButton.setText("取消");
				cancelButton.setBounds(200, 70, 60, 20);
				cancelButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						delete.setVisible(false);
					}
				});
				delete = new JDialog();
				delete.setLayout(null);
				delete.setVisible(true);
				delete.setSize(new Dimension(300, 150));
				delete.setLocation((screenSize.width) / 2,
						(screenSize.height) / 2);
				delete.add(tips);
				delete.add(yesButton);
				delete.add(cancelButton);
				}
			}
		});

		this.add(search);
		this.add(searchButton);
		this.add(nameLabel);
		this.add(name);
		this.add(idLabel);
		this.add(id);
		this.add(membersLabel);
		this.add(mem1);
		this.add(members1);
		this.add(mem2);
		this.add(members2);
		this.add(mem3);
		this.add(members3);
		this.add(modifyButton);
		this.add(deletebButton);

		searchButton.addActionListener(new Listener1());
		mem1.addItemListener(new Listener2(mem1, members1));
		mem2.addItemListener(new Listener2(mem2, members2));
		mem3.addItemListener(new Listener2(mem3, members3));
		modifyButton.addActionListener(new Listener3());
	}

	public class Listener1 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			String ids = search.getText();
			info = MS.showInsInfo(ids);
			name.setText(info.getName());
			id.setText(info.getId());
			}
		}

	}

	public class Listener2 implements ItemListener {
		MyComboBox box;
		MyTextField text;

		public Listener2(MyComboBox box, MyTextField text) {
			this.box = box;
			this.text = text;
		}

		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {
				eventHandle();
			}
		}

		public void eventHandle() {
			String item = (String) box.getSelectedItem();
			if (item.equals("快递员")) {
				String num = info.getN1() + "";
				text.setText(num);
			}
			if (item.equals("营业厅业务员")) {
				String num = info.getN2() + "";
				text.setText(num);
			}
			if (item.equals("中转中心业务员")) {
				String num = info.getN3() + "";
				text.setText(num);
			}
			if (item.equals("中转中心仓库管理人员")) {
				String num = info.getN4() + "";
				text.setText(num);
			}
			if (item.equals("财务人员")) {
				String num = info.getN5() + "";
				text.setText(num);
			}
			if (item.equals("总经理")) {
				String num = info.getN6() + "";
				text.setText(num);
			}
			if (item.equals("管理员")) {
				String num = info.getN7() + "";
				text.setText(num);
			}
		}

	}

	public class Listener3 implements ActionListener {
		InsDO ins = new InsDO();

		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			String ids = id.getText();
			String names = name.getText();
			ins.setId(ids);
			ins.setName(names);
			swfit(mem1, members1);
			swfit(mem2, members2);
			swfit(mem3, members3);
			MS.updateIns(ins);
			}
		}

		public int swfit(MyComboBox box, MyTextField text) {
			int index = 0;
			String item = (String) box.getSelectedItem();
			if (item.equals("快递员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN1(index);
			}
			if (item.equals("营业厅业务员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN2(index);
			}
			if (item.equals("中转中心业务员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN3(index);
			}
			if (item.equals("中转中心仓库管理人员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN4(index);
			}
			if (item.equals("财务人员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN5(index);
			}
			if (item.equals("总经理")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN6(index);
			}
			if (item.equals("管理员")) {
				if (!text.getText().equals("")) {
					index = Integer.parseInt(text.getText());
				}
				ins.setN7(index);
			}
			return index;
		}

	}
	
	public void paintComponent(Graphics g){
		Image background=new ImageIcon("photo2/graybg.png").getImage();
		g.drawImage(background, 0,0,null);
	}
	
}