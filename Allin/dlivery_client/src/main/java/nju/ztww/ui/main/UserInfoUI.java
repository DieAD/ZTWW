package nju.ztww.ui.main;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserInfoUI extends JPanel{
	public static JTextArea USERID = new JTextArea();
	
	public UserInfoUI(String userID){
		this.setBounds(0, 0, 210, 60);
		this.setLayout(null);
		USERID.setText(userID);
		USERID.setBounds(20, 20, 150, 20);
		this.add(USERID);
	}
	
	public static String getUserID(){
		return USERID.getText();
	}
	
}
