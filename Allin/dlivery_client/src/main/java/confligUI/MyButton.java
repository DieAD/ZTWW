package confligUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	int width = 40;
	int n;
	public static int type=0;
	public MyButton(){
		this.setBorderPainted(false);
	}
	public MyButton(char a){
		this.setBorderPainted(false);
		switch (a) {
		case 'a':
			this.setIcon(new ImageIcon("photo/submit.png"));
			this.setBounds(620, 400, 80, 30);
			break;
		case 'b':
			this.setIcon(new ImageIcon("photo/add.png"));
			this.setBounds(530, 400, 80, 30);
			break;
		case 'c':
			this.setIcon(new ImageIcon("photo/delete.png"));
			this.setBounds(440, 400, 80, 30);
			break;
		case 'd':
			this.setIcon(new ImageIcon("photo/search.png"));
			this.setBounds(350, 400, 80, 30);
		default:
			break;
		}
	}
	
	public MyButton(int n){
		this.n=n;
		this.setBorderPainted(false);
		int locate = setLocate(width, n);
		this.setBounds(0, locate, 150, width);
		this.addMouseListener(nevigation);
	}
	
	private int setLocate(int width, int n){
		return n*width;
	}
	
	MouseListener nevigation = new MouseListener() {
		
		public void mouseReleased(MouseEvent e) {
//			System.out.println("??????????");
//			String photo = MyButton.this.getIcon().toString();
//			System.out.println(photo);
//			photo = photo.substring(0, photo.length()-4)+"2.png";
//			MyButton.this.setIcon(new ImageIcon(photo));
		}
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseExited(MouseEvent e) {
			String photo = MyButton.this.getIcon().toString();
			if(!photo.contains("Logout")){
			if(n!=type){
			
			photo = photo.substring(0, photo.length()-5)+".png";
			MyButton.this.setIcon(new ImageIcon(photo));
			}
			}
		}
		
		public void mouseEntered(MouseEvent e) {
			
			String photo = MyButton.this.getIcon().toString();
			if(!photo.contains("Logout")){
			if(!photo.contains("2")){
			System.out.println(photo);
			photo = photo.substring(0, photo.length()-4)+"2.png";
			MyButton.this.setIcon(new ImageIcon(photo));
			}
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
}
