package nju.ztww.ui.manage;
/**
 * 田琦
 * 
 * */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserManageUI extends JPanel{
	
	DefaultTableModel defaultTableModel ;
	JDialog dlg;
	 JTable table;
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	private JButton userButton=new JButton();
	
	public UserManageUI(){
		
		ImageIcon save=new ImageIcon("photo/save.gif");
		
		userButton.setBounds(500, 420, 110, 38);
		userButton.setIcon(save);
		this.add(userButton);
		
		Object[][] playerInfo =
			  {
			    { "阿呆", new Integer(66), new Integer(32), new Integer(98),  new Boolean(false)},
			    { "阿呆", new Integer(82), new Integer(69), new Integer(128), new Boolean(true)}, 
			  };

			  //字段名称
			  String[] Names = { "姓名", "编号", "职位" , "登录账号", "权限级别"};

			  
			  //创建表格: 建立一个显示二维数组数据的表格，且可以显示列的名称。 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new JTable( defaultTableModel);       //字段名称
			  Dimension size = table.getTableHeader().getPreferredSize();
		
			  size.height = 30;//设置新的表头高度40
			  table.getTableHeader().setPreferredSize(size);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //绑定滚动条
			  JScrollPane scrollPane = new JScrollPane(table);
		      table.setRowHeight(25);
			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  this.setLayout(null);
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
}
