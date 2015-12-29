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

import nju.ztww.dao.OrderFormDO;

public class DBForOrderForm extends DB{
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
	
	public ArrayList<OrderFormDO> queryByID(String ID,String tableName){
		ArrayList<OrderFormDO> list =  new ArrayList<OrderFormDO>();
		String sql = "select * from "+tableName+" where ordernumber="+ID;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				OrderFormDO order = new OrderFormDO();
				order.setIndex(rs.getInt(1));
				order.setHoll(rs.getString(2));
				order.setOrdernumber(rs.getString(3));
				order.setSender(rs.getString(4));
				order.setPhone(rs.getString(5));
				order.setUnit(rs.getString(6));
				order.setTelephone(rs.getString(7));
				order.setRecip(rs.getString(8));
				order.setRphone(rs.getString(9));
				order.setAddress(rs.getString(10));
				order.setOrderinfo(rs.getString(11));								
				order.setPretime(rs.getString(12));
				order.setExe(rs.getInt(13));
				order.setState(rs.getInt(14));
				order.setCost(rs.getDouble(15));
				order.setCat(rs.getString(16));
				
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String insert(ArrayList<OrderFormDO> list,String tableName){
		 String sql  = "insert into "+tableName+"(holl,ordernumber,sender,phone,unit,telephone,recip,rphone,address,orderinfo,pretime,exe,state,cost,cat)"
			 		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 
		 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(OrderFormDO order : list){
				pstmt.setString(1, order.getHoll());
				pstmt.setString(2, order.getOrdernumber());
				pstmt.setString(3, order.getSender());
				pstmt.setString(4, order.getPhone());
				pstmt.setString(5, order.getUnit());
				pstmt.setString(6, order.getTelephone());
				pstmt.setString(7, order.getRecip());
				pstmt.setString(8, order.getRphone());
				pstmt.setString(9, order.getAddress());
				pstmt.setString(10, order.getOrderinfo());				
				pstmt.setString(11, order.getPretime());
				pstmt.setInt(12, order.getExe());
				pstmt.setInt(13, order.getState());
				pstmt.setDouble(14, order.getCost());
				pstmt.setString(15, order.getCat());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		 return "success";
	}
	
	public String update(ArrayList<OrderFormDO> list,String tableName){
		String sql = "update "+tableName+" set holl=?,ordernumber=?,sender=?,phone=?,unit=?,"
				+ "telephone=?,recip=?,rphone=?,address=?,orderinfo=?,pretime=?,exe=?,state=?,cost=?,cat=?"
				+ " where ordernumber=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(OrderFormDO order : list){
				pstmt.setString(1, order.getHoll());
				pstmt.setString(2, order.getOrdernumber());
				pstmt.setString(3, order.getSender());
				pstmt.setString(4, order.getPhone());
				pstmt.setString(5, order.getUnit());
				pstmt.setString(6, order.getTelephone());
				pstmt.setString(7, order.getRecip());
				pstmt.setString(8, order.getRphone());
				pstmt.setString(9, order.getAddress());
				pstmt.setString(10, order.getOrderinfo());				
				pstmt.setString(11, order.getPretime());
				pstmt.setInt(12, order.getExe());
				pstmt.setInt(13, order.getState());
				pstmt.setDouble(14, order.getCost());
				pstmt.setString(15, order.getCat());
				pstmt.setString(16, order.getOrdernumber());
				
				pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
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
	 
	 public ArrayList<OrderFormDO> selectAll(){
		 ArrayList<OrderFormDO> list = new ArrayList<OrderFormDO>();
		 String sql = "select * from orderform where exe=0";
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					OrderFormDO order = new OrderFormDO();
					order.setIndex(rs.getInt(1));
					order.setHoll(rs.getString(2));
					order.setOrdernumber(rs.getString(3));
					order.setSender(rs.getString(4));
					order.setPhone(rs.getString(5));
					order.setUnit(rs.getString(6));
					order.setTelephone(rs.getString(7));
					order.setRecip(rs.getString(8));
					order.setRphone(rs.getString(9));
					order.setAddress(rs.getString(10));
					order.setOrderinfo(rs.getString(11));								
					order.setPretime(rs.getString(12));
					order.setExe(rs.getInt(13));
					order.setState(rs.getInt(14));
					order.setCost(rs.getDouble(15));
					order.setCat(rs.getString(16));
					
					list.add(order);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	 }
	 
//	 public static void main(String[] args){
//		 DBForOrderForm db = new DBForOrderForm();
//		 db.init();
//		 ArrayList<OrderFormDO> list =db.queryByID("1511240001", "orderform");
//		 for(OrderFormDO order : list){
//			 order.setAddress("shanghai");
//		 }
//		 db.update(list, "orderform");
//		 db.close();
//		 
//	 }

}
