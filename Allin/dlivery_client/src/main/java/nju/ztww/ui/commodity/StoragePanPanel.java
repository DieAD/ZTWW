package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.bl.commodity.CheckOrderBL;
import nju.ztww.bl.commodity.PanExcelDaoBL;
import nju.ztww.bl.commodity.PlayMusic;
import nju.ztww.po.TracePO;
import nju.ztww.service.CommodityListService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.StorageListLineofInVO;
import confligUI.MyButton;
import confligUI.MyDialog;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;

public class StoragePanPanel extends JPanel  implements ActionListener{
	DefaultTableModel defaultTableModel;
	MyTable  table;
	public MyLabel time=new MyLabel();
	public MyTextField timefield=new MyTextField();
	public MyLabel countall=new MyLabel("总数量");
	public MyTextField countshuliang=new MyTextField(5);
	public JButton panagain=new JButton();
	public JButton excel=new JButton();
	public MyLabel baojing=new MyLabel("库存警戒线");
	public MyTextField baojingshuliang=new MyTextField(5);

	public MyLabel baojingxiugai=new MyLabel("设置新的警戒线");
	public JTextField baojingnew=new JTextField(5);
	public MyButton xiugai=new MyButton();
	public MyButton sure=new MyButton();
	public MyDialog dlg;
	long l = System.currentTimeMillis();
	Date data=new Date(l);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public ArrayList<StorageListLineofInVO> arraylist;//存储一个库存单的信息
	public CommodityListService commodityservice=new CommodityListServiceImpl();
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
  public StoragePanPanel() {
		this.setBackground(new Color(250, 240, 230));
	  this.setLayout(null);
	  Font font11=new Font("微软雅黑",Font.BOLD,20);
	   time.setFont(font11);	
	   time.setText("此次盘点时间：");
	   time.setForeground(new Color(255,255,255));
	   time.setBounds(20, 0, 150, 30);
	   Font font1=new Font("微软雅黑",Font.PLAIN,15);
	   timefield.setFont(font1);
	   timefield.setAlignmentX(CENTER_ALIGNMENT);
	   timefield.setBounds(180, 0, 120, 30);
	   timefield.setText(dateFormat.format(data));
	   //重新盘点按钮
	   panagain.setFont(font1);
	   panagain.setBounds(420, 0, 120, 30);
	   panagain.setIcon(new ImageIcon("photo/wj_pandian.png"));
	   panagain.setBorderPainted(false);
	   panagain.addActionListener(this);
	   countall.setFont(font1);
	   countall.setForeground(new Color(255,255,255));
	   //countall.setEnabled(false);
	   baojing.setFont(font1);
	   baojing.setForeground(new Color(255,255,255));
	   baojing.setBounds(490, 370, 100, 30);
	   baojingshuliang.setBounds(590, 370, 80, 30);
	   baojingshuliang.setEditable(false);
	   countall.setBounds(520,340, 60, 30);
	   countshuliang.setBounds(590, 340, 80, 30);
	   countshuliang.setEditable(false);
	   excel.setBounds(550, 0, 120, 30);
	   excel.setIcon(new ImageIcon("photo/wj_excel.png"));
	   excel.addActionListener(listenerdao);
	   excel.setBorderPainted(false);
	   xiugai.setBounds(0, 340, 140, 30);
	   xiugai.setIcon(new ImageIcon("photo/ModifyAlarm.png"));
	   xiugai.addActionListener(listenerxiugai);
	   this.add(countall);
	   this.add(time);
	   this.add(timefield);
	   this.add(panagain);
	   this.add(countshuliang);
	   this.add(excel);
	   this.add(baojing);
	   this.add(baojingshuliang);
	   this.add(xiugai);
	// TODO Auto-generated constructor stub
	   Object[][] playerInfo =
	{
		
				  };

		//字段名称
	  String[] Names = { "快件编号", "入库日期", "目的地", "区号", "排号" ,"架号","位号"};

				  
	  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
		defaultTableModel = new DefaultTableModel( playerInfo,Names); 
		table = new MyTable( defaultTableModel);       //字段名称
//		Dimension size = table.getTableHeader().getPreferredSize();
//		size.height = 30;//设置新的表头高度40
//		table.getTableHeader().setPreferredSize(size);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//		table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
//		table.setBackground(new Color(208,168,125)); //226,203,170
		//绑定滚动条
		MyScrollPane scrollPane = new MyScrollPane(table);
//		 table.setRowHeight(25);
		scrollPane.setBounds(0, 40, 670, 300);
//		scrollPane.getViewport().setOpaque(false);
//		scrollPane.setOpaque(false);
		this.add(scrollPane); 
}
  public void actionPerformed(ActionEvent e) {
	  if(TestIfConnect.ifConnect()){
	//实现接口 需要传一个满足要求的arraylist
	  defaultTableModel.setRowCount(0);
	arraylist=commodityservice.getStock(UserInfoUI.getUserID().substring(0, 5));//ZHE 个String 是id一部分
	CheckOrderBL checks=new CheckOrderBL();
	ArrayList<TracePO> stringlist=new ArrayList<TracePO>();
	stringlist=checks.findTrace("库存警戒线"+UserInfoUI.getUserID().substring(0, 5));
	for(int i=0;i<arraylist.size();i++){
		Vector<String> row = new Vector<String>(7);
		row.add(arraylist.get(i).getId());
		row.add(arraylist.get(i).getData());
		row.add(arraylist.get(i).getDestination());
		row.add(arraylist.get(i).getQu());
		row.add(arraylist.get(i).getPai());
		row.add(arraylist.get(i).getJia());
		row.add(arraylist.get(i).getWei());
		defaultTableModel.addRow(row);
	    table.revalidate();
	}
	countshuliang.setText(String.valueOf(arraylist.size()));
	baojingshuliang.setText(stringlist.get(0).getTrace());
	  }
  }
ActionListener listenerxiugai=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dlg=new MyDialog();
			dlg.setLayout(null);
			dlg.setSize(340, 150);
			dlg.setVisible(true);
			dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			baojingxiugai.setBounds(20, 5, 140, 30);
			baojingnew.setBounds(30,50,120,30);
			sure.setBounds(160, 50, 70, 30);
			sure.addActionListener(listenersure);
			sure.setIcon(new ImageIcon("photo/BusinessSure.png"));
			dlg.add(baojingxiugai);
			dlg.add(baojingnew);
			dlg.add(sure);
			
			
			//baojingxiugai.removeActionListener(listenerxiugai);;
		}
	};
