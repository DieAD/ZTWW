package nju.ztww.ui.commodity;

import javax.swing.JButton;
import javax.swing.JPanel;

import confligUI.MyLabel;
import confligUI.MyTextField;

public class StorageBaoJingPanel extends JPanel {
	public MyLabel baojing=new MyLabel("此时的库存警戒线：");
	public MyLabel shezhibaojing=new MyLabel("设置库存警戒线：");
	public MyTextField myTextField=new MyTextField();
	public MyTextField shezhiMyTextField=new MyTextField();
	public JButton baojingbutton=new JButton();
       public StorageBaoJingPanel() {
		// TODO Auto-generated constructor stub
    	   this.setLayout(null);
    	   baojing.setBounds(100, 100, 200, 50);
    	   myTextField.setBounds(310, 100, 150, 50);
    	   shezhibaojing.setBounds(100, 160, 200, 50);
    	   shezhiMyTextField.setBounds(310, 160, 200, 50);
    	   baojingbutton.setBounds(240, 240, 200, 100);
    	   this.add(baojing);
    	   this.add(myTextField);
    	   this.add(shezhibaojing);
    	   this.add(shezhiMyTextField);
    	   this.add(baojingbutton);
	}
}
