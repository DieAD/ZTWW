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
import javax.swing.table.TableColumn;

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
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.SendVO;
import nju.ztww.vo.ShippingVO;

/**
 * 接受与派件
 * @author TQ
 *
 */
public class ReceiveAndSendUI extends JPanel{
	
	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel("到达日期");
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel("出发地");
	private MyTextField orderNumbertextArea=new MyTextField("");
	private  MyLabel orderNumber=new  MyLabel("备注");
	private MyTextField findTransfertextArea=new MyTextField("请输入中转单号");
	private MyTextField findArrivetextArea=new MyTextField("");
	private MyLabel mylabel=new MyLabel();
	private MyButton sureButton=new MyButton();
	private MyButton findArriveSureButton=new MyButton();
	private MyButton sureTransferButton=new MyButton();
	
	 private MyButton findArriveButton=new MyButton('d');
     private MyButton deleteReceiveButton=new MyButton('c');
	 private MyButton sendArriveButton=new MyButton('a');
	 private MyButton addButton=new MyButton('b');
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private BusinessArriveVO businessArriveVO;
	
	private ArrayList<BusinessArriveVO> allbusinessArriveVO=new ArrayList<BusinessArriveVO>();
	
	DefaultTableModel defaultTableModel ;
	DefaultTableModel SmalldefaultTableModel;
	MyTable receiveTable;
	MyTable SmallreceiveTable;

