package nju.ztww.ui.user;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton addButton=new JButton();
	private JButton addSendButton=new JButton();
	private JButton sureButton=new JButton("确定");
	DefaultTableModel defaultTableModel ;
	DefaultTableModel defaultTableModel2 ;
	 JTable receiveTable;
	 JTable sendTable;
	 JDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public ReceiveAndSendUI(){
		ImageIcon add=new ImageIcon("photo/add.gif");
		addButton.setBounds(500, 420, 110, 38);
		addButton.setIcon(add);
		addSendButton.setBounds(300, 420, 110, 38);
		addSendButton.setIcon(add);
		Object[][] playerInfo =
			  {
			    { "阿s呆", new Integer(69), new Integer(32), new Integer(98),  new Boolean(false) },
			    { "阿呆", new Integer(82), new Integer(69), new Integer(128), new Boolean(true)}, 
			  };

			  //字段名称
			  String[] Names = { "到达日期", "中转单编号", "出发地", "货物到达状态", "备注"};

			  
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
				    { "阿s呆", new Integer(69), new Integer(32),  new Boolean(false) },
				    { "阿呆", new Integer(82), new Integer(69),  new Boolean(true)}, 
				  };

				  //字段名称
				  String[] Names2 = { "到达日期", "托运订单号", "派送员",  "备注"};

				  
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
			// TODO Auto-generated method stub
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
			receiveTable.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
		}
		
	};
}
