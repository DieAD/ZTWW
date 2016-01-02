package nju.ztww.ui.main;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Listener_Trace implements MouseListener {
	Login frame;

	public Listener_Trace(Login frame) {
		this.frame = frame;

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(TestIfConnect.ifConnect()){
		String id = frame.order.getText();
		TracePanel panel = new TracePanel(id);
		panel.setBounds(0, 0, 900, 600);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new JPanel());
		frame.getContentPane().add(panel);
		xiaoGuo((JPanel) frame.getContentPane(),(JPanel) frame.getContentPane());
		frame.repaint();
		}
		// panel.animate();

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		frame.searchButton.setIcon(new ImageIcon("photo/search2.png"));
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		frame.searchButton.setIcon(new ImageIcon("photo/search.png"));
	}
	public void xiaoGuo(final JPanel panel,final JPanel centerPanel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// 设置滑动初始位置
		int count = centerPanel.getComponentCount();// 获取centerPanel中控件数
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// 给list赋值
		}
		if (count > 0) {// 如果centerPanel中控件数大于0就执行效果
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// 获得该位置的控件

				if (comp instanceof JPanel) {// 判断控件类型
					final JPanel currentPanel = (JPanel) comp;// 获得当前panel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// 获得当前面板的位置信息
								int y = -centerPanel.getWidth();

								for (int i = 0; i <= centerPanel.getWidth(); i += 20) {
									// 设置面板位置
									currentPanel.setBounds(i, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									panel.setBounds(y, 0,
											centerPanel.getWidth(),
											centerPanel.getHeight());
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									y += 20;
								}

								centerPanel.remove(currentPanel);// 移除當前面板

								panel.setBounds(0, 0, centerPanel.getWidth(),
										centerPanel.getHeight());

							}
						}.start();
						break;
					}
				}
			}
		}
//
//		if (!list.contains(panel)) {
//			centerPanel.add(panel);// 添加要切换的面板
//		}

		centerPanel.validate();// 重构内容面板
		centerPanel.repaint();// 重绘内容面板
	}
}
