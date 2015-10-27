package nju.ztww.ui.user;

import javax.swing.JFrame;

public class UserOfCenter extends JFrame {
	public UserOfCenter() {
		// TODO Auto-generated constructor stub
		setTitle("Worker of Center!");
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserOfCenter user=new UserOfCenter();
        new WorkerOfCenterUI(user);
	}

}
