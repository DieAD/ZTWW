package nju.ztww.ui.finance;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Dialog_init1 extends JDialog{
   EditPanel tablePanel;
   MainPanel mainPanel = new MainPanel();
   public Dialog_init1(EditPanel tablePanel){
	   this.tablePanel = tablePanel;
	   
   }
   public class MainPanel extends JPanel{
	   
   }
}
