package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import confligUI.MyLabel;
import nju.ztww.dao.AccountDO;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.BenefitVO;

public class EditBenefit extends EditPanel {
    private Header  header = new Header();
    FinanceService fs = new FinanceServiceImpl();
	public EditBenefit(String[] strings, Object[][] objects ){
		
		super(strings,objects);
		this.setBackground(new Color(250, 240, 230));
		this.scrollPane.setBounds(0,25,750,375);   //——by zyz 
		this.header.setBounds(0, 0, 750, 25);
		this.add(header);
		this.remove(button1);
		this.remove(button3);
		button2.setIcon(new ImageIcon("photo/update.png"));
//		button2.setText("更新");
		button2.addActionListener(new Listener());
		this.add(button2);
		}
	
	class Header extends JPanel{
		MyLabel label1 = new MyLabel();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String info = "截止"+df.format(new Date())+"成本收益表为：";
	    public Header(){
	    	this.add(label1);
	    	label1.setText(info);
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
