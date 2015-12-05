package nju.ztww.ui.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.bl.manage.ManageBL;
import nju.ztww.service.ManageService;
import nju.ztww.serviceimpl.ManageServiceImpl;
import nju.ztww.vo.GenerateVO;
import nju.ztww.vo.IDVO;

public class GManager_CheckOrders extends JPanel {
	ManageService mService = new ManageServiceImpl();
	// JTextField search = new JTextField();
	// JButton searchButton = new JButton("搜索");
	// JLabel nameLabel = new JLabel();
	// JLabel numLabel = new JLabel();
	// JLabel memberJLabel = new JLabel();
	// JTextField name = new JTextField();
	// JTextField num = new JTextField();
	// JTextField num1 = new JTextField();
	// JTextField num2 = new JTextField();
	// JTextField num3 = new JTextField();
	// JButton sureButton = new JButton("确定");
	// JButton closButton = new JButton("关闭");
	JButton order1Button = new JButton();
	JButton order2Button = new JButton();
	JButton order3Button = new JButton();
	JButton order4Button = new JButton();
	JButton order5Button = new JButton();
	JButton order6Button = new JButton();
	JButton order7Button = new JButton();
	JButton order8Button = new JButton();
	JButton order9Button = new JButton();
	JButton order10Button = new JButton();
	JButton sureButton = new JButton();
	MyTable table;
	JPanel tablePanel = new JPanel();
	int index = 0;

	// Object[][] orders1;
	// Object[][] orders2;
	// Object[][] orders3;
	// Object[][] orders4;
	// Object[][] orders5;
	// Object[][] orders6;
	// Object[][] orders7;
	// Object[][] orders8;
	// Object[][] orders9;
	// Object[][] orders10;
	public GManager_CheckOrders() {
		// this.setLayout(null);
		// search.setBounds(20, 20, 100, 20);
		// searchButton.setBounds(150, 20, 100, 20);
		// nameLabel.setText("机构名称");
		// nameLabel.setBounds(50, 100, 100, 30);
		// name.setBounds(180, 100, 150, 20);
		// numLabel.setText("机构编号");
		// // numLabel.setBounds(50, 100, width, height);
		this.setLayout(null);
		tablePanel.setLayout(null);
		tablePanel.setBounds(135, 10, 570, 400);
		this.add(tablePanel);
		order1Button.setText("寄件单");
		order1Button.setBounds(10, 10, 120, 30);
		order2Button.setText("装车单");
		order2Button.setBounds(10, 40, 120, 30);
		order3Button.setText("营业厅到达单");
		order3Button.setBounds(10, 70, 120, 30);
		order4Button.setText("收款单");
		order4Button.setBounds(10, 100, 120, 30);
		order5Button.setText("派件单");
		order5Button.setBounds(10, 130, 120, 30);
		order6Button.setText("中装中心到达单");
		order6Button.setBounds(10, 160, 120, 30);
		order7Button.setText("入库单");
		order7Button.setBounds(10, 190, 120, 30);
		order8Button.setText("中转单");
		order8Button.setBounds(10, 220, 120, 30);
		order9Button.setText("出库单");
		order9Button.setBounds(10, 250, 120, 30);
		order10Button.setText("付款单");
		order10Button.setBounds(10, 280, 120, 30);
		sureButton.setText("审批单据");
		sureButton.setBounds(550, 420, 120, 30);
		order1Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(1);
			}
		});
		order2Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(2);
			}
		});
		order3Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(3);
			}
		});
		order4Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(4);
			}
		});
		order5Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				Object[][] Orders5 = { { false, "12345672345", "提交状态", "Jerry",
//						"派件单" } };
//
//				table = new MyTable(Orders5);
//				tablePanel.removeAll();
//				tablePanel.add(table);
//				tablePanel.repaint();
				getCheckOrderVO(5);
			}
		});
		order6Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(6);
			}
		});
		order7Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(7);
			}
		});
		order8Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(8);
			}
		});
		order9Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(9);
			}
		});
		order10Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getCheckOrderVO(10);
			}
		});

		this.add(order1Button);
		this.add(order2Button);
		this.add(order3Button);
		this.add(order4Button);
		this.add(order5Button);
		this.add(order6Button);
		this.add(order7Button);
		this.add(order8Button);
		this.add(order9Button);
		this.add(order10Button);
		this.add(sureButton);
		sureButton.addActionListener(new Listener());
		
	}
	
	public void getCheckOrderVO(int index){
		this.index = index;
		if(index>0){
			tablePanel.removeAll();}
		ArrayList<GenerateVO> list = mService.getCheckOrder(index);
		Object[][] values = new Object[list.size()][5];
		int i = 0;
		for (GenerateVO vo : list) {
			values[i][0] = new Boolean(false);
			values[i][1] = new String(vo.id);
			values[i][2] = new String(vo.state);
			values[i][3] = new String(vo.dealmen);
			values[i][4] = new String("1");
			i++;
		}
		table = new MyTable(values);
		
		tablePanel.add(table);
		tablePanel.repaint();
	}

	// ActionListener e1 = new ActionListener() {
	//
	// public void actionPerformed(ActionEvent e) {
	// // TODO Auto-generated method stub
	// Object[][] Orders = {
	// {" ", "123456789", "提交状态", "Tom", "......"}
	// };
	// MyTable table1 = new MyTable(Orders);
	// table1.setBounds(210,60,690,400);
	//
	// }
	// };
	
	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<IDVO> list = new ArrayList<IDVO>();
			int count = table.tableModel.getRowCount();
			for(int i=0;i<count;i++){
				boolean flag = (Boolean) table.tableModel.getValueAt(i, 0);
				if(flag){
					IDVO vo = new IDVO((String)table.tableModel.getValueAt(i, 1));
					list.add(vo);
				}
			}
			
			mService.updateInformation(list, index);
			for(IDVO vo : list){
				System.out.print(vo.id);
			}
			tablePanel.removeAll();
			tablePanel.repaint();
		}
		
	}
}
