package nju.ztww.ui.user;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.SendVO;

/**
 * 接受与派件
 * @author TQ
 *
 */
public class ReceiveAndSendUI extends JPanel{
	
	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel("到达日期");
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel("中转单编号");
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel("出发地");
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel("货物到达状态");
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel("备注");
	
	private JTextField datetextArea=new JTextField("");
	private  JLabel date=new  JLabel("到达日期");
	private JTextField numbertextArea=new JTextField("");
	private  JLabel number=new  JLabel("托运订单号");
	private JTextField sendertextArea=new JTextField("");
	private  JLabel sender=new  JLabel("派送员");
	private JTextField othertextArea=new JTextField("");
	private  JLabel other=new  JLabel("备注");
	
	private JButton deleteReceiveButton=new JButton("删除到达单");
	private JButton deleteSendButton=new JButton("删除派件单");
	private JButton addButton=new JButton();
	private JButton addSendButton=new JButton("添加派件单");
	private JButton sendButton=new JButton("提交派件单");
	private JButton sendArriveButton=new JButton("提交到达单");
	private JButton sureButton=new JButton("确定");
	private JButton sureSendButton=new JButton("确定");
	
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private BusinessArriveVO businessArriveVO;
	private SendVO sendVO;
	
	private ArrayList<BusinessArriveVO> allbusinessArriveVO=new ArrayList<BusinessArriveVO>();
	private ArrayList<SendVO> allSendVO=new ArrayList<SendVO>();
	
