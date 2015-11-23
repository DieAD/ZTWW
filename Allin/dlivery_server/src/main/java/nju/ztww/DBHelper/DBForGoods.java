package nju.ztww.DBHelper;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import nju.ztww.dao.GoodsDO;

public class DBForGoods {
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

	// 建立连接
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

	// 关闭连接
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<GoodsDO> queryByID(String ID,String tableName){
		ArrayList<GoodsDO> list = new ArrayList<GoodsDO>();
		String sql = "select * from "+tableName+" where ordernumber="+ID;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
