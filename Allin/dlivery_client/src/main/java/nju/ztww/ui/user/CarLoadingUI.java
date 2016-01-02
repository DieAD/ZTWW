package nju.ztww.ui.user;
/**
 * 田琦
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import confligUI.MyButton;
import confligUI.MyComboBox;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.bl.commodity.IsEmpty;
import nju.ztww.po.CarManagePO;
import nju.ztww.serviceimpl.OrderServiceImpl;
import nju.ztww.ui.main.GetDate;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.CarManageVO;
import nju.ztww.vo.LoadingVO;

public class CarLoadingUI extends JPanel{
	
	private MyTextField datatextArea=new MyTextField();
	private  MyLabel data=new  MyLabel();
	private MyTextField businesstextArea=new MyTextField();
	private  MyLabel business=new  MyLabel();
	private MyTextField cartextArea=new MyTextField();
	private  MyLabel car=new  MyLabel();
	private MyTextField arrivetextArea=new MyTextField();
	private  MyLabel arrive=new  MyLabel();
	private  MyLabel carNumber=new  MyLabel();
	private MyTextField jianzhuangtextArea=new MyTextField();
	private  MyLabel jianzhuang=new  MyLabel();
	private MyTextField yayuntextArea=new MyTextField();
	private  MyLabel yayun=new  MyLabel();
	private MyTextField orderNumbertextArea=new MyTextField();
	private  MyLabel orderNumber=new  MyLabel();
	private MyTextField departtextArea=new MyTextField();
	private  MyLabel depart=new  MyLabel();
	private MyTextField findtextArea=new MyTextField();
	private OrderServiceImpl orderServiceImpl=new OrderServiceImpl();
	private LoadingVO loadingVO;
	private MyLabel mylabel=new MyLabel();
	private ArrayList<LoadingVO> allLoadingVO=new ArrayList<LoadingVO>();
	
	private ResultMessageUI resultMessageUI=new ResultMessageUI();
	
	private MyButton addButton=new MyButton('b');
	private MyButton findSureButton=new MyButton();
	private MyButton findButton=new MyButton('d');
	private MyButton deleteButton=new MyButton('c');
	private MyButton sendButton=new MyButton('a');

	private MyButton sureButton=new MyButton();


	
	 public MyComboBox dbtype = new MyComboBox();

	DefaultTableModel defaultTableModel ;
	MyDialog dlg;
	 MyTable table;
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	private int width = 150;
	private int height = 25;
	public CarLoadingUI(){

		this.setBackground(new Color(250, 240, 230));

		this.setLayout(null);
		this.add(findButton);
		this.add(deleteButton);
		this.add(sendButton);
        this.add(addButton);
		Object[][] playerInfo =
			  {
			  
			  };

			  //字段名称
			  String[] Names = {"ID", "装车日期", "营业厅编号", "汽运编号", "到达地", "车辆代号" ,"运费"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new MyTable(defaultTableModel);
			  MyScrollPane scrollPane = new MyScrollPane(table);
			  

			  this.add(scrollPane);

			  
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						loadingVO=(LoadingVO) orderServiceImpl.getOrder(4);
						ArrayList<CarManagePO> list=orderServiceImpl.findAllCar();
						dlg= new MyDialog(); 
						dlg.setSize(new Dimension(600, 390));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            data.setText("装车日期");
			            data.setBounds(setX(1), setY(1), width, height);
			            datatextArea.setBounds(setX(2), setY(1), width, height);
			            datatextArea.setText(GetDate.getDate());
			            business.setText("营业厅编号");
			            business.setBounds(setX(3), setY(1), width, height);
			            businesstextArea.setBounds(setX(4), setY(1), width, height);
			            String ID = UserInfoUI.getUserID();
			            String IDD=ID.substring(0, 3)+ID.substring(5, 8);
			            businesstextArea.setText(IDD);
			            car.setText("汽运编号");
			            car.setBounds(setX(1), setY(2), width, height);
			            cartextArea.setBounds(setX(2), setY(2), width, height);
			            cartextArea.setText(IDD+GetDate.getDate2());
			            arrive.setText("到达地");
			            arrive.setBounds(setX(3), setY(2), width, height);
			            arrivetextArea.setBounds(setX(4), setY(2), width, height);
			            carNumber.setText("车辆代号");
			            carNumber.setBounds(setX(1), setY(3), width, height);
			            for(CarManagePO temp:list){
			            	dbtype.addItem(temp.getCarNumber());
			            }
			            dbtype.setBounds(setX(2), setY(3), width, height);
			            orderNumber.setText("订单号");
			            orderNumber.setBounds(setX(3), setY(3), width, height);
			            orderNumbertextArea.setBounds(setX(4), setY(3), width, height);
			           jianzhuang.setText("监装员");
			           jianzhuang.setBounds(setX(1), setY(4), width, height);
			           jianzhuangtextArea.setBounds(setX(2), setY(4), width, height);
			           yayun.setText("押运员");
			           yayun.setBounds(setX(3), setY(4), width, height);
			           yayuntextArea.setBounds(setX(4), setY(4), width, height);

			           depart.setText("出发地");
			           depart.setBounds(setX(1), setY(5), width, height);
			           departtextArea.setBounds(setX(2), setY(5), width, height);
			            
			            dlg.add(depart);
			            dlg.add(departtextArea);

			            dlg.add(yayun);
			            dlg.add(yayuntextArea);
			            dlg.add(jianzhuang);
			            dlg.add(jianzhuangtextArea);
			            dlg.add(orderNumber);
			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(dbtype);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(data);
			            dlg.add(datatextArea);
			            dlg.add(business);
			            dlg.add(businesstextArea);
			            dlg.add(sureButton);
			            sureButton.setBounds(460, 270, 80, 30);
			            mylabel.setText("信息未填全!");
			            mylabel.setBounds(460, 300, 100, 40);
			            sureButton.setIcon(new ImageIcon("photo/Sure.png"));
			            sureButton.addActionListener(listener);

//			            GridLayout layout = new GridLayout(0,2);
//			            layout.setHgap(20);
//			            layout.setVgap(40);
//			            dlg.setLayout(layout);
			            dlg.add(mylabel);
			            mylabel.setVisible(false);

			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
					});
			  sendButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						if(TestIfConnect.ifConnect()){
						for(LoadingVO loadingVOtemp : allLoadingVO){
							String result=orderServiceImpl.endSales(loadingVOtemp, 4);
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
			            findSureButton.setBounds(220, 30, 80, 30);
			            findSureButton.setIcon(new ImageIcon("photo/Sure.png"));
			            findSureButton.addActionListener(listener2);
			            dlg.add(findSureButton);
			            dlg.add(findtextArea);
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					}
			  });
	}

	private int setX(int type){
		switch(type){
		case 1:return 50;
		case 2:return 120;
		case 3:return 300;
		case 4:return 380;
		default:System.out.println("error!");return 0;
		}
	}
	
	private int setY(int line){
		return 20+(line-1)*50;
	}
	ActionListener listener = new ActionListener(){


		public void actionPerformed(ActionEvent e) {

			ArrayList<String> stringlist=new ArrayList<String>();
			stringlist.add(datatextArea.getText());
			stringlist.add(arrivetextArea.getText());
			stringlist.add(dbtype.getSelectedItem().toString());
			stringlist.add(jianzhuangtextArea.getText());
			stringlist.add(orderNumbertextArea.getText());
			stringlist.add(cartextArea.getText());
			stringlist.add(yayuntextArea.getText());
			stringlist.add(departtextArea.getText());
			stringlist.add(businesstextArea.getText());
			
			IsEmpty is=new IsEmpty();
			boolean isempty=is.isempty(stringlist);
			if(!isempty){
			
			loadingVO.setData(datatextArea.getText());
			loadingVO.setArrive(arrivetextArea.getText());
			loadingVO.setCarNumber(dbtype.getSelectedItem().toString());
			loadingVO.setJianZhuangName(jianzhuangtextArea.getText());
			double money=orderServiceImpl.getMoney(departtextArea.getText(), arrivetextArea.getText(), 1);
			loadingVO.setMoney(money);
			loadingVO.setOrderNumber(orderNumbertextArea.getText());
			
			loadingVO.setQiYunNumber(cartextArea.getText());
			loadingVO.setYaYunName(yayuntextArea.getText());
			loadingVO.setYingYeNumber(businesstextArea.getText());
			allLoadingVO.add(loadingVO);

			//增加行
			
			Vector<String> row = new Vector(7);
			row.add(loadingVO.getId());
			row.add(datatextArea.getText());
			row.add(businesstextArea.getText());
			row.add(cartextArea.getText());
			row.add(arrivetextArea.getText());
			row.add(loadingVO.getCarNumber());
			row.add(Double.toString(money));
			
			datatextArea.setText("");
			businesstextArea.setText("");
			cartextArea.setText("");
			arrivetextArea.setText("");
			defaultTableModel.addRow(row);
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

			LoadingVO loadingVO=(LoadingVO) orderServiceImpl.find(findtextArea.getText(), 4);
			Vector<String> row = new Vector(7);
			row.add(loadingVO.getId());
			row.add(loadingVO.getData());
			row.add(loadingVO.getYingYeNumber());
			row.add(loadingVO.getQiYunNumber());
			row.add(loadingVO.getArrive());
			row.add(loadingVO.getCarNumber());
			row.add(Double.toString(loadingVO.getMoney()));
			defaultTableModel.addRow(row);
		    table.revalidate();
		    findtextArea.setText("");
		    dlg.dispose();
		    findSureButton.removeActionListener(listener2);
		}
	};
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		
//		Image background=new ImageIcon("photo/background2.gif").getImage();
//		g.drawImage(background, 0,0,null);
//		
//	}
	
}
