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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.order.MyButton;
import nju.ztww.ui.order.MyScrollPane;
import nju.ztww.ui.order.MyTable;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.DriverMessageVO;
import nju.ztww.vo.LoadingVO;

/**
 * 司机信息管理ui
 * @author TQ
 *
 */
public class DriverManageUI extends JPanel{

	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel("司机编号");
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel("姓名");
	private JTextField driverSex=new JTextField("");
	private  JLabel driver=new  JLabel("性别");
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel("出生日期");
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel("身份证号");
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel("手机");
	private JTextField deadlinetextArea=new JTextField("");
	private  JLabel deadline=new  JLabel("行驶证期限");
	private JTextField findtextArea=new JTextField("");
	
	private ArrayList<DriverMessageVO> allDriverMessageVO=new ArrayList<DriverMessageVO>();
	
	private MyButton findButton=new MyButton('d');
	private JButton findSureButton=new JButton("确定");
	private MyButton deleteButton=new MyButton('c');
	private MyButton addButton=new MyButton('b');
	private JButton sureButton=new JButton("确定");
	private MyButton sendButton=new MyButton('a');
	
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private DriverMessageVO driverMessageVO;
	
	DefaultTableModel defaultTableModel ;
	 MyTable table;
	 JDialog dlg;
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
						driverMessageVO=(DriverMessageVO) orderServiceImpl.getOrder(10);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //身份证号
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(0, 200, 100, 40);
			            //司机编号
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(null);
			            business.setBounds(0, 50, 100, 40);
			            //出生日期
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(0, 150, 100, 40);
			            //姓名
			            cartextArea.setBounds(100, 105, 150, 30);
			            car.setIcon(null);
			            car.setBounds(0, 100, 100, 40);
			            //手机
			            orderNumbertextArea.setBounds(100, 255, 150, 30);
			            orderNumber.setIcon(null);
			            orderNumber.setBounds(0, 250, 100, 40);
			            //行驶证期限
			            deadlinetextArea.setBounds(100, 305, 150, 30);
			            deadline.setIcon(null);
			            deadline.setBounds(0, 300, 100, 40);
			            //性别
			            driverSex.setBounds(100, 355, 150, 30);
			            driver.setIcon(null);
			            driver.setBounds(0, 350, 100, 40);
			      
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
			            sureButton.setBounds(100, 450, 60, 40);
			            sureButton.addActionListener(listener);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
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
						for(DriverMessageVO DriverMessageVOTemp : allDriverMessageVO){
							String result=orderServiceImpl.endSales(DriverMessageVOTemp, 10);
							 System.out.println(result);
						}
						allDriverMessageVO.clear();
						defaultTableModel.setRowCount(0);
					}
			  });
			  findButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 150));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            findtextArea.setBounds(50, 30, 150, 30);
			            findSureButton.setBounds(100, 80, 70, 40);
			            findSureButton.addActionListener(listener2);
			            dlg.add(findSureButton);
			            dlg.add(findtextArea);
			            dlg.setLayout(null);
						dlg.setVisible(true);
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
