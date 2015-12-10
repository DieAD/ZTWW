package confligUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MyDialog extends JDialog{
	ImageIcon icon = new ImageIcon("photo/Dbg.png");
	JLabel comp = new JLabel();
	public MyDialog(){
		
		super();
		this.setBackground(new Color(250, 240, 230));
		comp.setSize(icon.getIconWidth(),icon.getIconHeight());
		comp.setLocation(0, 0);
		comp.setOpaque(false);
		this.add(comp);
	}
}
