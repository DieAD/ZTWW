package nju.ztww.ui.user;
/**
 * 田琦
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.order.MyButton;
import nju.ztww.ui.order.MyScrollPane;
import nju.ztww.ui.order.MyTable;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.LoadingVO;

public class CarLoadingUI extends JPanel{
	
	private JTextField datatextArea=new JTextField("");
	private  JLabel data=new  JLabel();
	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel();
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel();
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel();
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel();
	private JTextField jianzhuangtextArea=new JTextField("");
	private  JLabel jianzhuang=new  JLabel();
	private JTextField yayuntextArea=new JTextField("");
	private  JLabel yayun=new  JLabel();
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel();
	private JTextField departtextArea=new JTextField("");
	private  JLabel depart=new  JLabel("出发地");
	private JTextField findtextArea=new JTextField("");
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private LoadingVO loadingVO;
	
	private ArrayList<LoadingVO> allLoadingVO=new ArrayList<LoadingVO>();
	
	private ResultMessageUI resultMessageUI=new ResultMessageUI();
	
	private MyButton addButton=new MyButton('b');
	private JButton findSureButton=new JButton("确定");
	private MyButton findButton=new MyButton('d');
	private MyButton deleteButton=new MyButton('c');
	private MyButton sendButton=new MyButton('a');
	private JButton sureButton=new JButton("确定");
	DefaultTableModel defaultTableModel ;
	JDialog dlg;
	 MyTable table;
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public CarLoadingUI(){
		this.setBackground(new Color(250, 240, 230));
		
		final ImageIcon BusinessNumber=new ImageIcon("photo/businessNumberLabel.gif");
		final ImageIcon CarNumber=new ImageIcon("photo/carNumberLabel.gif");
		final ImageIcon Arrive=new ImageIcon("photo/arriveLabel.gif");
		final ImageIcon Car=new ImageIcon("photo/carLabel.gif");
		final ImageIcon Money=new ImageIcon("photo/moneyLabel.gif");
		final ImageIcon Jianzhuang=new ImageIcon("photo/jianzhuangLabel.gif");
		final ImageIcon Yayun=new ImageIcon("photo/yayunLabel.gif");
		final ImageIcon OrderNumber=new ImageIcon("photo/orderNumberLanel.gif");
		ImageIcon add=new ImageIcon("photo/add.gif");
		final ImageIcon dataLable=new ImageIcon("photo/dataLable.gif");


		this.setLayout(null);
		this.add(findButton);
		this.add(deleteButton);
		this.add(sendButton);
        this.add(addButton);
		Object[][] playerInfo =
			  {
			  
			  };

			  //字段名称
			  String[] Names = {"ID", "装车日期", "营业厅编号", "汽运编号", "到达地", "车辆代号" ,"运费"};

			  
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
//			  scrollPane.setBounds(0, 0, 750, 400);
			  this.add(scrollPane);
//			  
//			  //
//			  table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//				table.setBackground(new Color(208,168,125)); //226,203,170
//				scrollPane.getViewport().setOpaque(false);
//				scrollPane.setOpaque(false);
			  
			  
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						loadingVO=(LoadingVO) orderServiceImpl.getOrder(4);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //装车日期
			            datatextArea.setBounds(100, 5, 150, 30);
			            data.setIcon(dataLable);
			            data.setBounds(0, 0, 100, 40);
			            //营业厅编号
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(BusinessNumber);
			            business.setBounds(0, 50, 100, 40);
			            //汽运编号
			            cartextArea.setBounds(100, 105, 150, 30);
			            car.setIcon(Car);
			            car.setBounds(0, 100, 100, 40);
			            //到达地
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(Arrive);
			            arrive.setBounds(0, 150, 100, 40);
			            //车辆代号
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(CarNumber);
			            carNumber.setBounds(0, 200, 100, 40);
			            //订单号
			            orderNumbertextArea.setBounds(100, 255, 150, 30);
			            orderNumber.setIcon(OrderNumber);
			            orderNumber.setBounds(0, 250, 100, 40);
			            //监装员
			            jianzhuangtextArea.setBounds(100, 305, 150, 30);
			            jianzhuang.setIcon(Jianzhuang);
			            jianzhuang.setBounds(0, 300, 100, 40);
			            //押运员
			            yayuntextArea.setBounds(100, 355, 150, 30);
			            yayun.setIcon(Yayun);
			            yayun.setBounds(0, 350, 100, 40);
			    
			            //出发地
			            departtextArea.setBounds(100, 455, 150, 30);
			            depart.setIcon(null);
			            depart.setBounds(0, 450, 100, 40);
			            
			            dlg.add(depart);
			            dlg.add(departtextArea);

			            dlg.add(yayun);
			            dlg.add(yayuntextArea);
			            dlg.add(jianzhuang);
			            dlg.add(jianzhuangtextArea);
			            dlg.add(orderNumber);
			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(carNumbertextArea);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(data);
			            dlg.add(datatextArea);
			            dlg.add(business);
			            dlg.add(businesstextArea);
			            dlg.add(sureButton);
			            sureButton.setBounds(100, 450, 60, 40);
			            sureButton.addActionListener(listener);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					});
			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						for(LoadingVO loadingVOtemp : allLoadingVO){
							String result=orderServiceImpl.endSales(loadingVOtemp, 4);
							resultMessageUI.setPhoto(result);
							
						}
						resultMessageUI.setPhoto("success");
						allLoadingVO.clear();
						defaultTableModel.setRowCount(0);
					}
			  });
			  deleteButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) table.getValueAt(table.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"loadform");
						if(table.getSelectedRow()>=0&&allLoadingVO.size()!=0){
							allLoadingVO.remove(table.getSelectedRow());
						}
						defaultTableModel.removeRow(table.getSelectedRow());
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
			
			loadingVO.setData(datatextArea.getText());
			loadingVO.setArrive(arrivetextArea.getText());
			loadingVO.setCarNumber(carNumbertextArea.getText());
			loadingVO.setJianZhuangName(jianzhuangtextArea.getText());
			String [] temp=orderNumbertextArea.getText().split(";");
			double money=30*2*temp.length*0.01;
			loadingVO.setMoney(money);
			loadingVO.setOrderNumber(orderNumbertextArea.getText());
			loadingVO.setQiYunNumber(cartextArea.getText());
			loadingVO.setYaYunName(yayuntextArea.getText());
			loadingVO.setYingYeNumber(businesstextArea.getText());
			allLoadingVO.add(loadingVO);

			//增加行
			Vector<String> row = new Vector(7);
			row.add(loadingVO.getId());
			row.add(datatextArea.getText());
			row.add(businesstextArea.getText());
			row.add(cartextArea.getText());
			row.add(arrivetextArea.getText());
			row.add(carNumbertextArea.getText());
			row.add(Double.toString(loadingVO.getMoney()));
			datatextArea.setText("");
			businesstextArea.setText("");
			cartextArea.setText("");
			arrivetextArea.setText("");
			carNumbertextArea.setText("");
			defaultTableModel.addRow(row);
		    table.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
		}
		
	};
	
	ActionListener listener2 = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			LoadingVO loadingVO=(LoadingVO) orderServiceImpl.find(findtextArea.getText(), 4);
			Vector<String> row = new Vector(7);
			row.add(loadingVO.getId());
			row.add(loadingVO.getData());
			row.add(loadingVO.getYingYeNumber());
			row.add(loadingVO.getQiYunNumber());
			row.add(loadingVO.getArrive());
			row.add(loadingVO.getCarNumber());
			row.add(Double.toString(loadingVO.getMoney()));
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
	};
	
}
