package nju.ztww.ui.user;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.service_stub.UserService_stub;
import nju.ztww.vo.OrderVO;
import nju.ztww.vo.StateVO;

public class UserGuiTest extends JFrame {
    private String message;
    private JPanel panel;
    private JTextField input;
    private JButton submitButton;
    private JLabel infoLabel;
    private TextArea textArea;
    private Container contentPane;
    private UserService_stub userbl = new UserService_stub();
    public UserGuiTest(){
    	super("UserGuiTest");
        contentPane = this.getContentPane();
    	contentPane.setLayout(new BorderLayout());
    }
    
    public void setJPanel(){
        panel = new JPanel();
    	panel.setLayout(new GridLayout(3,1));
    	panel.setSize(50, 30);
    	panel.setBorder(BorderFactory.createTitledBorder("JTextField事件处理范例"));
    	
    	input = new JTextField();
    	submitButton = new JButton("submit");
    	textArea = new TextArea("");
    	submitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrderVO order = userbl.checkOrder(input.getText());
				StateVO stateVO = (StateVO)order;
				textArea.setText(stateVO.getCurrentPlace()+"\n"+stateVO.getHistoryPlace()+"\n");
				//infoLabel.setText(stateVO.getHistoryPlace()+"\n");
			}
    		
    	});
    	
    	panel.add(input);
    	panel.add(submitButton);
    	panel.add(textArea);
    	
    }
    
    public void initJFrame(){
    	this.contentPane.add(panel);
    	this.pack();
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args){
    	UserGuiTest user = new UserGuiTest();
        user.setJPanel();
        user.initJFrame();
    	
    
    	
    	
    	
    }
}
