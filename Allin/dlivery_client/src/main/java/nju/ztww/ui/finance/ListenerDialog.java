package nju.ztww.ui.finance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDialog implements ActionListener {
    private Dialog dialog;
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
    public ListenerDialog(Dialog dialog){
    	this.dialog = dialog;
    	dialog.setLocation((screenSize.width-700)/2, (screenSize.height-600)/2);
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog.setVisible(true);
	}

}
