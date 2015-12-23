package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import confligUI.MyTextField;


//最近修改： 王焕 11-17
//date 11-18 name wh
public class Login extends JFrame{ 
	//
	//02501001110
	//
	Border border1 = new LineBorder(new Color(232,181,53), 1, true);
	Border border2 = new LineBorder(new Color(155,122,90),1,true);
	JLabel theme = new JLabel();
	JLabel bg = new JLabel();
	JLabel idlLabel= new JLabel();
	JLabel passwordLabel = new JLabel();
	JTextField id = new JTextField();
	JPasswordField password = new JPasswordField();
//	JTextField password = new JTextField();
	JLabel loginbButton = new JLabel();
	JTextField order = new JTextField();
	JLabel searchButton = new JLabel();
	private ListenerUI uiListener;
	public static JFrame frame;
	public static JPanel panel;
	private MoniDelUI moni;
	
	public Login(){
		
		frame = this;
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(900, 600);
		this.setResizable(false);
		this.setFocusable(true);
	    panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBounds(0, 0, 900, 600);
		
		
		theme.setIcon(new ImageIcon("photo/system.png"));
		theme.setBounds(200, 20, 300, 100);
	
		bg.setIcon(new ImageIcon("photo/LoginBG.png"));
		bg.setBounds(0, 0, 900, 600);
		
		idlLabel.setIcon(new ImageIcon("photo/id.gif"));
		idlLabel.setBounds(505, 140, 120, 40);
		id.setBounds(635, 150, 150, 30);
		
		passwordLabel.setIcon(new ImageIcon("photo/password.gif"));
		passwordLabel.setBounds(505, 210, 120, 40);
		password.setBounds(635, 220, 150, 30);
		loginbButton.setIcon(new ImageIcon("photo/login1.png"));
		loginbButton.setBounds(790, 210, 50, 50);
		
		order.setBounds(585, 320, 200, 30);
		searchButton.setIcon(new ImageIcon("photo/searchOrder.gif"));
		searchButton.setBounds(790, 320, 120, 30);
		
		id.setBorder(border1);
		id.addMouseListener(ad1);
		password.setBorder(border1);
		password.addMouseListener(ad2);
		
		order.setBorder(border1);
		order.addMouseListener(ad3);
		panel.add(theme);
		panel.add(idlLabel);	
		panel.add(id);
		panel.add(passwordLabel);
		panel.add(password);
		panel.add(loginbButton);
		panel.add(order);
		panel.add(searchButton);
		panel.add(bg);
		
		moni = new MoniDelUI();
		moni.setBounds(0, 200, 400, 400);
		uiListener = new ListenerUI(this);
		loginbButton.addMouseListener(uiListener);
		searchButton.addMouseListener(new Listener_Trace(this));
		password.addKeyListener(new KeyAdapter() {

			public void keyPressed(final KeyEvent e) {

				if (e.getKeyCode() == 10)
					uiListener.switchUI();
			}
		});
		
		//移动了 add() setVisible 方法
		this.add(panel);
		this.setVisible(true);
		this.getContentPane().repaint();
		this.add(moni);
		
		///FRAME = this;
		

		//searchButton.addMouseListener(new Listener_Trace(this));
		//this.removeAll();
		//jframe = this;

	}
	
	
	
	public ListenerUI getUiListener() {
		return uiListener;
	}



	public void setUiListener(ListenerUI uiListener) {
		this.uiListener = uiListener;
	}



	public String getID(){
		return id.getText();
	}
	
	public String getPassword(){
		//password.setText("");   //by zyz at 11/22
		String psw = new String(password.getPassword());
		password.setText("");
		return psw;
		
	}
	public static void main(String[] args) {
		new Login();
	}
	
	MouseListener ad1 = new MouseListener() {
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.id.setBorder(border1);
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.id.setBorder(border2);
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	};

	MouseListener ad2 = new MouseListener() {
		
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.password.setBorder(border1);
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.password.setBorder(border2);
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	MouseListener ad3 = new MouseListener() {
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.order.setBorder(border1);
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Login.this.order.setBorder(border2);
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	};

	
	
	

}
