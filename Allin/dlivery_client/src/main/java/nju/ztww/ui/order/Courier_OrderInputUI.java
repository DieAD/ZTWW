package nju.ztww.ui.order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.MailingVO;

public class Courier_OrderInputUI extends JPanel{
	
	MyButton addButton = new MyButton('b');
	MyButton sureButton = new MyButton();
	JDialog addDlg ;
	DefaultTableModel defaultTableModel;
	MyTable table ;
	OrderService orderServiceImpl = new OrderServiceImpl();
	
	private JLabel numbersLabel = new JLabel();
	private JTextField numbers = new JTextField();
	private JLabel orderNumLabel = new JLabel();
	private JTextField orderNum = new JTextField();
	private JLabel senderLabel = new JLabel();
	private JTextField sender = new JTextField();
	private JLabel ognizationLabel = new JLabel();
	private JTextField ognization = new JTextField();
	private JLabel senderTELLabel = new JLabel();
	private JTextField senderTEL = new JTextField();
	private JLabel senderPhoneLabel = new JLabel();
	private JTextField senderPhone = new JTextField();
	private JLabel receiverLabel = new JLabel();
	private JTextField receiver = new JTextField();
	private JLabel placeLabel = new JLabel();
	private JTextField place = new JTextField();
//	private JLabel receiverTELLabel = new JLabel();
//	private JTextField receiverTEL = new JTextField();
	private JLabel receiverPhoneLabel = new JLabel();
	private JTextField receiverPhone = new JTextField();
	private JLabel goodInfoLabel = new JLabel();
	private JTextField goodInfo = new JTextField();
	private JLabel costLabel = new JLabel();
//	private JTextField cost = new JTextField();
	private JLabel typeLabel = new JLabel();
	private JTextField type = new JTextField();
	private JLabel estTimeLabel = new JLabel();
	private JTextField estTime = new JTextField();
	private JLabel packLabel = new JLabel();
	private JTextField pack = new JTextField();
	private MyButton submitButton = new MyButton('a');
	private MyButton deleteButton = new MyButton('c');
	private String[] pl = {"北京", "上海", "广州", "南京"};
	
	private String from ;
	private String businID ;//= ID.substring(0, 8);

//	public void getFrom(String ID){
//		String place = ID.substring(0, 3);
//		if(place.equals("025")) this.from = "北京";//这里！！！！！！！！！！！！！！！！！！！！
//		else if(place.equals("010")) this.from = "北京";
//		else if(place.equals("020")) this.from = "广州";
//		else if(place.equals("021")) this.from = "上海";
//		else System.out.println("无法获得当前城市！");
//		
//	}
	
	private JComboBox<String> places = new JComboBox<String>(pl);
	private ArrayList<MailingVO> mailingOrders = new ArrayList<MailingVO>();
	
	
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public Courier_OrderInputUI(){

		this.setBackground(new Color(250, 240, 230));
		
		this.setLayout(null);
		{/*for Button*/
//			addButton.setBounds(570, 400, 80, 30);	//——by zyz 2015/12/3
//			submitButton.setBounds(650, 400, 80, 30);	//——by zyz 2015/12/3
//			submitButton.setText("提交");
			submitButton.addActionListener(submit);
			this.add(submitButton);
//			addButton.setIcon(new ImageIcon("photo/add.gif"));
			this.add(addButton);
			
			
			addButton.addActionListener(add);
			
//			deleteButton.setBounds(490, 400, 80, 30);	//——by zyz 2015/12/3
			deleteButton.addActionListener(delete);
			this.add(deleteButton);
		}
		
		
		
		{/*for table*/
			Object[][] OrderInfo =
				{		
//					{"123","123", "123"}
				};
			String[] names = {"营业厅编号", "订单号", "寄件人", "手机", "收件人","手机" ,"费用合计", "种类", "地址"};
			
			defaultTableModel = new DefaultTableModel(OrderInfo, names);
			table = new MyTable(defaultTableModel);
			MyScrollPane scrollPane = new MyScrollPane(table);
//			table = new JTable(defaultTableModel );			
//			Dimension size = table.getTableHeader().getPreferredSize();		
//			
//			size.height = 30;
//			table.getTableHeader().setPreferredSize(size);
//			table.setOpaque(false);
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//			
//			JScrollPane scrollPane = new JScrollPane(table);
//			
//			//
//			table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//			table.setBackground(new Color(208,168,125)); //226,203,170
//			scrollPane.getViewport().setOpaque(false);
//			scrollPane.setOpaque(false);
////			scrollPane.getColumnHeader().setOpaque(false);
//			
//			
//			
//			
//			table.setRowHeight(25);
//			scrollPane.setBounds(0, 0, 750, 400);//——by zyz 2015/12/3
			this.add(scrollPane);
		}
		
	
	}
	