	 MyDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	int width=130;
	int hight=25;
	int number=0;
	    public ReceiveAndSendUI(){
		      this.setBackground(new Color(250, 240, 230));
	
		      Object[][] playerInfo = { };

			  //字段名称
			  String[] Names = { "ID","到达日期", "快递单号","出发地", "货物到达状态", "备注"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  receiveTable = new MyTable( defaultTableModel);       //字段名称
			  MyScrollPane scrollPane = new MyScrollPane(receiveTable);
			  this.add(scrollPane);
			  
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						businessArriveVO=(BusinessArriveVO) orderServiceImpl.getOrder(2);
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(520, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            
			            Object[][] p = { };

						 //字段名称
						 String[] n = { "快递单号","完整", "丢失", "损坏"};

						  
						 //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
						 SmalldefaultTableModel = new DefaultTableModel( p,n){
							  public Class getColumnClass(int column) {
						            for (int row = 0; row < getRowCount(); row++)  {
						                Object o = getValueAt(row, column);
						                if(column!=0){
						                	return Boolean.class;
						                }
						                if (o != null)
						                {
						                    return o.getClass();
						                }
						            }

						            return Object.class;
						        }
							
						  };
						 SmallreceiveTable = new MyTable( SmalldefaultTableModel);       //字段名称
						 MyScrollPane SmallscrollPane = new MyScrollPane(SmallreceiveTable);
						 TableColumn  column = SmallreceiveTable.getColumnModel().getColumn(0);
						 column.setPreferredWidth(150);
						 SmallscrollPane.setBounds(85, 100, 330, 200);
						 
						 findTransfertextArea.setBounds(100, 40, width, hight);
						 sureTransferButton.setBounds(280,40 , 80, 30);
						 sureTransferButton.addActionListener(findTransfer);
						 sureTransferButton.setIcon(new ImageIcon("photo/Sure.png"));
			            //到达日期
			            businesstextArea.setBounds(120, 355, width, hight);
			            businesstextArea.setText(GetDate.getDate());
			            business.setIcon(null);
			            business.setBounds(50, 350, 100, 40);
			            //出发地
			            arrivetextArea.setBounds(120, 405, width, hight);
			            arrive.setIcon(null);
			            arrive.setBounds(50, 400, 100, 40);
			           
			           
			            //备注
			            orderNumbertextArea.setBounds(320, 355, width, hight);
			            orderNumber.setIcon(null);
			            orderNumber.setBounds(270, 350, 100, 40);
			            
			            dlg.add(findTransfertextArea);
			            dlg.add(sureTransferButton);
			            dlg.add(SmallscrollPane);
			            dlg.add(orderNumber);
			            dlg.add(orderNumbertextArea);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(business);
			            dlg.add(businesstextArea);
			            dlg.add(sureButton);
			            sureButton.setBounds(336, 432, 80, 30);
			            sureButton.setIcon(new ImageIcon("photo/Sure.png"));
			            sureButton.addActionListener(listener);
			            mylabel.setText("信息未填全！");
			            mylabel.setBounds(336, 462,100, 40);
			            mylabel.setVisible(false);
			            dlg.add(mylabel);
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
					});
			 
			  sendArriveButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						for(BusinessArriveVO businessArriveVOtemp:allbusinessArriveVO){
							String result=orderServiceImpl.endSales(businessArriveVOtemp, 2);
							 System.out.println(result);
						}
						allbusinessArriveVO.clear();
						defaultTableModel.setRowCount(0);
					}
					}
			  });
			 
			  deleteReceiveButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) receiveTable.getValueAt(receiveTable.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"hollreciform");
						if(receiveTable.getSelectedRow()>=0&&allbusinessArriveVO.size()!=0){
							allbusinessArriveVO.remove(receiveTable.getSelectedRow());
						}
						defaultTableModel.removeRow(receiveTable.getSelectedRow());
					}
			  });
			 
			  findArriveButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 150));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            findArrivetextArea.setBounds(50, 30, 150, 30);
			            findArriveSureButton.setBounds(240, 30, 80, 30);
			            findArriveSureButton.addActionListener(listener3);
			            findArriveSureButton.setIcon(new ImageIcon("photo/Sure.png"));
			            dlg.add(findArriveSureButton);
			            dlg.add(findArrivetextArea);
			            dlg.setLayout(null);
						dlg.setVisible(true);
						}
					}
			  });
			  this.add(findArriveButton);
		
			  this.add(deleteReceiveButton);
		
			  this.add(addButton);
			
			  this.add(sendArriveButton);
		
			  this.setLayout(null);
	}

	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ArrayList<String>stringlist=new ArrayList<String>();
			stringlist.add(businesstextArea.getText());
			stringlist.add(arrivetextArea.getText());
			stringlist.add(orderNumbertextArea.getText());
			stringlist.add(findTransfertextArea.getText());
			IsEmpty is=new IsEmpty();
			boolean isempty=false;
			isempty=is.isempty(stringlist);
			if(!isempty){
			for(int i=0;i<number;i++){
				businessArriveVO.setData(businesstextArea.getText());
				businessArriveVO.setNumber((String)SmallreceiveTable.getValueAt(i, 0));
				businessArriveVO.setSend(arrivetextArea.getText());
//				businessArriveVO.setOrderState(carNumbertextArea.getText());
				if(SmallreceiveTable.getValueAt(i,1)!=null&&(Boolean)SmallreceiveTable.getValueAt(i,1) ){
					businessArriveVO.setOrderState("完整");
				}
				if(SmallreceiveTable.getValueAt(i,2)!=null&&(Boolean) SmallreceiveTable.getValueAt(i,2)){
					businessArriveVO.setOrderState("缺损");
				}
				if(SmallreceiveTable.getValueAt(i,3)!=null&&(Boolean) SmallreceiveTable.getValueAt(i,3)){
					businessArriveVO.setOrderState("丢失");
				}
				allbusinessArriveVO.add(businessArriveVO);
				//增加行
				Vector<String> row = new Vector(6);
				row.add(businessArriveVO.getId());
				row.add(businesstextArea.getText());
				row.add(businessArriveVO.getNumber());
				row.add(arrivetextArea.getText());
				row.add(businessArriveVO.getOrderState());
				row.add(orderNumbertextArea.getText());
				defaultTableModel.addRow(row);
			}
			
		
			businesstextArea.setText("");
			arrivetextArea.setText("");
			orderNumbertextArea.setText("");
			findTransfertextArea.setText("请输入中转单号");
			
			receiveTable.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
		}
			else{
				mylabel.setVisible(true);
			}
		}
		
	};
	ActionListener findTransfer = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			ShippingVO loadingVO=(ShippingVO) orderServiceImpl.find(findTransfertextArea.getText(), 7);
			String OrderNumber=loadingVO.getOrderNumber();
			String [] temp=OrderNumber.split(";");
			number=temp.length;
			for(int i=0;i<temp.length;i++){
				Vector<String> row = new Vector(4);
				row.add(temp[i]);
				SmalldefaultTableModel.addRow(row);
			}
			sureTransferButton.removeActionListener(findTransfer);
		}
	};
	

	ActionListener listener3 = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			BusinessArriveVO businessArriveVO=(BusinessArriveVO) orderServiceImpl.find(findArrivetextArea.getText(), 2);
			Vector<String> row = new Vector(6);
			row.add(businessArriveVO.getId());
			row.add(businessArriveVO.getData());
			row.add(businessArriveVO.getNumber());
			row.add(businessArriveVO.getSend());
			row.add(businessArriveVO.getOrderState());
			row.add("");
			defaultTableModel.addRow(row);
			receiveTable.revalidate();
		    findArrivetextArea.setText("");
		    dlg.dispose();
		    findArriveSureButton.removeActionListener(listener3);
		}
	};
}
