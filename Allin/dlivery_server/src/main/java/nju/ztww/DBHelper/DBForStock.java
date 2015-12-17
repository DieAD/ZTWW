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

import nju.ztww.dao.StockDO;

public class DBForStock extends DB{
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
	
	public ArrayList<StockDO> queryByID(String ID,String tableName,String idofcenter){
		ArrayList<StockDO> list  = new ArrayList<StockDO>();
		String sql = "select * from "+tableName+" where goodsid="+ID+" and idofcenter="+idofcenter;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StockDO stock = new StockDO();
				stock.setIndex(rs.getInt(1));
				stock.setGoodsid(rs.getString(2));
				stock.setEntrytime(rs.getString(3));
				stock.setAddress(rs.getString(4));
				stock.setQu(rs.getString(5));
				stock.setPai(rs.getString(6));
				stock.setJia(rs.getString(7));
				stock.setWei(rs.getString(8));
				stock.setState(rs.getInt(9));
				stock.setIdofcenter(rs.getString(10));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insert(ArrayList<StockDO> list, String tableName){
		String sql = "insert into "+tableName+"(goodsid,entrytime,address,qu,pai,jia,wei,state,idofcenter)values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(StockDO stock : list){
				pstmt.setString(1, stock.getGoodsid());
				pstmt.setString(2, stock.getEntrytime());
				pstmt.setString(3, stock.getAddress());
				pstmt.setString(4, stock.getQu());
				pstmt.setString(5, stock.getPai());
				pstmt.setString(6, stock.getJia());
				pstmt.setString(7, stock.getWei());
				pstmt.setInt(8,stock.getState());
				pstmt.setString(9,stock.getIdofcenter());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(ArrayList<StockDO> list,String tableName){
		String sql = "update "
				+ tableName
				+ " set goodsid=?,entrytime=?,address=?,qu=?,pai=?,jia=?,wei=?,state=?,idofcenter=?"
				+ " where goodsid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(StockDO stock : list){
				pstmt.setString(1, stock.getGoodsid());
				pstmt.setString(2, stock.getEntrytime());
				pstmt.setString(3, stock.getAddress());
				pstmt.setString(4, stock.getQu());
				pstmt.setString(5, stock.getPai());
				pstmt.setString(6, stock.getJia());
				pstmt.setString(7, stock.getWei());
				pstmt.setInt(8, stock.getState());
				pstmt.setString(9, stock.getIdofcenter());
				pstmt.setString(10,stock.getGoodsid());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String ID,String tableName){
		String sql = "delete from " + tableName + " where goodsid=" + ID;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<StockDO> queryByTime(String time,String tableName,String idofcenter){
		ArrayList<StockDO> list  = new ArrayList<StockDO>();
		String sql = "select * from "+tableName+" where entrytime='"+time+"'"+"and idofcenter="+idofcenter;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StockDO stock = new StockDO();
				stock.setIndex(rs.getInt(1));
				stock.setGoodsid(rs.getString(2));
				stock.setEntrytime(rs.getString(3));
				stock.setAddress(rs.getString(4));
				stock.setQu(rs.getString(5));
				stock.setPai(rs.getString(6));
				stock.setJia(rs.getString(7));
				stock.setWei(rs.getString(8));
				stock.setState(rs.getInt(9));
				stock.setIdofcenter(rs.getString(10));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<StockDO> queryALL(String tableName,String idofcenter){
		ArrayList<StockDO> list  = new ArrayList<StockDO>();
		String sql = "select * from "+tableName+" where idofcenter="+idofcenter;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StockDO stock = new StockDO();
				stock.setIndex(rs.getInt(1));
				stock.setGoodsid(rs.getString(2));
				stock.setEntrytime(rs.getString(3));
				stock.setAddress(rs.getString(4));
				stock.setQu(rs.getString(5));
				stock.setPai(rs.getString(6));
				stock.setJia(rs.getString(7));
				stock.setWei(rs.getString(8));
				stock.setState(rs.getInt(9));
				stock.setIdofcenter(rs.getString(10));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<StockDO> queryByQu(String qu,String tableName,String idofcenter){
		ArrayList<StockDO> list  = new ArrayList<StockDO>();
		String sql = "select * from "+tableName+" where qu='"+qu+"'"+"and idofcenter="+idofcenter;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StockDO stock = new StockDO();
				stock.setIndex(rs.getInt(1));
				stock.setGoodsid(rs.getString(2));
				stock.setEntrytime(rs.getString(3));
				stock.setAddress(rs.getString(4));
				stock.setQu(rs.getString(5));
				stock.setPai(rs.getString(6));
				stock.setJia(rs.getString(7));
				stock.setWei(rs.getString(8));
				stock.setState(rs.getInt(9));
				stock.setIdofcenter(rs.getString(10));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public ArrayList<StockDO> queryEvery(String tableName){
		ArrayList<StockDO> list  = new ArrayList<StockDO>();
		String sql = "select * from "+tableName;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				StockDO stock = new StockDO();
				stock.setIndex(rs.getInt(1));
				stock.setGoodsid(rs.getString(2));
				stock.setEntrytime(rs.getString(3));
				stock.setAddress(rs.getString(4));
				stock.setQu(rs.getString(5));
				stock.setPai(rs.getString(6));
				stock.setJia(rs.getString(7));
				stock.setWei(rs.getString(8));
				stock.setState(rs.getInt(9));
				stock.setIdofcenter(rs.getString(10));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args){
		DBForStock db = new DBForStock();
		ArrayList<StockDO> list=new ArrayList<StockDO>();
		db.init();
		
		
		list=db.queryByQu("航运区", "stocktable", "02501");
		for(int i=0;i<list.size();i++){
			
		System.out.println(list.get(i).getIdofcenter());
			//list.get(i).setQu("航运区");
		}
		
		db.update(list, "stocktable");
		db.close();
	}

}
