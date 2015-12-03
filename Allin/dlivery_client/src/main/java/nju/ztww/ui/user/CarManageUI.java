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
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.LoadingVO;

/**
 * 车辆管理ui
 * @author TQ
 *
 */
public class CarManageUI extends JPanel{


	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel("车辆代号");
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel("车牌号");
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel("车辆状态");
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel("服役时间");
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel("备注");
	private JTextField findtextArea=new JTextField("");
	private ArrayList<CarManageVO> allCarManageVO=new ArrayList<CarManageVO>();
	
	private JButton sendButton=new JButton("提交");
	private JButton findButton=new JButton("查找");
	private JButton deleteButton=new JButton("删除");
	private JButton findSureButton=new JButton("确定");
	private JButton addButton=new JButton();
	private JButton sureButton=new JButton("确定");
	
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private CarManageVO carManageVO;
	
	DefaultTableModel defaultTableModel ;
	 JTable table;
	 JDialog dlg;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	
	public CarManageUI(){
		ImageIcon add=new ImageIcon("photo/add.gif");
		addButton.setBounds(500, 420, 110, 38);
		addButton.setIcon(add);
		deleteButton.setBounds(220, 420, 110, 38);
		deleteButton.setIcon(null);
		sendButton.setBounds(360, 420, 110, 38);
		sendButton.setIcon(null);
		findButton.setBounds(90, 420, 110, 38);
		findButton.setIcon(null);
		Object[][] playerInfo =
			  {
			    
			  };

			  //字段名称
			  String[] Names = { "ID","车辆代号", "车牌号", "车辆状态", "服役时间", "备注" };

			  
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
						carManageVO=(CarManageVO) orderServiceImpl.getOrder(9);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //服役时间
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(null);
			            carNumber.setBounds(0, 200, 100, 40);
			            //车辆代号
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(null);
			            business.setBounds(0, 50, 100, 40);
			            //车辆状态
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(null);
			            arrive.setBounds(0, 150, 100, 40);
			            //车牌号
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
			  deleteButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
//						String id=(String) table.getValueAt(table.getSelectedRow(), 0);
//						String result=orderServiceImpl.deleteOrder(id,"carmanageform");
						if(table.getSelectedRow()>=0&&allCarManageVO.size()!=0){
							allCarManageVO.remove(table.getSelectedRow());
						}
				
						defaultTableModel.removeRow(table.getSelectedRow());
					}
			  });
			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						for(CarManageVO carManageVOtemp : allCarManageVO){
							String result=orderServiceImpl.endSales(carManageVOtemp, 9);
							 System.out.println(result);
						}
						allCarManageVO.clear();
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

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			carManageVO.setCarNumber(businesstextArea.getText());
			carManageVO.setCarState(arrivetextArea.getText());
			carManageVO.setPlateNUmber(cartextArea.getText());
			carManageVO.setServiceTime(carNumbertextArea.getText());
			allCarManageVO.add(carManageVO);
//			 String result=orderServiceImpl.endSales(carManageVO, 9);
//			 System.out.println(result);
			//增加行
			Vector<String> row = new Vector(6);
			row.add(carManageVO.getId());
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
	
	ActionListener listener2 = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			CarManageVO carManageVO=(CarManageVO) orderServiceImpl.find(findtextArea.getText(), 9);
			Vector<String> row = new Vector(6);
			row.add(carManageVO.getId());
			row.add(carManageVO.getCarNumber());
			row.add(carManageVO.getPlateNUmber());
			row.add(carManageVO.getCarState());
			row.add(carManageVO.getServiceTime());
			row.add("");
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
	};
}
