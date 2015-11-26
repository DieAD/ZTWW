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

import nju.ztww.dao.OutStockFormDO;

public class DBForOutStockForm extends DB{
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

	public ArrayList<OutStockFormDO> queryByID(String ID, String tableName) {
		ArrayList<OutStockFormDO> list = new ArrayList<OutStockFormDO>();
		String sql = "select * from " + tableName + " where id=" + ID;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				OutStockFormDO form = new OutStockFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setTime(rs.getString(4));
				form.setAddress(rs.getString(5));
				form.setTransmethod(rs.getInt(6));
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

	public void insert(ArrayList<OutStockFormDO> list, String tableName) {
		String sql = "insert into "
				+ tableName
				+ "(id,goodsid,time,address,transmethod,exe,state)values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (OutStockFormDO form : list) {
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3, form.getTime());
				pstmt.setString(4, form.getAddress());
				pstmt.setInt(5, form.getTransmethod());
				pstmt.setInt(6, form.getExe());
				pstmt.setInt(7, form.getState());

				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(ArrayList<OutStockFormDO> list, String tableName) {
		String sql = "update "
				+ tableName
				+ " set id=?,goodsid=?,time=?,address=?,transmethod=?,exe=?,state=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (OutStockFormDO form : list) {
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3, form.getTime());
				pstmt.setString(4, form.getAddress());
				pstmt.setInt(5, form.getTransmethod());
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
	
	public static void main(String[] args){
		DBForOutStockForm db = new DBForOutStockForm();
		db.init();
		ArrayList<OutStockFormDO> list = db.queryByID("1511240001", "outstockform");
		for(OutStockFormDO form : list){
			form.setAddress("beijing");
		}
		db.update(list, "outstockform");
		db.close();
	}
}
