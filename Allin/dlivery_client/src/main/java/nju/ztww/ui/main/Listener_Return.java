package nju.ztww.ui.main;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Listener_Return implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SwiftController.bg.removeAll();
		Login.frame.getContentPane().removeAll();
		Login.frame.getContentPane().add(new JPanel());
		Login.frame.getContentPane().add(Login.panel);
		returnPanel((JPanel)Login.frame.getContentPane(),(JPanel)Login.frame.getContentPane());
		Login.frame.repaint();
		
	}
   
	public void returnPanel(final JPanel panel,final JPanel centerPanel) {
		panel.setBounds(0, 0, centerPanel.getWidth(), centerPanel.getHeight());// ���û�����ʼλ��
		int count = centerPanel.getComponentCount();// ��ȡcenterPanel�пؼ���
		List list = new ArrayList();//
		for (Component comp : centerPanel.getComponents()) {
			list.add(comp);// ��list��ֵ
		}
		if (count > 0) {// ���centerPanel�пؼ�������0��ִ��Ч��
			for (int i = 0; i < count; i++) {
				Component comp = centerPanel.getComponent(i);// ��ø�λ�õĿؼ�

				if (comp instanceof JPanel) {// �жϿؼ�����
					final JPanel currentPanel = (JPanel) comp;// ��õ�ǰpanel
					if (currentPanel != panel) {

						new Thread() {

							public void run() {

								Rectangle rec = currentPanel.getBounds();// ��õ�ǰ����λ����Ϣ
								int y = centerPanel.getWidth();

								for (int i = 0; i >= -centerPanel.getWidth(); i -= 20) {
									// �������λ��
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
									y -= 20;
								}

								centerPanel.remove(currentPanel);// �Ƴ���ǰ���

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
//			centerPanel.add(panel);// ���Ҫ�л������
//		}

		centerPanel.validate();// �ع��������
		centerPanel.repaint();// �ػ��������
	}
}
