package nju.ztww.exception;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ConectException extends JFrame{
	
	public ConectException() {
		 // 设置容器
		  setTitle("JTable1");
		  
		  // 获取容器
		  Container container = getContentPane();

		  // setLayout(null);
		  container.setLayout(new BorderLayout());

		  // 获取屏幕最大坐标
		  Dimension size = getToolkit().getScreenSize();

		  setBounds((size.width - 500) / 2, (size.height - 200) / 2, 500, 200);

		  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		  
		  setVisible(true);
	}
	
}
