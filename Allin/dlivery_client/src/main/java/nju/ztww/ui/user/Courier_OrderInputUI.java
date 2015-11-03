package nju.ztww.ui.user;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Courier_OrderInputUI extends JPanel{
	
	JButton addButton = new JButton();
	JDialog addDlg = new JDialog();
	DefaultTableModel defaultTableModel ;
	JTable table = new JTable();
	
	
	private JLabel numbersLabel ;
	private JTextField numbers;
	private JLabel orderNumLabel;
	private JLabel orderNum;
	private JLabel senderLabel;
	private JTextField sender;
	private JLabel ognizationLabel;
	private JTextField ognization;
	private JLabel senderTELLabel;
	private JTextField senderTEL;
	private JLabel senderPhoneLabel;
	private JTextField senderPhone;
	private JLabel receiverLabel;
	private JTextField receiver;
	private JLabel placeLabel;
	private JTextField place;
	private JLabel receiverTELLabel;
	private JTextField receiverTEL;
	private JLabel receiverPhoneLabel;
	private JTextField receiverPhone;
	private JLabel goodInfoLabel;
	private JTextField goodInfo;
	private JLabel costLabel;
	private JLabel cost;
	private JLabel typeLabel;
	private JTextField type;
	private JLabel estTimeLabel;
	private JLabel estTime;
	
	
	
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public Courier_OrderInputUI(){
		this.setLayout(null);
		{/*for Button*/
			addButton.setBounds(500, 420, 110, 38);
			addButton.setIcon(new ImageIcon("photo/add.gif"));
			this.add(addButton);
			addButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// to add a dialog to complete
					//very important
					//including all the information and layout
					numbersLabel.setText("营业厅编号");
				}
				
			});
		}
		
		
		{/*for table*/
			Object[][] OrderInfo =
				{
					{"H12",  "123456789", "Tom", "12345678901",  "Jerry", 32.5, "特快"}
					
				};
			String[] names = {"营业厅编号", "订单号", "寄件人", "手机", "收件人", "费用合计", "种类"};
			
			table = new JTable( new DefaultTableModel(OrderInfo, names));			//???
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
}
