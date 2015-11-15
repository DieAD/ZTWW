package nju.ztww.ui.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	JLabel theme = new JLabel();
	JLabel bg = new JLabel();
	JLabel idlLabel= new JLabel();
	JLabel passwordLabel = new JLabel();
	JTextField id = new JTextField();
	JTextField password = new JTextField();
	JLabel loginbButton = new JLabel();
	JTextField order = new JTextField();
	JLabel searchButton = new JLabel();
	
	public Login(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(900, 600);
		this.setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBounds(0, 0, 900, 600);
		this.add(panel);
		
		theme.setIcon(new ImageIcon("photo/system.png"));
		theme.setBounds(200, 20, 300, 100);
	
		bg.setIcon(new ImageIcon("photo/bg.gif"));
		bg.setBounds(0, 0, 900, 600);
		
		idlLabel.setIcon(new ImageIcon("photo/id.gif"));
		idlLabel.setBounds(250, 190, 120, 40);
		id.setBounds(380, 200, 150, 30);
		
		passwordLabel.setIcon(new ImageIcon("photo/password.gif"));
		passwordLabel.setBounds(250, 260, 120, 40);
		password.setBounds(380, 270, 150, 30);
		loginbButton.setIcon(new ImageIcon("photo/login.gif"));
		loginbButton.setBounds(550, 270, 120, 30);
		
		order.setBounds(350, 370, 200, 30);
		searchButton.setIcon(new ImageIcon("photo/searchOrder.gif"));
		searchButton.setBounds(570, 370, 120, 30);
		panel.add(theme);
		panel.add(idlLabel);	
		panel.add(id);
		panel.add(passwordLabel);
		panel.add(password);
		panel.add(loginbButton);
		panel.add(order);
		panel.add(searchButton);
		panel.add(bg);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
