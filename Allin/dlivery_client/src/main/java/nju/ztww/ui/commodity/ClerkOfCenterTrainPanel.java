package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClerkOfCenterTrainPanel extends JPanel {
	public JTable table;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   public JButton addbutton;
	   public ClerkOfCenterTrainPanel() {
		   this.setLayout(null);
		   addbutton=new JButton();
		   ImageIcon add=new ImageIcon("photo/add.gif");
		   addbutton.setBounds(500, 420, 110, 38);
		   addbutton.setIcon(add);
		  
		   this.add(addbutton);
		// TODO Auto-generated constructor stub
		   Object[][] playerInfo =
	{
		{ "2015年11月12日", "555", "02", "上海","日本",2,"sb","00000000004",150},
		
				  };

		//字段名称
	  String[] Names = { "装运日期", "货运编号", "车次号", "出发地", "到达地" ,"车厢号","监装员","单号","运费"};

				  
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
