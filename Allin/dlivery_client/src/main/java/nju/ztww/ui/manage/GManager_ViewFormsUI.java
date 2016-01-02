package nju.ztww.ui.manage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import confligUI.MyComboBox;
import confligUI.MyLabel;
import nju.ztww.ui.finance.EditBenefit;
import nju.ztww.ui.finance.EditBusiness;

/**
 * @author wh 12/2
 *
 */
public class GManager_ViewFormsUI extends JPanel {
	EditBusiness businessPanel = new EditBusiness(new String[] { "付款日期",
			"付款金额", "付款人", "付款账号", "条目", "备注" }, new Object[][] { {
			new String("2015/11/1"), new Double(35.5), new String("Manager"),
			new String("000000001"), new String("人员工资"), new String("11月") } });// add
																				// business
																				// panel
	EditBenefit benefitPanel = new EditBenefit(new String[] { "总收入", "总支出",
			"总利润" }, new Object[][] { { new Double(2222.3),
			new Double("333.2"), new Double("0000.2") } });//add benefitPanel;
	public String[] Year = { "2010", "2011", "2012", "2013", "2014", "2015",
			"2016" };
	public final String[] Month = { "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "11", "12" };
	MyLabel state = new MyLabel();
	ImageIcon state1 = new ImageIcon("photo2/BusinessForm.png");
	ImageIcon state2 = new ImageIcon("photo2/BusinessForm2.png");;
	MyLabel cost = new MyLabel();
	ImageIcon cost1 = new ImageIcon("photo2/BenefitForm.png");
	ImageIcon cost2 = new ImageIcon("photo2/BenefitForm2.png");;
	MyLabel year = new MyLabel();
	MyLabel month = new MyLabel();
	MyComboBox monthBox = new MyComboBox(Month);
	MyComboBox yearBox = new MyComboBox(Year);
	JButton sureButton = new JButton();

	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();

	public GManager_ViewFormsUI() {
		;
//		 this.setBackground(new Color(250, 240, 230));
		this.setForeground(new Color(255,255,255));
		this.setLayout(null);
		sureButton.setText("确定");
		sureButton.setBounds(500, 400, 120, 40);
		yearBox.setBounds(330, 10, 60, 20);
		year.setText("年");
		year.setBounds(400, 10, 20, 20);
		monthBox.setBounds(460, 10, 50, 20);
		month.setText("月");
		month.setBounds(520, 10, 20, 20);
		state.setIcon(state2);
		state.setBounds(0, 10, 120, 20);
		state.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				state.setIcon(state2);
				cost.setIcon(cost1);
			}
		});

		cost.setIcon(cost1);
		cost.setBounds(120, 10, 120, 20);
		cost.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				cost.setIcon(cost2);
				state.setIcon(state1);
			}
		});
		businessPanel.setBounds(0, 35, 670, 375);
		benefitPanel.setBounds(0, 35, 670, 375);
		businessPanel.setOpaque(false);
		benefitPanel.setOpaque(false);
       // benefitPanel.button2.setBounds(295,420, 100, 20);
		this.add(state);
		this.add(cost);
		//this.add(year);
		//this.add(month);
		// this.add(sureButton);
		// this.add(yearBox);
		// this.add(monthBox);
		this.add(businessPanel);
		this.add(benefitPanel);
		//this.add(benefitPanel.button2);
		benefitPanel.setBounds(5, 30, 665, 375);
		benefitPanel.scrollPane.setBounds(0, 30, 670, 340);
		benefitPanel.button2.setLocation(580, 340);
//		benefitPanel.button2.setBounds(500, 350, 120, 30);
		benefitPanel.setVisible(false);
		this.cost.addMouseListener(new ListenerForCost());
		this.state.addMouseListener(new ListenerForState());
	}
	
	public class ListenerForCost implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			businessPanel.setVisible(false);
			benefitPanel.setVisible(true);
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	public class ListenerForState implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			benefitPanel.setVisible(false);
			
			
			businessPanel.setVisible(true);
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}
