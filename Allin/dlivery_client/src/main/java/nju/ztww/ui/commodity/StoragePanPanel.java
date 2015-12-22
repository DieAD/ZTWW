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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.po.StorageListLineofInPO;
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
	public JLabel time=new JLabel();
	public JTextField timefield=new JTextField();
	public JLabel countall=new JLabel("总数量");
	public JTextField countshuliang=new JTextField(5);
	public JButton panagain=new JButton();
	public JButton excel=new JButton();
	public JLabel baojing=new JLabel("库存警戒线");
	public JTextField baojingshuliang=new JTextField(5);
	long l = System.currentTimeMillis();
	Date data=new Date(l);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
	public ArrayList<StorageListLineofInVO> arraylist;//存储一个库存单的信息
	public CommodityListService commodityservice=new CommodityListServiceImpl();
	
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
	   panagain.setBounds(550, 0, 120, 30);
	   panagain.setIcon(new ImageIcon("photo/wj_pandian.png"));
	   panagain.setBorderPainted(false);
	   panagain.addActionListener(this);
	   countall.setFont(font1);
	   baojing.setFont(font1);
	   baojing.setBounds(400, 400, 80, 30);
	   baojingshuliang.setBounds(480, 400, 40, 30);
	   countall.setBounds(550,400, 60, 30);
	   countshuliang.setBounds(620, 400, 80, 30);
	   excel.setBounds(210, 400, 120, 30);
	   excel.setIcon(new ImageIcon("photo/wj_excel.png"));
	   excel.setBorderPainted(false);
	   this.add(countall);
	   this.add(time);
	   this.add(timefield);
	   this.add(panagain);
	   this.add(countshuliang);
	   this.add(excel);
	   this.add(baojing);
	   this.add(baojingshuliang);
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
		scrollPane.setBounds(0, 40, 700, 360);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		this.add(scrollPane); 
}
  public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//实现接口 需要传一个满足要求的arraylist
	arraylist=commodityservice.getStock(UserInfoUI.getUserID().substring(0, 5));//ZHE 个String 是id一部分
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
	
	ActionListener listenerdao=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
}
   
}