ActionListener listenersure=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dlg.setVisible(false);
			//需要改到库存中
			CheckOrderBL checks2=new CheckOrderBL();
			String number=baojingnew.getText();
			ArrayList<TracePO> stringlist2=new ArrayList<TracePO>();
			checks2.modifyBaoJing("库存警戒线"+UserInfoUI.getUserID().substring(0, 5), number);
			baojingnew.setText(null);
			baojingshuliang.setText(number);
			
			
			sure.removeActionListener(listenersure);
		}
	};
ActionListener listenerdao=new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PanExcelDaoBL dao=new PanExcelDaoBL();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd");
		CheckOrderBL checks=new CheckOrderBL();
		ArrayList<TracePO> stringlist=new ArrayList<TracePO>();
		stringlist=checks.findTrace("盘点"+UserInfoUI.getUserID().substring(0, 5));
		String lasttime=stringlist.get(0).getTrace().substring(0,10);
		int index=0;
		if(lasttime.equals(timefield.getText())){
			//时间相等
			index=Integer.parseInt(stringlist.get(0).getTrace().substring(10,12))+1;
		}
		else{
			index=1;
		}
		String nowindex=null;
		if(index<10){
			nowindex='0'+String.valueOf(index);
		}
		else{
			nowindex=String.valueOf(index);
		}
		
		String name=timefield.getText()+"第"+nowindex+"批";
		dao.dao(UserInfoUI.getUserID().substring(0,5), name);
		String nowtrace=timefield.getText()+nowindex;
		checks.modifyDao("盘点"+UserInfoUI.getUserID().substring(0,5), nowtrace);
		//getstockbl
		//excel.removeActionListener(listenerdao);
		try {
			PlayMusic.play("music/success.wav");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
};
  }
   

