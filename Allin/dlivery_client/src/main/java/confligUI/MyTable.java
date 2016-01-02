package confligUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MyTable extends JTable{
	Font myFont = new Font("微软雅黑", Font.PLAIN, 12);
	public MyTable(DefaultTableModel defaultTableModel){
		super(defaultTableModel);
		Dimension size = this.getTableHeader().getPreferredSize();	
		size.height = 30;
		this.getTableHeader().setPreferredSize(size);
		this.getTableHeader().setFont(myFont);
		this.getTableHeader().setForeground(new Color(225,225,225));
		this.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		this.setRowHeight(25);	
		this.getTableHeader().setBackground(new Color(44,76,120));//208,168,125
		//this.setBackground(new Color(208,168,125)); //226,203,170
		this.setFont(myFont);
//		this.setSelectionBackground(Color.black); 
//		this.setSelectionForeground(Color.blue);
		//this.setGridColor(Color.black);
		this.setBorder(null);
		this.setShowGrid(false);
		paintRow();
	}
	
	 public MyTable(Model tableModel) {
		// TODO Auto-generated constructor stub
		 super(tableModel);
			Dimension size = this.getTableHeader().getPreferredSize();	
			size.height = 30;
			this.getTableHeader().setPreferredSize(size);
			this.getTableHeader().setFont(myFont);
			this.getTableHeader().setForeground(new Color(225,225,225));
			this.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			
			this.setRowHeight(25);	
			this.getTableHeader().setBackground(new Color(44,76,120));//208,168,125
			//this.setBackground(new Color(208,168,125)); //226,203,170
			this.setFont(myFont);
//			this.setSelectionBackground(Color.black); 
//			this.setSelectionForeground(Color.blue);
			//this.setGridColor(Color.black);
			this.setBorder(null);
			this.setShowGrid(false);
			paintRow();
	}

	public void paintRow() 
	    {
	        TableColumnModel tcm = this.getColumnModel();
	        for (int i = 0, n = tcm.getColumnCount(); i < n; i++) 
	        {
	            TableColumn tc = tcm.getColumn(i);
	            tc.setCellRenderer(new RowRenderer());
	        }
	    }
	 private class RowRenderer extends DefaultTableCellRenderer 
	    {
	        public Component getTableCellRendererComponent(JTable t, Object value,
	                    boolean isSelected, boolean hasFocus, int row, int column) 
	        {
	            //设置奇偶行的背景色，可在此根据需要进行修改
	            if (row % 2 == 0)
	                setBackground(new Color(253,254,254));
	            else
	                setBackground(new Color(149,165,166));
	    
	            return super.getTableCellRendererComponent(t, value, isSelected,
	                    hasFocus, row, column);
	        }
	    }
	 
//	 public void paintComponent(Graphics g){
//		 super.paintComponent(g);
//		 Image background=new ImageIcon("photo2/graybg.png").getImage();
//			g.drawImage(background, 0,0,null);
//	 }
	
}
