package confligUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	public MyLabel(String str){
		super(str);
		this.setFont(myFont);

		this.setForeground(new Color(225,225,225));

	}
	
	public MyLabel(){
		super();
		this.setFont(myFont);
		this.setForeground(new Color(255,255,255));
	}

	public MyLabel(String string, int center) {
		// TODO Auto-generated constructor stub
		super(string, center);
		this.setFont(myFont);
		this.setForeground(new Color(255,255,255));
	}
}
