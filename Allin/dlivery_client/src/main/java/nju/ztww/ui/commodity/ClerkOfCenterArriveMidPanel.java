package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import confligUI.MyButton;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.bl.commodity.IsEmpty;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.GetDate;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.BusinessArriveVO;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.CenterReceiveVO;
import nju.ztww.vo.LoadingVO;
import nju.ztww.vo.SendVO;
import nju.ztww.vo.TransferVO;

public class ClerkOfCenterArriveMidPanel extends JPanel{
	
	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel("到达日期");
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel("出发地");
	private MyTextField transferNumbertextArea=new MyTextField("");
	private  MyLabel transferNumber=new  MyLabel("中转中心编号");
	private MyTextField findtextArea=new MyTextField("");
	private MyTextField findTransfertextArea=new MyTextField("请输入中转单号");
	private MyTextField findCarLoadtextArea=new MyTextField("请输入装车单号");
	private MyLabel mylabel=new MyLabel();
	private MyButton sendButton=new MyButton('a');
	private MyButton deleteSendButton=new MyButton('c');
	private MyButton sureButton=new MyButton();
	private MyButton findButton=new MyButton('d');
	private MyButton sureTransferButton=new MyButton();
	private MyButton sureCarLoadButton=new MyButton();
	private MyButton findSureButton=new MyButton();
	
	private ArrayList<CenterReceiveVO> allcenterReceiveVO=new ArrayList<CenterReceiveVO>();
	
	private CenterReceiveVO centerReceiveVO=new CenterReceiveVO(3);
	
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	 
	 private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	
	 public MyTable table;
	   public MyDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   DefaultTableModel SmalldefaultTableModel;
	   MyTable SmallreceiveTable;
	   int width=130;
		int hight=25;
		int number=0;

