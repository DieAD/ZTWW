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
import nju.ztww.dao.StockDO;

public class DBForEntryForm extends DB{
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
	
	public ArrayList<EntryFormDO> selectAll() {
		ArrayList<EntryFormDO> list = new ArrayList<EntryFormDO>();
		String sql = "select * from entryform where exe=0";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EntryFormDO form = new EntryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setEntrytime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setQu(rs.getString(6));
				form.setPai(rs.getString(7));
				form.setJia(rs.getString(8));
				form.setWei(rs.getString(9));
				form.setExe(rs.getInt(10));
				form.setState(rs.getInt(11));
				form.setIdofcenter(rs.getString(12));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<EntryFormDO> queryByID(String ID, String tableName,String idofcenter) {
		ArrayList<EntryFormDO> list = new ArrayList<EntryFormDO>();
		String sql = "select * from " + tableName + " where goodsid=" + ID+" and idofcenter="+idofcenter;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EntryFormDO form = new EntryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setEntrytime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setQu(rs.getString(6));
				form.setPai(rs.getString(7));
				form.setJia(rs.getString(8));
				form.setWei(rs.getString(9));
				form.setExe(rs.getInt(10));
				form.setState(rs.getInt(11));
				form.setIdofcenter(rs.getString(12));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String insert(ArrayList<EntryFormDO> list, String tableName) {
		String sql = "insert into "
				+ tableName
				+ "(goodsid,entrytime,address,qu,pai,jia,wei,id,exe,state)values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (EntryFormDO form : list) {
				pstmt.setString(1, form.getGoodsid());
				pstmt.setString(2, form.getEntrytime());
				pstmt.setString(3, form.getAddress());
				pstmt.setString(4, form.getQu());
				pstmt.setString(5, form.getPai());
				pstmt.setString(6, form.getJia());
				pstmt.setString(7, form.getWei());
				pstmt.setString(8, form.getId());
				pstmt.setInt(9, form.getExe());
				pstmt.setInt(10, form.getState());

				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
	}
	
	public void update(ArrayList<EntryFormDO> list,String tableName){
     String sql = "update "+ tableName +" set goodsid=?,entrytime=?,address=?,qu=?,pai=?,jia=?,wei=?,id=?,exe=?,state=?,idofcenter=? where goodsid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(EntryFormDO form : list){
				pstmt.setString(1, form.getGoodsid());
				pstmt.setString(2, form.getEntrytime());
				pstmt.setString(3, form.getAddress());
				pstmt.setString(4, form.getQu());
				pstmt.setString(5, form.getPai());
				pstmt.setString(6, form.getJia());
				pstmt.setString(7, form.getWei());
				pstmt.setString(8, form.getId());
				pstmt.setInt(9, form.getExe());
				pstmt.setInt(10, form.getState());
				pstmt.setString(11,form.getIdofcenter());
				pstmt.setString(12,form.getGoodsid());
				
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String ID,String tableName){
		String sql = "delete from " + tableName + " where id=" + ID;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<EntryFormDO> queryByTime(String time, String tableName,String idofcenter) {
		ArrayList<EntryFormDO> list = new ArrayList<EntryFormDO>();
		String sql = "select * from " + tableName + " where entrytime= '"+time+"'and exe=1 "+" and idofcenter="+idofcenter ;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EntryFormDO form = new EntryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setEntrytime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setQu(rs.getString(6));
				form.setPai(rs.getString(7));
				form.setJia(rs.getString(8));
				form.setWei(rs.getString(9));
				form.setExe(rs.getInt(10));
				form.setState(rs.getInt(11));
				form.setIdofcenter(rs.getString(12));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<EntryFormDO> queryALL( String tableName) {
		ArrayList<EntryFormDO> list = new ArrayList<EntryFormDO>();
		String sql = "select * from " + tableName  ;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EntryFormDO form = new EntryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setEntrytime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setQu(rs.getString(6));
				form.setPai(rs.getString(7));
				form.setJia(rs.getString(8));
				form.setWei(rs.getString(9));
				form.setExe(rs.getInt(10));
				form.setState(rs.getInt(11));
				form.setIdofcenter(rs.getString(12));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<EntryFormDO> queryByCenterID(String ID, String tableName,String idofcenter) {
		ArrayList<EntryFormDO> list = new ArrayList<EntryFormDO>();
		String sql = "select * from " + tableName + " where id=" + ID+" where idofcenter"+idofcenter;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EntryFormDO form = new EntryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setEntrytime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setQu(rs.getString(6));
				form.setPai(rs.getString(7));
				form.setJia(rs.getString(8));
				form.setWei(rs.getString(9));
				form.setExe(rs.getInt(10));
				form.setState(rs.getInt(11));
				form.setIdofcenter(rs.getString(12));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args){
		
		DBForEntryForm db = new DBForEntryForm();
		db.init();
		
		ArrayList<EntryFormDO>list=db.queryByTime("15/12/10", "entryform", "02501");
		EntryFormDO entrydo=new EntryFormDO();
	          
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getExe());
		
		}
		list.get(list.size()-1).setExe(1);
		db.update(list, "entryform");
		db.close();
	
		
	}

}
