package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.LoadFormDO;
import nju.ztww.po.LoadingPO;

public class DBForLoadForm extends DB {
	public ArrayList<LoadingPO> queryByID(String ID,String tableName){
		String sql = " select * from "+tableName+" where id="+ID;
		ArrayList<LoadingPO> list = new ArrayList<LoadingPO>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				LoadingPO form = new LoadingPO(4);
				ArrayList<String> orderNumber=new ArrayList<String>();
				form.setId(rs.getString(2));
				orderNumber.add(rs.getString(3));
				form.setOrderNumber(orderNumber);
				orderNumber.clear();
				form.setData(rs.getString(4));
				form.setYingYeNumber(rs.getString(5));
				form.setQiYunNumber(rs.getString(6));
				form.setArrive(rs.getString(7));
				form.setCarNumber(rs.getString(8));
				form.setJianZhuangName(rs.getString(9));
				form.setYaYunName(rs.getString(10));
				form.setMoney(rs.getDouble(11));
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
	
	public String insert(ArrayList<LoadingPO> list,String tableName){
	String sql = "insert into " + tableName+"(id,goodsid,time,holl,tructid,address,carid,"
			+ "loadmen,supercargo,cost,exe,state)values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(LoadingPO form : list){
			pstmt.setString(1, form.getId());
			pstmt.setString(2, form.getOrderNumber().get(0));
			pstmt.setString(3, form.getData());
			pstmt.setString(4,form.getYingYeNumber());
			pstmt.setString(5, form.getQiYunNumber());
			pstmt.setString(6, form.getArrive());
			pstmt.setString(7, form.getCarNumber());
			pstmt.setString(8,form.getJianZhuangName());
			pstmt.setString(9, form.getYaYunName());
			pstmt.setDouble(10, form.getMoney());
			pstmt.setInt(11, form.getExe());
			pstmt.setInt(12, form.getState());
			
			pstmt.executeUpdate();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "success";
	}
	
	public String update(ArrayList<LoadingPO> list, String tableName){
		String sql = "update "+tableName+" set id=?,goodsid=?,time=?,holl=?,tructid=?,"
				+ "address=?,carid=?,loadmen=?,supercargo=?,cost=?,exe=?,state=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(LoadingPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getOrderNumber().get(0));
				pstmt.setString(3, form.getData());
				pstmt.setString(4,form.getYingYeNumber());
				pstmt.setString(5, form.getQiYunNumber());
				pstmt.setString(6, form.getArrive());
				pstmt.setString(7, form.getCarNumber());
				pstmt.setString(8,form.getJianZhuangName());
				pstmt.setString(9, form.getYaYunName());
				pstmt.setDouble(10, form.getMoney());
				pstmt.setInt(11, form.getExe());
				pstmt.setInt(12, form.getState());
				pstmt.setString(13, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
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
