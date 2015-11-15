package nju.ztww.ui.commodity;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

public class ClerkOfCenterCarloadPanel extends JPanel{
	
	private JTextField datatextArea=new JTextField("");
	private  JLabel data=new  JLabel();
	private JTextField businesstextArea=new JTextField("");
	private  JLabel business=new  JLabel();
	private JTextField cartextArea=new JTextField("");
	private  JLabel car=new  JLabel();
	private JTextField arrivetextArea=new JTextField("");
	private  JLabel arrive=new  JLabel();
	private JTextField carNumbertextArea=new JTextField("");
	private  JLabel carNumber=new  JLabel();
	private JTextField jianzhuangtextArea=new JTextField("");
	private  JLabel jianzhuang=new  JLabel();
	private JTextField yayuntextArea=new JTextField("");
	private  JLabel yayun=new  JLabel();
	private JTextField orderNumbertextArea=new JTextField("");
	private  JLabel orderNumber=new  JLabel();
	private JTextField moneytextArea=new JTextField("");
	private  JLabel money=new  JLabel();
	
	private JButton addButton=new JButton();
	private JButton sureButton=new JButton("确定");
	DefaultTableModel defaultTableModel ;
	JDialog dlg;
	 JTable table;
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	
	public ClerkOfCenterCarloadPanel(){

		
		final ImageIcon BusinessNumber=new ImageIcon("photo/businessNumberLabel.gif");
		final ImageIcon CarNumber=new ImageIcon("photo/carNumberLabel.gif");
		final ImageIcon Arrive=new ImageIcon("photo/arriveLabel.gif");
		final ImageIcon Car=new ImageIcon("photo/carLabel.gif");
		final ImageIcon Money=new ImageIcon("photo/moneyLabel.gif");
		final ImageIcon Jianzhuang=new ImageIcon("photo/jianzhuangLabel.gif");
		final ImageIcon Yayun=new ImageIcon("photo/yayunLabel.gif");
		final ImageIcon OrderNumber=new ImageIcon("photo/orderNumberLanel.gif");
		ImageIcon add=new ImageIcon("photo/add.gif");
		final ImageIcon dataLable=new ImageIcon("photo/dataLable.gif");

		addButton.setBounds(500, 420, 110, 38);
		addButton.setIcon(add);
		

		this.setLayout(null);

        this.add(addButton);
		Object[][] playerInfo =
			  {
			    { "99", new Integer(66), new Integer(32), new Integer(98),  new Boolean(false),new Integer(32), },
			    { "99", new Integer(82), new Integer(69), new Integer(128), new Boolean(true) ,new Integer(32),}, 
			  };

			  //�ֶ�����
			  String[] Names = { "装车日期", "中转中心汽运编号", "到达地", "车辆代号", "监装员" ,"押运员","订单号","运费"};

			  
			 
			  defaultTableModel = new DefaultTableModel( playerInfo,Names); 
			  table = new JTable( defaultTableModel);       //�ֶ�����
			  Dimension size = table.getTableHeader().getPreferredSize();
		
			  size.height = 30;//�����µı�ͷ�߶�40
			  table.getTableHeader().setPreferredSize(size);
			  table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			//  table.setPreferredScrollableViewportSize(new Dimension( 550,
//			                60));
			  
			  //�󶨹�����
			  JScrollPane scrollPane = new JScrollPane(table);
		      table.setRowHeight(25);
			  scrollPane.setBounds(0, 0, 690, 420);
			  this.add(scrollPane);
			  addButton.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						dlg= new JDialog(); 
						dlg.setSize(new Dimension(350, 550));
			            dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
			            //װ������
			            datatextArea.setBounds(100, 5, 150, 30);
			            data.setIcon(dataLable);
			            data.setBounds(0, 0, 100, 40);
			            //Ӫҵ�����
			            businesstextArea.setBounds(100, 55, 150, 30);
			            business.setIcon(BusinessNumber);
			            business.setBounds(0, 50, 100, 40);
			            //���˱��
			            cartextArea.setBounds(100, 105, 150, 30);
			            car.setIcon(Car);
			            car.setBounds(0, 100, 100, 40);
			            //�����
			            arrivetextArea.setBounds(100, 155, 150, 30);
			            arrive.setIcon(Arrive);
			            arrive.setBounds(0, 150, 100, 40);
			            //��������
			            carNumbertextArea.setBounds(100, 205, 150, 30);
			            carNumber.setIcon(CarNumber);
			            carNumber.setBounds(0, 200, 100, 40);
			            //������
			            orderNumbertextArea.setBounds(100, 255, 150, 30);
			            orderNumber.setIcon(OrderNumber);
			            orderNumber.setBounds(0, 250, 100, 40);
			            //��װԱ
			            jianzhuangtextArea.setBounds(100, 305, 150, 30);
			            jianzhuang.setIcon(Jianzhuang);
			            jianzhuang.setBounds(0, 300, 100, 40);
			            //Ѻ��Ա
			            yayuntextArea.setBounds(100, 355, 150, 30);
			            yayun.setIcon(Yayun);
			            yayun.setBounds(0, 350, 100, 40);
			            //�˷�
			            moneytextArea.setBounds(100, 405, 150, 30);
			            money.setIcon(Money);
			            money.setBounds(0, 400, 100, 40);
			            
			            dlg.add(money);
			            dlg.add(moneytextArea);
			            dlg.add(yayun);
			            dlg.add(yayuntextArea);
			            dlg.add(jianzhuang);
			            dlg.add(jianzhuangtextArea);
			            dlg.add(orderNumber);
			            dlg.add(orderNumbertextArea);
			            dlg.add(carNumber);
			            dlg.add(carNumbertextArea);
			            dlg.add(arrive);
			            dlg.add(arrivetextArea);
			            dlg.add(car);
			            dlg.add(cartextArea);
			            dlg.add(data);
			            dlg.add(datatextArea);
			            dlg.add(business);
			            dlg.add(businesstextArea);
			            dlg.add(sureButton);
			            sureButton.setBounds(100, 450, 60, 40);
			            sureButton.addActionListener(listener);
			            
			            dlg.setLayout(null);
						dlg.setVisible(true);
					}
					});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/bbbackground2.gif").getImage();
		g.drawImage(background, 0,0,null);
		
	}
	
	ActionListener listener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//������
			Vector<String> row = new Vector(6);
			row.add(datatextArea.getText());
			row.add(businesstextArea.getText());
			row.add(cartextArea.getText());
			row.add(arrivetextArea.getText());
			row.add(carNumbertextArea.getText());
			row.add(moneytextArea.getText());
			datatextArea.setText("");
			businesstextArea.setText("");
			cartextArea.setText("");
			arrivetextArea.setText("");
			carNumbertextArea.setText("");
			moneytextArea.setText("");
			defaultTableModel.addRow(row);
		    table.revalidate();
		    dlg.dispose();
		    sureButton.removeActionListener(listener);
		}
		
	};
	
}