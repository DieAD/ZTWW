package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nju.ztww.dao.DCFormDO;

public class DBForDCForm extends DB {
	public DCFormDO query(String city1, String city2) {
		
		String sql = "select * from dctable where city1='"+city1+"' and city2='"+city2+"'";
//				+ " and city2=" + city2;
		DCFormDO form = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
   
			rs.next();
			form = new DCFormDO();
			form.setIndex(rs.getInt(1));
			form.setCity1(rs.getString(2));
			form.setCity2(rs.getString(3));
			form.setDistance(rs.getDouble(4));
			form.setEco(rs.getDouble(5));
			form.setSta(rs.getDouble(6));
			form.setFas(rs.getDouble(7));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return form;
	}
	
	public void insert(DCFormDO form){
		String sql = "insert into dctable(city1,city2,distance,eco,sta,fas)values"
				+ "(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, form.getCity1());
			pstmt.setString(2,form.getCity2());
			pstmt.setDouble(3, form.getDistance());
			pstmt.setDouble(4,form.getEco());
			pstmt.setDouble(5, form.getSta());
			pstmt.setDouble(6, form.getFas());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(DCFormDO form){
		String sql = "update dctable set city1=?,city2=?,distance=?,eco=?,sta=?,fas=? where city1=? and city2=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, form.getCity1());
			pstmt.setString(2,form.getCity2());
			pstmt.setDouble(3, form.getDistance());
			pstmt.setDouble(4,form.getEco());
			pstmt.setDouble(5, form.getSta());
			pstmt.setDouble(6, form.getFas());
			pstmt.setString(7, form.getCity1());
			pstmt.setString(8, form.getCity2());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static void main(String[] args){
//		DBForDCForm db = new DBForDCForm();
//		db.init();
//		DCFormDO form  =db.query("北京", "上海");
//		form.setSta(999);
//		db.update(form);
//		db.close();
//	}
}
