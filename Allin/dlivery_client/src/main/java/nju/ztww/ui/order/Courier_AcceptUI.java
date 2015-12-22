package nju.ztww.ui.order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.service.OrderService;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.AcceptVO;

public class Courier_AcceptUI extends JPanel{

	MyButton searchButton = new MyButton('d');
	MyButton addButton = new MyButton('b');
	MyButton sureSearchButton = new MyButton();
	MyButton sureAddButton = new MyButton();
	MyButton deleteButton = new MyButton('c');
	MyButton submitButton = new MyButton('a');
	DefaultTableModel de;
	JDialog searchDlg;
	JDialog addDlg;
	MyTable table;
	
//	private ArrayList<E>
	
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
	private OrderService orderServiceImpl = new OrderServiceImpl();
	
	private String businID;
	private ArrayList<AcceptVO> acceptOrders = new ArrayList<AcceptVO>();
	private String timer;
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	
	
	public Courier_AcceptUI(){
		this.setBackground(new Color(250, 240, 230));
		this.setLayout(null);
		{/*for Button*/
//			searchButton.setBounds(410, 400, 80, 30);	//——by zyz 2015/12/3
//			searchButton.setIcon(new ImageIcon("photo/search.gif"));
//			this.add(searchButton);
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
			
		
//			addButton.setBounds(570, 400, 80, 30);	//——by zyz 2015/12/3
//			addButton.setText("添加");
			this.add(addButton);
			addButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String ID = UserInfoUI.getUserID();
					businID = ID.substring(0, 8);
					
					addDlg = new JDialog();
					addDlg.setSize(new Dimension(360, 320));
		            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            sureAddButton.setText("确定");
		            sureAddButton.setBounds(220, 230, 70, 30);
		            sureAddButton.addActionListener(listener);
		 
		            numbersLabel.setBounds(50, 20, 150, 20);
		            numbersLabel.setText("营业厅编号");
		            numbers.setBounds(140, 20, 100, 20);
		            numbers.setText(businID);
		            
		            acceptNumLabel.setBounds(50, 60, 150, 20);
		            acceptNumLabel.setText("收件信息编号");
		            acceptNum.setBounds(140, 60, 150, 20);
		            receiverLabel.setBounds(50, 100, 150, 20);
		            receiverLabel.setText("收件人");
		            receiver.setBounds(140, 100, 150, 20);
		            timeLabel.setBounds(50, 140, 150, 20);
		            timeLabel.setText("收件日期");
		            time.setBounds(140, 140, 150, 20);
		            timer = getDate();
		            time.setText(timer);
		            courierLabel.setBounds(50, 180, 150, 20);
		            courierLabel.setText("快递员编号");
		            courier.setBounds(140, 180, 150, 20);
		            courier.setText(ID);
		            
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
		
		
//			deleteButton.setBounds(490, 400, 80, 30);	//——by zyz 2015/12/3
			this.add(deleteButton);
			deleteButton.addActionListener(delete);
		
//			submitButton.setBounds(650, 400, 80, 30);	//——by zyz 2015/12/3
			this.add(submitButton);
			submitButton.addActionListener(submit);
			
		
		}
		
		
		{/* for Table*/
			Object[][] Accept = 
				{
					
				};
			String[] names = {"营业厅编号", "收件信息编号", "收件人", "收件时间", "快递员编号"};
		
		de = new DefaultTableModel(Accept, names);
		table = new MyTable(de);
		MyScrollPane scrollPane = new MyScrollPane(table);
		this.add(scrollPane);
//		Dimension size = table.getTableHeader().getPreferredSize();		
//		
//		size.height = 30;
//		table.getTableHeader().setPreferredSize(size);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		JScrollPane scrollPane = new JScrollPane(table);
//		
//		//
//		table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//		table.setBackground(new Color(208,168,125)); //226,203,170
//		scrollPane.getViewport().setOpaque(false);
//		scrollPane.setOpaque(false);
//		
//		table.setRowHeight(25);
//		scrollPane.setBounds(0, 0, 750, 400);
//		this.add(scrollPane);
		}
		
	}
	
	ActionListener listener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Vector<String> row =  new Vector<String>();
			AcceptVO acceptOrder = new AcceptVO(11);
			acceptOrder.setBusinID(numbers.getText());
			acceptOrder.setAcceptID(acceptNum.getText());
			acceptOrder.setAccepter(receiver.getText());
			acceptOrder.setAcceptTime(time.getText());
			acceptOrder.setCourierID(courier.getText());
			acceptOrder.setState(1);
			acceptOrder.setExe(0);
			acceptOrders.add(acceptOrder);
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

	ActionListener delete = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selected = table.getSelectedRow();
			if(selected>=0&&acceptOrders.size()>=0){
				de.removeRow(selected);
				acceptOrders.remove(selected);
			}
		}
	};
	
	
	ActionListener submit = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int size = acceptOrders.size();
			for(int i = 0; i<size;i++){
				orderServiceImpl.endSales(acceptOrders.get(i), 11);
			}
			acceptOrders.clear();
			de.setRowCount(0);
		}
	};
	
	
	public static String getDate(){
		Date now = new Date();
		SimpleDateFormat matter= new SimpleDateFormat("yyyy/MM/dd/HH:mm");
		String date = matter.format(now);
		return date;
	}
}
