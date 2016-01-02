package nju.ztww.ui.commodity;
//debug 时注意成员变量arraylist 是否会造成添加
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

import confligUI.MyButton;
import confligUI.MyComboBox;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.bl.commodity.IsEmpty;
import nju.ztww.bl.commodity.StringToInt;
import nju.ztww.service.CommodityService;
import nju.ztww.serviceimpl.CommodityServiceImp;
import nju.ztww.serviceimpl.StorageOutListServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public class OutofStoragePanel extends JPanel {
   public MyTable table;
   public MyDialog dlg;
   DefaultTableModel defaultTableModel ;
   public MyButton addbutton;
   public MyButton surebutton;
   public StorageListLineofOutVO  storagelineout;
   public MyButton  sureofbutton=new MyButton();
   public MyButton  submitofbutton=new MyButton('a');
   public MyButton deletebutton=new MyButton('c');
   public CommodityService commodity=new StorageOutListServiceImpl();
   public MyLabel submitlabel=new MyLabel();
   java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
   public MyLabel ordernumber=new MyLabel("快递编号");
   public MyLabel data=new MyLabel("出库日期");
   public MyLabel arrive=new MyLabel("目的地");
   public MyLabel zhuangyun=new MyLabel("装运形式");
   public MyLabel yunshu=new MyLabel("运输编号");
   public MyTextField ordernumberfield=new MyTextField();
   public MyTextField datafield=new MyTextField();
   public MyTextField arrivefield=new MyTextField();
   public MyTextField zhuangyunfield=new MyTextField();
   public MyTextField yunshufield=new MyTextField();
   public MyLabel mylabel=new MyLabel();//提示未正确
	
   long l = System.currentTimeMillis();
   Date time=new Date(l);
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
   public MyComboBox dbtype = new MyComboBox();
    
   public ArrayList<StorageListLineofOutVO>arraylist=new ArrayList<StorageListLineofOutVO>();
   public OutofStoragePanel() {
	   this.setBackground(new Color(250, 240, 230));
	   this.setLayout(null);
	   addbutton=new MyButton('b');
	   
//	   ImageIcon add=new ImageIcon("photo/add.gif");
//	   addbutton.setBounds(450, 420, 110, 38);
//	   addbutton.setIcon(add);
//	   sureofbutton.setBounds(580, 420, 110,38);
//	   deletebutton.setBounds(190, 420, 110, 38);
//	   submitofbutton.setBounds(320, 420, 110, 38);
//	   submitlabel.setFont(new Font("楷体",0,20));
//	   submitlabel.setText("提交成功");
//	   submitlabel.setBounds(20, 420, 200, 38);
//	   this.add(sureofbutton);
	   this.add(addbutton);
	   this.add(submitofbutton);
//	   this.add(submitlabel);
	   this.add(deletebutton);
	   deletebutton.addActionListener(listener3);
//	   submitlabel.setVisible(false);
	// TODO Auto-generated constructor stub
	   Object[][] playerInfo =
{
	
			  };

	//字段名称
  String[] Names = { "快件编号", "出库日期", "目的地", "装运形式", "货运编号" };

			  
  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
	defaultTableModel = new DefaultTableModel( playerInfo,Names); 
	table = new MyTable(defaultTableModel);
	MyScrollPane scrollPane = new MyScrollPane(table);
//	table = new JTable( defaultTableModel);       //字段名称
//	Dimension size = table.getTableHeader().getPreferredSize();
//	size.height = 30;//设置新的表头高度40
//	table.getTableHeader().setPreferredSize(size);
//	table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//	//绑定滚动条
//	JScrollPane scrollPane = new JScrollPane(table);
//	 table.setRowHeight(25);
//	scrollPane.setBounds(0, 0, 700, 400);
	this.add(scrollPane); 
	submitofbutton.addActionListener(listener2);
	dbtype.addItem("火车");
    dbtype.addItem("飞机");
    dbtype.addItem("汽车");
	addbutton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		if(TestIfConnect.ifConnect()){
		dlg=new MyDialog();
		dlg.setLayout(null);

		dlg.setSize(new Dimension(350, 420));
        dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);

        //surebutton.setBounds(200, 250, 80, 40);
        mylabel.setText("信息未填全！");
        mylabel.setBounds(190, 300, 120, 40);
        ordernumberfield.setBounds(100, 5, 150, 30);
        ordernumber.setFont(new Font("黑体",0,18));
        ordernumber.setBounds(0, 0, 100, 40);;
        datafield.setBounds(100, 55, 150, 30);
        data.setFont(new Font("黑体",0,18));
        data.setBounds(0, 50,100, 40);
        arrivefield.setBounds(100, 105, 150, 30);
        arrive.setFont(new Font("黑体",0,18));
        arrive.setBounds(0, 100, 100, 40);

		//dlg.setSize(new Dimension(350, 400));
        //dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
        //surebutton=new JButton("确定");
        

        surebutton=new MyButton();
        surebutton.setIcon(new ImageIcon("photo/Sure.png"));
        surebutton.setBounds(190, 270, 80, 30);

        
        ordernumberfield.setBounds(120, 15, 150, 30);
//        ordernumber.setFont(new Font("黑体",0,18));
        ordernumber.setBounds(20, 10, 100, 40);;
        datafield.setBounds(120, 65, 150, 30);
//        data.setFont(new Font("黑体",0,18));
        data.setBounds(20, 60,100, 40);
        arrivefield.setBounds(120, 115, 150, 30);
//        arrive.setFont(new Font("黑体",0,18));
        arrive.setBounds(20, 110, 100, 40);

        //zhuangyunfield.setBounds(100, 155, 150, 30);
//        zhuangyun.setFont(new Font("黑体",0,18));
        zhuangyun.setBounds(20, 160, 100, 40);
        yunshufield.setBounds(120, 215, 150, 30);
//        yunshu.setFont(new Font("黑体",0,18));
        yunshu.setBounds(20, 210, 100, 40);
        
 	    dbtype.setBounds(120, 165, 150, 30);
 	    dlg.add(dbtype);
        dlg.add(surebutton);
        dlg.add(arrive);
        dlg.add(arrivefield);
        dlg.add(data);
        dlg.add(datafield);
        dlg.add(ordernumber);
        dlg.add(ordernumberfield);
        dlg.add(yunshu);
        dlg.add(yunshufield);
        dlg.add(zhuangyun);
        //dlg.add(zhuangyunfield);
        dlg.add(mylabel);
        dlg.add(surebutton);
        surebutton.addActionListener(listener);
        mylabel.setVisible(false);
        dlg.setVisible(true);
		// TODO Auto-generated method stub
	
				}
	        }
			});
	   
}
 ActionListener listener=new ActionListener() {

	
	public void actionPerformed(ActionEvent e) {

		if(TestIfConnect.ifConnect()){
		ArrayList<String> stringlist=new ArrayList<String>();
		stringlist.add(ordernumberfield.getText());
		stringlist.add(datafield.getText());
		stringlist.add(arrivefield.getText());
		stringlist.add(dbtype.getSelectedItem().toString());
		stringlist.add(yunshufield.getText());
		boolean isempty=false;
		IsEmpty is=new IsEmpty();
		isempty=is.isempty(stringlist);
		if(!isempty){
		Vector<String> row = new Vector(5);
		row.add(ordernumberfield.getText());
		row.add(datafield.getText());
		row.add(arrivefield.getText());
		row.add(dbtype.getSelectedItem().toString());
		row.add(yunshufield.getText());
		//构造了一个vo
		String idofcenter=UserInfoUI.getUserID().substring(0, 5);
        String index=UserInfoUI.getUserID().substring(0,8)+dateFormat.format(time)+commodity.getLastidofcenter(idofcenter);
		StringToInt way=new StringToInt();
		storagelineout=new StorageListLineofOutVO(index,ordernumberfield.getText(), datafield.getText(), arrivefield.getText(),way.changetoint(dbtype.getSelectedItem().toString()), yunshufield.getText(),idofcenter);
      
		

		arraylist.add(storagelineout);
		//arraylist中加入提交之前需要的出库信息
		ordernumberfield.setText(null);
		datafield.setText(null);
		arrivefield.setText(null);
		zhuangyunfield.setText(null);
		yunshufield.setText(null);
		defaultTableModel.addRow(row);
	    table.revalidate();
	    dlg.dispose();
	    surebutton.removeActionListener(listener);
	}
		else{
			mylabel.setVisible(true);
		}
	}
	}
}; 
ActionListener listener2=new ActionListener(){

//需要界面提供给我idofcenter
	public void actionPerformed(ActionEvent e) {

		String idofcenter=UserInfoUI.getUserID().substring(0, 5);//表名改啦
		// TODO Auto-generated method stub
	 commodity.addoutOrder(arraylist,idofcenter);
	 arraylist.clear();
	 defaultTableModel.setRowCount(0);
	 submitlabel.setVisible(true);
	 
	}
	
};
ActionListener listener3=new ActionListener(){

	//需要界面提供给我idofcenter
		public void actionPerformed(ActionEvent e) {

			if(table.getSelectedRow()>=0){
		arraylist.remove(table.getSelectedRow());
		defaultTableModel.removeRow(table.getSelectedRow());
		
		
			}
		}
		
	};
   
}
