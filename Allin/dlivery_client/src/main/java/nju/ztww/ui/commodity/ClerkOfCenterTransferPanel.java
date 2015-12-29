package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.user.ResultMessageUI;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.TransferVO;

public class ClerkOfCenterTransferPanel extends JPanel {
	
	   public MyTable table;

	   Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	   public MyDialog dlg;
	
	   DefaultTableModel defaultTableModel;

		private MyButton findSureButton=new MyButton();
		private MyButton findButton=new MyButton('d');
		private MyButton deleteButton=new MyButton('c');
		private MyButton sendButton=new MyButton('a');
		
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	   
	   private ArrayList<TransferVO> alltransferVO=new ArrayList<TransferVO>();
	   
	   private MyTextField findtextArea=new MyTextField("");
		private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
		private ResultMessageUI resultMessageUI=new ResultMessageUI();
		private TransferVO transferVO=new TransferVO(8);

	   public ClerkOfCenterTransferPanel() {
		   
		   this.setBackground(new Color(250, 240, 230));
		   
//		   deleteButton.setBounds(360, 420, 110, 38);
//			deleteButton.setIcon(null);
//			sendButton.setBounds(500, 420, 110, 38);
//			sendButton.setIcon(null);
			findButton.setBounds(530, 400, 80, 30);
//			findButton.setIcon(null);
			this.add(findButton);
			this.add(deleteButton);
			this.add(sendButton);
		   this.setLayout(null);
		   Object[][] playerInfo =
				  {
				  
				  };

				  //字段名称
				  String[] Names = {"ID", "运输方式", "装运日期", "中转中心运输编号", "航班(车次)号", "出发地" ,"到达地","运费"};

				  
				  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
				  table = new MyTable(defaultTableModel);
				  table.setFont(myFont);
				  MyScrollPane scrollPane = new MyScrollPane(table);
//				  table = new JTable( defaultTableModel);       //字段名称
//				  Dimension size = table.getTableHeader().getPreferredSize();
//			
//				  size.height = 30;//设置新的表头高度40
//				  table.getTableHeader().setPreferredSize(size);
//				  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//				//  table.setPreferredScrollableViewportSize(new Dimension( 550,
////				                60));
//				  
//				  //绑定滚动条
//				  JScrollPane scrollPane = new JScrollPane(table);
//			      table.setRowHeight(25);
//				  scrollPane.setBounds(0, 0, 690, 420);
				  this.add(scrollPane);
				  sendButton.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent e) {
							if(TestIfConnect.ifConnect()){
							for(TransferVO alltransferVOTemp : alltransferVO){
								String result=orderServiceImpl.endSales(alltransferVOTemp, 8);
							}
							alltransferVO.clear();
							defaultTableModel.setRowCount(0);
						}
						}
				  });
				  deleteButton.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent e) {
//							String id=(String) table.getValueAt(table.getSelectedRow(), 0);
//							String result=orderServiceImpl.deleteOrder(id,"loadform");
							if(table.getSelectedRow()>=0&&alltransferVO.size()!=0){
								alltransferVO.remove(table.getSelectedRow());
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
				            findSureButton.setBounds(240, 30, 70, 30);
				            findSureButton.addActionListener(listener2);
				            findSureButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
				            dlg.add(findSureButton);
				            dlg.add(findtextArea);
				            dlg.setLayout(null);
							dlg.setVisible(true);
						}
						}
				  });
		   
	}
	   
//	   public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			
//			Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
//			g.drawImage(background, 0,0,null);
//			
//		}
	   
	   public void getTransferOrder(TransferVO transferVO){
		   alltransferVO.add(transferVO);
		 //增加行
			Vector<String> row = new Vector(8);
			row.add(transferVO.getId());
			row.add(transferVO.getMethod());
			row.add(transferVO.getTransferData());
			row.add(transferVO.getMethodNumber());
			row.add(transferVO.getCarData());
			row.add(transferVO.getSendPlace());
			row.add(transferVO.getArrivePlace());
			row.add(Double.toString(transferVO.getMoney()));
			defaultTableModel.addRow(row);
		    table.revalidate();
	   }
	   
	   ActionListener listener2 = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				TransferVO transferVO=(TransferVO) orderServiceImpl.find(findtextArea.getText(), 8);
				Vector<String> row = new Vector(8);
				row.add(transferVO.getId());
				row.add(transferVO.getMethod());
				row.add(transferVO.getTransferData());
				row.add(transferVO.getMethodNumber());
				row.add(transferVO.getCarData());
				row.add(transferVO.getSendPlace());
				row.add(transferVO.getArrivePlace());
				row.add(Double.toString(transferVO.getMoney()));
				defaultTableModel.addRow(row);
			    table.revalidate();
			    findtextArea.setText("");
			    dlg.dispose();
			    findSureButton.removeActionListener(listener2);
			}
			}
		};
}
