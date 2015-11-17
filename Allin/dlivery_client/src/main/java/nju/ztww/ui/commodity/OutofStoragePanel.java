package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import nju.ztww.service.CommodityService;
import nju.ztww.serviceimpl.CommodityServiceImp;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StorageListLineofOutVO;
import nju.ztww.vo.StorageListVO;

public class OutofStoragePanel extends JPanel {
   public JTable table;
   public JDialog dlg=new JDialog();
   DefaultTableModel defaultTableModel ;
   public JButton addbutton;
   public JButton surebutton;
   public StorageListLineofOutVO  storagelineout;
   public CommodityService commodity=new CommodityServiceImp();
	
	
   java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
   public JLabel ordernumber=new JLabel("快递编号");
   public JLabel data=new JLabel("出库日期");
   public JLabel arrive=new JLabel("目的地");
   public JLabel zhuangyun=new JLabel("装运形式");
   public JLabel yunshu=new JLabel("运输编号");
   public JTextField ordernumberfield=new JTextField();
   public JTextField datafield=new JTextField();
   public JTextField arrivefield=new JTextField();
   public JTextField zhuangyunfield=new JTextField();
   public JTextField yunshufield=new JTextField();
   public OutofStoragePanel() {
	   this.setLayout(null);
	   addbutton=new JButton();
	   ImageIcon add=new ImageIcon("photo/add.gif");
	   addbutton.setBounds(500, 420, 110, 38);
	   addbutton.setIcon(add);
	   this.add(addbutton);
	// TODO Auto-generated constructor stub
	   Object[][] playerInfo =
{
	{ "0000000007", "2015年11月1日", "南京", "A",14,2,4 },
	{ "0000000008", "2015年11月2日", "上海", "B", 15 ,3,6}, 
			  };

	//字段名称
  String[] Names = { "快件编号", "出库日期", "目的地", "区号", "排号" ,"架号","位号"};

			  
  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
	defaultTableModel = new DefaultTableModel( playerInfo,Names); 
	table = new JTable( defaultTableModel);       //字段名称
	Dimension size = table.getTableHeader().getPreferredSize();
	size.height = 30;//设置新的表头高度40
	table.getTableHeader().setPreferredSize(size);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	//绑定滚动条
	JScrollPane scrollPane = new JScrollPane(table);
	 table.setRowHeight(25);
	scrollPane.setBounds(0, 0, 700, 400);
	this.add(scrollPane); 
	addbutton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		dlg.setLayout(null);
		dlg.setSize(new Dimension(350, 550));
        dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
        surebutton=new JButton("确定");
        surebutton.setBounds(200, 250, 80, 40);
        
        ordernumberfield.setBounds(100, 5, 150, 30);
        ordernumber.setFont(new Font("黑体",0,18));
        ordernumber.setBounds(0, 0, 100, 40);;
        datafield.setBounds(100, 55, 150, 30);
        data.setFont(new Font("黑体",0,18));
        data.setBounds(0, 50,100, 40);
        arrivefield.setBounds(100, 105, 150, 30);
        arrive.setFont(new Font("黑体",0,18));
        arrive.setBounds(0, 100, 100, 40);
        zhuangyunfield.setBounds(100, 155, 150, 30);
        zhuangyun.setFont(new Font("黑体",0,18));
        zhuangyun.setBounds(0, 150, 100, 40);
        yunshufield.setBounds(100, 205, 150, 30);
        yunshu.setFont(new Font("黑体",0,18));
        yunshu.setBounds(0, 200, 100, 40);
        
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
        dlg.add(zhuangyunfield);
        surebutton.addActionListener(listener);
        dlg.setVisible(true);
		// TODO Auto-generated method stub
	
				}
			});
	   
}
 ActionListener listener=new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vector<String> row = new Vector(5);
		row.add(ordernumberfield.getText());
		row.add(datafield.getText());
		row.add(arrivefield.getText());
		row.add(zhuangyunfield.getText());
		row.add(yunshufield.getText());
		storagelineout=new StorageListLineofOutVO(ordernumberfield.getText(), datafield.getText(), arrivefield.getText(), yunshufield.getText());
		commodity.addOrder(storagelineout);
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
}; 
}
