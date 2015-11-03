package nju.ztww.ui.commodity;

import javax.swing.JFrame;

public class StorageUi extends JFrame {
	StorageNavigationPanel navigationpanel;
    TopPanel toppanel;
    OutofStoragePanel sheetpanel;
	public StorageUi() {
		// TODO Auto-generated constructor stub
		setup();
		setPosition();
		setTitle("Worker of Center!");
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public  void setup(){
		navigationpanel=new StorageNavigationPanel();
		toppanel=new TopPanel();
		sheetpanel=new OutofStoragePanel();
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 0, 150, 600);
		toppanel.setBounds(150, 0, 750, 100);
		sheetpanel.setBounds(150, 100, 750, 500);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(sheetpanel);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StorageUi();
       
}
}
