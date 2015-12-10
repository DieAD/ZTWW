package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

public class ClerkOfCenterArriveEndPanel extends JPanel {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	public JTable table;
	   public JDialog dlg;
	   DefaultTableModel defaultTableModel ;
	   public JButton addbutton;
	   public ClerkOfCenterArriveEndPanel() {
		   this.setLayout(null);
		   addbutton=new JButton();
		   ImageIcon add=new ImageIcon("photo/add.gif");
		   addbutton.setBounds(500, 420, 110, 38);
		   addbutton.setIcon(add);
		  
		   this.add(addbutton);
		// TODO Auto-generated constructor stub
		   Object[][] playerInfo =
	{
		{ "025001245", "11月21日", "0216", "上海","完整"},
		
				  };

		//瀛楁鍚嶇О
	  String[] Names = { "中转中心编号", "到达日期", "中转单编号", "出发地", "货物到达状态"};

				  
	  
		defaultTableModel = new DefaultTableModel( playerInfo,Names); 
		table = new JTable( defaultTableModel);       
		Dimension size = table.getTableHeader().getPreferredSize();
		size.height = 30;
		table.getTableHeader().setPreferredSize(size);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFont(myFont);
		JScrollPane scrollPane = new JScrollPane(table);
		 table.setRowHeight(25);
		scrollPane.setBounds(0, 0, 690, 420);
		this.add(scrollPane); 
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		defaultTableModel.addRow(new Vector());
			table.revalidate();
					}
				});
		   
	}
	   
	   public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
			g.drawImage(background, 0,0,null);
			
		}
}
