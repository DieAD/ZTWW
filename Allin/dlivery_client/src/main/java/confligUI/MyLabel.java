package confligUI;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	public MyLabel(String str){
		super(str);
		this.setFont(myFont);
	}
}
