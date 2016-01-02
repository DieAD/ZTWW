package nju.ztww.ui.finance;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nju.ztww.service.FinanceService;
import nju.ztww.serviceimpl.FinanceServiceImpl;
import nju.ztww.vo.CollectionVO;
import confligUI.MyLabel;
import confligUI.MyTextField;

public class EditCollection extends EditPanel{
	 private  Header header = new Header();
	 private FinanceService financeService= new FinanceServiceImpl();
	 
     public EditCollection(String[] strings, Object[][] objects) {
		// TODO Auto-generated constructor stub
    	 super( strings, objects);
    	// this.setBackground(new Color(250, 240, 230));
    	 this.scrollPane.setBounds(0, 25, 670, 325);//690->750
    	// this.scrollPane.setBackground(new Color(250, 240, 230));
    	 this.header.setBounds(0, 0, 670, 25);  //690->750
    	 this.add(header);
    	 this.remove(button1);
    	 this.remove(button2);
    	 this.remove(button3);
    	 this.setVisible(false);
	}

//	public void setUp(){
//    	 this.setUp();
//    	 this.scrollPane.setBounds(0, 10, 690, 420);
//     }
     
    public class Header extends JPanel{
    	
    	public MyLabel label1  = new MyLabel("日期：",JLabel.LEFT);
    	public MyLabel label2 = new MyLabel("营业厅编号：",JLabel.LEFT);
    	public JButton button1  = new JButton("");
    	public MyTextField text1 = new MyTextField();
    	public MyTextField text2 = new MyTextField();
    	private Listener listener = new Listener();
    	public Header(){
    		this.setLayout(null);
    		label1.setBounds(0, 0, 80, 25);
    		text1.setBounds(70,0,100,25);
    		label2.setBounds(170,0,100,25);
    		text2.setBounds(260,0,100,25);
    		button1.setBounds(570,0,100,25);
    		button1.setIcon(new ImageIcon("photo2/view.png"));
    		//this.setBackground(new Color(250, 240, 230));
    		label1.setForeground(new Color(255,255,255));
    		label2.setForeground(new Color(255,255,255));
    		this.add(label1);
    		this.add(text1);
    		this.add(label2);
    		this.add(text2);
    		this.add(button1);
    		button1.addActionListener(listener);
    		this.setOpaque(false);
    	}
    	
    	  public class Listener implements ActionListener{

    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				String querydate = text1.getText();
    				String queryholl = text2.getText();
    				ArrayList<CollectionVO> listVO = financeService.queryCollection(querydate,queryholl);
    				for(CollectionVO vo : listVO){
    					tableModel.addRow(new Object[]{new String(vo.date),new Double(vo.money),new String(vo.courierid),new String(vo.orderid)});
    				}
    				//tableModel.addRow(new Object[]{new String("2015/11"),new Integer(100),new String("000002"),new String("00000001")});
    				
    			}
    	    	
    	    }

    }
    
    
  
	
}
