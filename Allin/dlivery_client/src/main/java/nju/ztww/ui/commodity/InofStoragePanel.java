package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InofStoragePanel extends JPanel{
	public JTable table;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   public JButton addbutton;
	   public InofStoragePanel() {
		   this.setLayout(null);
		   addbutton=new JButton("添加");
		   addbutton.setBounds(450, 400, 100, 30);
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
			// TODO Auto-generated method stub
		defaultTableModel.addRow(new Vector());
			table.revalidate();
					}
				});
		   
	}
	  
}
