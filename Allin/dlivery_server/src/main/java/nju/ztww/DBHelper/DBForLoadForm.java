package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.LoadFormDO;

public class DBForLoadForm extends DB {
	public ArrayList<LoadFormDO> queryByID(String ID,String tableName){
		String sql = " select * from "+tableName+" where id="+ID;
		ArrayList<LoadFormDO> list = new ArrayList<LoadFormDO>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				LoadFormDO form = new LoadFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setTime(rs.getString(4));
				form.setHoll(rs.getString(5));
				form.setTructid(rs.getString(6));
				form.setAddress(rs.getString(7));
				form.setCarid(rs.getString(8));
				form.setLoadmen(rs.getString(9));
				form.setSupercargo(rs.getString(10));
				form.setCost(rs.getDouble(11));
				form.setExe(rs.getInt(12));
				form.setState(rs.getInt(13));
				
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insert(ArrayList<LoadFormDO> list,String tableName){
	String sql = "insert into " + tableName+"(id,goodsid,time,holl,tructid,address,carid,"
			+ "loadmen,supercargo,cost,exe,state)values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(LoadFormDO form : list){
			pstmt.setString(1, form.getId());
			pstmt.setString(2, form.getGoodsid());
			pstmt.setString(3, form.getTime());
			pstmt.setString(4,form.getHoll());
			pstmt.setString(5, form.getTructid());
			pstmt.setString(6, form.getAddress());
			pstmt.setString(7, form.getCarid());
			pstmt.setString(8,form.getLoadmen());
			pstmt.setString(9, form.getSupercargo());
			pstmt.setDouble(10, form.getCost());
			pstmt.setInt(11, form.getExe());
			pstmt.setInt(12, form.getState());
			
			pstmt.executeUpdate();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void update(ArrayList<LoadFormDO> list, String tableName){
		String sql = "update "+tableName+" set id=?,goodsid=?,time=?,holl=?,tructid=?,"
				+ "address=?,carid=?,loadmen=?,supercargo=?,cost=?,exe=?,state=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(LoadFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3, form.getTime());
				pstmt.setString(4,form.getHoll());
				pstmt.setString(5, form.getTructid());
				pstmt.setString(6, form.getAddress());
				pstmt.setString(7, form.getCarid());
				pstmt.setString(8,form.getLoadmen());
				pstmt.setString(9, form.getSupercargo());
				pstmt.setDouble(10, form.getCost());
				pstmt.setInt(11, form.getExe());
				pstmt.setInt(12, form.getState());
				pstmt.setString(13, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args){
//		DBForLoadForm db = new DBForLoadForm();
//		db.init();
//		ArrayList<LoadFormDO> list = db.queryByID("1511250001", "loadform")	;
//		for(LoadFormDO form : list){
//			form.setSupercargo("习近平");
//		}
//		db.update(list, "loadform");
//		//db.insert(db.queryByID("1511250001", "loadform")	, "loadform");
//		db.close();
//	}

}
