package nju.ztww.ui.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


//最近修改： 王焕 11-17
//date 11-18 name wh
public class Login extends JFrame{ 
	//
	//02501001110
	//
	
	int x = 100;
	int y = 300;
	int iy = 300;
	//
	Image icon1=new ImageIcon("photo2/feidie.png").getImage();
	//Image icon2=new ImageIcon("photo/Login2.png").getImage();
	Border border2 = new LineBorder(new Color(44,76,120), 1, true);
	Border border1 = new LineBorder(new Color(225,225,225),1,true);
	JLabel theme = new JLabel();
	JLabel bg = new JLabel();
	JLabel orderT = new JLabel();
	JLabel idlLabel= new JLabel();
	JLabel passwordLabel = new JLabel();
	JTextField id = new JTextField();
	JPasswordField password = new JPasswordField();
//	JTextField password = new JTextField();
	JLabel loginbButton = new JLabel();
	JTextField order = new JTextField();
	JLabel searchButton = new JLabel();
	GetDate getDate=new GetDate();
	private ListenerUI uiListener;
	public static JFrame frame;
	public static JPanel panel;
	private MoniDelUI moni;
	private Font myfont = new Font("微软雅黑", Font.PLAIN, 18);
	private Color mycolor = new Color(225, 225, 225);
	
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
		
		
//		theme.setIcon(new ImageIcon("photo/system.png"));
//		theme.setBounds(200, 20, 300, 100);
	
		bg.setIcon(new ImageIcon("photo/Login2(1).png"));
		bg.setBounds(0, 0, 900, 600);
		
//		idlLabel.setIcon(new ImageIcon("photo/id.gif"));
		idlLabel.setText("ID:");
		idlLabel.setFont(myfont);
		idlLabel.setForeground(mycolor);
		
		idlLabel.setBounds(585, 170, 120, 40);
		id.setBounds(645, 175, 185, 30);
		
//		passwordLabel.setIcon(new ImageIcon("photo/password.gif"));
		passwordLabel.setText("密码:");
		passwordLabel.setFont(myfont);
		passwordLabel.setForeground(mycolor);
		passwordLabel.setBounds(575, 225, 135, 40);
		password.setBounds(645, 230, 185, 30);
		loginbButton.setIcon(new ImageIcon("photo/login.png"));
		loginbButton.setBounds(760, 280, 80, 30);
		
//		orderT.setIcon(new ImageIcon("photo2/OrderNum.png"));
		orderT.setText("订单号：");
		orderT.setFont(myfont);
		orderT.setForeground(mycolor);
		orderT.setBounds(575, 440, 105, 30);
		panel.add(orderT);
		order.setBounds(665, 440, 170, 30);
		searchButton.setIcon(new ImageIcon("photo/search.png"));
		searchButton.setBounds(760, 490, 80, 30);
		
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
		//panel.add(bg);
		startRun();
		panel.add(bg);
//		moni = new MoniDelUI();
//		moni.setBounds(0, 250, 500, 150);
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
		this.setIconImage(icon1);
		this.setTitle("快递物流信息系统");
//		this.add(moni);
		
		///FRAME = this;
		

		//searchButton.addMouseListener(new Listener_Trace(this));
		//this.removeAll();
		//jframe = this;

		int windowWidth = frame.getWidth();                     //获得窗口宽  
		 int windowHeight = frame.getHeight();                   //获得窗口高  
		 Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包  
		 Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸  
		 int screenWidth = screenSize.width;                     //获取屏幕的宽  
		 int screenHeight = screenSize.height;                   //获取屏幕的高  
		 frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
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
		return psw;/////
		
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

	class Moni implements Runnable{
		JLabel car = new JLabel();
		JLabel home = new JLabel();
		public Moni() {
			// TODO Auto-generated constructor stub
			car.setIcon(new ImageIcon("photo/Lcar.png"));
			home.setIcon(new ImageIcon("photo/Lhome.png"));
			car.setBounds(x, y, 60, 40);
			home.setBounds(320, iy, 60, 40);
			panel.add(car);
			panel.add(home);
			panel.repaint();
		}
		public void run() {
			// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				while(true){
					panel.repaint();
//				car.repaint();
//				home.repaint();
				
//				
//					car.repaint();
//					home.repaint();
					car.setBounds(x, y, 60, 40);
					x+=5;
					if(x>260){
						x=20;
						iy=100;
					}
					if(x>200){
						this.home.setVisible(true);
						iy+=4;
					}else{
						this.home.setVisible(false);
					}
					
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
		}
		
	}
	
	private void startRun(){
//		panel.setBackground(new Color(155,149,134));
//		this.setBackground(null);
//		this.setOpaque(false);
//		panel.setSize(500, 200);
//		panel.setLayout(null);
		Moni m = new Moni();
		Thread t = new Thread(m);
		 t.start();
	}

	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		g.drawImage(icon2, 0, 0, 900, 600, null);
//	}
	public void xiaoGuo(final JPanel panel,final JPanel centerPanel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 20) {
									// 设置面板位置
									currentPanel.setBounds(i, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									panel.setBounds(y, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 20;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}
//
//		if (!list.contains(panel)) {
//			centerPanel.add(panel);// 添加要切换的面板
//		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}

}
