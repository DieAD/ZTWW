package nju.ztww.ui.commodity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nju.ztww.ui.order.MyButton;

public class ClerkOfCenterNavigationPanel extends JPanel {

	MyButton ArriveMid;// 到达单
	MyButton ArriveEnd;// 鐏溅
	MyButton Transfer;// 中转单
	MyButton CarLoadbutton;// 装车单
	MyButton StorageFind;// 库存查看 ——by zyz 2015/12/05
	final ImageIcon checkStorage = new ImageIcon("photo/check.png");
	final ImageIcon arriveOrder = new ImageIcon("photo/arrive.png");
	final ImageIcon transit = new ImageIcon("photo/zhongzhuan.png");
	final ImageIcon carLoading = new ImageIcon("photo/CarLoading.png");
	ImageIcon checkStorage2 = new ImageIcon("photo/check2.png");
	ImageIcon arriveOrder2 = new ImageIcon("photo/arrive2.png");
	ImageIcon transit2 = new ImageIcon("photo/zhongzhuan2.png");
	ImageIcon carLoading2 = new ImageIcon("photo/CarLoading2.png");
	int panel = 0;
	
	public ClerkOfCenterNavigationPanel() {


		// TODO Auto-generated constructor stub
		this.setBackground(new Color(155, 122, 90));
		setup();
		setPosition();

		ArriveMid.addActionListener(arrive);
		Transfer.addActionListener(transfer);
		CarLoadbutton.addActionListener(carLoad);
		StorageFind.addActionListener(storage);

	}

	public void setup() {// 鍒濆鍖栭儴浠跺璞�


		ArriveMid = new MyButton(0);
		ArriveMid.setIcon(arriveOrder);
		// ArriveEnd=new MyButton();
		// ArriveEnd.setIcon(Train);
		Transfer = new MyButton(1);
		Transfer.setIcon(transit);
		CarLoadbutton = new MyButton(2);
		CarLoadbutton.setIcon(carLoading);
		StorageFind = new MyButton(3);
		StorageFind.setIcon(checkStorage); // 2015/12/05 ——by zyz
		// StorageFind.setIcon(null); //???????注释掉了 2015/12/05 ——by zyz
		// 当时为啥setnull？
	}

	public void setPosition() {// 璁剧疆浣嶇疆

		this.setLayout(null);

		// ArriveMid.setBounds(0, 60, 210, 58);
		// // ArriveEnd.setBounds(0, 118, 210, 58);
		// Transfer.setBounds(0, 118, 210, 58);
		// CarLoadbutton.setBounds(0, 176, 210, 58);
		// StorageFind.setBounds(0, 234, 210, 58);
		// this.add(IDbutton);
		this.add(ArriveMid);
		// this.add(ArriveEnd);
		this.add(Transfer);
		this.add(CarLoadbutton);
		this.add(StorageFind);
	}

	public void setListener() {

	}

	ActionListener arrive = new ActionListener() {


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			removeButton(panel);
			ArriveMid.setIcon(arriveOrder2);
			panel = 0;
		}
	};

	ActionListener transfer = new ActionListener() {


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			removeButton(panel);
			Transfer.setIcon(transit2);
			panel = 1;
		}
	};

	ActionListener carLoad = new ActionListener() {


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			removeButton(panel);
			CarLoadbutton.setIcon(carLoading2);
			panel = 2;
		}
	};

	ActionListener storage = new ActionListener() {


		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			removeButton(panel);
			StorageFind.setIcon(checkStorage2);
			panel =3;
		}
	};

	private void removeButton(int n){
		switch (n){
		case 0:ArriveMid.setIcon(arriveOrder);break;
		case 1:Transfer.setIcon(transit);break;
		case 2:CarLoadbutton.setIcon(carLoading);break;
		case 3:StorageFind.setIcon(checkStorage);break;
		}
	}
	//
	// public void paintComponent(Graphics g){
	// super.paintComponent(g);
	//
	// Image background=new ImageIcon("photo/bbbackground.gif").getImage();
	// g.drawImage(background, 0,0,null);
	//
	// }
}
