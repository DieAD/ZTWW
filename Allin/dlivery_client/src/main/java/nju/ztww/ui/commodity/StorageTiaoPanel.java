package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nju.ztww.service.CommodityListService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.vo.StorageListLineofInVO;

public class StorageTiaoPanel extends JPanel {
	DefaultTableModel defaultTableModel;
	JTable  table;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	public ArrayList<StorageListLineofInVO> arraylist=new ArrayList<StorageListLineofInVO>() ;//存储一个库存单的信息
	public CommodityListService commodityservice=new CommodityListServiceImpl();
	public JButton tiaozheng=new JButton("调整");
	public JLabel ordernumber=new JLabel("快递编号");
	public JTextField ordernumberfield=new JTextField();
	public JLabel    xuanze=new JLabel("分区选择");
	public JButton  showbutton=new JButton("显示信息");
	public JButton tijiao=new JButton("提交");
	public JTextField idoforder=new JTextField(10);
	public JDialog dlg=new JDialog();
	public JComboBox dbtype = new JComboBox();
	public JComboBox dbtype2 = new JComboBox();
	public JLabel qu=new JLabel("区号");
	public JLabel pai=new JLabel("排号");
	public JLabel jia=new JLabel("架号");
	public JLabel wei=new JLabel("位号");
	public JTextField paifield=new JTextField();
	public JTextField jiafield=new JTextField();
	public JTextField weifield=new JTextField();
	JButton surebutton=new JButton("确定");
	String idofcenter="";//中转中心的编号
  public StorageTiaoPanel() {
	// TODO Auto-generated constructor stub
	  this.setLayout(null);
	    dbtype.addItem("航运区");
	    dbtype.addItem("铁运区");
	    dbtype.addItem("汽运区");
	    dbtype.addItem("机动区");
	    dbtype2.addItem("航运区");
	    dbtype2.addItem("铁运区");
	    dbtype2.addItem("汽运区");
	    dbtype2.addItem("机动区");
	    tiaozheng.setBounds(500, 400, 100, 60);
	    tiaozheng.addActionListener(listenertiao);
	    tijiao.setBounds(610, 400, 100, 60);
	    this.add(xuanze);
		this.add(dbtype);
		this.add(showbutton);
		this.add(tiaozheng);
		this.add(tijiao);
	  xuanze.setBounds(20, 10, 60, 30);
	  dbtype.setBounds(90, 10, 100, 30);
	  showbutton.setBounds(200, 10, 100, 30);
	  showbutton.addActionListener(show);
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
				//绑定滚动条
				JScrollPane scrollPane = new JScrollPane(table);
				 table.setRowHeight(25);
				scrollPane.setBounds(0, 40, 700, 360);
				this.add(scrollPane); 
		}
	 
	  
	 
  
	   ActionListener listenertiao=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(table.getSelectedRow()>=0){
			dlg=new JDialog();
			dlg.setLayout(null);
			dlg.setSize(new Dimension(350, 250));
            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            ordernumber.setFont(new Font("黑体",0,18));
            ordernumber.setBounds(0, 0, 100, 40);
            ordernumberfield.setBounds(100, 5, 100, 30);
            qu.setFont(new Font("黑体",0,18));
            qu.setBounds(0, 50, 100, 40);
            dbtype2.setBounds(100, 55, 100, 30);
             paifield.setBounds(100, 105, 150, 30);
             pai.setFont(new Font("黑体",0,18));
             pai.setBounds(0, 100, 100, 40);
             jiafield.setBounds(100, 155, 150, 30);
             
             jia.setBounds(0, 150, 100, 40);
             jia.setFont(new Font("黑体",0,18));
             weifield.setBounds(100, 205, 150, 30);
             wei.setFont(new Font("黑体",0,18));
             wei.setBounds(0, 200, 100, 40);
             surebutton.setBounds(250, 180, 80, 30);
             dlg.add(qu);
             dlg.add(dbtype2);
             dlg.add(pai);
             dlg.add(paifield);
             dlg.add(jia);
             dlg.add(jiafield);
             dlg.add(wei);
             dlg.add(weifield);
             dlg.add(surebutton);
             dlg.add(ordernumber);
             dlg.add(ordernumberfield);
             dlg.setVisible(true);
             surebutton.addActionListener(surelistener);
			}
		}
	};
		
	ActionListener surelistener=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			surebutton.removeActionListener(surelistener);
			// TODO Auto-generated method stub
			
			
		}
	};
		// TODO Auto-generated method stub
  ActionListener show=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	ArrayList<StorageListLineofInVO> arraylistshow=new ArrayList<StorageListLineofInVO>();
	arraylistshow=commodityservice.getStockbyQu(dbtype.getSelectedItem().toString(),idofcenter);
	for(int i=0;i<arraylistshow.size();i++){
		Vector<String> row = new Vector<String>(7);
		row.add(arraylistshow.get(i).getId());
		row.add(arraylistshow.get(i).getData());
		row.add(arraylistshow.get(i).getDestination());
		row.add(arraylistshow.get(i).getQu());
		row.add(arraylistshow.get(i).getPai());
		row.add(arraylistshow.get(i).getJia());
		row.add(arraylistshow.get(i).getWei());
		defaultTableModel.addRow(row);
	    table.revalidate();
	}
		}
	};
ActionListener tijiaolisten=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
}

