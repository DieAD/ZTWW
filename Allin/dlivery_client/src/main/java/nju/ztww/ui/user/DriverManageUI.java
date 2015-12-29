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
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;

/**
 * 司机信息管理ui
 * @author TQ
 *
 */
public class DriverManageUI extends JPanel{

	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel("司机编号");
	private MyTextField cartextArea=new MyTextField("");
	private  MyLabel car=new  MyLabel("姓名");
	private MyTextField driverSex=new MyTextField("");
	private  MyLabel driver=new  MyLabel("性别");
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel("出生日期");
	private MyTextField carNumbertextArea=new MyTextField("");
	private  MyLabel carNumber=new  MyLabel("身份证号");
	private MyTextField orderNumbertextArea=new MyTextField("");
	private  MyLabel orderNumber=new  MyLabel("手机");
	private MyTextField deadlinetextArea=new MyTextField("");
	private  MyLabel deadline=new  MyLabel("行驶证期限");
	private MyTextField findtextArea=new MyTextField("");
	
	private ArrayList<DriverMessageVO> allDriverMessageVO=new ArrayList<DriverMessageVO>();
	
	private MyButton findButton=new MyButton('d');
	private MyButton findSureButton=new MyButton();
	private MyButton deleteButton=new MyButton('c');
	private MyButton addButton=new MyButton('b');
	private MyButton sureButton=new MyButton();
	private MyButton sendButton=new MyButton('a');
	private MyLabel mylabel=new MyLabel();
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private DriverMessageVO driverMessageVO;
	
	DefaultTableModel defaultTableModel ;
	 MyTable table;
	 MyDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public DriverManageUI(){
		this.setBackground(new Color(250, 240, 230));
//		ImageIcon add=new ImageIcon("photo/add.gif");
//		addButton.setBounds(500, 420, 110, 38);
//		addButton.setIcon(add);
//		deleteButton.setBounds(220, 420, 110, 38);
//		deleteButton.setIcon(null);
//		sendButton.setBounds(360, 420, 110, 38);
//		sendButton.setIcon(null);
//		findButton.setBounds(90, 420, 110, 38);
//		findButton.setIcon(null);
		Object[][] playerInfo =
			  {
			  
			  };

			  //字段名称
			  String[] Names = { "ID","司机编号", "姓名", "出生日期", "身份证号", "手机 " ,"行驶证期限"};

			  
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
						driverMessageVO=(DriverMessageVO) orderServiceImpl.getOrder(10);
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(400, 500));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //身份证号
			            
			            carNumbertextArea.setBounds(150, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(50, 200, 100, 40);
			            //司机编号
			            businesstextArea.setBounds(150, 55, 150, 30);
			            business.setIcon(null);
			            business.setBounds(50, 50, 100, 40);
			            //出生日期
			            arrivetextArea.setBounds(150, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(50, 150, 100, 40);
			            //姓名
			            cartextArea.setBounds(150, 105, 150, 30);
			            car.setIcon(null);
			            car.setBounds(50, 100, 100, 40);
			            //手机
			            orderNumbertextArea.setBounds(150, 255, 150, 30);
			            orderNumber.setIcon(null);
			            orderNumber.setBounds(50, 250, 100, 40);
			            //行驶证期限
			            deadlinetextArea.setBounds(150, 305, 150, 30);
			            deadline.setIcon(null);
			            deadline.setBounds(50, 300, 100, 40);
			            //性别
			            driverSex.setBounds(150, 355, 150, 30);
			            driver.setIcon(null);
			            driver.setBounds(50, 350, 100, 40);
			      
			            dlg.add(driver);
			            dlg.add(driverSex);
			            dlg.add(deadline);
			            dlg.add(deadlinetextArea);
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
			            sureButton.setBounds(230, 400, 70, 30);
			            sureButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
			            sureButton.addActionListener(listener);
			            mylabel.setText("信息未填全！");
			            mylabel.setBounds(230, 430, 100, 40);
			            dlg.add(mylabel);
			            mylabel.setVisible(false);
			            dlg.setLayout(null);
						dlg.setVisible(true);
						}
					}
					});
			  deleteButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) table.getValueAt(table.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"drivermessage");
						if(table.getSelectedRow()>=0&&allDriverMessageVO.size()!=0){
							allDriverMessageVO.remove(table.getSelectedRow());
						}
					
						defaultTableModel.removeRow(table.getSelectedRow());
					}
			  });
			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						for(DriverMessageVO DriverMessageVOTemp : allDriverMessageVO){
							String result=orderServiceImpl.endSales(DriverMessageVOTemp, 10);
							 System.out.println(result);
						}
						allDriverMessageVO.clear();
						defaultTableModel.setRowCount(0);
					}
					}
			  });
			  findButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 150));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            findtextArea.setBounds(50, 30, 150, 30);
			            findSureButton.setBounds(250, 30, 70, 30);
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
			  this.add(sendButton);
			  this.add(deleteButton);
			  this.add(addButton);
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
			ArrayList<String>stringlist=new ArrayList<String>();
			stringlist.add(arrivetextArea.getText());
			stringlist.add(carNumbertextArea.getText());
			stringlist.add(cartextArea.getText());
			stringlist.add(businesstextArea.getText());
			stringlist.add(deadlinetextArea.getText());
			stringlist.add(driverSex.getText());
			stringlist.add(orderNumbertextArea.getText());
			IsEmpty is=new IsEmpty();
			boolean isempty=is.isempty(stringlist);
			if(!isempty){
			driverMessageVO.setDriverBirthday(arrivetextArea.getText());
			driverMessageVO.setDriverId(carNumbertextArea.getText());
			driverMessageVO.setDriverName(cartextArea.getText());
			driverMessageVO.setDriverNumber(businesstextArea.getText());
			driverMessageVO.setDriverServiceDeadline(deadlinetextArea.getText());
			driverMessageVO.setDriverSex(driverSex.getText());
			driverMessageVO.setDriverTelephone(orderNumbertextArea.getText());
			allDriverMessageVO.add(driverMessageVO);
//			 String result=orderServiceImpl.endSales(driverMessageVO, 10);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(7);
			row.add(driverMessageVO.getId());
			row.add(businesstextArea.getText());
			row.add(cartextArea.getText());
			row.add(arrivetextArea.getText());
			row.add(carNumbertextArea.getText());
			row.add(orderNumbertextArea.getText());
			row.add(deadlinetextArea.getText());
			businesstextArea.setText("");
			cartextArea.setText("");
			arrivetextArea.setText("");
			carNumbertextArea.setText("");
			orderNumbertextArea.setText("");
			deadlinetextArea.setText("");
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
			DriverMessageVO driverMessageVO=(DriverMessageVO) orderServiceImpl.find(findtextArea.getText(), 10);
			Vector<String> row = new Vector(7);
			row.add(driverMessageVO.getId());
			row.add(driverMessageVO.getDriverNumber());
			row.add(driverMessageVO.getDriverName());
			row.add(driverMessageVO.getDriverBirthday());
			row.add(driverMessageVO.getDriverId());
			row.add(driverMessageVO.getDriverTelephone());
			row.add(driverMessageVO.getDriverServiceDeadline());
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
	};
}
