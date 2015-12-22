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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import confligUI.MyButton;
import confligUI.MyComboBox;
import confligUI.MyLabel;
import confligUI.MyScrollPane;
import confligUI.MyTable;
import confligUI.MyTextField;
import nju.ztww.service.CommodityService;
import nju.ztww.serviceimpl.CommodityServiceImp;
import nju.ztww.serviceimpl.StorageInListServiceImpl;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.StorageListLineofInVO;
import nju.ztww.vo.StorageListLineofOutVO;

public class InofStoragePanel extends JPanel{
	public MyTable table;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   public MyButton addbutton;
	   public MyLabel ordernumber=new MyLabel("快递编号");
	   public MyLabel data=new MyLabel("入库日期");
	   public MyLabel arrive=new MyLabel("目的地");
	   public MyLabel qu=new MyLabel("区号");
	   public MyLabel pai=new MyLabel("排号");
	   public MyLabel jia=new MyLabel("架号");
	   public MyLabel wei=new MyLabel("位号");
	   public MyTextField ordernumberfield=new MyTextField();
	   public MyTextField datafield=new MyTextField();
	   public MyTextField arrivefield=new MyTextField();
	   public MyTextField qufield=new MyTextField();
	   public MyTextField paifield=new MyTextField();
	   public MyTextField jiafield=new MyTextField();
	   public MyTextField weifield=new MyTextField();
	   public JButton  surebutton=new JButton("确定");
	   public JButton  sureofbutton=new JButton("确定");
	   public MyButton  submitbutton=new MyButton('a');
	   public MyButton  deletebutton=new MyButton('c');
	   public CommodityService commodity=new StorageInListServiceImpl();
	   
	   long l = System.currentTimeMillis();
	  Date time=new Date(l);
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd ");
	  SimpleDateFormat dateFormatindex=new SimpleDateFormat("yyMMdd");
	   public StorageListLineofInVO  storagelineIn;
	   public ArrayList<StorageListLineofInVO>arraylist=new ArrayList<StorageListLineofInVO>();//成员变量
	   java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
	   public MyComboBox dbtype = new MyComboBox();
	  
