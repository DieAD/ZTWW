package nju.ztww.ui.commodity;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StorageBaoJingPanel extends JPanel {
	public JLabel baojing=new JLabel("此时的库存警戒线：");
	public JLabel shezhibaojing=new JLabel("设置库存警戒线：");
	public JTextField jtextfield=new JTextField();
	public JTextField shezhijtextfield=new JTextField();
	public JButton baojingbutton=new JButton();
       public StorageBaoJingPanel() {
		// TODO Auto-generated constructor stub
    	   this.setLayout(null);
    	   baojing.setBounds(100, 100, 200, 50);
    	   jtextfield.setBounds(310, 100, 150, 50);
    	   shezhibaojing.setBounds(100, 160, 200, 50);
    	   shezhijtextfield.setBounds(310, 160, 200, 50);
    	   baojingbutton.setBounds(240, 240, 200, 100);
    	   this.add(baojing);
    	   this.add(jtextfield);
    	   this.add(shezhibaojing);
    	   this.add(shezhijtextfield);
    	   this.add(baojingbutton);
	}
}
