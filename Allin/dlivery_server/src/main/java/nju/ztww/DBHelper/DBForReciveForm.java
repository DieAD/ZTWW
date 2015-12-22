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

import nju.ztww.dao.ReciveFormDO;

public class DBForReciveForm extends DB{
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
	
	public ArrayList<ReciveFormDO> queryByID(String ID,String tableName){
		ArrayList<ReciveFormDO> list =new ArrayList<ReciveFormDO>();
		String sql = " select * from "+tableName+" where id="+ID;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			 ReciveFormDO form = new ReciveFormDO();
			 form.setIndex(rs.getInt(1));
			 form.setId(rs.getString(2));
			 form.setHoll(rs.getString(3));
			 form.setRecip(rs.getString(4));
			 form.setRealtime(rs.getString(5));
			 form.setCourierid(rs.getString(6));
			 form.setExe(rs.getInt(7));
			 form.setState(rs.getInt(8));
			 
			 list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String insert(ArrayList<ReciveFormDO> list,String tableName){
		String sql = "insert into "+tableName+"(id,holl,recip,realtime,courierid,exe,state)"
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(ReciveFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getHoll());
				pstmt.setString(3, form.getRecip());
				pstmt.setString(4, form.getRealtime());
				pstmt.setString(5, form.getCourierid());
				pstmt.setInt(6, form.getExe());
				pstmt.setInt(7, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
	}
	
	public void update(ArrayList<ReciveFormDO> list,String tableName){
		String sql = " update "+tableName+" set id=?,holl=?,recip=?,realtime=?,courierid=?,exe=?,state=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(ReciveFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getHoll());
				pstmt.setString(3, form.getRecip());
				pstmt.setString(4, form.getRealtime());
				pstmt.setString(5, form.getCourierid());
				pstmt.setInt(6, form.getExe());
				pstmt.setInt(7, form.getState());
				pstmt.setString(8, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete(String ID,String tableName){
		 String sql = "delete from "+tableName+" where ordernumber="+ID;
		 try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
//	public  static void main(String[] args){
//		DBForReciveForm db = new DBForReciveForm();
//		db.init();
//		//db.insert(db.queryByID("1511250001", "reciveform"), "reciveform");
//		ArrayList<ReciveFormDO> list = db.queryByID("1511250001", "reciveform");
//		for(ReciveFormDO form : list){
//			form.setRecip("haha");
//		}
//		db.update(list, "reciveform");
//		db.close();
//	}
}
