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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import confligUI.MyButton;
import confligUI.MyComboBox;
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
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.MailingVO;

public class Courier_OrderInputUI extends JPanel{
	
	MyButton addButton = new MyButton('b');
	MyButton sureButton = new MyButton();
	MyDialog addDlg ;
	DefaultTableModel defaultTableModel;
	MyTable table ;
	OrderService orderServiceImpl = new OrderServiceImpl();
	String[] TYPES = {"特快", "标准", "经济"};
	private MyLabel mylabel=new MyLabel();
	private MyLabel numbersLabel = new MyLabel();
	private MyTextField numbers = new MyTextField();
	private MyLabel orderNumLabel = new MyLabel();
	private MyTextField orderNum = new MyTextField();
	private MyLabel senderLabel = new MyLabel();
	private MyTextField sender = new MyTextField();
	private MyLabel ognizationLabel = new MyLabel();
	private MyTextField ognization = new MyTextField();
	private MyLabel senderTELLabel = new MyLabel();
	private MyTextField senderTEL = new MyTextField();
	private MyLabel senderPhoneLabel = new MyLabel();
	private MyTextField senderPhone = new MyTextField();
	private MyLabel receiverLabel = new MyLabel();
	private MyTextField receiver = new MyTextField();
	private MyLabel placeLabel = new MyLabel();
	private MyTextField place = new MyTextField();
//	private MyLabel receiverTELLabel = new MyLabel();
//	private MyTextField receiverTEL = new MyTextField();
	private MyLabel receiverPhoneLabel = new MyLabel();
	private MyTextField receiverPhone = new MyTextField();
	private MyLabel goodInfoLabel = new MyLabel();
	private MyTextField goodInfo = new MyTextField();
	private MyLabel costLabel = new MyLabel();
//	private MyTextField cost = new MyTextField();
	private MyLabel typeLabel = new MyLabel();
	private MyComboBox<String> type = new MyComboBox<String>(TYPES);
	private MyLabel estTimeLabel = new MyLabel();
	private MyTextField estTime = new MyTextField();
	private MyLabel packLabel = new MyLabel();
	private MyTextField pack = new MyTextField();
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
	
