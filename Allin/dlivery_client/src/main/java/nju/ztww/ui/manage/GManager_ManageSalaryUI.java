package nju.ztww.ui.manage;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import confligUI.MyComboBox;
import confligUI.MyLabel;
import confligUI.MyTextField;
import nju.ztww.dao.DCFormDO;
import nju.ztww.po.MUserPO;
import nju.ztww.service.ManageService;
import nju.ztww.serviceimpl.ManageServiceImpl;
import nju.ztww.ui.main.TestIfConnect;
import nju.ztww.vo.UserSalaryVO;
//



public class GManager_ManageSalaryUI extends JPanel{
	String[] Position = {" ", "快递员", "营业厅业务员", "中转中心业务员", "仓库管理员", "财务人员", "总经理", "管理员"};
	String names;
	String[] Places = {"北京", "上海", "深圳", "广州", "南京"};
	JButton sureButton1 = new JButton();
	JButton sureButton2 = new JButton();
	JButton searchButton = new JButton();
	MyLabel positionLabel = new MyLabel();
	MyLabel nameLabel = new MyLabel();
	MyLabel idLabel = new MyLabel();
	MyLabel nameLabel2 = new MyLabel();
	MyLabel idLabel2 = new MyLabel();
	MyLabel numLabel = new MyLabel();
	MyLabel moneyLabel = new MyLabel();
	MyLabel strategyLabel = new MyLabel();
	MyLabel sumSalaryLabel = new MyLabel();
	MyLabel fromLabel = new MyLabel();
	MyLabel toLabel = new MyLabel();
	MyLabel distanceLabel = new MyLabel();
	MyLabel RMB = new MyLabel();
	MyComboBox position = new MyComboBox(Position);
	MyComboBox from = new MyComboBox(Places);
	MyComboBox to = new MyComboBox(Places);
	MyTextField id1 = new MyTextField();
	MyTextField name2 = new MyTextField();
	MyTextField id2 = new MyTextField();
	MyTextField num = new MyTextField();
	MyTextField money = new MyTextField();
	MyTextField sumSalary = new MyTextField();
	MyTextField distance = new MyTextField();
	JRadioButton monthly = new JRadioButton("按月提成");
	JRadioButton timely = new JRadioButton("按次提成");
	//
	JButton searchButton2  =new JButton();
	private ManageService MS = new ManageServiceImpl();
	//TQ的修改
	ButtonGroup group = new ButtonGroup ();
	public GManager_ManageSalaryUI(){
		group.add(timely);
		group.add(monthly);
		String[] name = {" "};
		this.setLayout(null);
		positionLabel.setText("职位");
		positionLabel.setBounds(20, 20, 80, 30);
		position.setBounds(80, 20, 170, 30);
		// delete name jbox ;
		nameLabel.setText("姓名");
		nameLabel.setBounds(20, 100, 80, 30);
		MyComboBox name1 = new MyComboBox(name);
		name1.setBounds(80, 100, 140, 30);
		//change id text dy;
		idLabel.setText("ID");
		idLabel.setBounds(20, 180, 80, 30);
		id1.setBounds(80, 180, 140, 30);
//		searchButton.setBounds(220, 180, 70, 30);//!!!!!!!!!!!!!!
		
		nameLabel2.setText("姓名");
		nameLabel2.setBounds(300, 20, 60, 30);
		name2.setBounds(360, 20, 110, 30);
		idLabel2.setText("ID");
		idLabel2.setBounds(490, 20, 60, 30);
		id2.setBounds(550, 20, 110, 30);
		
		numLabel.setText("派件数量");
		numLabel.setBounds(300, 80, 60, 30);
		num.setBounds(360, 80, 110, 30);
		moneyLabel.setText("单件酬金");
		moneyLabel.setBounds(490, 80, 60, 30);
		money.setBounds(550, 80, 110, 30);
		
		strategyLabel.setText("薪水策略");
		strategyLabel.setBounds(300, 140, 60, 30);
		monthly.setBounds(380, 140, 100, 30);
		timely.setBounds(480, 140, 100, 30);
		
		sumSalaryLabel.setText("薪水总额");
		sumSalaryLabel.setBounds(300, 200, 60, 30);
		sumSalary.setBounds(360, 200, 110, 30);
		RMB.setText("RMB");
		RMB.setBounds(490, 200, 60, 30);
		
		sureButton1.setIcon(new ImageIcon("photo/Gsure.png"));
		sureButton1.setBounds(580, 200, 80, 30);
		
		fromLabel.setText("出发地");
		fromLabel.setBounds(50, 270, 100, 30);
		toLabel.setText("到达地");
		toLabel.setBounds(230, 270, 100, 30);
		distanceLabel.setText("距离");
		distanceLabel.setBounds(410, 270, 100, 30);
		
		from.setBounds(50, 300, 130, 30);
		to.setBounds(230, 300, 130, 30);
		distance.setBounds(410, 300, 130, 30);
		sureButton2.setIcon(new ImageIcon("photo/Gsure.png"));
		sureButton2.setBorderPainted(false);
		sureButton1.setBorderPainted(false);
		sureButton2.setBounds(580, 300, 80, 30);
		this.add(positionLabel);
		this.add(position);
		//name jbox delete
		this.add(nameLabel);
		this.add(name1);
		this.add(idLabel);
		this.add(id1);
		this.add(searchButton);
		this.add(name2);
		this.add(nameLabel2);
		this.add(idLabel2);
		this.add(id2);
		this.add(numLabel);
		this.add(num);
		this.add(moneyLabel);
		this.add(money);
		this.add(strategyLabel);
		this.add(monthly);
		this.add(timely);
		this.add(sumSalaryLabel);
		this.add(sumSalary);
		this.add(RMB);
		this.add(sureButton1);
		this.add(fromLabel);
		this.add(toLabel);
		this.add(distanceLabel);
		this.add(from);
		this.add(to);
		this.add(distance);
		this.add(sureButton2);
		//name1.addActionListener(new Listener1());
		//
		searchButton2.setBounds(220, 100, 30, 30);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		searchButton.setBounds(220,180,30,30);
		searchButton.setIcon(new ImageIcon("photo/Gsearch.png"));
		searchButton2.setIcon(new ImageIcon("photo/Gsearch.png"));
		this.add(searchButton2);
		position.addItemListener(new Listener1(position,name1));
		searchButton2.addActionListener(new Listener2(position,name1));
		searchButton.addActionListener(new Listener3(name1));
		sureButton1.addActionListener(new Listener4());
		
		name2.setHorizontalAlignment(MyTextField.CENTER);
		name2.setEditable(false);
		id2.setHorizontalAlignment(MyTextField.CENTER);
		id2.setEditable(false);
		num.setHorizontalAlignment(MyTextField.CENTER);
		num.setEditable(false);
		money.setHorizontalAlignment(MyTextField.CENTER);
		money.setEditable(true);
	}
	
