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
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.ReceiveVO;
import nju.ztww.vo.SendVO;

public class RecieiveMoneyUI extends JPanel{
	
	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel("收款日期");
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel("收款金额");
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel("收款快递员");
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel("订单号");
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel("备注");
	private JButton addButton=new JButton();
	private JButton addSendButton=new JButton("提交");
	private JButton sureButton=new JButton("确定");
	
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private ReceiveVO receiveVO;
	
	private ArrayList<String> allOrderNumber;
	private ArrayList<ReceiveVO> allreceiveVO;
	
	DefaultTableModel defaultTableModel ;
	 JTable table;
	 JDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public RecieiveMoneyUI(){
		ImageIcon add=new ImageIcon("photo/add.gif");
		addButton.setBounds(500, 420, 110, 38);
		addButton.setIcon(add);
		

		addSendButton.setBounds(300, 420, 110, 38);
		addSendButton.setIcon(null);
		Object[][] playerInfo =
			  {
			    { "阿s呆", new Integer(69), new Integer(32), new Integer(98),  new Boolean(false) },
			    { "阿呆", new Integer(82), new Integer(69), new Integer(128), new Boolean(true)}, 
			  };

			  //字段名称
			  String[] Names = { "收款日期", "收款金额", "收款快递员", "订单号", "备注" };

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new JTable( defaultTableModel);       //字段名称
			  Dimension size = table.getTableHeader().getPreferredSize();
		
			  size.height = 30;//设置新的表头高度40
			  table.getTableHeader().setPreferredSize(size);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //绑定滚动条
			  JScrollPane scrollPane = new JScrollPane(table);
		      table.setRowHeight(25);
			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						receiveVO=(ReceiveVO) orderServiceImpl.getOrder(5);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //订单号
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(0, 200, 100, 40);
			            //收款日期
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(null);
			            business.setBounds(0, 50, 100, 40);
			            //收款快递员
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(0, 150, 100, 40);
			            //收款金额
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
						for(ReceiveVO receiveVOtemp:allreceiveVO){
							String result=orderServiceImpl.endSales(receiveVOtemp, 5);
							 System.out.println(result);
						}
					}
			  });
			  this.add(addButton);
			  this.add(addSendButton);
			  this.setLayout(null);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			receiveVO.setData(businesstextArea.getText());
			String temp[]=carNumbertextArea.getText().split(";");
			for(int i=0;i<temp.length;i++){
				allOrderNumber.add(temp[i]);
			}
			receiveVO.setOrderNumber(allOrderNumber);
			double money=Double.parseDouble(cartextArea.getText());
			receiveVO.setReceiveMoney(money);
			receiveVO.setReceiverName(arrivetextArea.getText());
			allreceiveVO.add(receiveVO);
//			 String result=orderServiceImpl.endSales(receiveVO, 5);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(5);
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
		
	};

}
