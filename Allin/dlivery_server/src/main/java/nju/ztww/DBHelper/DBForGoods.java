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

import nju.ztww.dao.GoodsDO;

public class DBForGoods extends DB{
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
			
			while(rs.next()){
				GoodsDO good = new GoodsDO();
				good.setIndex(rs.getInt(1));
				good.setHoll(rs.getString(2));
				good.setOrdernumber(rs.getString(3));
				good.setSender(rs.getString(4));
				good.setPhone(rs.getString(5));
				good.setUnit(rs.getString(6));
				good.setTelephone(rs.getString(7));
				good.setRecip(rs.getString(8));
				good.setRphone(rs.getString(9));
				good.setAddress(rs.getString(10));
				good.setGoodsinfo(rs.getString(11));
				good.setCost(rs.getDouble(12));
				good.setGoodscat(rs.getString(13));
				good.setPretime(rs.getString(14));
				good.setLmis(rs.getString(15));
				good.setRealtime(rs.getString(16));
				good.setRealreci(rs.getString(17));
				
				list.add(good);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void update(ArrayList<GoodsDO> list,String tableName){
		String sql = "update "+tableName+" set holl=?,ordernumber=?,sender=?,phone=?,unit=?,"
				+ "telephone=?,recip=?,rphone=?,address=?,goodsinfo=?,cost=?,goodscat=?,pretime=?,"
				+ "lmis=?,realtime=?,realreci=? where ordernumber=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(GoodsDO good : list){
				pstmt.setString(1, good.getHoll());
				pstmt.setString(2, good.getOrdernumber());
				pstmt.setString(3, good.getSender());
				pstmt.setString(4, good.getPhone());
				pstmt.setString(5, good.getUnit());
				pstmt.setString(6, good.getTelephone());
				pstmt.setString(7, good.getRecip());
				pstmt.setString(8, good.getRphone());
				pstmt.setString(9, good.getAddress());
				pstmt.setString(10, good.getGoodsinfo());
				pstmt.setDouble(11, good.getCost());
				pstmt.setString(12, good.getGoodscat());
				pstmt.setString(13, good.getPretime());
				pstmt.setString(14, good.getLmis());
				pstmt.setString(15, good.getRealtime());
				pstmt.setString(16, good.getRealreci());
				pstmt.setString(17, good.getOrdernumber());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	String sql = "update "+tableName+"set holl=?,ordernumber=?,sender=?,phone=?,unit=?"
//			+ ",telephone=?,recip=?,rphone=?,address=?,goodsinfo=?,cost=?,goodscat=?,pretime=?,"
//			+ "lmis=?,realtime=?,realreci=? where id=?";
//	
	 public void insert(ArrayList<GoodsDO>  list,String tableName){
		 String sql  = "insert into "+tableName+"(holl,ordernumber,sender,phone,unit,telephone,recip,rphone,address,goodsinfo,cost,goodscat,pretime,"
		 		+ "lmis,realtime,realreci)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 
		 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(GoodsDO good : list){
				pstmt.setString(1, good.getHoll());
				pstmt.setString(2, good.getOrdernumber());
				pstmt.setString(3, good.getSender());
				pstmt.setString(4, good.getPhone());
				pstmt.setString(5, good.getUnit());
				pstmt.setString(6, good.getTelephone());
				pstmt.setString(7, good.getRecip());
				pstmt.setString(8, good.getRphone());
				pstmt.setString(9, good.getAddress());
				pstmt.setString(10, good.getGoodsinfo());
				pstmt.setDouble(11, good.getCost());
				pstmt.setString(12, good.getGoodscat());
				pstmt.setString(13, good.getPretime());
				pstmt.setString(14, good.getLmis());
				pstmt.setString(15, good.getRealtime());
				pstmt.setString(16, good.getRealreci());
				
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
	 
	 public static void main(String[] args){
		 DBForGoods db = new DBForGoods();
		 db.init();
		 ArrayList<GoodsDO> list = db.queryByID("2015112301", "goodstable");
	     for(GoodsDO good:list){
	    	 good.setAddress("beijing");
	     }
		 db.update(list, "goodstable");
		 db.close();
	 }
		
	
}