	public class Listener1 implements ItemListener{
		MyComboBox box  ;
		MyComboBox boxToDis;
		public Listener1(MyComboBox box,MyComboBox boxToDis){
			this.box = box;
			this.boxToDis = boxToDis;
		}

		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange()==ItemEvent.SELECTED){
				eventHandle();
			}
		}
		
		public void eventHandle(){
            String s = (String)box.getSelectedItem();
            if(s.equals("快递员")){
            	System.out.print("0");
            }
            String[] disInfo;
            disInfo = MS.getItem(s);
            
            boxToDis.removeAllItems();
            for(int i=0;i<disInfo.length;i++){
            	boxToDis.addItem(disInfo[i]);
            }
       ///     boxToDis.addItem(disInfo);
			
			//System.out.print(s);
		}

		
		
	}
	
	public class Listener2 implements ActionListener{
		
		private MyComboBox index;
		private MyComboBox name;
		public Listener2(MyComboBox index,MyComboBox name){
			this.index = index;
			this.name =name;
		}

		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			String sindex = (String)index.getSelectedItem();
			String sname = (String)name.getSelectedItem();
			System.out.print(sindex + sname);
			MUserPO userInfo = MS.getUserInfo(sindex, sname);
			name2.setText(userInfo.getName());
			id1.setText(userInfo.getId());
			id2.setText(userInfo.getId());
			String number = userInfo.getNumber()+"";
			num.setText(number);
			String sp = userInfo.getSp() + "";
			money.setText(sp);
			String salary = userInfo.getSalary()+"";
			sumSalary.setText(salary);
			if(userInfo.getSalarymethod()==0){
				monthly.setSelected(true);	
				timely.setSelected(false);
			}else{
				monthly.setSelected(false);
				timely.setSelected(true);
			}
			}
		}
		
		
	}
	public class Listener3 implements ActionListener{
		MyComboBox nameBox;
		public Listener3(MyComboBox box){
			this.nameBox = box;
		}

		public void actionPerformed(ActionEvent e) {
			if(TestIfConnect.ifConnect()){
			String id = id1.getText();
			System.out.print(id);
			MUserPO userInfo = MS.getUserInfoById(id);
			name2.setText(userInfo.getName());
//			id1.setText(userInfo.getId());
			id2.setText(userInfo.getId());
			String number = userInfo.getNumber()+"";
			num.setText(number);
			String sp = userInfo.getSp() + "";
			money.setText(sp);
			String salary = userInfo.getSalary()+"";
			sumSalary.setText(salary);
			if(userInfo.getSalarymethod()==0){
				monthly.setSelected(true);	
				timely.setSelected(false);
				//money.setEditable(false);
			}else{
				monthly.setSelected(false);
				timely.setSelected(true);
				//sumSalary.setEditable(false);
			}
			nameBox.removeAllItems();
		}
		}
	}
	
	public class Listener4 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double sp = Double.parseDouble(money.getText());
			double sum = Double.parseDouble(sumSalary.getText());
			System.out.print(sp + "df"+sum);
		}
		
	}
	


	public class Listener5 implements ItemListener{
        MyComboBox box1;
        MyComboBox box2;
        public Listener5(MyComboBox box1,MyComboBox box2){
        	this.box1 = box1;
        	this.box2 = box2;
        	
        }
        
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange()==ItemEvent.SELECTED){
				eventHandle();
			}
			
		}
		
		public void eventHandle(){
			String bddress = (String)box1.getSelectedItem();
			String address = (String)box2.getSelectedItem();
			DCFormDO form = MS.showDC(bddress, address);
			String dis = form.getDistance()+"";
			distance.setText(dis);
		}
		
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/ManaSalary2.png").getImage();
		g.drawImage(background, 0,0,null);


		
	}
	
}
