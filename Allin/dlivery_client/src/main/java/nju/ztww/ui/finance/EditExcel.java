package nju.ztww.ui.finance;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.bl.finance.ExcelHelper;
import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.BenefitVO;

public class EditExcel extends EditPanel {

	JButton button1 = new JButton();
	JButton button2 = new JButton();
	public EditExcel(){
		this.removeAll();
		init();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image lable=new ImageIcon("photo/outBK.gif").getImage();
		g.drawImage(lable, 0,0,null);
		
	}
	public void init(){
		ImageIcon image1 = new ImageIcon("photo/ExportBenefitForm.png");
		ImageIcon image2 = new ImageIcon("photo/ExportBusinessForm.png");
		button1.setBounds(260, 55, 140,35 );
		button1.setIcon(image2);
		button2.setBounds(260,115,140,35);
		button2.setIcon(image1);
		button1.addActionListener(new Listener(this,1));
		button2.addActionListener(new Listener(this,2));
		this.add(button1);
		this.add(button2);
	}
	//--------------------------------------------
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
