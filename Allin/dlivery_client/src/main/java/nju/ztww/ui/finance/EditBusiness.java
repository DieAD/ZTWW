package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import confligUI.MyComboBox;
import confligUI.MyLabel;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.PaymentVO;

public class EditBusiness extends EditPanel{
	FinanceService fs = new FinanceServiceImpl();
    Header header = new Header();
    MyLabel label1 = new MyLabel("付款单：",JLabel.LEFT);
    MyLabel label2 = new MyLabel("收款单：",JLabel.LEFT);
    EditPanel scrollPanel2 = new EditPanel(new String[]{"收款日期","收款金额","收款快递员","订单条形码"},new Object[][]{{new String("2015/11"),new Integer(100),new String("000002"),new String("00000001")}});
	public EditBusiness(String[] strings,Object[][] objects){
		super(strings,objects);
		this.setBackground(new Color(250, 240, 230));
		scrollPanel2.remove(button1);
		scrollPanel2.remove(button2);
		scrollPanel2.remove(button3);
		
		header.setBounds(0, 0, 690, 25);
		label1.setBounds(0, 25, 690, 25);
		label2.setBounds(0,225,690,25);
		this.scrollPane.setBounds(0, 50, 690, 175);
		scrollPanel2.setBounds(0, 250, 690, 175);
		
		this.scrollPane.setBackground(new Color(250, 240, 230));
		scrollPanel2.setBackground(new Color(250, 240, 230)); //by zyz
		
		this.add(header);
		this.add(label1);
		this.add(label2);
		this.add(scrollPanel2);
		
		
		
		this.remove(button1);
		this.remove(button2);
		this.remove(button3);
	}
	
	
	
	class Header extends JPanel {
		public MyLabel label1  = new MyLabel("开始时间：",JLabel.CENTER);
    	public MyLabel label2 = new MyLabel("结束时间：",JLabel.CENTER);
    	public JButton button1  = new JButton("查看");
    	public JTextField text1 = new JTextField();
    	public JTextField text2 = new JTextField();
    	public MyComboBox jbox1;
    	public MyComboBox jbox2;
    	public String[] startTime = {"15/11/23","15/11/24","15/11/25","15/11/26"};
    	public String[] endTime = {"15/11/23","15/11/24","15/11/26"};
    	public Header(){
    		jbox1 =   new MyComboBox(startTime);
    		jbox2 = new MyComboBox(endTime);
    		this.setLayout(new GridLayout(1,5));
    		this.add(label1);
    		//this.add(text1);
    		this.add(jbox1);
    		this.add(label2);
    		//this.add(text2);
    		this.add(jbox2);
    		this.add(button1);
    		button1.addActionListener(new Listener());
    	}
	}
	
	
	public class Listener implements ActionListener{
		

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String beginTime = (String)header.jbox1.getSelectedItem();
			String endTime   = (String)header.jbox2.getSelectedItem();
			ArrayList<PaymentVO> list1 = fs.queryPCP(beginTime, endTime, "001");
			ArrayList<CollectionVO> list2 = fs.queryPCC(beginTime, endTime, "001");
			int count = tableModel.getRowCount();
			for(int i=0;i<count;i++){
				tableModel.removeRow(0);
			}
			for(PaymentVO vo : list1){
				tableModel.addRow(new Object[]{new String(vo.date),new Double(vo.money),new String(vo.paymen),
    	new String(vo.payaccount),new String(vo.paycat),new String(vo.ps)});
			}
			count = scrollPanel2.tableModel.getRowCount();
			for(int i=0;i<count;i++){
				scrollPanel2.tableModel.removeRow(0);
			}
			for(CollectionVO vo : list2){
				scrollPanel2.tableModel.addRow(new Object[]{new String(vo.date),new Double(vo.money),new String(vo.courierid),new String(vo.orderid)});
			}
			
		}
		
	}
	
}
