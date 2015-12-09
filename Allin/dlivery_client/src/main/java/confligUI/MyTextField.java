package confligUI;

import java.awt.Font;

import javax.swing.JTextField;

public class MyTextField extends JTextField {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	public MyTextField(){
		this.setFont(myFont);
		
	}
}
