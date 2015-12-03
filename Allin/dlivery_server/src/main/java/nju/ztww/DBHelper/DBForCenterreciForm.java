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

import nju.ztww.dao.CenterreciFormDO;
import nju.ztww.po.CenterReceivePO;

public class DBForCenterreciForm extends DB{
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
	public ArrayList<CenterreciFormDO> selectAll(){
		ArrayList<CenterreciFormDO> list = new ArrayList<CenterreciFormDO>();

		String sql = " select * from centerreciform where exe=0" ;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CenterreciFormDO form = new CenterreciFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setCenterid(rs.getString(3));
				form.setGoodsid(rs.getString(4));
				form.setTime(rs.getString(5));
				form.setBddress(rs.getString(6));
				form.setGoodsstate(rs.getString(7));
				form.setExe(rs.getInt(8));
				form.setState(rs.getInt(9));

				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}


	public ArrayList<CenterReceivePO> queryByID(String ID, String tableName) {
		ArrayList<CenterReceivePO> list = new ArrayList<CenterReceivePO>();

		String sql = " select * from " + tableName + " where id=" + ID;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CenterReceivePO form = new CenterReceivePO(3);
				form.setId(rs.getString(2));
				form.setCenterNumber(rs.getString(3));
				form.setTransferNumber(rs.getString(4));
				form.setData(rs.getString(5));
				form.setSendPlace(rs.getString(6));
				form.setOrderState(rs.getString(7));
				form.setExe(rs.getInt(8));
				form.setState(rs.getInt(9));

				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public String insert(ArrayList<CenterReceivePO> list, String tableName) {
		String sql = "insert into " + tableName
				+ "(id,centerid,goodsid,time,bddress,goodsstate,exe,state)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (CenterReceivePO form : list) {
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getCenterNumber());
				pstmt.setString(3, form.getTransferNumber());
				pstmt.setString(4, form.getData());
				pstmt.setString(5, form.getSendPlace());
				pstmt.setString(6, form.getOrderState());
				pstmt.setInt(7, form.getExe());
				pstmt.setInt(8, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String update(ArrayList<CenterReceivePO> list,String tableName){
		String sql = " update "+tableName+" set id=?,centerid=?,goodsid=?,time=?,bddress=?,goodsstate=?,exe=?,state=?"
				+ " where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(CenterReceivePO form: list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getCenterNumber());
				pstmt.setString(3, form.getTransferNumber());
				pstmt.setString(4, form.getData());
				pstmt.setString(5, form.getSendPlace());
				pstmt.setString(6, form.getOrderState());
				pstmt.setInt(7, form.getExe());
				pstmt.setInt(8, form.getState());
				pstmt.setString(9,form.getId());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
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
	
//	public static void main(String[] args){
//		DBForCenterreciForm db = new DBForCenterreciForm();
//		db.init();
//		ArrayList<CenterreciFormDO> list = db.queryByID("1511250001","centerreciform");
//		for(CenterreciFormDO form : list){
//			form.setBddress("nanjing");
//		}
//		db.update(list, "centerreciform");
//		db.close();
//	}
}
