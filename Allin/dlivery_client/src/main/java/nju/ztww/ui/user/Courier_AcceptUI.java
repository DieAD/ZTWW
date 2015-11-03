package nju.ztww.ui.user;

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

public class Courier_AcceptUI extends JPanel{

	JButton searchButton = new JButton();
	JDialog searchDlg = new JDialog();
	JTable table = new JTable();
	
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public Courier_AcceptUI(){
		this.setLayout(null);
		{/*for Button*/
			searchButton.setBounds(500, 420, 110, 38);
			searchButton.setIcon(new ImageIcon("photo/search.gif"));
			this.add(searchButton);
			searchButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// to add a dialog to complete
					//very important
					//including a textfield
			
				}
				
			});
			
		}
		
		
		{/* for Table*/
			Object[][] Accept = 
				{
					{"H12", "123455", "Jerry", "2015/11/2  14:00", "123456789"}
				};
			String[] names = {"营业厅编号", "收件信息编号", "收件人", "收件时间", "快递员编号"};
		
		table = new JTable(new DefaultTableModel(Accept, names));
		Dimension size = table.getTableHeader().getPreferredSize();		//??
		
		size.height = 30;
		table.getTableHeader().setPreferredSize(size);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(25);
		scrollPane.setBounds(0, 0, 690, 420);
		this.add(scrollPane);
		}
	}
}
