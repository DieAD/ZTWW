package nju.ztww.ui.commodity;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nju.ztww.ui.main.ListenerEndUI;
import nju.ztww.ui.main.Listener_Return;
//date 11-18 name wh
//需要根据中转中心业务员身份知道中转中心的id
public class StorageUi extends JFrame implements Runnable{
	StorageNavigationPanel navigationpanel;
    TopPanel toppanel;
    OutofStoragePanel outofStoragepanel;
    InofStoragePanel  inofStoragepanel;
    StorageCheckPanel storagecheckpanel;
    StoragePanPanel storagepanpanel;
    StorageTiaoPanel storagetiaopanel;
    StorageBaoJingPanel storagebaojingpanel;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
    //modify
    private ArrayList<JPanel> list = new ArrayList<JPanel>();
    
	public StorageUi() {

		// TODO Auto-generated constructor stub
//		setup();
//		setPosition();
//		setController();

//		 TODO Auto-generated constructor stub
		setup();
		setPosition();
		setController();
//
//		setTitle("Worker of Center!");
//		setSize(900,600);		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public  void setup(){
		Thread tishibaojing=new Thread(this);
		navigationpanel=new StorageNavigationPanel();
		toppanel=new TopPanel();
		outofStoragepanel=new OutofStoragePanel();
		inofStoragepanel=new InofStoragePanel();
		storagecheckpanel=new StorageCheckPanel();
		storagepanpanel=new StoragePanPanel();
		storagetiaopanel=new StorageTiaoPanel();
		storagebaojingpanel=new StorageBaoJingPanel();
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 100, 150, 500);
		toppanel.setBounds(150, 0, 750, 60);
		outofStoragepanel.setBounds(150, 100, 750, 450);
		inofStoragepanel.setBounds(150, 100, 750, 450);
		storagecheckpanel.setBounds(150, 100, 750, 450);
		storagepanpanel.setBounds(150, 100, 750, 450);
		storagetiaopanel.setBounds(150, 100, 750, 450);
		storagebaojingpanel.setBounds(150, 100, 750, 450);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(storagecheckpanel);
		this.add(outofStoragepanel);
		this.add(inofStoragepanel);
		this.add(storagepanpanel);
		this.add(storagetiaopanel);
		this.add(storagebaojingpanel);
	
		inofStoragepanel.setVisible(false);
		outofStoragepanel.setVisible(false);
		storagepanpanel.setVisible(false);
	    storagetiaopanel.setVisible(false);
	}
	public void setController(){
		arraylist.add(outofStoragepanel);
		arraylist.add(inofStoragepanel);
		arraylist.add(storagecheckpanel);
		arraylist.add(storagepanpanel);
		arraylist.add(storagetiaopanel);
		navigationpanel.Inbutton.addActionListener(new StorageControllerUi(this, inofStoragepanel, arraylist));
		navigationpanel.Outbutton.addActionListener(new StorageControllerUi(this, outofStoragepanel, arraylist));
		navigationpanel.Panbutton.addActionListener(new StorageControllerUi(this, storagepanpanel, arraylist));
		navigationpanel.Checkbutton.addActionListener(new StorageControllerUi(this, storagecheckpanel, arraylist));
		navigationpanel.LogoutButton.addActionListener(new Listener_Return());
		navigationpanel.Tiaobutton.addActionListener(new StorageControllerUi(this, storagetiaopanel, arraylist));
		
	}

//public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new StorageUi();
//     
//}
	public ArrayList<JPanel> getPanelList(){
		list.add(navigationpanel);
		list.add(toppanel);
		list.add(storagecheckpanel);
		list.add(outofStoragepanel);
		list.add(inofStoragepanel);
		list.add(storagepanpanel);
		list.add(storagetiaopanel);
		return list;
	}
public void run() {
	// TODO Auto-generated method stub
	
}
}
