package confligUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Administrator
 * 继承JButton类，并设置符合本系统新的特性
 *
 */
public class MyButton extends JButton {
	int width = 40;
	int n;
	public static int type=0;
	public MyButton(){
		this.setBorderPainted(false);
	}
	/**
	 * @param a，区别表示增、删、改、查、提交
	 */
	public MyButton(char a){
		this.setBorderPainted(false);
		switch (a) {
		case 'a':
			this.setIcon(new ImageIcon("photo/submit.png"));
			this.setBounds(570, 370, 80, 30);
			break;
		case 'b':
			this.setIcon(new ImageIcon("photo/add.png"));
			this.setBounds(470, 370, 80, 30);
			break;
		case 'c':
			this.setIcon(new ImageIcon("photo/delete.png"));
			this.setBounds(370, 370, 80, 30);
			break;
		case 'd':
			this.setIcon(new ImageIcon("photo/search.png"));
			this.setBounds(270, 370, 80, 30);
		default:
			break;
		}
	}
	
	/**
	 * @param n，用于导航，设置不同button在导航页面中的不同位置
	 */
	public MyButton(int n){
		this.n=n;
		this.setBorderPainted(false);
		int locate = setLocate(width, n);
		this.setBounds(0, locate, 150, width);
		this.addMouseListener(nevigation);
	}
	
	/**
	 * MyButton的私有方法，计算设置导航button的大小
	 * @param width，设置button的宽度
	 * @param n，输入第几个button的位置
	 * @return button在该导航界面的height
	 */
	private int setLocate(int width, int n){
		return n*width;
	}
	/**
	 * 设置导航界面中panel的鼠标监听事件
	 */
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
