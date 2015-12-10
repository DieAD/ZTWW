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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import confligUI.MyButton;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.user.ResultMessageUI;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.ShippingVO;

public class ClerkOfCenterCarloadPanel extends JPanel{
	
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
	private JTextField moneytextArea=new JTextField("");
	private  JLabel money=new  JLabel();
	private JTextField departtextArea=new JTextField("");
	private  JLabel depart=new  JLabel();
	private JTextField findtextArea=new JTextField("");
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private ShippingVO shippingVO;
	private int temp=0;
	private ArrayList<ShippingVO> allLoadingVO=new ArrayList<ShippingVO>();
	
	private ResultMessageUI resultMessageUI=new ResultMessageUI();
	
	private MyButton addButton=new MyButton('b');
	private JButton findSureButton=new JButton("确定");
	private MyButton findButton=new MyButton('d');
	private MyButton deleteButton=new MyButton('c');
	private MyButton sendButton=new MyButton('a');
	private JButton sureButton=new JButton("确定");
	 DefaultTableModel defaultTableModel ;
	JDialog dlg;
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
		findButton.setBounds(560, 400, 80, 30);
//		findButton.setIcon(null);

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
						for(ShippingVO shippingVOtemp : allLoadingVO){
							String result=orderServiceImpl.endSales(shippingVOtemp, 7);
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
	};

}
	
