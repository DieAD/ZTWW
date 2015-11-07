package nju.ztww.ui.commodity;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class ClerkOfCenterUi extends JFrame {
	ClerkOfCenterNavigationPanel navigationpanel;
    ClerkOfCenterTopPanel toppanel;
    ClerkOfCenterPlanePanel Planepanel;
    ClerkOfCenterBusPanel  Buspanel;
    ClerkOfCenterTrainPanel Trainpanel;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
	public ClerkOfCenterUi() {
		// TODO Auto-generated constructor stub
		setup();
		setPosition();
		setController();
		setTitle("Worker of Center!");
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public  void setup(){
		navigationpanel=new ClerkOfCenterNavigationPanel();
		toppanel=new ClerkOfCenterTopPanel();
		Planepanel=new ClerkOfCenterPlanePanel();
		Buspanel=new ClerkOfCenterBusPanel();
		Trainpanel=new ClerkOfCenterTrainPanel();
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 0, 150, 600);
		toppanel.setBounds(150, 0, 750, 100);
		Planepanel.setBounds(150, 100, 750, 500);
		Buspanel.setBounds(150, 100, 750, 500);
		Trainpanel.setBounds(150, 100, 750, 500);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(Planepanel);
		this.add(Buspanel);
		this.add(Trainpanel);
		
	}
	public void setController(){
		arraylist.add(Planepanel);
		arraylist.add(Buspanel);
		arraylist.add(Trainpanel);
		navigationpanel.Planebutton.addActionListener(new ClerkOfCenterController(this, Planepanel, arraylist));
		navigationpanel.Busbutton.addActionListener(new ClerkOfCenterController(this, Buspanel, arraylist));
		navigationpanel.Trainbutton.addActionListener(new ClerkOfCenterController(this, Trainpanel, arraylist));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClerkOfCenterUi();
       
}
}