	DefaultTableModel defaultTableModel ;
	DefaultTableModel defaultTableModel2 ;
	 JTable receiveTable;
	 JTable sendTable;
	 JDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public ReceiveAndSendUI(){
		ImageIcon add=new ImageIcon("photo/add.gif");
		addButton.setBounds(550, 420, 110, 38);
		addButton.setIcon(add);
		addSendButton.setBounds(430, 420, 110, 38);
		addSendButton.setIcon(null);
		sendButton.setBounds(310, 420, 110, 38);
		sendButton.setIcon(null);
		sendArriveButton.setBounds(190, 420, 110, 38);
		sendArriveButton.setIcon(null);
		deleteReceiveButton.setBounds(100, 420, 80, 38);
		deleteReceiveButton.setIcon(null);
		deleteSendButton.setBounds(10, 420, 80, 38);
		deleteSendButton.setIcon(null);
		Object[][] playerInfo =
			  {
			 
			  };

			  //字段名称
			  String[] Names = { "ID","到达日期", "中转单编号", "出发地", "货物到达状态", "备注"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  receiveTable = new JTable( defaultTableModel);       //字段名称
			  Dimension size = receiveTable.getTableHeader().getPreferredSize();
		
			  size.height = 30;//设置新的表头高度40
			  receiveTable.getTableHeader().setPreferredSize(size);
			  receiveTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //绑定滚动条
			  JScrollPane scrollPane = new JScrollPane(receiveTable);
			  receiveTable.setRowHeight(25);
			  scrollPane.setBounds(0, 0, 690, 210);
			  this.add(scrollPane);
			  
			  //设置派件单
			  Object[][] playerInfo2 =
				  {
				 
				  };

				  //字段名称
				  String[] Names2 = {"ID", "到达日期", "托运订单号", "派送员",  "备注"};

				  
				  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				  defaultTableModel2 = new DefaultTableModel( playerInfo2,Names2); 
				  sendTable = new JTable( defaultTableModel2);       //字段名称
				  Dimension size2 = sendTable.getTableHeader().getPreferredSize();
			
				  size2.height = 30;//设置新的表头高度40
				  sendTable.getTableHeader().setPreferredSize(size2);
				  sendTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//				                60));
				  
				  //绑定滚动条
				  JScrollPane scrollPane2 = new JScrollPane(sendTable);
				  sendTable.setRowHeight(25);
				  scrollPane2.setBounds(0, 210, 690, 210);
				  this.add(scrollPane2);
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						businessArriveVO=(BusinessArriveVO) orderServiceImpl.getOrder(2);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //货物到达状态
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(0, 200, 100, 40);
			            //到达日期
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(null);
			            business.setBounds(0, 50, 100, 40);
			            //出发地
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(0, 150, 100, 40);
			            //中转单编号
			            cartextArea.setBounds(100, 105, 150, 30);
			            car.setIcon(null);
			            car.setBounds(0, 100, 100, 40);
			           
			           
			            //备注
			            orderNumbertextArea.setBounds(100, 255, 150, 30);
			            orderNumber.setIcon(null);
			            orderNumber.setBounds(0, 250, 100, 40);
			            
			      
			            dlg.add(orderNumber);
			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(carNumbertextArea);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(business);
			            dlg.add(businesstextArea);
			            dlg.add(sureButton);
			            sureButton.setBounds(100, 450, 60, 40);
			            sureButton.addActionListener(listener);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					});
			  addSendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						sendVO=(SendVO) orderServiceImpl.getOrder(6);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //到达日期
			            datetextArea.setBounds(100, 55, 150, 30);
			            date.setIcon(null);
			            date.setBounds(0, 50, 100, 40);
			            //托运订单号
			            numbertextArea.setBounds(100, 155, 150, 30);
			            number.setIcon(null);
			            number.setBounds(0, 150, 100, 40);
			            //派送员
			           sendertextArea.setBounds(100, 105, 150, 30);
			            sender.setIcon(null);
			            sender.setBounds(0, 100, 100, 40);
			           
			           
			            //备注
			           othertextArea.setBounds(100, 255, 150, 30);
			            other.setIcon(null);
			            other.setBounds(0, 250, 100, 40);
			            
			      
			            dlg.add(other);
			            dlg.add(othertextArea);
			            dlg.add(sender);
			            dlg.add(sendertextArea);
			            dlg.add(number);
			            dlg.add(numbertextArea);
			            dlg.add(date);
			            dlg.add(datetextArea);
			            dlg.add(sureSendButton);
			            sureSendButton.setBounds(100, 450, 60, 40);
			            sureSendButton.addActionListener(listenerSend);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					});
			  sendArriveButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						for(BusinessArriveVO businessArriveVOtemp:allbusinessArriveVO){
							String result=orderServiceImpl.endSales(businessArriveVOtemp, 2);
							 System.out.println(result);
						}
						allbusinessArriveVO.clear();
						defaultTableModel.setRowCount(0);
					}
			  });
			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						for(SendVO sendVOtemp:allSendVO){
							String result=orderServiceImpl.endSales(sendVOtemp, 6);
							 System.out.println(result);
						}
						allSendVO.clear();
						defaultTableModel2.setRowCount(0);
					}
			  });
			  deleteSendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) sendTable.getValueAt(sendTable.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"deliveryform");
					
						allSendVO.remove(sendTable.getSelectedRow());
						defaultTableModel2.removeRow(sendTable.getSelectedRow());
					}
			  });
			  deleteReceiveButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) receiveTable.getValueAt(receiveTable.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"hollreciform");
						
						allbusinessArriveVO.remove(receiveTable.getSelectedRow());
						defaultTableModel.removeRow(receiveTable.getSelectedRow());
					}
			  });
			  this.add(deleteReceiveButton);
			  this.add(deleteSendButton);
			  this.add(addButton);
			  this.add(addSendButton);
			  this.add(sendArriveButton);
			  this.add(sendButton);
			  this.setLayout(null);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			businessArriveVO.setData(businesstextArea.getText());
			businessArriveVO.setNumber(cartextArea.getText());
			businessArriveVO.setSend(arrivetextArea.getText());
			businessArriveVO.setOrderState(carNumbertextArea.getText());
			allbusinessArriveVO.add(businessArriveVO);
//			String result=orderServiceImpl.endSales(businessArriveVO, 2);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(6);
			row.add(businessArriveVO.getId());
			row.add(businesstextArea.getText());
			row.add(cartextArea.getText());
			row.add(arrivetextArea.getText());
			row.add(carNumbertextArea.getText());
			row.add(orderNumbertextArea.getText());
		
			businesstextArea.setText("");
			cartextArea.setText("");
			arrivetextArea.setText("");
			carNumbertextArea.setText("");
			orderNumbertextArea.setText("");
			defaultTableModel.addRow(row);
			receiveTable.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
		}
		
	};
	
	ActionListener listenerSend = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			sendVO.setData(datetextArea.getText());
			sendVO.setOrderNumber(numbertextArea.getText());
			sendVO.setSenderName(sendertextArea.getText());
			allSendVO.add(sendVO);
//			String result=orderServiceImpl.endSales(sendVO, 6);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(5);
			row.add(sendVO.getId());
			row.add(datetextArea.getText());
			row.add(numbertextArea.getText());
			row.add(sendertextArea.getText());
			row.add(othertextArea.getText());
		
			datetextArea.setText("");
			numbertextArea.setText("");
			sendertextArea.setText("");
			othertextArea.setText("");
			defaultTableModel2.addRow(row);
			sendTable.revalidate();
		    dlg.dispose();
		    sureSendButton.removeActionListener(listenerSend);
		}
		
	};
}
