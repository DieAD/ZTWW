package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.DeliveryFormDO;

public class DBForDeliveryForm extends DB{

	
	public ArrayList<DeliveryFormDO> queryByID(String ID,String tableName){
		ArrayList<DeliveryFormDO> list = new ArrayList<DeliveryFormDO>();
		String sql = "select * from "+tableName+" where id="+ID;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				DeliveryFormDO form = new DeliveryFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setCourierid(rs.getString(4));
				form.setArrivetime(rs.getString(5));
				form.setExe(rs.getInt(6));
				form.setState(rs.getInt(7));
				
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public void insert(ArrayList<DeliveryFormDO> list,String tableName){
		String sql = "insert into "+tableName+"(id,goodsid,courierid,arrivetime,exe,state)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(DeliveryFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getGoodsid());
				pstmt.setString(3, form.getCourierid());
				pstmt.setString(4, form.getArrivetime());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(ArrayList<DeliveryFormDO> list,String tableName){
		String sql = "update "+tableName+" set id=?,goodsid=?,courierid=?,arrivetime=?,exe=?,state=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(DeliveryFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getGoodsid());
				pstmt.setString(3, form.getCourierid());
				pstmt.setString(4, form.getArrivetime());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				pstmt.setString(7,form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		DBForDeliveryForm db = new DBForDeliveryForm();
		db.init();
	//	db.insert(db.queryByID("1511250001", "deliveryform"), "deliveryform");
		ArrayList<DeliveryFormDO> list =db.queryByID("1511250001", "deliveryform");
		for(DeliveryFormDO form : list){
			form.setArrivetime("不送了，慢慢等吧");
		}
		db.update(list, "deliveryform");
		db.close();
		
	}
	
	
}
