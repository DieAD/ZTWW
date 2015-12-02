package nju.ztww.ui.commodity;

import javax.swing.JFrame;

public class OrderCheckUi extends JFrame {
	OrderCheckPanel  ordercheckpanel;
	
   public OrderCheckUi() {
	// TODO Auto-generated constructor stub

    setup();
	setPosition();
	setController();
	setTitle("欢迎来到物流系统");
	setSize(900,600);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
public void setController() {
	// TODO Auto-generated method stub
	
}
public void setPosition() {
	// TODO Auto-generated method stub
	this.setLayout(null);
	ordercheckpanel.setBounds(0, 0, 900, 600);
	
	this.add(ordercheckpanel);
	
	
	
}
public void setup() {
	// TODO Auto-generated method stub
	ordercheckpanel=new OrderCheckPanel("000000002");
	
}
public static void main(String[]args){
	new OrderCheckUi();
}
}
