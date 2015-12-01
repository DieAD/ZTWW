package nju.ztww.ui.user;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.UserVO;

public class PersonalMesageUI extends JPanel{
	
	private  JLabel name=new  JLabel("姓名");
	private JTextField nametextArea=new JTextField("");
	private  JLabel sex=new  JLabel("性别");
	private JTextField sextextArea=new JTextField("");
	private  JLabel ID=new  JLabel("ID");
	private JTextField itextArea=new JTextField("");
	private  JLabel area=new  JLabel("身份证号");
	private JTextField areatextArea=new JTextField("");
	private  JLabel position=new  JLabel("职位");
	private JTextField positiontextArea=new JTextField("");
	private  JLabel age=new  JLabel("年龄");
	private JTextField agetextArea=new JTextField("");
	private  JLabel workyear=new  JLabel("工作时间");
	private JTextField worktextArea=new JTextField("");
	private  JLabel salary=new  JLabel("薪水");
	private JTextField salarytextArea=new JTextField("");
	
	private JButton changeButton=new JButton();
	private String MyID = UserInfoUI.getUserID();
	private UserService userService = new UserLoginImpl();
	private UserVO user;
	
	public PersonalMesageUI(){

		ImageIcon change=new ImageIcon("photo/change.gif");
		
		changeButton.setBounds(430, 370, 110, 40);
		changeButton.setIcon(change);
		
		name.setFont(new Font("SimSun", Font.BOLD, 20));
		name.setBounds(270, 50, 132, 41);
		nametextArea.setBounds(320, 55, 72, 31);
		sex.setFont(new Font("SimSun", Font.BOLD, 20));
		sex.setBounds(270, 100, 132, 41);
		sextextArea.setBounds(320, 105, 72, 31);
		ID.setFont(new Font("SimSun", Font.BOLD, 20));
		ID.setBounds(440, 50, 132, 41);
		itextArea.setBounds(470, 55, 72, 31);
		age.setFont(new Font("SimSun", Font.BOLD, 20));
		age.setBounds(425, 100, 132, 41);
		agetextArea.setBounds(470, 105, 72, 31);
		area.setFont(new Font("SimSun", Font.BOLD, 20));
		area.setBounds(270, 150, 132, 41);
		areatextArea.setBounds(320, 155, 222, 31);
		position.setFont(new Font("SimSun", Font.BOLD, 20));
		position.setBounds(270, 200, 132, 41);
		positiontextArea.setBounds(320, 205, 222, 31);

		workyear.setFont(new Font("SimSun", Font.BOLD, 20));
		workyear.setBounds(270, 250, 132, 41);
		worktextArea.setBounds(360, 255, 182, 31);
		salary.setFont(new Font("SimSun", Font.BOLD, 20));
		salary.setBounds(270, 300, 132, 41);
		salarytextArea.setBounds(320, 305, 222, 31);
		
		
		user = userService.getUser(MyID);
		String pos =this.IdenPos();
		String Name = user.getName();
		String Id = user.getID();
		int Sex = user.getSex();
		int Age = user.getAge();
		String IDCard = user.getIDCard();
		int WorkTime = user.getWorkTime();
		double Salary = user.getSalary();
		
		positiontextArea.setText(pos);
		nametextArea.setText(Name);
		itextArea.setText(Id);
		areatextArea.setText(IDCard);
		String MySex = this.IdenSex(Sex);
		sextextArea.setText(MySex);
		agetextArea.setText(Age+"");
		worktextArea.setText(WorkTime+"");
		salarytextArea.setText(Salary+"");
		
		this.setLayout(null);
		this.add(changeButton);
		this.add(salary);
		this.add(salarytextArea);
		this.add(workyear);
		this.add(worktextArea);
		this.add(position);
		this.add(positiontextArea);
		this.add(area);
		this.add(areatextArea);
		this.add(age);
		this.add(agetextArea);
		this.add(ID);
		this.add(itextArea);
		this.add(name);
		this.add(nametextArea);
		this.add(sex);
		this.add(sextextArea);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Image background=new ImageIcon("photo/background3.gif").getImage();
		g.drawImage(background, 0,0,null);
		Image touxiang=new ImageIcon("photo/touxiang.gif").getImage();
		g.drawImage(touxiang, 30,30,null);
	}
	
	public String IdenPos(){
		//用到UserInfo的静态方法得到ID并进行解析
		String position;
		char pos = MyID.charAt(8);
		switch (pos) {
		case '0':position = "快递员";break;	
		case '1':position = "营业厅业务员"; break;
		case '2':position = "中转中心业务员";break;
		case '3':position = "仓库管理员";break;
		case '4':position = "财务人员";break;
		case '5':position = "总经理";break;
		case '6':position = "管理员";break;
		default:position = "未知错误";break;
		}
		return position;
	}
	
	public String IdenSex(int Sex){
		String sex;
		if(Sex == 0){
			sex = "男";
		}
		else {
			sex = "女";
		}
		return sex;
	}
}
