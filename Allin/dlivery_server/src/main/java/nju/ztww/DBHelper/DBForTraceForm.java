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

import nju.ztww.dao.EntryFormDO;
import nju.ztww.dao.TraceFormDO;

public class DBForTraceForm extends DB {
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
   public ArrayList<TraceFormDO> queryByID(String id,String tableName){
	   ArrayList<TraceFormDO> list = new ArrayList<TraceFormDO>();
	   String sql = "select * from "+tableName+" where goodsid="+id;
	   try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TraceFormDO traceformdo=new TraceFormDO();
				traceformdo.setIndex(rs.getInt(1));
				traceformdo.setGoodsid(rs.getString(2));
				traceformdo.setTrace(rs.getString(3));
				list.add(traceformdo);
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  
   }
   //直接插入一行
   public void insert(TraceFormDO traceformdo, String tableName){
	   String sql = "insert into "
				+ tableName
				+ "(goodsid,trace)values(?,?)";
	   try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, traceformdo.getGoodsid());
			pstmt.setString(3, traceformdo.getTrace());
			pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void update(TraceFormDO traceformdo, String tableName){
	   String sql = "update "+ tableName +" set goodsid=?,entrytime=?where goodsid=?";
	   try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, traceformdo.getGoodsid());
			pstmt.setString(2, traceformdo.getTrace());
			pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
