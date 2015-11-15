package nju.ztww.ui.manage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GManager_CheckOrders extends JPanel{
		JTextField search = new JTextField();
		JButton searchButton  = new JButton("搜索");
		JLabel nameLabel = new JLabel();
		JLabel numLabel = new JLabel();
		JLabel memberJLabel = new JLabel();
		JTextField name  = new JTextField();
		JTextField num = new JTextField();
		JTextField num1 = new JTextField();
		JTextField num2 = new JTextField();
		JTextField num3 = new JTextField();
		JButton sureButton = new JButton("确定");
		JButton closButton = new JButton("关闭");
		
		public GManager_CheckOrders(){
			this.setLayout(null);
			search.setBounds(20, 20, 100, 20);
			searchButton.setBounds(150, 20, 100, 20);
			nameLabel.setText("机构名称");
			nameLabel.setBounds(50, 100, 100, 30);
			name.setBounds(180, 100, 150, 20);
			numLabel.setText("机构编号");
//			numLabel.setBounds(50, 100, width, height);
		}
}
