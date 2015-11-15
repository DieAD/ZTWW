package nju.ztww.ui.commodity;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class ClerkOfCenterUi extends JFrame {
	ClerkOfCenterNavigationPanel navigationpanel;
    ClerkOfCenterTopPanel toppanel;
    ClerkOfCenterArriveMidPanel ArriveMidpanel;
    ClerkOfCenterTransferPanel  Transferpanel;
    ClerkOfCenterArriveEndPanel ArriveEndpanel;
    ClerkOfCenterCarloadPanel CarloadPanel;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
	public ClerkOfCenterUi() {
		// TODO Auto-generated constructor stub
		setup();
		setPosition();
		setController();
		setTitle("Worker of Center!");
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-900)/2, (height-600)/2);
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public  void setup(){
		navigationpanel=new ClerkOfCenterNavigationPanel();
		toppanel=new ClerkOfCenterTopPanel();
		ArriveMidpanel=new ClerkOfCenterArriveMidPanel();
		Transferpanel=new ClerkOfCenterTransferPanel();
		ArriveEndpanel=new ClerkOfCenterArriveEndPanel();
		CarloadPanel=new ClerkOfCenterCarloadPanel();
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 0, 210, 600);
		toppanel.setBounds(210, 0, 690, 60);
		ArriveMidpanel.setBounds(210, 60, 690, 480);
		Transferpanel.setBounds(210, 60, 690, 480);
		ArriveEndpanel.setBounds(210, 60, 690, 480);
		CarloadPanel.setBounds(210, 60, 690, 480);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(ArriveMidpanel);
		this.add(Transferpanel);
		this.add(ArriveEndpanel);
		this.add(CarloadPanel);
	}
	public void setController(){
		arraylist.add(ArriveMidpanel);
		arraylist.add(Transferpanel);
		arraylist.add(ArriveEndpanel);
		arraylist.add(CarloadPanel);
		navigationpanel.ArriveMid.addActionListener(new ClerkOfCenterController(this, ArriveMidpanel, arraylist));
		navigationpanel.Transfer.addActionListener(new ClerkOfCenterController(this, Transferpanel, arraylist));
		navigationpanel.ArriveEnd.addActionListener(new ClerkOfCenterController(this, ArriveEndpanel, arraylist));
		navigationpanel.CarLoadbutton.addActionListener(new ClerkOfCenterController(this, CarloadPanel, arraylist));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClerkOfCenterUi();
       
}
}
