package nju.ztww.ui.commodity;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StorageUi extends JFrame {
	StorageNavigationPanel navigationpanel;
    TopPanel toppanel;
    OutofStoragePanel outofStoragepanel;
    InofStoragePanel  inofStoragepanel;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
	public StorageUi() {
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
		navigationpanel=new StorageNavigationPanel();
		toppanel=new TopPanel();
		outofStoragepanel=new OutofStoragePanel();
		inofStoragepanel=new InofStoragePanel();
		
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 0, 150, 600);
		toppanel.setBounds(150, 0, 750, 100);
		outofStoragepanel.setBounds(150, 100, 750, 500);
		inofStoragepanel.setBounds(150, 100, 750, 500);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(outofStoragepanel);
		this.add(inofStoragepanel);
		
	}
	public void setController(){
		arraylist.add(outofStoragepanel);
		arraylist.add(inofStoragepanel);
		navigationpanel.Inbutton.addActionListener(new StorageControllerUi(this, inofStoragepanel, arraylist));
		navigationpanel.Outbutton.addActionListener(new StorageControllerUi(this, outofStoragepanel, arraylist));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StorageUi();
       
}
}
