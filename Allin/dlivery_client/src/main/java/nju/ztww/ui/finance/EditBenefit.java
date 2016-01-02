package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.bl.finance.ExcelHelper;
import nju.ztww.dao.AccountDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.BenefitVO;
import confligUI.MyLabel;

public class EditBenefit extends EditPanel {
    private Header  header = new Header();
    FinanceService fs = new FinanceServiceImpl();
    
	public EditBenefit(String[] strings, Object[][] objects ){
		
		super(strings,objects);
		this.setBackground(new Color(250, 240, 230));
		this.scrollPane.setBounds(0,25,670,325);   //——by zyz 
		this.header.setBounds(0, 0, 670, 25);
//		button4.setBounds(50, 370, 80, 30);
//		this.add(button4);
		this.add(header);
		this.remove(button1);
		this.remove(button3);
		button2.setIcon(new ImageIcon("photo2/update.png"));
//		button2.setText("更新");
		button2.addActionListener(new Listener());
		this.add(button2);
		}
	
	class Header extends JPanel{
		MyLabel label1 = new MyLabel();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String info = "截止"+df.format(new Date())+"成本收益表为：";
		JButton button4 = new JButton("");
	    public Header(){
	    	this.setLayout(null);
	    	label1.setBounds(0, 0, 550, 25);
	    	this.add(label1);
	    	label1.setText(info);
	    	label1.setForeground(new Color(255,255,255));
	    	this.setOpaque(false);
	    	button4.setBounds(570, 0, 100, 25);
	    	button4.setIcon(new ImageIcon("photo2/ExportForms.png"));
	    	this.add(button4);
	    	button4.addActionListener(new Listener(this,0));
	    }
	    public class Listener implements ActionListener{
	        int index;
	        JPanel panel;
	        public Listener(JPanel panel,int index){
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String info = "截止"+df.format(new Date())+"成本收益表为：";
		header.label1.setText(info);
		BenefitVO benefitVO= fs.getBenefit();
		tableModel.removeRow(0);
		tableModel.addRow(new Object[]{new Double(benefitVO.totalCollection),new Double(benefitVO.totalPayment),new Double(benefitVO.totalBenefit)});
		AccountDO account  = new AccountDO();
		account.setRemain(benefitVO.totalBenefit);
		fs.updateAccount(account);
	}
	   
   }
}
