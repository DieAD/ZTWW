package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.po.LoadingPO;
import nju.ztww.po.ShippingPO;

public class DBForShippingForm extends DB {
	
	public ArrayList<ShippingPO> queryByID(String ID,String tableName){
		String sql = " select * from "+tableName+" where id="+ID;
		ArrayList<ShippingPO> list = new ArrayList<ShippingPO>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				ShippingPO form = new ShippingPO(7);
				form.setId(rs.getString(2));
				form.setOrderNumber(rs.getString(3));
				form.setData(rs.getString(4));
				form.setQiYunNumber(rs.getString(5));
				form.setArrivePlace(rs.getString(6));
				form.setCarNumber(rs.getString(7));
				form.setJianZhuangName(rs.getString(8));
				form.setYaYunName(rs.getString(9));
				form.setMoney(rs.getDouble(10));
				form.setExe(rs.getInt(11));
				form.setState(rs.getInt(12));
				
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String insert(ArrayList<ShippingPO> list,String tableName){
	String sql = "insert into " + tableName+"(id,goodsid,time,tructid,address,carid,"
			+ "loadmen,supercargo,cost,exe,state)values(?,?,?,?,?,?,?,?,?,?,?)";
	
	
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(ShippingPO form : list){
			pstmt.setString(1, form.getId());
			pstmt.setString(2, form.getOrderNumber());
			pstmt.setString(3, form.getData());
			pstmt.setString(4, form.getQiYunNumber());
			pstmt.setString(5, form.getArrivePlace());
			pstmt.setString(6, form.getCarNumber());
			pstmt.setString(7,form.getJianZhuangName());
			pstmt.setString(8, form.getYaYunName());
			pstmt.setDouble(9, form.getMoney());
			pstmt.setInt(10, form.getExe());
			pstmt.setInt(11, form.getState());
			
			pstmt.executeUpdate();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		return "fail";
	}
	return "success";
	}

	public String update(ArrayList<ShippingPO> list, String tableName){
		String sql = "update "+tableName+" set id=?,goodsid=?,time=?,tructid=?,"
				+ "address=?,carid=?,loadmen=?,supercargo=?,cost=?,exe=?,state=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(ShippingPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getOrderNumber());
				pstmt.setString(3, form.getData());
				pstmt.setString(4, form.getQiYunNumber());
				pstmt.setString(5, form.getArrivePlace());
				pstmt.setString(6, form.getCarNumber());
				pstmt.setString(7,form.getJianZhuangName());
				pstmt.setString(8, form.getYaYunName());
				pstmt.setDouble(9, form.getMoney());
				pstmt.setInt(10, form.getExe());
				pstmt.setInt(11, form.getState());
				pstmt.setString(12, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
		return "success";
	}
}
