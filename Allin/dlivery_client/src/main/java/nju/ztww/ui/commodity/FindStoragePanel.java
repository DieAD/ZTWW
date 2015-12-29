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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import confligUI.MyButton;
import confligUI.MyComboBox;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyTextField;
import nju.ztww.bl.commodity.IsEmpty;
import nju.ztww.bl.commodity.StringToInt;
import nju.ztww.po.CarManagePO;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.serviceimpl.StorageOutListServiceImpl;
import nju.ztww.ui.main.GetDate;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.DeliverFeesVO;
import nju.ztww.vo.ShippingVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.TransferVO;

/**
 * 查看库存面板
 * @author TQ
 *
 */
public class FindStoragePanel extends JPanel {
	
	private static String OrderNumber="";
	private int down=0;
	private MyTextField datatextArea=new MyTextField("");
	private  MyLabel data=new  MyLabel();
	private MyTextField businesstextArea=new MyTextField("");
	private  MyLabel business=new  MyLabel();
	private MyTextField cartextArea=new MyTextField("");
	private  MyLabel car=new  MyLabel();
	private MyTextField arrivetextArea=new MyTextField("");
	private  MyLabel arrive=new  MyLabel();
	public MyComboBox dbtype = new MyComboBox();
	private  MyLabel carNumber=new  MyLabel();
	private MyTextField jianzhuangtextArea=new MyTextField("");
	private  MyLabel jianzhuang=new  MyLabel();
	private MyTextField yayuntextArea=new MyTextField("");
	private  MyLabel yayun=new  MyLabel();
	private MyTextField orderNumbertextArea=new MyTextField("");
	private  MyLabel orderNumber=new  MyLabel();
    private MyLabel label1=new MyLabel();
    private MyLabel label2=new MyLabel();
	private MyTextField departtextArea=new MyTextField("");
	private  MyLabel depart=new  MyLabel();

	private MyTextField loadDataText=new MyTextField("");
	private  MyLabel loadData=new  MyLabel("装运日期");
	private MyTextField transferNumberText=new MyTextField("");
	private  MyLabel transferNumber=new  MyLabel("中转运输编号");
	private MyTextField methodText=new MyTextField("");
	private  MyLabel method=new  MyLabel("运输方式");
	private MyTextField AirOrCarNumberText=new MyTextField("");
	private  MyLabel AirOrCarNumber=new  MyLabel("航班(车次)号");
	private MyTextField transferArriveText=new MyTextField("");
	private  MyLabel transferArrive=new  MyLabel("到达地");
	private MyTextField transferSendText=new MyTextField("");
	private  MyLabel transferSend=new  MyLabel("出发地");
	private MyTextField counterText=new MyTextField("");
	private  MyLabel counter=new  MyLabel("货柜号");
	private MyTextField jianzhuangText=new MyTextField("");
	private  MyLabel transferJianzhuang=new  MyLabel("监装员");
	private MyTextField allOrderText=new MyTextField("");
	private  MyLabel allOrder=new  MyLabel();

	MyDialog dlg;
	
	   private MyButton find=new MyButton('c');
	   private MyButton addTransferOrder=new MyButton('b');
	   private MyButton addLoadOrder=new MyButton('a');
	   private MyButton sureButton=new MyButton();
	   private MyButton sureTransferButton=new MyButton();
	  
	   DefaultTableModel defaultTableModel ;
	   static JTable table;
	   
	   java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	   private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	   private StorageOutListServiceImpl StorageOutListServiceImpl=new StorageOutListServiceImpl();
	   private CommodityListServiceImpl commodityListServiceImpl=new CommodityListServiceImpl();
	   
	   private ShippingVO loadingVO;
	   private TransferVO transferVO;
	   
