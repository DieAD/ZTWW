package confligUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class MyTextField extends JTextField {
	Font myFont = new Font("微软雅黑", Font.PLAIN, 15);
	Border border1 = new LineBorder(new Color(165,163,162), 1, true);
	Border border2  = new LineBorder(new Color(155,122,90),1,true);
	public MyTextField(){
		this.setFont(myFont);
		this.addMouseListener(ad);
	}
	
	
	
	MouseListener ad = new MouseListener() {
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			MyTextField.this.setBorder(border1);
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			MyTextField.this.setBorder(border2);
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	};

}
