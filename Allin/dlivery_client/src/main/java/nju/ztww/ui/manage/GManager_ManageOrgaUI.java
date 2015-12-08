package nju.ztww.ui.manage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.dao.InsDO;
import nju.ztww.service.ManageService;
import nju.ztww.serviceimpl.ManageServiceImpl;

public class GManager_ManageOrgaUI extends JPanel {
	String[] position = { "快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员",
			"总经理", "管理员" };
	JButton searchButton = new JButton();
	JButton modifyButton = new JButton();
	JButton deletebButton = new JButton();
	JLabel nameLabel = new JLabel();
	JLabel idLabel = new JLabel();
	JLabel membersLabel = new JLabel();
	JTextField search = new JTextField();
	JTextField name = new JTextField();
	JTextField id = new JTextField();
	JTextField members1 = new JTextField();
	JTextField members2 = new JTextField();
	JTextField members3 = new JTextField();
	JDialog delete;
	JButton yesButton = new JButton();
	JButton cancelButton = new JButton();
	JLabel tips = new JLabel();
	InsDO info;
	ManageService MS = new ManageServiceImpl();

	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();

	JComboBox mem1 = new JComboBox(position);
	JComboBox mem2 = new JComboBox(position);
	JComboBox mem3 = new JComboBox(position);

	public GManager_ManageOrgaUI() {
		this.setLayout(null);
		search.setBounds(60, 20, 160, 30);
		searchButton.setText("查询");
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

		modifyButton.setText("修改");
		modifyButton.setBounds(540, 400, 80, 30);

		deletebButton.setText("删除");
		deletebButton.setBounds(430, 400, 80, 30);
		deletebButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			String ids = search.getText();
			info = MS.showInsInfo(ids);
			name.setText(info.getName());
			id.setText(info.getId());
		}

	}

	public class Listener2 implements ItemListener {
		JComboBox box;
		JTextField text;

		public Listener2(JComboBox box, JTextField text) {
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
			// TODO Auto-generated method stub
			String ids = id.getText();
			String names = name.getText();
			ins.setId(ids);
			ins.setName(names);
			swfit(mem1, members1);
			swfit(mem2, members2);
			swfit(mem3, members3);
			MS.updateIns(ins);
		}

		public int swfit(JComboBox box, JTextField text) {
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
}
