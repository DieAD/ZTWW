package nju.ztww.ui.order;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.MailingVO;

public class Courier_OrderInputUI extends JPanel{
	
	JButton addButton = new JButton();
	JButton sureButton = new JButton();
	JDialog addDlg ;
	DefaultTableModel defaultTableModel;
	JTable table = new JTable();
	OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
	
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
	private JLabel receiverTELLabel = new JLabel();
	private JTextField receiverTEL = new JTextField();
	private JLabel receiverPhoneLabel = new JLabel();
	private JTextField receiverPhone = new JTextField();
	private JLabel goodInfoLabel = new JLabel();
	private JTextField goodInfo = new JTextField();
	private JLabel costLabel = new JLabel();
	private JTextField cost = new JTextField();
	private JLabel typeLabel = new JLabel();
	private JTextField type = new JTextField();
	private JLabel estTimeLabel = new JLabel();
	private JTextField estTime = new JTextField();
	private JLabel packLabel = new JLabel();
	private JTextField pack = new JTextField();
	private JButton submitButton = new JButton();
	private String[] pl = {"北京", "上海", "广州", "南京"};
	private String from = "北京";
	private DeliverFeesVO deliverFees;
	
	private JComboBox places = new JComboBox(pl);
	private ArrayList<MailingVO> mailingOrders = new ArrayList<MailingVO>();
	
	
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public Courier_OrderInputUI(){
		this.setLayout(null);
		{/*for Button*/
			addButton.setBounds(500, 420, 110, 38);
			submitButton.setBounds(350, 420, 110, 38);
			submitButton.setText("提交");
			submitButton.addActionListener(e2);
			addButton.setIcon(new ImageIcon("photo/add.gif"));
			this.add(addButton);
			
			addButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// to add a dialog to complete
					//very important
					//including all the information and layout
					addDlg = new JDialog();
					addDlg.setSize(new Dimension(600, 450));
		            addDlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            sureButton.setText("确定");
		 
		            numbersLabel.setBounds(50, 20, 150, 20);
		            numbersLabel.setText("营业厅编号");
		            numbers.setBounds(120, 20, 100, 20);
		            orderNumLabel.setBounds(300, 20, 150, 20);
		            orderNumLabel.setText("订单号");
		            orderNum.setBounds(350, 20, 100, 20);
		            
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
//		            costLabel.setBounds(300, 260, 150, 20);
//		            costLabel.setText("运费");
//		            cost.setBounds(370, 260, 150, 20);
		            
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
//		            addDlg.add(cost);
		            addDlg.add(typeLabel);
		            addDlg.add(type);
		            addDlg.add(packLabel);
		            addDlg.add(pack);
		            
		            
		            addDlg.add(sureButton);
		            
		            
		            addDlg.setLayout(null);
					addDlg.setVisible(true);
					
				}
				
			});
		}
		
		this.add(submitButton);
		
		{/*for table*/
			Object[][] OrderInfo =
				{
					{"H12",  "123456789", "Tom", "12345678901",  "Jerry","13411111111" , 32.5, "特快", "江苏南京"}
					
				};
			String[] names = {"营业厅编号", "订单号", "寄件人", "手机", "收件人","手机" ,"费用合计", "种类", "地址"};
			
			defaultTableModel = new DefaultTableModel(OrderInfo, names);
			table = new JTable(defaultTableModel );			//???
			Dimension size = table.getTableHeader().getPreferredSize();		//??
			
			size.height = 30;
			table.getTableHeader().setPreferredSize(size);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			JScrollPane scrollPane = new JScrollPane(table);
			table.setRowHeight(25);
			scrollPane.setBounds(0, 0, 690, 420);
			this.add(scrollPane);
		}
		
	
	}
	
	ActionListener e2 = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int size = mailingOrders.size();
			for(int i=0;i<size;i++){
				orderServiceImpl.endSales(mailingOrders.get(i), 1);
			}
		}
	};
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Vector<String> row = new Vector<String>();
			
			MailingVO mailOrder = new MailingVO(1);
			mailOrder.setBusinID(numbers.getText());
			mailOrder.setStripNumber(orderNum.getText());
			mailOrder.setSendName(sender.getText());
			mailOrder.setSendTelephone(senderPhone.getText());
			mailOrder.setSendOrga(ognization.getText());
			mailOrder.setSendTEL(senderTEL.getText());
			mailOrder.setReceiveName(receiver.getText());
			mailOrder.setReceiveTelephone(receiverPhone.getText());
			mailOrder.setSendLocation(places.getActionCommand()+place.getText());
			mailOrder.setInfortation(goodInfo.getText());
			mailOrder.setCount(Double.valueOf(deliverFees.getCost()));
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
			row.add(deliverFees.getCost()+"");
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
	
	
}