	ActionListener submit = new ActionListener() {

		
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			int size = mailingOrders.size();
			for(int i=0;i<size;i++){
				orderServiceImpl.endSales(mailingOrders.get(i), 1);
				
			}
			mailingOrders.clear();
			defaultTableModel.setColumnCount(0);
		}
	};
	
	ActionListener listener = new ActionListener(){


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			Vector<String> row = new Vector<String>();
			
			String ID = UserInfoUI.getUserID();
			String PLACE = ID.substring(0, 3);
			if(PLACE.equals("025")) from = "南京";
			else if(PLACE.equals("010")) from = "北京";
			else if(PLACE.equals("020")) from = "广州";
			else if(PLACE.equals("021")) from = "上海";
			else System.out.println("无法获得当前城市！");
			
			DeliverFeesVO deliverFees = new DeliverFeesVO(from, (String)places.getSelectedItem(), 
					type.getText(), Double.valueOf(pack.getText()), goodInfo.getText());
			
			double result = orderServiceImpl.getCost(deliverFees);
			MailingVO mailOrder = new MailingVO(1);
			mailOrder.setBusinID(numbers.getText());
			mailOrder.setStripNumber(orderNum.getText());
			mailOrder.setSendName(sender.getText());
			mailOrder.setSendTelephone(senderPhone.getText());
			mailOrder.setSendOrga(ognization.getText());
			mailOrder.setSendTEL(senderTEL.getText());
			mailOrder.setReceiveName(receiver.getText());
			mailOrder.setReceiveTelephone(receiverPhone.getText());
			mailOrder.setSendLocation(places.getSelectedItem()+place.getText());
			mailOrder.setInfortation(goodInfo.getText());
			mailOrder.setCount(result);
			mailOrder.setTime(Integer.valueOf(estTime.getText()));
			mailOrder.setState(1);
			mailOrder.setExe(0);
			mailingOrders.add(mailOrder);
			row.add(numbers.getText());
			row.add(orderNum.getText());
			row.add(sender.getText());
			row.add(senderPhone.getText());
			row.add(receiver.getText());
			row.add(receiverPhone.getText());
			row.add(result+"");
			row.add(type.getText());
			defaultTableModel.addRow(row);
			 table.revalidate();
			 numbers.setText("");
			 orderNum.setText("");
			 ognization.setText("");
			 sender.setText("");
			 senderPhone.setText("");
			 senderTEL.setText("");
			 receiver.setText("");
			 receiverPhone.setText("");
			 place.setText("");
			 goodInfo.setText("");
//			 cost.setText("");
			 type.setText("");
			 estTime.setText("");
			 pack.setText("");
			 

			 addDlg.dispose();
			 sureButton.removeActionListener(listener);
			 
	
		}
		
	};
	
	ActionListener delete = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int selected = table.getSelectedRow();
			defaultTableModel.removeRow(selected);
			System.out.println("selected = "+selected);
			mailingOrders.remove(selected-1); //暂时不能删除第一个
		}
	};

	ActionListener add = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			// to add a dialog to complete
			//very important
			//including all the information and layout
			String ID = UserInfoUI.getUserID();
			businID = ID.substring(0, 8);
			
			addDlg = new JDialog();
			addDlg.setSize(new Dimension(600, 450));
            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            sureButton.setText("确定");
            String  mailingOrderID = orderServiceImpl.getOrderID();
 
            numbersLabel.setBounds(50, 20, 150, 20);
            numbersLabel.setText("营业厅编号");
            numbers.setBounds(120, 20, 100, 20);
            numbers.setText(businID);
            orderNumLabel.setBounds(300, 20, 150, 20);
            orderNumLabel.setText("订单号");
            orderNum.setBounds(350, 20, 100, 20);
            orderNum.setText(mailingOrderID);
            
            senderLabel.setBounds(50, 70, 150, 20);
            senderLabel.setText("寄件人");
            sender.setBounds(100, 70, 100, 20); 
            senderPhoneLabel.setBounds(300, 70, 150, 20);   
            senderPhoneLabel.setText("手机");
            senderPhone.setBounds(350, 70, 150, 20);  
            
            ognizationLabel.setBounds(50, 100, 150, 20);
            ognizationLabel.setText("单位");
            ognization.setBounds(100, 100, 150, 20);
            senderTELLabel.setBounds(300, 100, 150, 20);
            senderTELLabel.setText("电话");
            senderTEL.setBounds(350, 100, 150, 20);
            
            receiverLabel.setBounds(50, 150, 150, 20);
            receiverLabel.setText("收件人");
            receiver.setBounds(100, 150, 150, 20);
            receiverPhoneLabel.setBounds(300, 150, 150, 20);
            receiverPhoneLabel.setText("手机");
            receiverPhone.setBounds(350, 150, 150, 20);
            
            placeLabel.setBounds(50, 180, 150, 20);
            placeLabel.setText("地址");
            places.setBounds(100, 180, 150, 20);
            place.setBounds(100, 210, 400, 30);
            
            goodInfoLabel.setBounds(50, 260, 150, 20);
            goodInfoLabel.setText("货物信息");
            goodInfo.setBounds(120, 260, 150, 20);