	   public InofStoragePanel() {
			this.setBackground(new Color(250, 240, 230));

		   this.setLayout(null);
		   addbutton=new MyButton('b');
//		   ImageIcon add=new ImageIcon("photo/add.gif");
//		   addbutton.setBounds(450, 420, 110, 38);
//		   addbutton.setIcon(add);
//		   sureofbutton.setBounds(580, 420, 110,38);
//		   submitbutton.setBounds(320, 420, 110, 38);
//		   deletebutton.setBounds(190, 420, 110, 38);
//		   this.add(sureofbutton);
		    dbtype.addItem("航运区");
		    dbtype.addItem("铁运区");
		    dbtype.addItem("汽运区");
		    dbtype.addItem("机动区");
		   this.add(addbutton);
		   this.add(submitbutton);
		   this.add(deletebutton);
		   
		   //提交时的监听
		   submitbutton.addActionListener(listener2);
		   deletebutton.addActionListener(listener3);
		// TODO Auto-generated constructor stub
		   Object[][] playerInfo =
	{
		
				  };

		//字段名称
	  String[] Names = { "快件编号", "入库日期", "目的地", "区号", "排号" ,"架号","位号"};

				  
	  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
		defaultTableModel = new DefaultTableModel( playerInfo,Names);
		table = new MyTable(defaultTableModel);
		MyScrollPane scrollPane = new MyScrollPane(table);
//		table = new JTable( defaultTableModel);       //字段名称
//		Dimension size = table.getTableHeader().getPreferredSize();
//		size.height = 30;//设置新的表头高度40
//		table.getTableHeader().setPreferredSize(size);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//		//绑定滚动条
//		JScrollPane scrollPane = new JScrollPane(table);
//		 table.setRowHeight(25);
//		scrollPane.setBounds(0, 0, 700, 400);
		this.add(scrollPane); 
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dlg=new JDialog();
			dlg.setSize(new Dimension(350, 470));
            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
            ordernumberfield.setBounds(120, 5, 150, 30);
//            ordernumber.setFont(new Font("黑体",0,18));
            ordernumber.setBounds(20, 0, 100, 40);;
            datafield.setBounds(120, 55, 150, 30);
//            data.setFont(new Font("黑体",0,18));
            data.setBounds(20, 50,100, 40);
            arrivefield.setBounds(120, 105, 150, 30);
//            arrive.setFont(new Font("黑体",0,18));
            arrive.setBounds(20, 100, 100, 40);
            dbtype.setBounds(120, 155, 150, 30);
//           qu.setFont(new Font("黑体",0,18));
           qu.setBounds(20, 150, 100, 40);
            paifield.setBounds(120, 205, 150, 30);
//            pai.setFont(new Font("黑体",0,18));
            pai.setBounds(20, 200, 100, 40);
            jiafield.setBounds(120, 255, 150, 30);
            
            jia.setBounds(20, 250, 100, 40);
//            jia.setFont(new Font("黑体",0,18));
            weifield.setBounds(120, 305, 150, 30);
//            wei.setFont(new Font("黑体",0,18));
            wei.setBounds(20, 300, 100, 40);
            dlg.setLayout(null);
            dlg.add(ordernumberfield);
            dlg.add(ordernumber);
            dlg.add(arrive);
            dlg.add(arrivefield);
            dlg.add(data);
            dlg.add(datafield);
            dlg.add(jia);
            dlg.add(jiafield);
            dlg.add(pai);
            dlg.add(paifield);
            dlg.add(qu);
            dlg.add(dbtype);
            dlg.add(wei);
            dlg.add(weifield);
           
            surebutton.setBounds(150, 350,100, 30);
            dlg.add(surebutton);
            
            surebutton.addActionListener(surelistener);
            dlg.setVisible(true);
            
      
		
					}
				});
		//ShowIdOfCenter();
		
	   }

    ActionListener surelistener=new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Vector<String> row = new Vector(7);
			
			row.add(ordernumberfield.getText());
			row.add(datafield.getText());
			row.add(arrivefield.getText());
			row.add(dbtype.getSelectedItem().toString());
			row.add(paifield.getText());
			row.add(jiafield.getText());
			row.add(weifield.getText());
			//idoforder 不知道怎么用  用1替代。
			
			String index=commodity.getLastidofcenter(UserInfoUI.getUserID().substring(0,5));
			System.out.println(index);
			String idofdanzi=UserInfoUI.getUserID().substring(0,8)+dateFormatindex.format(time)+index;
			System.out.println(idofdanzi);
			storagelineIn=new StorageListLineofInVO(1,idofdanzi,ordernumberfield.getText(), datafield.getText(), arrivefield.getText(), qufield.getText(), paifield.getText(), jiafield.getText(), weifield.getText(),0,UserInfoUI.getUserID().substring(0,5));
			arraylist.add(storagelineIn);
			
			ordernumberfield.setText(null);
			datafield.setText(null);
			arrivefield.setText(null);
			//qufield.setText(null);
			paifield.setText(null);
			jiafield.setText(null);
			weifield.setText(null);
			defaultTableModel.addRow(row);
		    table.revalidate();
		    dlg.dispose();
		    surebutton.removeActionListener(surelistener);
		    
		}
	};
	ActionListener listener2=new ActionListener(){
		//需要界面提供给我idofcenter
			public void actionPerformed(ActionEvent e) {
				String idofcenter="0001";
				// TODO Auto-generated method stub
				commodity.addinOrder(arraylist,idofcenter);
				arraylist.clear();
				defaultTableModel.setRowCount(0);
				
			}
			
		};
	ActionListener listener3=new ActionListener(){
			//需要界面提供给我idofcenter
				public void actionPerformed(ActionEvent e) {
					System.out.println(table.getSelectedRow());
				if(table.getSelectedRow()>=0){
					// TODO Auto-generated method stub
					arraylist.remove(table.getSelectedRow());
				defaultTableModel.removeRow(table.getSelectedRow());
				
				}
				}
				
			};	
//	public void ShowIdOfCenter(){
//		String idofcenter2=UserInfoUI.getUserID();
//		System.out.println(idofcenter2);
		
	//}
}
	





