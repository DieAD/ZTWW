package nju.ztww.ui.commodity;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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



import confligUI.MyLabel;
import confligUI.MyTextField;

import nju.ztww.bl.commodity.CheckOrderBL;

import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.TracePO;
import nju.ztww.service.CommodityListService;
import nju.ztww.service.CommodityService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.serviceimpl.CommodityServiceImp;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListVO;

public class StoragePanPanel extends JPanel  implements ActionListener{
	DefaultTableModel defaultTableModel;
	JTable  table;
	public MyLabel time=new MyLabel();
	public MyTextField timefield=new MyTextField();
	public MyLabel countall=new MyLabel("总数量");
	public MyTextField countshuliang=new MyTextField(5);
	public JButton panagain=new JButton();
	public JButton excel=new JButton();
	public MyLabel baojing=new MyLabel("库存警戒线");
	public MyTextField baojingshuliang=new MyTextField(5);

	public JButton baojingxiugai=new JButton("设置新的警戒线");
	public JTextField baojingnew=new JTextField(5);
	public JButton xiugai=new JButton("修改警戒线");
	public JButton sure=new JButton("确定");
	public JDialog dlg;
	long l = System.currentTimeMillis();
	Date data=new Date(l);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
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
	   time.setBounds(20, 0, 150, 30);
	   Font font1=new Font("微软雅黑",Font.PLAIN,15);
	   timefield.setFont(font1);
	   timefield.setAlignmentX(CENTER_ALIGNMENT);
	   timefield.setBounds(180, 0, 120, 30);
	   timefield.setText(dateFormat.format(data));
	   //重新盘点按钮
	   panagain.setFont(font1);
	   panagain.setBounds(450, 0, 120, 30);
	   panagain.setIcon(new ImageIcon("photo/wj_pandian.png"));
	   panagain.setBorderPainted(false);
	   panagain.addActionListener(this);
	   countall.setFont(font1);
	   baojing.setFont(font1);
	   baojing.setBounds(520, 370, 100, 30);
	   baojingshuliang.setBounds(620, 370, 80, 30);
	   countall.setBounds(550,340, 60, 30);
	   countshuliang.setBounds(620, 340, 80, 30);
	   excel.setBounds(580, 0, 120, 30);
	   excel.setIcon(new ImageIcon("photo/wj_excel.png"));
	   excel.setBorderPainted(false);
	   xiugai.setBounds(580, 400, 120, 30);
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
		table = new JTable( defaultTableModel);       //字段名称
		Dimension size = table.getTableHeader().getPreferredSize();
		size.height = 30;//设置新的表头高度40
		table.getTableHeader().setPreferredSize(size);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
		table.setBackground(new Color(208,168,125)); //226,203,170
		//绑定滚动条
		JScrollPane scrollPane = new JScrollPane(table);
		 table.setRowHeight(25);
		scrollPane.setBounds(0, 40, 700, 300);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.add(scrollPane); 
}
  public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//实现接口 需要传一个满足要求的arraylist
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
	ActionListener listenerdao=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
  }
ActionListener listenerxiugai=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dlg=new JDialog();
			dlg.setLayout(null);
			dlg.setSize(240, 150);
			dlg.setVisible(true);
			dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			baojingxiugai.setBounds(40, 0, 140, 30);
			baojingnew.setBounds(60,50,100,30);
			sure.setBounds(160, 80, 80, 30);
			sure.addActionListener(listenersure);
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
  }
   