//            costLabel.setBounds(300, 260, 150, 20);
//            costLabel.setText("运费");
//            cost.setBounds(370, 260, 150, 20);
            
            typeLabel.setBounds(50, 290, 150, 20);
            typeLabel.setText("货物类型");
            type.setBounds(120, 290, 150, 20);
            estTimeLabel.setBounds(300, 290, 150, 20);
            estTimeLabel.setText("预估时间");
            estTime.setBounds(370, 290, 150, 20);
            
            packLabel.setText("包装费");
            packLabel.setBounds(300, 260, 150, 20);
            pack.setBounds(370, 260, 150, 20);
    
            sureButton.setBounds(450, 350, 70, 30);
            sureButton.addActionListener(listener);
            
            addDlg.add(numbersLabel);
            addDlg.add(numbers);
            addDlg.add(senderLabel);
            addDlg.add(sender);
            addDlg.add(orderNumLabel);
            addDlg.add(orderNum);
            addDlg.add(ognizationLabel);
            addDlg.add(ognization);
            addDlg.add(senderTELLabel);
            addDlg.add(senderTEL);
            addDlg.add(senderPhoneLabel);
            addDlg.add(senderPhone);
            addDlg.add(receiverLabel);
            addDlg.add(receiver);
            addDlg.add(receiverPhoneLabel);
            addDlg.add(receiverPhone);
            addDlg.add(placeLabel);
            addDlg.add(place);
            addDlg.add(places);
            addDlg.add(goodInfoLabel);
            addDlg.add(goodInfo);
            addDlg.add(estTimeLabel);
            addDlg.add(estTime);
            addDlg.add(costLabel);
//            addDlg.add(cost);
            addDlg.add(typeLabel);
            addDlg.add(type);
            addDlg.add(packLabel);
            addDlg.add(pack);
            
            
            addDlg.add(sureButton);
            
            
            addDlg.setLayout(null);
			addDlg.setVisible(true);
			
		}
	};
}
