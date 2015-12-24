package nju.ztww.ui.user;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import nju.ztww.service.UserService;
import nju.ztww.serviceimpl.UserLoginImpl;
import nju.ztww.ui.main.UserInfoUI;
import nju.ztww.vo.UserVO;
import confligUI.MyLabel;
import confligUI.MyTextField;

public class PersonalMesageUI extends JPanel{
	
	private  MyLabel name=new  MyLabel("姓名");
	private MyTextField nametextArea=new MyTextField("");
	private  MyLabel sex=new  MyLabel("性别");
	private MyTextField sextextArea=new MyTextField("");
	private  MyLabel ID=new  MyLabel("ID");
	private MyTextField itextArea=new MyTextField("");
	private  MyLabel area=new  MyLabel("身份证号");
	private MyTextField areatextArea=new MyTextField("");
	private  MyLabel position=new  MyLabel("职位");
	private MyTextField positiontextArea=new MyTextField("");
	private  MyLabel age=new  MyLabel("年龄");
	private MyTextField agetextArea=new MyTextField("");
	private  MyLabel workyear=new  MyLabel("工作时间");
	private MyTextField worktextArea=new MyTextField("");
	private  MyLabel salary=new  MyLabel("薪水");
	private MyTextField salarytextArea=new MyTextField("");
	
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
		ID.setBounds(490, 50, 132, 41);
		itextArea.setBounds(520, 55, 120, 31);
		age.setFont(new Font("SimSun", Font.BOLD, 20));
		age.setBounds(475, 100, 132, 41);
		agetextArea.setBounds(520, 105, 120, 31);
		area.setFont(new Font("SimSun", Font.BOLD, 20));
		area.setBounds(270, 150, 132, 41);
		areatextArea.setBounds(360, 155, 242, 31);
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
		this.setBounds(150,100,750,450);
//		this.add(changeButton);
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
		String path = loadImage();
		Image background=new ImageIcon("photo/PersonInfoBG.png").getImage();
		g.drawImage(background, 0,0,null);
		Image touxiang=new ImageIcon(path).getImage();
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
	public String loadImage(){
		String path = "photo2/";
		char pos = MyID.charAt(8);
		switch (pos) {
		case '0':path+="L1.png";break;	
		case '1':path+="L2.png"; break;
		case '2':path+="L3.png";break;
		case '3':path+="L4.png";break;
		case '4':path+="L5.png";break;
		case '5':path+="L6.png";break;
		case '6':path+="L7.png";break;
		default:path+="L1.png";break;
		}
		return path;
	}
}
