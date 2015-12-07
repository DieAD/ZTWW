package nju.ztww.DBHelper;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import nju.ztww.dao.UserDO;
import nju.ztww.po.ManaUserPO;

/**
 * @author wh
 *用法： 实例化该类的一个对象
 *首先调用 init（）；建立连接（注意跟我要ip地址，在 config.properties中修改）
 *
 *这里分别有增删改查的方法，可以按情况调用
 *
 *有一个方法叫 queryTable()用于遍历table中内容并在控制台输出，方便查看你的操作有没有成功
 *
 *最后操作完成后调用 close（）方法关闭连接；
 *
 *另： table中每一行，对应一个userDO对象（为了不和userPO产生冲突,我在value模块中新建的一个DO模块，具体成员变量自己去看一下）
 */
public class DBHelper extends DB{
	private static String driver;
	private static String url;
	private static String username;
	private static String psw;
	private Connection conn = null;

	static {
		Properties prop = new Properties();
		Reader in;
		try {
			in = new FileReader("src\\main\\java\\config.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		psw = prop.getProperty("psw");
	}

	
	//建立连接
	public void init() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //用于测试table中的内容，在控制台输出内容；
	public void queryTable(String tableName) {
		String sql = "select * from " + tableName;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int index = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				String psw = rs.getString(4);
				String authority = rs.getString(5);
				int age = rs.getInt(6);
				int worktime = rs.getInt(7);
				String idcard = rs.getString(8);
				int salarymethod = rs.getInt(9);
				double salary = rs.getDouble(10);
				int wetherwork = rs.getInt(11);
				int sex = rs.getInt(12);
				String phone = rs.getString(13);
				int times = rs.getInt(14);
				double sp = rs.getDouble(15);
				String info = index + " " + id + " " + name + " " + psw + " "
						+ authority + " " + age + " " + worktime + " " + idcard
						+ " " + salarymethod + " " + salary + " " + wetherwork
						+ " " + sex + " " + phone + " " + times + " " + sp;
				System.out.println(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    //关闭连接
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<UserDO> searchByPosition(String index,String tableName){
		ArrayList<UserDO> list = new ArrayList<UserDO>();
		String sql = "select * from " + tableName + " where position='" + index+"'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserDO userDO = new UserDO();
				userDO.setIndex(rs.getInt(1));
				userDO.setId(rs.getString(2));
				userDO.setName(rs.getString(3));
				userDO.setPsw(rs.getString(4));
				userDO.setAuthority(rs.getString(5));
				userDO.setAge(rs.getInt(6));
				userDO.setWorktime(rs.getInt(7));
				userDO.setIdcard(rs.getString(8));
				userDO.setSalarymethod(rs.getInt(9));
				userDO.setSalary(rs.getDouble(10));
				userDO.setWetherwork(rs.getInt(11));
				userDO.setSex(rs.getInt(12));
				userDO.setPhone(rs.getString(13));
				userDO.setTimes(rs.getInt(14));
				userDO.setSp(rs.getDouble(15));
				userDO.setPosition(rs.getString(16));
				list.add(userDO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    //按ID值返回一个UserDO list
	/**
	 * @param id
	 * @param tableName
	 * @return
	 */
	public ArrayList<UserDO> queryByID(String id, String tableName) {
		ArrayList<UserDO> list = new ArrayList<UserDO>();
		String sql = "select * from " + tableName + " where id=" + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UserDO userDO = new UserDO();
				userDO.setIndex(rs.getInt(1));
				userDO.setId(rs.getString(2));
				userDO.setName(rs.getString(3));
				userDO.setPsw(rs.getString(4));
				userDO.setAuthority(rs.getString(5));
				userDO.setAge(rs.getInt(6));
				userDO.setWorktime(rs.getInt(7));
				userDO.setIdcard(rs.getString(8));
				userDO.setSalarymethod(rs.getInt(9));
				userDO.setSalary(rs.getDouble(10));
				userDO.setWetherwork(rs.getInt(11));
				userDO.setSex(rs.getInt(12));
				userDO.setPhone(rs.getString(13));
				userDO.setTimes(rs.getInt(14));
				userDO.setSp(rs.getDouble(15));
				userDO.setPosition(rs.getString(16));
				list.add(userDO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<ManaUserPO> queryAll(String tableName) {
		ArrayList<ManaUserPO> list = new ArrayList<ManaUserPO>();
		String sql = "select * from " + tableName ;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ManaUserPO userDO = new ManaUserPO();
				userDO.setId(rs.getString(2));
				userDO.setName(rs.getString(3));
				userDO.setPsw(rs.getString(4));
				userDO.setAuthority(rs.getString(5));
				userDO.setAge(rs.getInt(6));
				userDO.setWorktime(rs.getInt(7));
				userDO.setIdcard(rs.getString(8));
				userDO.setSalarymethod(rs.getInt(9));
				userDO.setSalary(rs.getDouble(10));
				userDO.setWetherwork(rs.getInt(11));
				userDO.setSex(rs.getInt(12));
				userDO.setPhone(rs.getString(13));
				userDO.setTimes(rs.getInt(14));
				userDO.setSp(rs.getDouble(15));
				userDO.setPosition(rs.getString(16));
				list.add(userDO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
   //增加记录
	/**
	 * @param userDOList
	 * @param tableName
	 */
	public void insert(ArrayList<UserDO> userDOList, String tableName) {
		String sql = "insert into "
				+ tableName
				+ "(id,name,psw,authority,age,worktime,idcard,salarymethod,salary,wetherwork,sex,phone,times,sp,position)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (UserDO user : userDOList) {
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getPsw());
				pstmt.setString(4, user.getAuthority());
				pstmt.setInt(5, user.getAge());
				pstmt.setInt(6, user.getWorktime());
				pstmt.setString(7, user.getIdcard());
				pstmt.setInt(8, user.getSalarymethod());
				pstmt.setDouble(9, user.getSalary());
				pstmt.setInt(10, user.getWetherwork());
				pstmt.setInt(11, user.getSex());
				pstmt.setString(12, user.getPhone());
				pstmt.setInt(13, user.getTimes());
				pstmt.setDouble(14, user.getSp());
				pstmt.setString(15, user.getPosition());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**修改
	 * @param userDOList
	 * @param tableName
	 */
	public String updateByID(ArrayList<UserDO> userDOList, String tableName) {
		String sql = "update "
				+ tableName
				+ " set name=?,psw=?,authority=?,age=?,worktime=?,idcard=?,salarymethod=?,salary=?"
				+ ",wetherwork=?,sex=?,phone=?,times=?,sp=?,position=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (UserDO user : userDOList) {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPsw());
				pstmt.setString(3, user.getAuthority());
				pstmt.setInt(4, user.getAge());
				pstmt.setInt(5, user.getWorktime());
				pstmt.setString(6, user.getIdcard());
				pstmt.setInt(7, user.getSalarymethod());
				pstmt.setDouble(8, user.getSalary());
				pstmt.setInt(9, user.getWetherwork());
				pstmt.setInt(10, user.getSex());
				pstmt.setString(11, user.getPhone());
				pstmt.setInt(12, user.getTimes());
				pstmt.setDouble(13, user.getSp());
				pstmt.setString(14, user.getPosition());
				pstmt.setString(15, user.getId());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**按照id删除对应记录
	 * @param ID
	 * @param tableName
	 */
	public void delete(String ID, String tableName) {
		String sql = "delete from " + tableName + " where id=" + ID;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public  String getSize(String tableName){
		String sql = "select count(*) from "+tableName;
		long len = 0;
		int  length;
		String str = "0000";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			len = rs.getInt(1);
			length = (int) (len%9999);
			 str=  String.format("%04d", length);
			System.out.print(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	
//	public static void main(String[] args){
//		DBHelper db = new DBHelper();
//		db.init();
//		db.getSize("userstable");
//		db.close();
//	}

	
}
