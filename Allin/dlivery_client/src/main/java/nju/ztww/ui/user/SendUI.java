package nju.ztww.ui.user;

import java.awt.Color;
import java.awt.Dimension;
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
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.SendVO;

public class SendUI extends JPanel{
	
	private MyTextField datetextArea=new MyTextField("");
	private  MyLabel date=new  MyLabel("到达日期");
	private MyTextField numbertextArea=new MyTextField("");
	private  MyLabel number=new  MyLabel("托运订单号");
	private MyTextField sendertextArea=new MyTextField("");
	private  MyLabel sender=new  MyLabel("派送员");
	private MyTextField othertextArea=new MyTextField("");
	private  MyLabel other=new  MyLabel("备注");
	private MyTextField findSendtextArea=new MyTextField("");
	private MyLabel mylabel=new MyLabel();
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private SendVO sendVO;
	private ArrayList<SendVO> allSendVO=new ArrayList<SendVO>();
	
	 MyDialog dlg;
	
	 DefaultTableModel defaultTableModel2 ;
	 MyTable sendTable;
     private MyButton findSendButton=new MyButton('d');
     private MyButton deleteSendButton=new MyButton('c');
	 private MyButton sendButton=new MyButton('a');
	 private MyButton addSendButton=new MyButton('b');
	 private MyButton sureSendButton=new MyButton();
	 private MyButton findSendSureButton=new MyButton();
	 
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	 
	 public SendUI(){
		    //设置派件单
		    Object[][] playerInfo2 =
			  {
			 
			  };

			//字段名称
			String[] Names2 = {"ID", "到达日期", "托运订单号", "派送员",  "备注"};

			  
			//创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			defaultTableModel2 = new DefaultTableModel( playerInfo2,Names2); 
			sendTable = new MyTable( defaultTableModel2);       //字段名称
			MyScrollPane scrollPane = new MyScrollPane(sendTable);
		    this.add(scrollPane);
		    this.setLayout(null);
			this.add(findSendButton);
		   	this.add(addSendButton);
			this.add(sendButton);
			this.add(deleteSendButton);
			this.setBackground(new Color(250, 240, 230));
			addSendButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(TestIfConnect.ifConnect()){
					sendVO=(SendVO) orderServiceImpl.getOrder(6);
					dlg= new MyDialog(); 
					dlg.setSize(new Dimension(400, 380));
		            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            //到达日期
		            datetextArea.setBounds(150, 55, 150, 30);
		            datetextArea.setText(GetDate.getDate());
		            
		            date.setIcon(null);
		            date.setBounds(50, 50, 100, 40);
		            //托运订单号
		            numbertextArea.setBounds(150, 155, 150, 30);
		            number.setIcon(null);
		            number.setBounds(50, 150, 100, 40);
		            //派送员
		           sendertextArea.setBounds(150, 105, 150, 30);
		            sender.setIcon(null);
		            sender.setBounds(50, 100, 100, 40);
		           
		           
		            //备注
		           othertextArea.setBounds(150, 205, 150, 30);
		            other.setIcon(null);
		            other.setBounds(50, 200, 100, 40);
		            
		      
		            dlg.add(other);
		            dlg.add(othertextArea);
		            dlg.add(sender);
		            dlg.add(sendertextArea);
		            dlg.add(number);
		            dlg.add(numbertextArea);
		            dlg.add(date);
		            dlg.add(datetextArea);
		            dlg.add(sureSendButton);
		            sureSendButton.setBounds(230, 265, 80, 30);
		            sureSendButton.setIcon(new ImageIcon("photo/Sure.png"));
		            sureSendButton.addActionListener(listenerSend);
		            mylabel.setText("信息未填全！");
		            mylabel.setBounds(230, 295, 100, 40);
		            mylabel.setVisible(false);
		            dlg.add(mylabel);
		            dlg.setLayout(null);
					dlg.setVisible(true);
					}
				}
				});
			sendButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(TestIfConnect.ifConnect()){
					for(SendVO sendVOtemp:allSendVO){
						String result=orderServiceImpl.endSales(sendVOtemp, 6);
						 System.out.println(result);
					}
					allSendVO.clear();
					defaultTableModel2.setRowCount(0);
					}
				}
		  });
		  deleteSendButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
//					String id=(String) sendTable.getValueAt(sendTable.getSelectedRow(), 0);
//					String result=orderServiceImpl.deleteOrder(id,"deliveryform");
					if(sendTable.getSelectedRow()>=0&&allSendVO.size()!=0){
						allSendVO.remove(sendTable.getSelectedRow());
					}
					defaultTableModel2.removeRow(sendTable.getSelectedRow());
				}
		  });
		  findSendButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(TestIfConnect.ifConnect()){
					dlg= new MyDialog(); 
					dlg.setSize(new Dimension(350, 150));
		            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		            findSendtextArea.setBounds(50, 30, 150, 30);
		            findSendSureButton.setBounds(250, 30, 80, 30);
		            findSendSureButton.addActionListener(listener2);
		            findSendSureButton.setIcon(new ImageIcon("photo/Sure.png"));
		            dlg.add(findSendSureButton);
		            dlg.add(findSendtextArea);
		            dlg.setLayout(null);
					dlg.setVisible(true);
					}
				}
		  });
	}
	 
	 ActionListener listener2 = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				SendVO sendVO=(SendVO) orderServiceImpl.find(findSendtextArea.getText(), 6);
				Vector<String> row = new Vector(5);
				row.add(sendVO.getId());
				row.add(sendVO.getData());
				row.add(sendVO.getOrderNumber());
				row.add(sendVO.getSenderName());
				row.add("");
				defaultTableModel2.addRow(row);
				sendTable.revalidate();
			    findSendtextArea.setText("");
			    dlg.dispose();
			    findSendSureButton.removeActionListener(listener2);
			}
		};
		ActionListener listenerSend = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<String>stringlist=new ArrayList<String>();
				stringlist.add(datetextArea.getText());
				stringlist.add(numbertextArea.getText());
				stringlist.add(sendertextArea.getText());
				stringlist.add(othertextArea.getText());
				IsEmpty is=new IsEmpty();
				boolean isempty=false;
				isempty=is.isempty(stringlist);
				if(!isempty){
				sendVO.setData(datetextArea.getText());
				sendVO.setOrderNumber(numbertextArea.getText());
				sendVO.setSenderName(sendertextArea.getText());
				allSendVO.add(sendVO);
//				String result=orderServiceImpl.endSales(sendVO, 6);
//				 System.out.println(result);
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
				else{
					mylabel.setVisible(true);
				}
			}
		};

}
