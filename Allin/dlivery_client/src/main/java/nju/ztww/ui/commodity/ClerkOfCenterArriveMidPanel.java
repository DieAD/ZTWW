package nju.ztww.ui.commodity;

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
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.CenterReceiveVO;
import nju.ztww.vo.SendVO;

public class ClerkOfCenterArriveMidPanel extends JPanel {
	
	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel("到达日期");
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel("中转单编号");
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel("出发地");
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel("货物到达状态");
	private JTextField transferNumbertextArea=new JTextField("");
	private  JLabel transferNumber=new  JLabel("中转中心编号");
	private JTextField findtextArea=new JTextField("");
	
	private MyButton sendButton=new MyButton('a');
	private MyButton deleteSendButton=new MyButton('c');
	private JButton sureButton=new JButton("确定");
	private MyButton findButton=new MyButton('d');
	private JButton findSureButton=new JButton("确定");
	
	private ArrayList<CenterReceiveVO> allcenterReceiveVO=new ArrayList<CenterReceiveVO>();
	
	private CenterReceiveVO centerReceiveVO=new CenterReceiveVO(3);
	
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	 
	 private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	
	 public MyTable table;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   public MyButton addbutton = new MyButton('b');
	   public ClerkOfCenterArriveMidPanel() {
		   
			this.setBackground(new Color(250, 240, 230));

		   this.setLayout(null);
//		   addbutton=new MyButton('b');
//		   ImageIcon add=new ImageIcon("photo/add.gif");
//		   addbutton.setBounds(560, 420, 110, 38);
//		   addbutton.setIcon(add);
//		   sendButton.setBounds(430, 420, 110, 38);
//			sendButton.setIcon(null);
//			deleteSendButton.setBounds(300, 420, 110, 38);
//			deleteSendButton.setIcon(null);
//			findButton.setBounds(170, 420, 110, 38);
//			findButton.setIcon(null);
			this.add(deleteSendButton);
		  this.add(findButton);
		  this.add(sendButton);
		   this.add(addbutton);
		// TODO Auto-generated constructor stub
		   Object[][] playerInfo ={
		
				  };

		//瀛楁鍚嶇О
	  String[] Names = { "ID","中转中心编号", "到达日期", "中转单编号", "出发地", "货物到达状态" };

				  
	  //鍒涘缓琛ㄦ牸: 寤虹珛涓�涓樉绀轰簩缁存暟缁勬暟鎹殑琛ㄦ牸锛屼笖鍙互鏄剧ず鍒楃殑鍚嶇О銆� 
		defaultTableModel = new DefaultTableModel( playerInfo,Names); 
		
		table = new MyTable(defaultTableModel);
		MyScrollPane scrollPane = new MyScrollPane(table);
//		table = new JTable( defaultTableModel);       //瀛楁鍚嶇О
//		Dimension size = table.getTableHeader().getPreferredSize();
//		size.height = 30;//璁剧疆鏂扮殑琛ㄥご楂樺害40
//		table.getTableHeader().setPreferredSize(size);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//		//缁戝畾婊氬姩鏉�
//		JScrollPane scrollPane = new JScrollPane(table);
//		 table.setRowHeight(25);
//		scrollPane.setBounds(0, 0, 690, 420);
		this.add(scrollPane); 
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			centerReceiveVO=(CenterReceiveVO) orderServiceImpl.getOrder(3);
			dlg= new JDialog(); 
			dlg.setSize(new Dimension(350, 550));
            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
          //中转中心编号
            transferNumbertextArea.setBounds(100, 55, 150, 30);
            transferNumber.setIcon(null);
            transferNumber.setBounds(0, 50, 100, 40);
            //货物到达状态
            carNumbertextArea.setBounds(100, 255, 150, 30);
            carNumber.setIcon(null);
            carNumber.setBounds(0, 250, 100, 40);
            //到达日期
            businesstextArea.setBounds(100, 105, 150, 30);
            business.setIcon(null);
            business.setBounds(0, 100, 100, 40);
            //出发地
            arrivetextArea.setBounds(100, 205, 150, 30);
            arrive.setIcon(null);
            arrive.setBounds(0, 200, 100, 40);
            //中转单编号
            cartextArea.setBounds(100, 155, 150, 30);
            car.setIcon(null);
            car.setBounds(0, 150, 100, 40);
            
            dlg.add(transferNumber);
            dlg.add(transferNumbertextArea);
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
		sendButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				for(CenterReceiveVO centerReceiveVOTemp:allcenterReceiveVO){
					String result=orderServiceImpl.endSales(centerReceiveVOTemp, 3);
					 System.out.println(result);
				}
				allcenterReceiveVO.clear();
				defaultTableModel.setRowCount(0);
			}
	  });
		deleteSendButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
//				String id=(String) sendTable.getValueAt(sendTable.getSelectedRow(), 0);
//				String result=orderServiceImpl.deleteOrder(id,"deliveryform");
				if(table.getSelectedRow()>=0&&allcenterReceiveVO.size()!=0){
					allcenterReceiveVO.remove(table.getSelectedRow());
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
	   
//	   public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			
//			Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
//			g.drawImage(background, 0,0,null);
//			
//		}
	   
	   ActionListener listener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				centerReceiveVO.setData(businesstextArea.getText());
				centerReceiveVO.setTransferNumber(cartextArea.getText());
				centerReceiveVO.setSendPlace(arrivetextArea.getText());
				centerReceiveVO.setOrderState(carNumbertextArea.getText());
				centerReceiveVO.setCenterNumber(transferNumbertextArea.getText());
				allcenterReceiveVO.add(centerReceiveVO);

				//增加行
				Vector<String> row = new Vector(6);
				row.add(centerReceiveVO.getId());
				row.add(transferNumbertextArea.getText());
				row.add(businesstextArea.getText());
				row.add(cartextArea.getText());
				row.add(arrivetextArea.getText());
				row.add(carNumbertextArea.getText());
				
			
				businesstextArea.setText("");
				cartextArea.setText("");
				arrivetextArea.setText("");
				carNumbertextArea.setText("");
				transferNumbertextArea.setText("");
				defaultTableModel.addRow(row);
				table.revalidate();
			    dlg.dispose();
			    sureButton.removeActionListener(listener);
			}
			
		};
		
		ActionListener listener2 = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterReceiveVO centerReceiveVO=(CenterReceiveVO) orderServiceImpl.find(findtextArea.getText(), 3);
				Vector<String> row = new Vector(6);
				row.add(centerReceiveVO.getId());
				row.add(centerReceiveVO.getCenterNumber());
				row.add(centerReceiveVO.getData());
				row.add(centerReceiveVO.getTransferNumber());
				row.add(centerReceiveVO.getSendPlace());
				row.add(centerReceiveVO.getOrderState());

				defaultTableModel.addRow(row);
			    table.revalidate();
			    findtextArea.setText("");
			    dlg.dispose();
			    findSureButton.removeActionListener(listener2);
			}
		};
}
