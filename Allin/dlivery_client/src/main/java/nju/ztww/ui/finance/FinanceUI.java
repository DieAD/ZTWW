package nju.ztww.ui.finance;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.user.PersonalMesageUI;
//date 11-18 name wh//
public class FinanceUI  {
    JFrame frame ;
    EditPanel accountPanel = new EditPanel();
    EditPanel paymentPanel = new EditPanel(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),
    	new String("000000001"),new String("人员工资"),new String("11月")}});
    EditPanel collectionPanel = new EditCollection(new String[]{"收款日期","收款金额","收款快递员","订单条形码"},new Object[][]{{new String("2015/11"),new Double(100),new String("000002"),new String("00000001")}});
    EditPanel benefitPanel = new EditBenefit(new String[]{"总收入","总支出","总利润"},new Object[][]{{new Double(2222.3),new Double("333.2"),new Double("0000.2")}});
    EditPanel businessPanel = new EditBusiness(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),new String("000000001"),new String("人员工资"),new String("11月")}});
    EditPanel initPanel = new EditInit(new String[]{"账号","创建时间","创建人","是否使用中"},new Object[][]{{new String("000001"),new String("2014/1"),new String("manager"),new String("是")}});
    HeaderPanel headerPanel = new HeaderPanel();
    MenuePanel menuePanel = new MenuePanel();
    EditPerson personInfo = new EditPerson();
    ArrayList<EditPanel> panelList = new ArrayList<EditPanel>();
    //modify
    private ArrayList<JPanel> list = new ArrayList<JPanel>();
    
    
    public void setUp(){
//    	frame.setSize(900, 600);
//		frame.setTitle("Bussiness");
//		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
//		frame.setLocation((width-900)/2, (height-600)/2);
//		frame.setResizable(false);
//		//add panel;
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(accountPanel);
//		frame.getContentPane().add(headerPanel);
//		frame.getContentPane().add(menuePanel);
//		frame.setVisible(true);
    	personInfo.setVisible(false);
    }
    
    public void setPanelBounds(){
    	menuePanel.setBounds(0, 100, 150, 500);
    	headerPanel.setBounds(150, 0, 750, 60);
    	personInfo.setBounds(150, 100, 750, 450);
    	//
//    	accountPanel.setBounds(210,60,690,480);
//    	paymentPanel.setBounds(210,60,690,480);
    }
    public void setPanelListener(){
    	//dialog button;
        paymentPanel.button3.addActionListener(new ListenerDialog(new Dialog(paymentPanel)));
        paymentPanel.button1.addActionListener(new ListenerPull(paymentPanel));
        accountPanel.button1.addActionListener(accountPanel.Accountlistener);
    	//menuebutton
    	panelList.add(accountPanel);
    	panelList.add(paymentPanel);
    	panelList.add(collectionPanel);
    	panelList.add(benefitPanel);
    	panelList.add(businessPanel);
    	panelList.add(initPanel);
    	panelList.add(personInfo);
    	//-------
    	
    	for(EditPanel p : panelList){
    		p.setBounds(150,100,750,450);
    		//frame.getContentPane().add(p);
    		//p.setVisible(false);
    		
    	}
    	menuePanel.accountButton.addActionListener(new ListenerTable(frame,accountPanel,panelList));
    	menuePanel.paymentButton.addActionListener(new ListenerTable(frame,paymentPanel,panelList));
    	menuePanel.collectionButton.addActionListener(new ListenerTable(frame,collectionPanel,panelList));
    	menuePanel.benefitButton.addActionListener(new ListenerTable(frame,benefitPanel,panelList));
    	menuePanel.businessButton.addActionListener(new ListenerTable(frame,businessPanel,panelList));
    	menuePanel.initButton.addActionListener(new ListenerTable(frame,initPanel,panelList));
    	menuePanel.personInfoButton.addActionListener(new ListenerTable(frame, personInfo, panelList));
    }
    public FinanceUI(JFrame frame){
    	this.frame = frame;
    	setPanelBounds();
    	setPanelListener();
    	setUp();
    	//setPanelListener();
    }
    
    public ArrayList<JPanel> getPanelList(){
    	list.add(headerPanel);
    	list.add(menuePanel);
    	list.add(personInfo);
    	for(EditPanel p : panelList){
    		list.add(p);
    	}
    	return list;
    }
    
//    public static void main(String[] args){
//    	new FinanceUI(new JFrame());
//    }
}
