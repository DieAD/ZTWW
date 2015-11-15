package nju.ztww.ui.order;

import java.awt.Dimension;
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

public class Courier_AcceptUI extends JPanel{

	JButton searchButton = new JButton();
	JButton addButton = new JButton();
	JButton sureSearchButton = new JButton();
	JButton sureAddButton = new JButton();
	DefaultTableModel de;
	JDialog searchDlg;
	JDialog addDlg;
	JTable table = new JTable();
	
	private JLabel numbersLabel = new JLabel();
	private JTextField numbers = new JTextField();
	private JLabel acceptNumLabel = new JLabel();
	private JTextField acceptNum = new JTextField();
	private JLabel receiverLabel = new JLabel();
	private JTextField receiver = new JTextField();
	private JLabel timeLabel = new JLabel();
	private JTextField time = new JTextField();
	private JLabel courierLabel = new JLabel();
	private JTextField courier = new JTextField();
	private JTextField search = new JTextField();
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	
	
	public Courier_AcceptUI(){
		this.setLayout(null);
		{/*for Button*/
			searchButton.setBounds(500, 420, 110, 38);
			searchButton.setIcon(new ImageIcon("photo/search.gif"));
			this.add(searchButton);
			searchButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// to add a dialog to complete
					//very important
					//including a textfield
					searchDlg = new JDialog();
					searchDlg.setSize(new Dimension(300, 120));
					searchDlg.setLocation((screenSize.width)/2, (screenSize.height)/2);
					sureSearchButton.setBounds(200, 25, 70, 30);
					sureSearchButton.setText("查询");
				
					search.setBounds(20, 25, 150, 30);
					
					searchDlg.add(sureSearchButton);
					searchDlg.add(search);
					
					searchDlg.setLayout(null);
					searchDlg.setVisible(true);
					
				}
				
			});
			
		
			addButton.setBounds(400, 420, 110, 38);
			addButton.setText("添加");
			this.add(addButton);
			addButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					addDlg = new JDialog();
					addDlg.setSize(new Dimension(360, 320));
		            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            sureAddButton.setText("确定");
		            sureAddButton.setBounds(220, 230, 70, 30);
		            sureAddButton.addActionListener(listener);
		 
		            numbersLabel.setBounds(50, 20, 150, 20);
		            numbersLabel.setText("营业厅编号");
		            numbers.setBounds(140, 20, 100, 20);
		            acceptNumLabel.setBounds(50, 60, 150, 20);
		            acceptNumLabel.setText("收件信息编号");
		            acceptNum.setBounds(140, 60, 150, 20);
		            receiverLabel.setBounds(50, 100, 150, 20);
		            receiverLabel.setText("收件信息编号");
		            receiver.setBounds(140, 100, 150, 20);
		            timeLabel.setBounds(50, 140, 150, 20);
		            timeLabel.setText("收件日期");
		            time.setBounds(140, 140, 150, 20);
		            courierLabel.setBounds(50, 180, 150, 20);
		            courierLabel.setText("快递员编号");
		            courier.setBounds(140, 180, 150, 20);
		            
		            addDlg.add(numbersLabel);
		            addDlg.add(numbers);
		            addDlg.add(acceptNumLabel);
		            addDlg.add(acceptNum);
		            addDlg.add(receiverLabel);
		            addDlg.add(receiver);
		            addDlg.add(timeLabel);
		            addDlg.add(time);
		            addDlg.add(courierLabel);
		            addDlg.add(courier);
		            
		            addDlg.add(sureAddButton);
		            
		            addDlg.setLayout(null);
					addDlg.setVisible(true);
				}
			});
		
		}
		
		
		{/* for Table*/
			Object[][] Accept = 
				{
					{"H12", "123455", "Jerry", "2015/11/2  14:00", "123456789"}
				};
			String[] names = {"营业厅编号", "收件信息编号", "收件人", "收件时间", "快递员编号"};
		
		de = new DefaultTableModel(Accept, names);
		table = new JTable(de);
		Dimension size = table.getTableHeader().getPreferredSize();		
		
		size.height = 30;
		table.getTableHeader().setPreferredSize(size);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(25);
		scrollPane.setBounds(0, 0, 690, 420);
		this.add(scrollPane);
		}
		
	}
	
	ActionListener listener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Vector<String> row =  new Vector<String>();
			row.add(numbers.getText());
			numbers.setText("");
			row.add(acceptNum.getText());
			acceptNum.setText("");
			row.add(receiver.getText());
			receiver.setText("");
			row.add(time.getText());
			time.setText("");
			row.add(courier.getText());
			courier.setText("");
			de.addRow(row);
			 table.revalidate();
			 
			addDlg.dispose();
			sureAddButton.removeActionListener(listener);
		}
	};
}