	   public MyButton addbutton = new MyButton('b');
	   public ClerkOfCenterArriveMidPanel() {

			this.setBackground(new Color(250, 240, 230));

		   this.setLayout(null);
			this.add(deleteSendButton);
		  this.add(findButton);
		  this.add(sendButton);
		   this.add(addbutton);
		   Object[][] playerInfo ={
		
				  };

		//瀛楁鍚嶇О
	  String[] Names = { "ID","中转中心编号", "到达日期", "中转单编号", "出发地", "货物到达状态" };

				  
	  //鍒涘缓琛ㄦ牸: 寤虹珛涓�涓樉绀轰簩缁存暟缁勬暟鎹殑琛ㄦ牸锛屼笖鍙互鏄剧ず鍒楃殑鍚嶇О銆� 
		defaultTableModel = new DefaultTableModel( playerInfo,Names); 
		
		table = new MyTable(defaultTableModel);
		MyScrollPane scrollPane = new MyScrollPane(table);

		this.add(scrollPane); 
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(TestIfConnect.ifConnect()){
			centerReceiveVO=(CenterReceiveVO) orderServiceImpl.getOrder(3);
			dlg= new MyDialog(); 
			dlg.setSize(new Dimension(520, 550));
            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            
            Object[][] p = {{"123456"} };

			 //字段名称
			 String[] n = { "快递单号","完整", "丢失", "损坏"};

			  
			 //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			 SmalldefaultTableModel = new DefaultTableModel( p,n){
				  public Class getColumnClass(int column) {
			            for (int row = 0; row < getRowCount(); row++)  {
			                Object o = getValueAt(row, column);
			                if(column!=0){
			                	return Boolean.class;
			                }
			                if (o != null)
			                {
			                    return o.getClass();
			                }
			            }

			            return Object.class;
			        }
				
			  };
			 SmallreceiveTable = new MyTable( SmalldefaultTableModel);       //字段名称
			 MyScrollPane SmallscrollPane = new MyScrollPane(SmallreceiveTable);
			 TableColumn  column = SmallreceiveTable.getColumnModel().getColumn(0);
			 column.setPreferredWidth(150);
			 SmallscrollPane.setBounds(85, 100, 330, 200);
			 
			 findTransfertextArea.setBounds(100, 25, width, hight);
			 sureTransferButton.setBounds(280,25 , 80, 30);
			 sureTransferButton.setIcon(new ImageIcon("photo/Sure.png"));
			 findCarLoadtextArea.setBounds(100, 65, width, hight);
			 sureCarLoadButton.setBounds(280,65 , 80, 30);
			 sureCarLoadButton.setIcon(new ImageIcon("photo/Sure.png"));
			 sureCarLoadButton.addActionListener(findCarLoad);
			 sureTransferButton.addActionListener(findTransfer);
          //中转中心编号
			 String ID = UserInfoUI.getUserID();
	         String IDD=ID.substring(0, 5);
            transferNumbertextArea.setBounds(110, 355, width, hight);
            transferNumbertextArea.setText(IDD);
            transferNumber.setIcon(null);
            transferNumber.setBounds(20, 350, 100, 40);
            //到达日期
            businesstextArea.setBounds(110, 405, width, hight);
            businesstextArea.setText(GetDate.getDate());
            business.setIcon(null);
            business.setBounds(20, 400, 100, 40);
            //出发地
            arrivetextArea.setBounds(320, 355, width, hight);
            arrive.setIcon(null);
            arrive.setBounds(260, 350, 100, 40);
            
            dlg.add(findTransfertextArea);
            dlg.add(sureTransferButton);
            dlg.add(findCarLoadtextArea);
            dlg.add(sureCarLoadButton);
            dlg.add(transferNumber);
            dlg.add(transferNumbertextArea);
            dlg.add(arrive);
            dlg.add(arrivetextArea);
            dlg.add(business);
            dlg.add(businesstextArea);
            dlg.add(sureButton);
            dlg.add(SmallscrollPane);
            sureButton.setBounds(336, 400, 80, 30);
            sureButton.setIcon(new ImageIcon("photo/Sure.png"));
            sureButton.addActionListener(listener);
            mylabel.setText("信息未填全！");
            mylabel.setVisible(false);
            mylabel.setBounds(336, 430, 100, 40);
            dlg.add(mylabel);
            dlg.setLayout(null);
			dlg.setVisible(true);
					}
		}
				});
		sendButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				for(CenterReceiveVO centerReceiveVOTemp:allcenterReceiveVO){
					String result=orderServiceImpl.endSales(centerReceiveVOTemp, 3);
					 System.out.println(result);
				}
				allcenterReceiveVO.clear();
				defaultTableModel.setRowCount(0);
			}
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
	   ActionListener findTransfer = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				TransferVO transferVO=(TransferVO) orderServiceImpl.find(findTransfertextArea.getText(), 8);
				String OrderNumber=transferVO.getSendNumber();
				String [] temp=OrderNumber.split(";");
				number=temp.length;
				for(int i=0;i<temp.length;i++){
					Vector<String> row = new Vector(4);
					row.add(temp[i]);
					SmalldefaultTableModel.addRow(row);
				}
				sureTransferButton.removeActionListener(findTransfer);
			}
			}
	   };
	   ActionListener findCarLoad = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				LoadingVO loadingVO=(LoadingVO) orderServiceImpl.find(findCarLoadtextArea.getText(), 4);
				String OrderNumber=loadingVO.getOrderNumber();
				String [] temp=OrderNumber.split(";");
				number=temp.length;
				for(int i=0;i<temp.length;i++){
					Vector<String> row = new Vector(4);
					row.add(temp[i]);
					SmalldefaultTableModel.addRow(row);
				}
				sureCarLoadButton.removeActionListener(findCarLoad);
			}
			}
	   };
	   
	   ActionListener listener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<String>stringlist=new ArrayList<String>();
				stringlist.add(businesstextArea.getText());
				stringlist.add(arrivetextArea.getText());
				stringlist.add(arrivetextArea.getText());
				IsEmpty is=new IsEmpty();
				boolean isempty=is.isempty(stringlist);
				if(!isempty){
				for(int i=0;i<number;i++){
					centerReceiveVO.setData(businesstextArea.getText());
					centerReceiveVO.setTransferNumber((String)SmallreceiveTable.getValueAt(i, 0));
					centerReceiveVO.setSendPlace(arrivetextArea.getText());
					if(SmallreceiveTable.getValueAt(i,1)!=null&&(Boolean)SmallreceiveTable.getValueAt(i,1) ){
						centerReceiveVO.setOrderState("完整");
					}
					if(SmallreceiveTable.getValueAt(i,2)!=null&&(Boolean) SmallreceiveTable.getValueAt(i,2)){
						centerReceiveVO.setOrderState("缺损");
					}
					if(SmallreceiveTable.getValueAt(i,3)!=null&&(Boolean) SmallreceiveTable.getValueAt(i,3)){
						centerReceiveVO.setOrderState("丢失");
					}
					centerReceiveVO.setCenterNumber(transferNumbertextArea.getText());
					allcenterReceiveVO.add(centerReceiveVO);

					//增加行
					Vector<String> row = new Vector(6);
					row.add(centerReceiveVO.getId());
					row.add(transferNumbertextArea.getText());
					row.add(businesstextArea.getText());
					row.add(centerReceiveVO.getTransferNumber());
					row.add(arrivetextArea.getText());
					row.add(centerReceiveVO.getOrderState());
					defaultTableModel.addRow(row);
				}
				
				
			
				businesstextArea.setText("");
				arrivetextArea.setText("");
				transferNumbertextArea.setText("");
				findTransfertextArea.setText("请输入中转单号");
				findCarLoadtextArea.setText("请输入装车单号");
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
				if(TestIfConnect.ifConnect()){
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
			}
		};
	
}
