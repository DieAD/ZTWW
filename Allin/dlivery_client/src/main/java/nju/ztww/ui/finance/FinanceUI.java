package nju.ztww.ui.finance;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FinanceUI  {
    JFrame frame = new JFrame("Finance");
    EditPanel accountPanel = new EditPanel();
    EditPanel benefitPanel = new EditPanel(new String[]{"付款日期","付款金额","付款人","付款账号","条目","备注"},new Object[][]{{new String("2015/11/1"),new Double(35.5),new String("Manager"),
    	new String("000000001"),new String("人员工资"),new String("11月")}});
    
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
    	accountPanel.setBounds(210,60,690,480);
    	benefitPanel.setBounds(210,60,690,480);
    }
    public void setPanelListener(){
    	//dialog button;
        accountPanel.button3.addActionListener(new ListenerDialog(new Dialog()));
    	//menuebutton
    	panelList.add(accountPanel);
    	panelList.add(benefitPanel);
    	for(EditPanel p : panelList){
    		frame.getContentPane().add(p);
    	}
    	menuePanel.accountButton.addActionListener(new ListenerTable(frame,accountPanel,panelList));
    	menuePanel.benefitButton.addActionListener(new ListenerTable(frame,benefitPanel,panelList));
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