	private MyComboBox<String> places = new MyComboBox<String>(pl);
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
			if(TestIfConnect.ifConnect()){
			// TODO Auto-generated method stub
			int size = mailingOrders.size();
			for(int i=0;i<size;i++){
				orderServiceImpl.endSales(mailingOrders.get(i), 1);
				
			}
			mailingOrders.clear();
			defaultTableModel.setRowCount(0);
		}
		}
	};
	
	ActionListener listener = new ActionListener(){


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			ArrayList<String>stringlist=new ArrayList<String>();
			stringlist.add(numbers.getText());
			stringlist.add(orderNum.getText());
			stringlist.add(sender.getText());
			stringlist.add(senderPhone.getText());
			stringlist.add(ognization.getText());
			stringlist.add(senderTEL.getText());
			stringlist.add(receiver.getText());
			stringlist.add(receiverPhone.getText());
			stringlist.add(goodInfo.getText());
			stringlist.add(estTime.getText());
			stringlist.add(pack.getText());
			stringlist.add(place.getText());
			stringlist.add(places.getSelectedItem().toString());
			stringlist.add(type.getSelectedItem().toString());
			IsEmpty is=new IsEmpty();
			boolean isempty=false;
			isempty=is.isempty(stringlist);
			if(!isempty){
			Vector<String> row = new Vector<String>();
			
			String ID = UserInfoUI.getUserID();
			String PLACE = ID.substring(0, 3);
			if(PLACE.equals("025")) from = "北京";
			else if(PLACE.equals("010")) from = "北京";
			else if(PLACE.equals("020")) from = "广州";
			else if(PLACE.equals("021")) from = "上海";
			else System.out.println("无法获得当前城市！");
			
			DeliverFeesVO deliverFees = new DeliverFeesVO(from, (String)places.getSelectedItem(), 
					(String) type.getSelectedItem(), Double.valueOf(pack.getText()), goodInfo.getText());
			
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
			row.add((String) type.getSelectedItem());
			row.add(places.getSelectedItem()+place.getText());
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
//			 type.setText("");
			 estTime.setText("");
			 pack.setText("");
			 

			 addDlg.dispose();
			 sureButton.removeActionListener(listener);
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
			if(selected>=0&&mailingOrders.size()!=0){
				
				mailingOrders.remove(selected); //暂时不能删除第一个
			}
			defaultTableModel.removeRow(selected);
			}
	};

	ActionListener add = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			// to add a dialog to complete
			//very important
			//including all the information and layout
			String ID = UserInfoUI.getUserID();
			businID = ID.substring(0, 8);
			
			addDlg = new MyDialog();
			addDlg.setSize(new Dimension(600, 550));
            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            sureButton.setIcon(new ImageIcon("photo/Sure.png"));
            String  mailingOrderID = orderServiceImpl.getOrderID();
            mylabel.setText("信息未填全！");
            mylabel.setBounds(440, 460, 100, 40);
            numbersLabel.setBounds(50, 20, 150, 30);
            numbersLabel.setText("营业厅编号");
            numbers.setBounds(130, 20, 120, 30);
            numbers.setText(businID);
            orderNumLabel.setBounds(300, 20, 120, 30);
            orderNumLabel.setText("订单号");
            orderNum.setBounds(350, 20, 150, 30);
            orderNum.setText(mailingOrderID);
            
            senderLabel.setBounds(50, 85, 120, 30);
            senderLabel.setText("寄件人");
            sender.setBounds(100, 85, 140, 30); 
            senderPhoneLabel.setBounds(300, 85, 150, 30);   
            senderPhoneLabel.setText("手机");
            senderPhone.setBounds(350, 85, 150, 30);  
            
            ognizationLabel.setBounds(50, 130, 150, 30);
            ognizationLabel.setText("单位");
            ognization.setBounds(100, 130, 150, 30);
            senderTELLabel.setBounds(300, 130, 150, 30);
            senderTELLabel.setText("电话");
            senderTEL.setBounds(350, 130, 150, 30);
            
            receiverLabel.setBounds(50, 195, 150, 30);
            receiverLabel.setText("收件人");
            receiver.setBounds(100, 195, 150, 30);
            receiverPhoneLabel.setBounds(300, 195, 150, 30);
            receiverPhoneLabel.setText("手机");
            receiverPhone.setBounds(350, 195, 150, 30);
            
            placeLabel.setBounds(50, 240, 150, 30);
            placeLabel.setText("地址");
            places.setBounds(100, 240, 150, 30);
            place.setBounds(100, 270, 400, 40);
            
            goodInfoLabel.setBounds(50, 335, 150, 30);
            goodInfoLabel.setText("货物重量");
            goodInfo.setBounds(120, 335, 150, 30);
//            costLabel.setBounds(300, 260, 150, 20);
//            costLabel.setText("运费");
//            cost.setBounds(370, 260, 150, 20);
            
            typeLabel.setBounds(50, 380, 150, 30);
            typeLabel.setText("货物类型");
            type.setBounds(120, 380, 150, 30);
            estTimeLabel.setBounds(300, 380, 150, 30);
            estTimeLabel.setText("预估时间");
            estTime.setBounds(370, 380, 150, 30);
            
            packLabel.setText("包装费");
            packLabel.setBounds(300, 335, 150, 30);
            pack.setBounds(370, 335, 150, 30);
    
            sureButton.setBounds(450, 430, 80, 30);
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
            addDlg.add(mylabel);
            mylabel.setVisible(false);
            
            addDlg.add(sureButton);
            
            
            addDlg.setLayout(null);
			addDlg.setVisible(true);
			}
		}
	};
}
