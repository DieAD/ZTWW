package nju.ztww.ui.finance;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.user.ThemeLabelUI;
//date 11-18 name wh//
public class FinanceUI  {
    JFrame frame ;
    EditPanel searchPanel = new EditSearch();
    EditPanel excelPanel = new EditExcel();
    EditPanel accountPanel = new EditPanel();
    EditPanel paymentPanel = new EditPanel(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},
    	null);
    EditPanel collectionPanel = new EditCollection(new String[]{"收款日期","收款金额","收款快递员","订单条形码"},null);
    EditPanel benefitPanel = new EditBenefit(new String[]{"总收入","总支出","总利润"},null);
    EditPanel businessPanel = new EditBusiness(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},null);
    EditPanel initPanel = new EditInit(new String[]{"账号","创建时间","创建人","是否使用中"},null);

    MenuePanel menuePanel = new MenuePanel();
    EditPerson personInfo = new EditPerson();
    ThemeLabelUI Theme = new ThemeLabelUI();
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
    	paymentPanel.add(paymentPanel.button3);
    	paymentPanel.button1.setIcon(new ImageIcon("photo/submit.png"));
    	personInfo.setVisible(false);
    }
    
    public void setPanelBounds(){
    	menuePanel.setBounds(25, 150, 150, 400);
    	Theme.setBounds(200, 0, 670, 120);
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
    	panelList.add(excelPanel);
    	panelList.add(searchPanel);
    	//-------
    	
    	for(EditPanel p : panelList){
    		p.setBounds(200,120,670,410);
    		//frame.getContentPane().add(p);
    		p.setVisible(false);
    		
    	}
    	personInfo.setOpaque(false);
    	accountPanel.setVisible(true);
    	menuePanel.accountButton.addActionListener(new ListenerTable(frame,accountPanel,panelList,0));
    	menuePanel.paymentButton.addActionListener(new ListenerTable(frame,paymentPanel,panelList,0));
    	menuePanel.collectionButton.addActionListener(new ListenerTable(frame,collectionPanel,panelList,0));
    	menuePanel.benefitButton.addActionListener(new ListenerTable(frame,benefitPanel,panelList,0));
    	menuePanel.businessButton.addActionListener(new ListenerTable(frame,businessPanel,panelList,0));
    	menuePanel.initButton.addActionListener(new ListenerTable(frame,initPanel,panelList,1));
    	menuePanel.personInfoButton.addActionListener(new ListenerTable(frame, personInfo, panelList,0));
    	menuePanel.exportFormButton.addActionListener(new ListenerTable(frame,excelPanel,panelList,0));
    	menuePanel.checkOrderButton.addActionListener(new ListenerTable(frame,searchPanel,panelList,2));
    }
    public FinanceUI(JFrame frame){
    	this.frame = frame;
    	setPanelBounds();
    	setPanelListener();
    	setUp();
    	//setPanelListener();
    }
    
    public ArrayList<JPanel> getPanelList(){
    	//list.add(new JPanel());
    	list.add(Theme);
    	list.add(menuePanel);
    	//list.add(personInfo);
    	for(EditPanel p : panelList){
    		list.add(p);
    	}
    	return list;
    }
    
//    public static void main(String[] args){
//    	new FinanceUI(new JFrame());
//    }
}
