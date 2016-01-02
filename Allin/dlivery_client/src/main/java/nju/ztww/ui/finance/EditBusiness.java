package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.bl.finance.ExcelHelper;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.BenefitVO;
import nju.ztww.vo.CollectionVO;
import nju.ztww.vo.PaymentVO;
import confligUI.MyComboBox;
import confligUI.MyLabel;

public class EditBusiness extends EditPanel{
	FinanceService fs = new FinanceServiceImpl();
    Header header = new Header();
    MyLabel label1 = new MyLabel("付款单：",JLabel.LEFT);
    MyLabel label2 = new MyLabel("收款单：",JLabel.LEFT);
    EditPanel scrollPanel2 = new EditPanel(new String[]{"收款日期","收款金额","收款快递员","订单条形码"},null);
	public EditBusiness(String[] strings,Object[][] objects){
		super(strings,objects);
		this.setBackground(new Color(250, 240, 230));
		scrollPanel2.remove(button1);
		scrollPanel2.remove(button2);
		scrollPanel2.remove(button3);
		
		header.setBounds(0, 0, 670, 25);
		label1.setBounds(0, 25, 670, 25);
		label1.setForeground(new Color(255,255,255));
		label2.setBounds(0,225,670,25);
		label2.setForeground(new Color(255,255,255));
		this.scrollPane.setBounds(0, 50, 670, 175);
		scrollPanel2.setBounds(0, 250, 670, 160);
		scrollPanel2.setOpaque(false);
//		this.scrollPane.setBackground(new Color(250, 240, 230));
//		scrollPanel2.setBackground(new Color(250, 240, 230)); //by zyz
		
		this.add(header);
		this.add(label1);
		this.add(label2);
		this.add(scrollPanel2);
		
		
		
		this.remove(button1);
		this.remove(button2);
		this.remove(button3);
	}
	
	
	
	class Header extends JPanel {
		public MyLabel label1  = new MyLabel("开始时间：",JLabel.LEFT);
    	public MyLabel label2 = new MyLabel("结束时间：",JLabel.LEFT);
    	public JButton button1  = new JButton();
    	public JTextField text1 = new JTextField();
    	public JTextField text2 = new JTextField();
        public JButton button2 = new JButton();
    	public MyComboBox jbox1;
    	public MyComboBox jbox2;
    	public String[] startTime = {"15/11/23","15/11/24","15/11/25","15/11/26"};
    	public String[] endTime = {"15/11/23","15/11/24","15/11/26"};
    	public Header(){
    		button1.setIcon(new ImageIcon("photo2/view.png"));
    		button2.setIcon(new ImageIcon("photo2/ExportForms.png"));
    		jbox1 =   new MyComboBox(startTime);
    		jbox2 = new MyComboBox(endTime);
    		this.setLayout(null);
    		label1.setBounds(0,0,80,25);
    		jbox1.setBounds(70,0,110,25);
    		label2.setBounds(220, 0, 80, 25);
    		jbox2.setBounds(290, 0, 110, 25);
    		button1.setBounds(420, 0, 100, 25);
    		button2.setBounds(550, 0, 100, 25);
    		label1.setForeground(new Color(255,255,255));
    		label2.setForeground(new Color(255,255,255));
    		this.add(label1);
    		//this.add(text1);
    		this.add(jbox1);
    		this.add(label2);
    		//this.add(text2);
    		this.add(jbox2);
    		this.add(button1);
    		this.add(button2);
    		this.setOpaque(false);
    		button1.addActionListener(new Listener());
    		button2.addActionListener(new Listener2(this,1));
    	}
    	public class Listener2 implements ActionListener{
            int index;
            JPanel panel;
            public Listener2(JPanel panel,int index){
            	this.panel = panel;
            	this.index = index;
            }
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(index==1){
    			FinanceService  fs = new FinanceServiceImpl();
    			fs.exportExcel(index);}
    			else{
    				special();
    			}
    			new DialogInfo().show();
    		}
    		
    		public void special(){
    			FinanceService  fs = new FinanceServiceImpl();
    			BenefitVO benefitVO= fs.getBenefit();
    			ExcelHelper helper = new ExcelHelper();
    			helper.BusinessToExcel(benefitVO.totalCollection, benefitVO.totalPayment,benefitVO.totalBenefit);
    			
    		}
    		
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
