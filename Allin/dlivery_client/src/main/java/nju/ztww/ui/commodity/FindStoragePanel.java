package nju.ztww.ui.commodity;

import java.awt.Dimension;
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

import nju.ztww.bl.commodity.StringToInt;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.serviceimpl.StorageOutListServiceImpl;
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
	private  JLabel depart=new  JLabel();

	private JTextField loadDataText=new JTextField("");
	private  JLabel loadData=new  JLabel();
	private JTextField transferNumberText=new JTextField("");
	private  JLabel transferNumber=new  JLabel();
	private JTextField methodText=new JTextField("");
	private  JLabel method=new  JLabel();
	private JTextField AirOrCarNumberText=new JTextField("");
	private  JLabel AirOrCarNumber=new  JLabel();
	private JTextField transferArriveText=new JTextField("");
	private  JLabel transferArrive=new  JLabel();
	private JTextField transferSendText=new JTextField("");
	private  JLabel transferSend=new  JLabel();
	private JTextField counterText=new JTextField("");
	private  JLabel counter=new  JLabel();
	private JTextField jianzhuangText=new JTextField("");
	private  JLabel transferJianzhuang=new  JLabel();
	private JTextField allOrderText=new JTextField("");
	private  JLabel allOrder=new  JLabel();

	JDialog dlg;
	
	   private JButton find=new JButton("查看库存");
	   private JButton addTransferOrder=new JButton("生成中转单");
	   private JButton addLoadOrder=new JButton("生成装车单");
	   private JButton sureButton=new JButton("确定");
	   private JButton sureTransferButton=new JButton("确定");
	  
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
		
		     find.setBounds(220, 420, 110, 38);
		     find.setIcon(null);
		     addTransferOrder.setBounds(360, 420, 110, 38);
		     addTransferOrder.setIcon(null);
		     addLoadOrder.setBounds(500, 420, 110, 38);
		     addLoadOrder.setIcon(null);


		      final Object[][] p =
				  {
					 { "1212121212", new Integer(66), new Integer(32), new Integer(98),  new Integer(16),
						 new Integer(16), new Integer(16),new Integer(16), new Boolean(false) },
						 { "4545454545", new Integer(66), new Integer(32), new Integer(98),  new Integer(16),
							 new Integer(16), new Integer(16),new Integer(16), new Boolean(false) }
				  };

				  //字段名称
				  String[] n = { "快递编号","入库日期", "目的地", "区号", "排号", "架号" ,"位号","状态","选择"};
			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
				  defaultTableModel=new DefaultTableModel(p,n){
					  public Class getColumnClass(int column) {
				            for (int row = 0; row < getRowCount(); row++)  {
				                Object o = getValueAt(row, column);
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
			  scrollPane.setBounds(0, 0, 690, 420);
			  addLoadOrder.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						loadingVO=(ShippingVO) orderServiceImpl.getOrder(7);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //装车日期
			            datatextArea.setBounds(100, 5, 150, 30);
			            data.setIcon(dataLable);
			            data.setBounds(0, 0, 100, 40);
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
//			            //订单号
//			            orderNumbertextArea.setBounds(100, 255, 150, 30);
//			            orderNumber.setIcon(OrderNumber);
//			            orderNumber.setBounds(0, 250, 100, 40);
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
			            depart.setIcon(Money);
			            depart.setBounds(0, 450, 100, 40);
			            
			            dlg.add(depart);
			            dlg.add(departtextArea);
			            dlg.add(yayun);
			            dlg.add(yayuntextArea);
			            dlg.add(jianzhuang);
			            dlg.add(jianzhuangtextArea);
//			            dlg.add(orderNumber);
//			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(carNumbertextArea);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(data);
			            dlg.add(datatextArea);
			    
			            dlg.add(sureButton);
			            sureButton.setBounds(100, 450, 60, 40);
			            sureButton.addActionListener(listener);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
			  });
			  addTransferOrder.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						transferVO=(TransferVO) orderServiceImpl.getOrder(8);
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			           //运输方式
			            methodText.setBounds(100, 5, 150, 30);
			            method.setIcon(null);
			            method.setBounds(0, 0, 100, 40);
			            //装车日期
			            loadDataText.setBounds(100, 55, 150, 30);
			            loadData.setIcon(null);
			            loadData.setBounds(0, 50, 100, 40);
			            //中转运输编号
			            transferNumberText.setBounds(100, 105, 150, 30);
			            transferNumber.setIcon(null);
			            transferNumber.setBounds(0, 100, 100, 40);
			            //航班（车次）号
			            AirOrCarNumberText.setBounds(100, 155, 150, 30);
			            AirOrCarNumber.setIcon(null);
			            AirOrCarNumber.setBounds(0, 150, 100, 40);
			            //出发地
			            transferSendText.setBounds(100, 205, 150, 30);
			            transferSend.setIcon(null);
			            transferSend.setBounds(0, 200, 100, 40);
			            //到达地
			            transferArriveText.setBounds(100, 255, 150, 30);
			            transferArrive.setIcon(null);
			            transferArrive.setBounds(0, 250, 100, 40);
			            //监装员
			            jianzhuangText.setBounds(100, 305, 150, 30);
			            transferJianzhuang.setIcon(null);
			            transferJianzhuang.setBounds(0, 300, 100, 40);
			            //货柜号
			            counterText.setBounds(100, 355, 150, 30);
			            counter.setIcon(null);
			            counter.setBounds(0, 350, 100, 40);
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
			            sureTransferButton.setBounds(100, 450, 60, 40);
			            sureTransferButton.addActionListener(listener2);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
			  });
			  find.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						getStorage=commodityListServiceImpl.getStock("0251111");
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
			  });
			  this.add(find);
			  this.add(addLoadOrder);
			  this.add(addTransferOrder);
			  this.add(scrollPane);
			  this.setLayout(null);
	}
	
	   
	   ActionListener listener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				loadingVO.setData(datatextArea.getText());
				loadingVO.setArrivePlace(arrivetextArea.getText());
				loadingVO.setCarNumber(carNumbertextArea.getText());
				loadingVO.setJianZhuangName(jianzhuangtextArea.getText());
				double money=orderServiceImpl.getMoney(departtextArea.getText(), arrivetextArea.getText(), 1);
				loadingVO.setMoney(money);
				getSelectString();
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
							arrivetextArea.getText(),2,cartextArea.getText());
					arraylist.add(StorageListLineofOutVO);
				}
				//中转中心编号未确定
				StorageOutListServiceImpl.addoutOrder(arraylist, "0251111");
				arraylist.clear();
				OrderNumber="";
			    dlg.dispose();
			    sureButton.removeActionListener(listener);
			}
		};
		ActionListener listener2 = new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				transferVO.setArrivePlace(transferArriveText.getText());
				transferVO.setCarData(loadDataText.getText());
				transferVO.setCounterNumber(counterText.getText());
				transferVO.setJianZhuangName(jianzhuangText.getText());
				transferVO.setMethod(methodText.getText());
				transferVO.setMethodNumber(AirOrCarNumberText.getText());
				transferVO.setSendPlace(transferSendText.getText());
				transferVO.setTransferData(transferNumberText.getText());
				double money=orderServiceImpl.getMoney(transferSendText.getText(), transferArriveText.getText(), 1);
				transferVO.setMoney(money);
				getSelectString();
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
							methodText.getText(),st.changetoint(transferArriveText.getText()),transferNumberText.getText());
					arraylist.add(StorageListLineofOutVO);
				}
				//中转中心编号未确定
				StorageOutListServiceImpl.addoutOrder(arraylist, "0251111");
				arraylist.clear();
				OrderNumber="";
			    dlg.dispose();
			    sureTransferButton.removeActionListener(listener2);
			}
		};
		
		public static void outStorage(String orderNumber){
			
		}
		
		public static void getSelectString(){
			for(int i=0;i<table.getRowCount();i++){
				if( (Boolean) table.getValueAt(i,8)){
					OrderNumber=OrderNumber+";"+(String) table.getValueAt(i,0);
					row.add(i);
				}
			}
		}
}

 
 

