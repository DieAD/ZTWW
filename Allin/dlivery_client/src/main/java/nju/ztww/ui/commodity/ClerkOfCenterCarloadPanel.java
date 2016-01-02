package nju.ztww.ui.commodity;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import confligUI.MyButton;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.user.ResultMessageUI;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.ShippingVO;

public class ClerkOfCenterCarloadPanel extends JPanel{
	
	private MyTextField datatextArea=new MyTextField("");
	private  MyLabel data=new  MyLabel();
	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel();
	private MyTextField cartextArea=new MyTextField("");
	private  MyLabel car=new  MyLabel();
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel();
	private MyTextField carNumbertextArea=new MyTextField("");
	private  MyLabel carNumber=new  MyLabel();
	private MyTextField jianzhuangtextArea=new MyTextField("");
	private  MyLabel jianzhuang=new  MyLabel();
	private MyTextField yayuntextArea=new MyTextField("");
	private  MyLabel yayun=new  MyLabel();
	private MyTextField orderNumbertextArea=new MyTextField("");
	private  MyLabel orderNumber=new  MyLabel();
	private MyTextField moneytextArea=new MyTextField("");
	private  MyLabel money=new  MyLabel();
	private MyTextField departtextArea=new MyTextField("");
	private  MyLabel depart=new  MyLabel();
	private MyTextField findtextArea=new MyTextField("");
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private ShippingVO shippingVO;
	private int temp=0;
	private ArrayList<ShippingVO> allLoadingVO=new ArrayList<ShippingVO>();
	
	private ResultMessageUI resultMessageUI=new ResultMessageUI();
	
	private MyButton addButton=new MyButton('b');
	private MyButton findSureButton=new MyButton();
	private MyButton findButton=new MyButton('b');
	private MyButton deleteButton=new MyButton('c');
	private MyButton sendButton=new MyButton('a');
	private MyButton sureButton=new MyButton();
	 DefaultTableModel defaultTableModel ;
	MyDialog dlg;
	 static MyTable table;
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();

	public ClerkOfCenterCarloadPanel(){

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

//		addButton.setBounds(500, 420, 110, 38);
//		addButton.setIcon(add);
//		deleteButton.setBounds(360, 420, 110, 38);
//		deleteButton.setIcon(null);
//		sendButton.setBounds(500, 420, 110, 38);
//		sendButton.setIcon(null);
//		findButton.setBounds(50, 370, 80, 30);
//		findButton.setIcon(null);
		findButton.setIcon(new ImageIcon("photo/search.png"));
		this.setLayout(null);
		this.add(findButton);
		this.add(deleteButton);
		this.add(sendButton);
//        this.add(addButton);
		Object[][] playerInfo =
			  {
			  
			  };

			  //字段名称
			  String[] Names = {"ID", "装车日期",  "汽运编号", "到达地", "车辆代号" ,"运费"};

			  
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

			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						for(ShippingVO shippingVOtemp : allLoadingVO){
							String result=orderServiceImpl.endSales(shippingVOtemp, 7);
							resultMessageUI.setPhoto(result);
							
						}
						resultMessageUI.setPhoto("success");
						allLoadingVO.clear();
						defaultTableModel.setRowCount(0);
					}
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
						if(TestIfConnect.ifConnect()){
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 150));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            findtextArea.setBounds(50, 30, 150, 30);
			            findSureButton.setBounds(240, 30, 80, 30);
			            findSureButton.addActionListener(listener2);
			            findSureButton.setIcon(new ImageIcon("photo/Sure.png"));
			            dlg.add(findSureButton);
			            dlg.add(findtextArea);
			            dlg.setLayout(null);
						dlg.setVisible(true);
						}
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
	
	public void getLoadingVO(ShippingVO loadingVO){
		allLoadingVO.add(loadingVO);
		//增加行
		Vector<String> row = new Vector(6);
		row.add(loadingVO.getId());
		row.add(loadingVO.getData());
		row.add(loadingVO.getQiYunNumber());
		row.add(loadingVO.getArrivePlace());
		row.add(loadingVO.getCarNumber());
		row.add(Double.toString(loadingVO.getMoney()));
		defaultTableModel.addRow(row);
	    table.revalidate();

	}

	
	ActionListener listener2 = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			ShippingVO loadingVO=(ShippingVO) orderServiceImpl.find(findtextArea.getText(), 7);
			Vector<String> row = new Vector(6);
			row.add(loadingVO.getId());
			row.add(loadingVO.getData());
			row.add(loadingVO.getQiYunNumber());
			row.add(loadingVO.getArrivePlace());
			row.add(loadingVO.getCarNumber());
			row.add(Double.toString(loadingVO.getMoney()));
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
		}
	};

}
	
