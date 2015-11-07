package nju.ztww.ui.finance;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FinanceUI  {
    JFrame frame = new JFrame("Finance");
    EditPanel accountPanel = new EditPanel();
    EditPanel paymentPanel = new EditPanel(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),
    	new String("000000001"),new String("人员工资"),new String("11月")}});
    EditPanel collectionPanel = new EditCollection(new String[]{"收款日期","收款金额","收款快递员","订单条形码"},new Object[][]{{new String("2015/11"),new Integer(100),new String("000002"),new String("00000001")}});
    EditPanel benefitPanel = new EditBenefit(new String[]{"总收入","总支出","总利润"},new Object[][]{{new Double(2222.3),new Double("333.2"),new Double("0000.2")}});
    EditPanel businessPanel = new EditBusiness(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),new String("000000001"),new String("人员工资"),new String("11月")}});
    EditPanel initPanel = new EditInit(new String[]{"账号","创建时间","创建人","是否使用中"},new Object[][]{{new String("000001"),new String("2014/1"),new String("manager"),new String("是")}});
    HeaderPanel headerPanel = new HeaderPanel();
    MenuePanel menuePanel = new MenuePanel();
    ArrayList<EditPanel> panelList = new ArrayList<EditPanel>();
    
    
    public void setUp(){
    	frame.setSize(900, 600);
		frame.setTitle("Bussiness");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setLocation((width-900)/2, (height-600)/2);
		frame.setResizable(false);
		//add panel;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.getContentPane().add(accountPanel);
		frame.getContentPane().add(headerPanel);
		frame.getContentPane().add(menuePanel);
		frame.setVisible(true);
    }
    
    public void setPanelBounds(){
    	menuePanel.setBounds(0, 0, 210, 600);
    	headerPanel.setBounds(210, 0, 690, 60);
    	//
//    	accountPanel.setBounds(210,60,690,480);
//    	paymentPanel.setBounds(210,60,690,480);
    }
    public void setPanelListener(){
    	//dialog button;
        accountPanel.button3.addActionListener(new ListenerDialog(new Dialog()));
    	//menuebutton
    	panelList.add(accountPanel);
    	panelList.add(paymentPanel);
    	panelList.add(collectionPanel);
    	panelList.add(benefitPanel);
    	panelList.add(businessPanel);
    	panelList.add(initPanel);
    	for(EditPanel p : panelList){
    		p.setBounds(210,60,690,520);
    		frame.getContentPane().add(p);
    		
    	}
    	menuePanel.accountButton.addActionListener(new ListenerTable(frame,accountPanel,panelList));
    	menuePanel.paymentButton.addActionListener(new ListenerTable(frame,paymentPanel,panelList));
    	menuePanel.collectionButton.addActionListener(new ListenerTable(frame,collectionPanel,panelList));
    	menuePanel.benefitButton.addActionListener(new ListenerTable(frame,benefitPanel,panelList));
    	menuePanel.businessButton.addActionListener(new ListenerTable(frame,businessPanel,panelList));
    	menuePanel.initButton.addActionListener(new ListenerTable(frame,initPanel,panelList));
    }
    public FinanceUI(){
    	setPanelBounds();
    	setPanelListener();
    	setUp();
    	//setPanelListener();
    }
    
    public static void main(String[] args){
    	new FinanceUI();
    }
}