	   private static ArrayList<Integer> row=new ArrayList<Integer>();
	   private ArrayList<StorageListLineofOutVO> arraylist=new ArrayList<StorageListLineofOutVO>();
	   private ArrayList<StorageListLineofInVO> getStorage=new ArrayList<StorageListLineofInVO>();
	   public FindStoragePanel() {

		   
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
		
//		     find.setBounds(220, 420, 110, 38);
		     find.setIcon(new ImageIcon("photo/ViewStorage.png"));
//		     addTransferOrder.setBounds(360, 420, 110, 38);
		     addTransferOrder.setIcon(new ImageIcon("photo/TransitOrder.png"));
//		     addLoadOrder.setBounds(500, 420, 110, 38);
		     addLoadOrder.setIcon(new ImageIcon("photo/LoadingOrder.png"));


		      final Object[][] p =
				  {
					
				  };

				  //字段名称
				  String[] n = { "快递编号","入库日期", "目的地", "区号", "排号", "架号" ,"位号","状态","选择"};
			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				  defaultTableModel=new DefaultTableModel(p,n){
					  public Class getColumnClass(int column) {
				            for (int row = 0; row < getRowCount(); row++)  {
				                Object o = getValueAt(row, column);
				                if(column==8){
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
//			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new JTable(defaultTableModel);       //字段名称
			  Dimension size = table.getTableHeader().getPreferredSize();
		
			  size.height = 30;//设置新的表头高度40
			  table.getTableHeader().setPreferredSize(size);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //绑定滚动条
			  JScrollPane scrollPane = new JScrollPane(table);
		      table.setRowHeight(25);
		      //
			  scrollPane.setBounds(0, 0, 700, 400);
				scrollPane.getViewport().setOpaque(false);
				scrollPane.setOpaque(false);
				table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
				table.setBackground(new Color(208,168,125)); //226,203,170
			  //
			  addLoadOrder.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						loadingVO=(ShippingVO) orderServiceImpl.getOrder(7);
						ArrayList<CarManagePO> list=orderServiceImpl.findAllCar();
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 520));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //装车日期
			            datatextArea.setBounds(120, 5, 150, 30);
			            datatextArea.setText(GetDate.getDate());
			            data.setText("装车日期");
			            data.setBounds(20, 0, 100, 40);
			            //汽运编号
			            String ID = UserInfoUI.getUserID();
			            String IDD=ID.substring(0, 3)+ID.substring(5, 8);
			            cartextArea.setBounds(120, 105, 150, 30);
			            cartextArea.setText(IDD+GetDate.getDate2());
			            car.setText("汽运编号");
			            car.setBounds(20, 100, 100, 40);
			            //到达地
			            arrivetextArea.setBounds(120, 155, 150, 30);
			            arrive.setText("到达地");
			            arrive.setBounds(20, 150, 100, 40);
			            //车辆代号
			            for(CarManagePO temp:list){
			            	dbtype.addItem(temp.getCarNumber());
			            }
			            dbtype.setBounds(120, 55, 150, 30);
			            carNumber.setText("车辆编号");
			            carNumber.setBounds(20, 50, 100, 40);
//			            //订单号
//			            orderNumbertextArea.setBounds(100, 255, 150, 30);
//			            orderNumber.setIcon(OrderNumber);
//			            orderNumber.setBounds(0, 250, 100, 40);
			            //监装员
			            jianzhuangtextArea.setBounds(120, 205, 150, 30);
			            jianzhuang.setText("监装员");
			            jianzhuang.setBounds(20, 200, 100, 40);
			            //押运员
			            yayuntextArea.setBounds(120, 255, 150, 30);
			           yayun.setText("押运员");
			            yayun.setBounds(20, 250, 100, 40);
			          
			            //出发地
			            departtextArea.setBounds(120, 305, 150, 30);
			            depart.setText("出发地");
			            depart.setBounds(20, 320, 100, 40);
			            
			            dlg.add(depart);
			            dlg.add(departtextArea);
			            dlg.add(yayun);
			            dlg.add(yayuntextArea);
			            dlg.add(jianzhuang);
			            dlg.add(jianzhuangtextArea);
//			            dlg.add(orderNumber);
//			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(dbtype);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(data);
			            dlg.add(datatextArea);
			    
			            dlg.add(sureButton);
			            sureButton.setBounds(190, 360, 70, 30);
			            sureButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
			            sureButton.addActionListener(listener);
			            label1.setVisible(false);
			            label1.setText("信息未填完！");
			            label1.setBounds(190, 390, 100, 40);
			            dlg.add(label1);
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
			  });
			  addTransferOrder.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						transferVO=(TransferVO) orderServiceImpl.getOrder(8);
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			           //运输方式
			            methodText.setBounds(120, 5, 150, 30);
			            method.setIcon(null);
			            method.setBounds(20, 0, 100, 40);
			            //装车日期
			            loadDataText.setBounds(120, 55, 150, 30);
			            loadDataText.setText(GetDate.getDate());
			            loadData.setIcon(null);
			            loadData.setBounds(20, 50, 100, 40);
			            //中转运输编号
			            transferNumberText.setBounds(120, 105, 150, 30);
			            transferNumber.setIcon(null);
			            transferNumber.setBounds(20, 100, 100, 40);
			            //航班（车次）号
			            AirOrCarNumberText.setBounds(120, 155, 150, 30);
			            AirOrCarNumber.setIcon(null);
			            AirOrCarNumber.setBounds(20, 150, 100, 40);
			            //出发地
			            transferSendText.setBounds(120, 205, 150, 30);
			            transferSend.setIcon(null);
			            transferSend.setBounds(20, 200, 100, 40);
			            //到达地
			            transferArriveText.setBounds(120, 255, 150, 30);
			            transferArrive.setIcon(null);
			            transferArrive.setBounds(20, 250, 100, 40);
			            //监装员
			            jianzhuangText.setBounds(120, 305, 150, 30);
			            transferJianzhuang.setIcon(null);
			            transferJianzhuang.setBounds(20, 300, 100, 40);
			            //货柜号
			            counterText.setBounds(120, 355, 150, 30);
			            counter.setIcon(null);
			            counter.setBounds(20, 350, 100, 40);
//			            //托运单号
//			            allOrderText.setBounds(100, 405, 150, 30);
//			            allOrder.setIcon(null);
//			            allOrder.setBounds(0, 400, 100, 40);
			            
			            dlg.add(methodText);
			            dlg.add(method);
			            dlg.add(loadDataText);
			            dlg.add(loadData);
			            dlg.add(transferNumberText);
			            dlg.add(transferNumber);
			            dlg.add(AirOrCarNumberText);
			            dlg.add(AirOrCarNumber);
			            dlg.add(transferSend);
			            dlg.add(transferSendText);
			            dlg.add(transferArriveText);
			            dlg.add(transferArrive);
			            dlg.add(jianzhuangText);
			            dlg.add(transferJianzhuang);
			            dlg.add(counterText);
			            dlg.add(counter);
//			            dlg.add(allOrderText);
//			            dlg.add(allOrder);
			            dlg.add(sureTransferButton);
			            sureTransferButton.setBounds(200, 415, 70, 30);
			            sureTransferButton.setIcon(new ImageIcon("photo/BusinessSure.png"));
			            sureTransferButton.addActionListener(listener2);
			            label2.setVisible(false);
			            label2.setText("信息未填全！");
			            label2.setBounds(200, 445, 100, 40);
			            dlg.add(label2);
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
			  });
			  find.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						defaultTableModel.setRowCount(0);
						getStorage=commodityListServiceImpl.getStock(UserInfoUI.getUserID().substring(0,5));
						for(StorageListLineofInVO storageListLineofInVO:getStorage){
							Vector<String> row = new Vector(9);
							row.add(storageListLineofInVO.getId());
							row.add(storageListLineofInVO.getData());
							row.add(storageListLineofInVO.getDestination());
							row.add(storageListLineofInVO.getQu());
							row.add(storageListLineofInVO.getPai());
							row.add(storageListLineofInVO.getJia());
							row.add(storageListLineofInVO.getWei());
							//设置状态
							defaultTableModel.addRow(row);
						}
						}
					}
			  });
			  this.add(find);
			  this.add(addLoadOrder);
			  this.add(addTransferOrder);
			  this.add(scrollPane);
			  this.setLayout(null);
	}
	
	   
	   ActionListener listener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				ArrayList<String>stringlist=new ArrayList<String>();
				stringlist.add(datatextArea.getText());
				stringlist.add(arrivetextArea.getText());
				//stringlist.add(carNumbertextArea.getText());
				stringlist.add(jianzhuangtextArea.getText());
				stringlist.add(departtextArea.getText());
				stringlist.add(yayuntextArea.getText());
				stringlist.add(cartextArea.getText());
				IsEmpty is=new IsEmpty();
				boolean isempty=false;
				isempty=is.isempty(stringlist);
				if(!isempty){		
				
				loadingVO.setData(datatextArea.getText());
				loadingVO.setArrivePlace(arrivetextArea.getText());
				loadingVO.setCarNumber(dbtype.getSelectedItem().toString());
				loadingVO.setJianZhuangName(jianzhuangtextArea.getText());
				getSelectString();
				double money=30*2*row.size()*0.01;
				loadingVO.setMoney(money);
				if(OrderNumber !=""){
					OrderNumber=OrderNumber.substring(1);
				}
				loadingVO.setOrderNumber(OrderNumber);
				loadingVO.setQiYunNumber(cartextArea.getText());
				loadingVO.setYaYunName(yayuntextArea.getText());
				
				ClerkOfCenterUi.CarloadPanel.getLoadingVO(loadingVO);
				for(int i:row){
					i-=down;
					defaultTableModel.removeRow(i);
					down++;
				}
				down=0;
				row.clear();
				//进行出库操作   未写完
				String [] temp=OrderNumber.split(";");
				// 2biao  shi qiche
				for(int i=0;i<temp.length;i++){
					StorageListLineofOutVO StorageListLineofOutVO=new StorageListLineofOutVO("idofdanzi",temp[i],datatextArea.getText(),
							arrivetextArea.getText(),2,cartextArea.getText(),"02501");
					//需要改的
					arraylist.add(StorageListLineofOutVO);
				}
				String ID = UserInfoUI.getUserID();
	            String IDD=ID.substring(0, 5);
				StorageOutListServiceImpl.addoutOrder(arraylist, IDD);
				arraylist.clear();
				OrderNumber="";
			    dlg.dispose();
			    sureButton.removeActionListener(listener);
			}
				else{
					label1.setVisible(true);
				}
			}
			}
		};
		ActionListener listener2 = new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if(TestIfConnect.ifConnect()){
				ArrayList<String>stringlist=new ArrayList<String>();
				stringlist.add(transferArriveText.getText());
				stringlist.add(loadDataText.getText());
				stringlist.add(counterText.getText());
				stringlist.add(jianzhuangText.getText());
				stringlist.add(methodText.getText());
				stringlist.add(AirOrCarNumberText.getText());
				stringlist.add(transferSendText.getText());
				stringlist.add(transferNumberText.getText());
				IsEmpty is=new IsEmpty();
				boolean isempty=false;
				isempty=is.isempty(stringlist);
				if(!isempty){
				transferVO.setArrivePlace(transferArriveText.getText());
				transferVO.setCarData(loadDataText.getText());
				transferVO.setCounterNumber(counterText.getText());
				transferVO.setJianZhuangName(jianzhuangText.getText());
				transferVO.setMethod(methodText.getText());
				transferVO.setMethodNumber(AirOrCarNumberText.getText());
				transferVO.setSendPlace(transferSendText.getText());
				transferVO.setTransferData(transferNumberText.getText());
				getSelectString();
				DeliverFeesVO deliverFeesVO=new DeliverFeesVO(transferSendText.getText(),transferArriveText.getText()
						,methodText.getText(),0,Double.toString(row.size()*0.01));
				double money=orderServiceImpl.getMoney(deliverFeesVO);
				transferVO.setMoney(money);
				if(OrderNumber !=""){
					OrderNumber=OrderNumber.substring(1);
				}
				transferVO.setSendNumber(OrderNumber);
				ClerkOfCenterUi.Transferpanel.getTransferOrder(transferVO);
				for(int i:row){
					i-=down;
					defaultTableModel.removeRow(i);
					down++;
				}
				down=0;
				row.clear();
				//进行出库操作   未写完
				String [] temp=OrderNumber.split(";");
				for(int i=0;i<temp.length;i++){
					StringToInt st=new StringToInt();
					StorageListLineofOutVO StorageListLineofOutVO=new StorageListLineofOutVO("idofdanzi",temp[i],loadDataText.getText(),
							methodText.getText(),st.changetoint(transferArriveText.getText()),transferNumberText.getText(),"02501");
					// 需要改的
					arraylist.add(StorageListLineofOutVO);
				}
				String ID = UserInfoUI.getUserID();
	            String IDD=ID.substring(0, 5);
				StorageOutListServiceImpl.addoutOrder(arraylist, IDD);
				arraylist.clear();
				OrderNumber="";
			    dlg.dispose();
			    sureTransferButton.removeActionListener(listener2);
				}
				else{
					label2.setVisible(true);
				}
			}
			}
		};
		
		public static void outStorage(String orderNumber){
			
		}
		
		public static void getSelectString(){
			for(int i=0;i<table.getRowCount();i++){
				if(table.getValueAt(i,8)!=null&& (Boolean) table.getValueAt(i,8)){
					OrderNumber=OrderNumber+";"+(String) table.getValueAt(i,0);
					row.add(i);
				}
			}
		}
		
//		public void paintComponent(Graphics g){
//			super.paintComponent(g);
//			
//			Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
//			g.drawImage(background, 0,0,null);
//			
//		}
}

 
 

