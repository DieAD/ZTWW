package nju.ztww.ui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.GetDate;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.ReceiveVO;
import nju.ztww.vo.SendVO;

public class RecieiveMoneyUI extends JPanel{
	
	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel("收款日期");
	private MyTextField cartextArea=new MyTextField("");
	private  MyLabel car=new  MyLabel("收款金额");
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel("收款快递员");
	private MyTextField carNumbertextArea=new MyTextField("");
	private  MyLabel carNumber=new  MyLabel("订单号");
	private MyTextField orderNumbertextArea=new MyTextField("");
	private  MyLabel orderNumber=new  MyLabel("备注");
	private MyTextField findtextArea=new MyTextField("");
	private MyLabel mylabel=new MyLabel();
	private MyButton findButton=new MyButton('d');
	private MyButton findSureButton=new MyButton();
	private MyButton deleteButton=new MyButton('c');
	private MyButton addButton=new MyButton('b');
	private MyButton addSendButton=new MyButton('a');
	private MyButton sureButton=new MyButton();
	
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private ReceiveVO receiveVO;
	
	private ArrayList<String> allOrderNumber=new ArrayList<String>();
	private ArrayList<ReceiveVO> allreceiveVO=new ArrayList<ReceiveVO>();
	
	DefaultTableModel defaultTableModel ;
	 MyTable table;
	 MyDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public RecieiveMoneyUI(){
		this.setBackground(new Color(250, 240, 230));
//		ImageIcon add=new ImageIcon("photo/add.gif");
//		addButton.setBounds(500, 420, 110, 38);
//		addButton.setIcon(add);
//		deleteButton.setBounds(220, 420, 110, 38);
//		deleteButton.setIcon(null);
//		addSendButton.setBounds(360, 420, 110, 38);
//		addSendButton.setIcon(null);
//		findButton.setBounds(90, 420, 110, 38);
//		findButton.setIcon(null);
		Object[][] playerInfo =
			  {
			  
			  };

			  //字段名称
			  String[] Names = {"ID", "收款日期", "收款金额", "收款快递员", "订单号", "备注" };

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new MyTable(defaultTableModel);
			  MyScrollPane scrollPane = new MyScrollPane(table);
//			  table = new JTable( defaultTableModel);       //字段名称
//			  Dimension size = table.getTableHeader().getPreferredSize();
//		
//			  size.height = 30;//设置新的表头高度40
//			  table.getTableHeader().setPreferredSize(size);
//			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
////			                60));
//			  
//			  //绑定滚动条
//			  JScrollPane scrollPane = new JScrollPane(table);
//		      table.setRowHeight(25);
//			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						receiveVO=(ReceiveVO) orderServiceImpl.getOrder(5);
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(400, 450));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //订单号
			            carNumbertextArea.setBounds(150, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(50, 200, 100, 40);
			            //收款日期
			            businesstextArea.setBounds(150, 55, 150, 30);
			            businesstextArea.setText(GetDate.getDate());
			            business.setIcon(null);
			            business.setBounds(50, 50, 100, 40);
			            //收款快递员
			            arrivetextArea.setBounds(150, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(50, 150, 100, 40);
			            //收款金额
			            cartextArea.setBounds(150, 105, 150, 30);
			            car.setIcon(null);
			            car.setBounds(50, 100, 100, 40);
			           
			           
			            //备注
			            orderNumbertextArea.setBounds(150, 255, 150, 30);
			            orderNumber.setIcon(null);
			            orderNumber.setBounds(50, 250, 100, 40);
			            
			      
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
			            sureButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
			            sureButton.setBounds(230, 315, 70, 30);
			            sureButton.addActionListener(listener);
			            mylabel.setText("信息未填完！");
			            mylabel.setBounds(230, 345, 100, 40);
			            mylabel.setVisible(false);
			            dlg.add(mylabel);
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
					});
			  addSendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						for(ReceiveVO receiveVOtemp:allreceiveVO){
							String result=orderServiceImpl.endSales(receiveVOtemp, 5);
							 System.out.println(result);
						}
						allreceiveVO.clear();
						defaultTableModel.setRowCount(0);
					}
					}
			  });
			  deleteButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) table.getValueAt(table.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"payeeform");
						if(table.getSelectedRow()>=0&&allreceiveVO.size()!=0){
							allreceiveVO.remove(table.getSelectedRow());
						}
	
						defaultTableModel.removeRow(table.getSelectedRow());
					}
			  });
			  findButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 150));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            findtextArea.setBounds(50, 30, 150, 30);
			            findSureButton.setBounds(240, 30, 70, 30);
			            findSureButton.addActionListener(listener2);
			            findSureButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
			            dlg.add(findSureButton);
			            dlg.add(findtextArea);
			            dlg.setLayout(null);
						dlg.setVisible(true);
						}
					}
			  });
			  this.add(findButton);
			  this.add(deleteButton);
			  this.add(addButton);
			  this.add(addSendButton);
			  this.setLayout(null);
	}

//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background2.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ArrayList<String>stringlist =new ArrayList<String>();
			stringlist.add(businesstextArea.getText());
			stringlist.add(carNumbertextArea.getText());
			stringlist.add(cartextArea.getText());
			stringlist.add(arrivetextArea.getText());
			stringlist.add(orderNumbertextArea.getText());
			IsEmpty is=new IsEmpty();
			boolean isempty=is.isempty(stringlist);
			if(!isempty){
			receiveVO.setData(businesstextArea.getText());
			receiveVO.setOrderNumber(carNumbertextArea.getText());
			double money=Double.parseDouble(cartextArea.getText());
			receiveVO.setReceiveMoney(money);
			receiveVO.setReceiverName(arrivetextArea.getText());
			receiveVO.setHoll(UserInfoUI.getUserID().substring(5, 8));
			allreceiveVO.add(receiveVO);
//			 String result=orderServiceImpl.endSales(receiveVO, 5);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(6);
			row.add(receiveVO.getId());
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
		    table.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
			}
			else{
				mylabel.setVisible(true);
			}
		}
		
	};
	ActionListener listener2 = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ReceiveVO receiveVO=(ReceiveVO) orderServiceImpl.find(findtextArea.getText(), 5);
			Vector<String> row = new Vector(6);
			row.add(receiveVO.getId());
			row.add(receiveVO.getData());
			row.add(Double.toString(receiveVO.getReceiveMoney()));
			row.add(receiveVO.getReceiverName());
			row.add(receiveVO.getOrderNumber());
			row.add("");
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
	};
}
