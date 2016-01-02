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
import nju.ztww.bl.commodity.IsEmpty;
import nju.ztww.service.OrderService;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
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
	MyDialog searchDlg;
	MyDialog addDlg;
	MyTable table;
	
//	private ArrayList<E>
	
	private MyLabel numbersLabel = new MyLabel();
	private MyTextField numbers = new MyTextField();
	private MyLabel acceptNumLabel = new MyLabel();
	private MyTextField acceptNum = new MyTextField();
	private MyLabel receiverLabel = new MyLabel();
	private MyTextField receiver = new MyTextField();
	private MyLabel timeLabel = new MyLabel();
	private MyTextField time = new MyTextField();
	private MyLabel courierLabel = new MyLabel();
	private MyTextField courier = new MyTextField();
	private MyTextField search = new MyTextField();
	private OrderService orderServiceImpl = new OrderServiceImpl();
	private MyLabel mylabel=new MyLabel();
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
					if(TestIfConnect.ifConnect()){
					searchDlg = new MyDialog();
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
					
				}
				
			});
			
		
//			addButton.setBounds(570, 400, 80, 30);	//——by zyz 2015/12/3
//			addButton.setText("添加");
			this.add(addButton);
			addButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(TestIfConnect.ifConnect()){
					String ID = UserInfoUI.getUserID();
					businID = ID.substring(0, 8);
					addDlg = new MyDialog();
					addDlg.setSize(new Dimension(360, 340));
		            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            sureAddButton.setIcon(new ImageIcon("photo/Sure.png"));
		            sureAddButton.setBounds(220, 235, 80, 30);
		            mylabel.setText("信息未填全！");
		            mylabel.setBounds(220, 265, 100, 40);
		            sureAddButton.addActionListener(listener);
		 
		            numbersLabel.setBounds(50, 20, 150, 25);
		            numbersLabel.setText("营业厅编号");
		            numbers.setBounds(140, 20, 100, 25);
		            numbers.setText(businID);
		            
		            acceptNumLabel.setBounds(50, 65, 150, 25);
		            acceptNumLabel.setText("收件信息编号");
		            acceptNum.setBounds(140, 65, 150, 25);
		            receiverLabel.setBounds(50, 110, 150, 25);
		            receiverLabel.setText("收件人");
		            receiver.setBounds(140, 110, 150, 25);
		            timeLabel.setBounds(50, 155, 150, 25);
		            timeLabel.setText("收件日期");
		            time.setBounds(140, 155, 150, 25);
		            timer = getDate();
		            time.setText(timer);
		            courierLabel.setBounds(50, 200, 150, 25);
		            courierLabel.setText("快递员编号");
		            courier.setBounds(140, 200, 150, 25);
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
		            addDlg.add(mylabel);
		            addDlg.add(sureAddButton);
		            mylabel.setVisible(false);
		            addDlg.setLayout(null);
					addDlg.setVisible(true);
					}
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
			ArrayList<String>stringlist=new ArrayList<String>();
			stringlist.add(numbers.getText());
			stringlist.add(acceptNum.getText());
			stringlist.add(receiver.getText());
			stringlist.add(time.getText());
			stringlist.add(courier.getText());
			IsEmpty is=new IsEmpty();
			boolean isempty=false;
			isempty=is.isempty(stringlist);
			if(!isempty){
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
			else{
				mylabel.setVisible(true);
			}
		}
			
	};

	ActionListener delete = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selected = table.getSelectedRow();
			if(selected>=0&&acceptOrders.size()!=0){
				acceptOrders.remove(selected);
			}
			de.removeRow(selected);
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
