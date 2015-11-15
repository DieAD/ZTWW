package nju.ztww.ui.commodity;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StoragePanPanel extends JPanel {
	DefaultTableModel defaultTableModel;
	JTable  table;
  public StoragePanPanel() {
	  this.setLayout(null);
	// TODO Auto-generated constructor stub
	   Object[][] playerInfo =
	{
		{ "0000000003", "2015年11月1日", "南京", "A",14,2,4 },
		{ "0000000004", "2015年11月2日", "上海", "B", 15 ,3,6}, 
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
		scrollPane.setBounds(0, 0, 700, 400);
		this.add(scrollPane); 
}
}
