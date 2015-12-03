package nju.ztww.ui.commodity;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
//date 11-18 name wh
//需要根据中转中心业务员身份知道中转中心的id
public class StorageUi extends JFrame {
	StorageNavigationPanel navigationpanel;
    TopPanel toppanel;
    OutofStoragePanel outofStoragepanel;
    InofStoragePanel  inofStoragepanel;
    StorageCheckPanel storagecheckpanel;
    StoragePanPanel storagepanpanel;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
    //modify
    private ArrayList<JPanel> list = new ArrayList<JPanel>();
    
	public StorageUi() {
		// TODO Auto-generated constructor stub
		setup();
		setPosition();
		setController();
//		setTitle("Worker of Center!");
//		setSize(900,600);		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public  void setup(){
		navigationpanel=new StorageNavigationPanel();
		toppanel=new TopPanel();
		outofStoragepanel=new OutofStoragePanel();
		inofStoragepanel=new InofStoragePanel();
		storagecheckpanel=new StorageCheckPanel();
		storagepanpanel=new StoragePanPanel();
	}
	public void setPosition(){
		this.setLayout(null);
		navigationpanel.setBounds(0, 0, 150, 600);
		toppanel.setBounds(150, 0, 750, 60);
		outofStoragepanel.setBounds(150, 60, 750, 500);
		inofStoragepanel.setBounds(150, 60, 750, 500);
		storagecheckpanel.setBounds(150, 60, 750, 500);
		storagepanpanel.setBounds(150, 60, 750, 500);
		this.add(navigationpanel);
		this.add(toppanel);
		this.add(storagecheckpanel);
		this.add(outofStoragepanel);
		this.add(inofStoragepanel);
		this.add(storagepanpanel);
		
	}
	public void setController(){
		arraylist.add(outofStoragepanel);
		arraylist.add(inofStoragepanel);
		arraylist.add(storagecheckpanel);
		arraylist.add(storagepanpanel);
		navigationpanel.Inbutton.addActionListener(new StorageControllerUi(this, inofStoragepanel, arraylist));
		navigationpanel.Outbutton.addActionListener(new StorageControllerUi(this, outofStoragepanel, arraylist));
		navigationpanel.Panbutton.addActionListener(new StorageControllerUi(this, storagepanpanel, arraylist));
		navigationpanel.Checkbutton.addActionListener(new StorageControllerUi(this, storagecheckpanel, arraylist));
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
		return list;
	}
}
