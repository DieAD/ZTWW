package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import nju.ztww.service.CommodityListService;
import nju.ztww.serviceimpl.CommodityListServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.ui.main.UserInfoUI;



import nju.ztww.vo.StorageListLineofInVO;

public class StorageTiaoPanel extends JPanel {
	DefaultTableModel defaultTableModel;
	JTable  table;
	 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	public ArrayList<StorageListLineofInVO> arraylist=new ArrayList<StorageListLineofInVO>() ;//存储一个库存单的信息
	public CommodityListService commodityservice=new CommodityListServiceImpl();
	public MyButton tiaozheng=new MyButton('b');
	public MyLabel ordernumber=new MyLabel("快递编号");
	public MyTextField ordernumberfield=new MyTextField();
	public MyLabel    xuanze=new MyLabel("分区选择");
	public JButton  showbutton=new JButton();
	public MyButton tijiao=new MyButton('a');
	public MyTextField idoforder=new MyTextField(10);
	public MyDialog dlg=new MyDialog();
	public MyComboBox dbtype = new MyComboBox();
	public MyComboBox dbtype2 = new MyComboBox();
	public MyLabel qu=new MyLabel("区号");
	public MyLabel pai=new MyLabel("排号");
	public MyLabel jia=new MyLabel("架号");
	public MyLabel wei=new MyLabel("位号");
	public MyTextField paifield=new MyTextField();
	public MyTextField jiafield=new MyTextField();
	public MyTextField weifield=new MyTextField();
	ArrayList<StorageListLineofInVO> arraylistshow=new ArrayList<StorageListLineofInVO>();
	MyButton surebutton=new MyButton();
	
	
  public StorageTiaoPanel() {
	// TODO Auto-generated constructor stub
		this.setBackground(new Color(250, 240, 230));
	  this.setLayout(null);
	    dbtype.addItem("航运区");
	    dbtype.addItem("铁运区");
	    dbtype.addItem("汽运区");
	    dbtype.addItem("机动区");
	    dbtype2.addItem("航运区");
	    dbtype2.addItem("铁运区");
	    dbtype2.addItem("汽运区");
	    dbtype2.addItem("机动区");
//	    tiaozheng.setBounds(500, 400, 100, 60);
	    tiaozheng.setIcon(new ImageIcon("photo/wj_adjust.png"));
	    tiaozheng.addActionListener(listenertiao);
//	    tijiao.setBounds(610, 400, 100, 60);
	    tijiao.addActionListener(tijiaolisten);
	    System.out.println("ss");
		System.out.println(UserInfoUI.getUserID());
	    this.add(xuanze);
		this.add(dbtype);
		this.add(showbutton);
		this.add(tiaozheng);
		this.add(tijiao);
	  xuanze.setBounds(20, 10, 60, 30);
	  dbtype.setBounds(90, 10, 100, 30);
	  showbutton.setBounds(200, 10, 100, 30);
	  showbutton.setIcon(new ImageIcon("photo/wj_show.png"));
	  showbutton.setBorderPainted(false);
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
				 table.getTableHeader().setBackground(new Color(249,231,212));//208,168,125
				 table.setBackground(new Color(208,168,125)); //226,203,170
				scrollPane.setBounds(0, 40, 700, 360);
				scrollPane.getViewport().setOpaque(false);
				scrollPane.setOpaque(false);
				this.add(scrollPane); 
		}
	 
	  
	 
  
	   ActionListener listenertiao=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(table.getSelectedRow()>=0){
			dlg=new MyDialog();
			dlg.setLayout(null);
			dlg.setSize(new Dimension(350, 380));
            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
//            ordernumber.setFont(new Font("黑体",0,18));
            ordernumber.setBounds(20, 10, 100, 40);
            ordernumberfield.setBounds(120, 15, 100, 30);
            int row=table.getSelectedRow();
            System.out.println(table.getValueAt(row, 0));
            ordernumberfield.setText((String) table.getValueAt(row, 0));
//            qu.setFont(new Font("黑体",0,18));
            qu.setBounds(20, 60, 100, 40);
            dbtype2.setBounds(120, 65, 100, 30);
             paifield.setBounds(120, 115, 150, 30);
//             pai.setFont(new Font("黑体",0,18));
             pai.setBounds(20, 110, 100, 40);
             jiafield.setBounds(120, 165, 150, 30);
             jia.setBounds(20, 160, 100, 40);
//             jia.setFont(new Font("黑体",0,18));
             weifield.setBounds(120, 215, 150, 30);
//             wei.setFont(new Font("黑体",0,18));
             wei.setBounds(20, 210, 100, 40);
             surebutton.setBounds(200, 280, 70, 30);
             surebutton.setIcon(new ImageIcon("photo/BusinessSure.png"));
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
			
			StorageListLineofInVO storagelistlineinvo=new StorageListLineofInVO(1, "", ordernumberfield.getText(), "", "", dbtype2.getSelectedItem().toString(), paifield.getText(), jiafield.getText(), weifield.getText(), 0,UserInfoUI.getUserID().substring(0,5));			
			arraylist.add(storagelistlineinvo);
			System.out.println(ordernumberfield.getText());
			
			int row=table.getSelectedRow();
			table.setValueAt(dbtype2.getSelectedItem().toString(), row, 3);
			table.setValueAt(paifield.getText(), row, 4);
			table.setValueAt(jiafield.getText(), row, 5);
			table.setValueAt(weifield.getText(), row, 6);
			ordernumberfield.setText(null);
			paifield.setText(null);
			jiafield.setText(null);
			weifield.setText(null);
			
			
			dlg.setVisible(false);
			surebutton.removeActionListener(surelistener);
			// TODO Auto-generated method stub
			
			
		}
	};
		// TODO Auto-generated method stub
  ActionListener show=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			defaultTableModel.setRowCount(0);
			String idofcenter=UserInfoUI.getUserID().substring(0,5);
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
		}
	};
ActionListener tijiaolisten=new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			String idofcenter=UserInfoUI.getUserID().substring(0,5);
			commodityservice.modify(arraylist,idofcenter);
			defaultTableModel.setRowCount(0);
			arraylist.clear();
			}
		}
	};
}

