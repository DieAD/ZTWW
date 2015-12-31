package nju.ztww.ui.commodity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nju.ztww.bl.commodity.CheckOrderBL;
import nju.ztww.bl.commodity.GetStockListBL;
import nju.ztww.po.StorageListLineofInPO;
import nju.ztww.po.TracePO;
import nju.ztww.ui.finance.EditSearch;
import nju.ztww.ui.main.Listener_Return;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.ui.user.PersonalMesageUI;
import nju.ztww.ui.user.ThemeLabelUI;
//date 11-18 name wh
//需要根据中转中心业务员身份知道中转中心的id
public class StorageUi extends JFrame implements Runnable{
	
	StorageNavigationPanel navigationpanel;
    //TopPanel toppanel;
	ThemeLabelUI lablePanel;
    OutofStoragePanel outofStoragepanel;
    InofStoragePanel  inofStoragepanel;
    StorageCheckPanel storagecheckpanel;
    StoragePanPanel storagepanpanel;
    EditSearch editSearch;
    StorageTiaoPanel storagetiaopanel;
    StorageBaoJingPanel storagebaojingpanel;
    PersonalMesageUI personInfo;
    ArrayList<JPanel>arraylist=new ArrayList<JPanel>();
    ArrayList<TracePO>arraylistpo=new ArrayList<TracePO>();
    public JDialog dlg=new JDialog();
    boolean ispast=false;
    
    public JLabel tishi=new JLabel("库存已超出警戒线");
    public JButton sure=new JButton("确定");
    Thread t=new Thread(this);
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
   
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
		editSearch=new EditSearch();
		navigationpanel=new StorageNavigationPanel();
		//toppanel=new TopPanel();
		lablePanel=new ThemeLabelUI();
		outofStoragepanel=new OutofStoragePanel();
		inofStoragepanel=new InofStoragePanel();
		storagecheckpanel=new StorageCheckPanel();
		storagepanpanel=new StoragePanPanel();
		storagetiaopanel=new StorageTiaoPanel();
		personInfo = new PersonalMesageUI();
		
		//storagebaojingpanel=new StorageBaoJingPanel();
	}
	public void setPosition(){
		this.setLayout(null);
		editSearch.setBounds(200,120,670,410);
		navigationpanel.setBounds(25, 150, 150, 400);
		lablePanel.setBounds(200, 0, 670, 120);
		outofStoragepanel.setBounds(200,120,670,410);
		inofStoragepanel.setBounds(200,120,670,410);
		storagecheckpanel.setBounds(200,120,670,410);
		storagepanpanel.setBounds(200,120,670,410);
		storagetiaopanel.setBounds(200,120,670,410);
		personInfo.setBounds(200,120,670,410);
		//storagebaojingpanel.setBounds(150, 100, 750, 450);
		this.add(navigationpanel);
		this.add(lablePanel);
		this.add(storagecheckpanel);
		this.add(outofStoragepanel);
		this.add(inofStoragepanel);
		this.add(storagepanpanel);
		this.add(storagetiaopanel);
		this.add(editSearch);
		
		
		
		
		
		//this.add(storagebaojingpanel);
	   
		inofStoragepanel.setVisible(false);
		outofStoragepanel.setVisible(false);
		storagepanpanel.setVisible(false);
	    storagetiaopanel.setVisible(false);
	    personInfo.setVisible(false);
	}
	public void setController(){
		arraylist.add(outofStoragepanel);
		arraylist.add(inofStoragepanel);
		arraylist.add(storagecheckpanel);
		arraylist.add(storagepanpanel);
		arraylist.add(storagetiaopanel);
		arraylist.add(editSearch);
		arraylist.add(personInfo);
		//GetAnnouceUI e=new GetAnnouceUI();
		navigationpanel.CheckOrderButton.addActionListener(new StorageControllerUi(this, editSearch, arraylist));
		navigationpanel.Inbutton.addActionListener(new StorageControllerUi(this, inofStoragepanel, arraylist));
		navigationpanel.Outbutton.addActionListener(new StorageControllerUi(this, outofStoragepanel, arraylist));
		navigationpanel.Panbutton.addActionListener(new StorageControllerUi(this, storagepanpanel, arraylist));
		navigationpanel.Checkbutton.addActionListener(new StorageControllerUi(this, storagecheckpanel, arraylist));
		navigationpanel.LogoutButton.addActionListener(new Listener_Return());
		navigationpanel.Tiaobutton.addActionListener(new StorageControllerUi(this, storagetiaopanel, arraylist));
		navigationpanel.YourMessageButton.addActionListener(new StorageControllerUi(this, personInfo, arraylist));
	}

//public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new StorageUi();
//     
//}
	public ArrayList<JPanel> getPanelList(){
		list.add(navigationpanel);
		//list.add(toppanel);
		list.add(storagecheckpanel);
		list.add(outofStoragepanel);
		list.add(inofStoragepanel);
		list.add(storagepanpanel);
		list.add(storagetiaopanel);
		list.add(lablePanel);
		list.add(personInfo);
		list.add(editSearch);
		return list;
	}
public void run() {
	// TODO Auto-generated method stub
	while(true){
		show();
		if(ispast){
		dlg.setLayout(null);
		dlg.setSize(new Dimension(250, 150));
	    dlg.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
		tishi.setBounds(2, 0, 200, 50);
	    sure.setBounds(120, 50, 60, 40);
	    sure.addActionListener(surelistener);
		dlg.add(tishi);
		dlg.add(sure);	
		dlg.setVisible(true);
		t.stop();
		}
	}
}

   public  void show(){
	   CheckOrderBL bl=new  CheckOrderBL();
	   arraylistpo=bl.findTrace("库存警戒线"+UserInfoUI.getUserID().substring(0,5));
	   ArrayList<StorageListLineofInPO> storagelist=new ArrayList<StorageListLineofInPO>();
	   GetStockListBL gbl=new GetStockListBL();
	   storagelist=gbl.getStock(UserInfoUI.getUserID().substring(0,5));
	   int baojing=Integer.parseInt(arraylistpo.get(0).getTrace());
	   int storage=storagelist.size();
	   
	   //System.out.println(storagelist.size());
	   //System.out.println(arraylistpo.get(0).getTrace());
	   if(storage>baojing){
		 ispast=true;
		   }
   }
   ActionListener surelistener=new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dlg.setVisible(false);
		ispast=false;
		//t.stop();
		
	}
}; 
   public void startThread(){
	  
	   t.start();
   }
}
