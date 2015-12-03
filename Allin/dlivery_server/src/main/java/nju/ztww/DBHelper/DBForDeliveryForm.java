package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.DeliveryFormDO;
import nju.ztww.po.SendPO;

public class DBForDeliveryForm extends DB{
	public ArrayList<DeliveryFormDO> selectAll(){
		ArrayList<DeliveryFormDO> list = new ArrayList<DeliveryFormDO>();
		String sql = "select * from deliveryform where exe=0";
		
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

	
	public ArrayList<SendPO> queryByID(String ID,String tableName){
		ArrayList<SendPO> list = new ArrayList<SendPO>();
		String sql = "select * from "+tableName+" where id="+ID;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				SendPO form = new SendPO(6);
				form.setId(rs.getString(2));
				form.setOrderNumber(rs.getString(3));
				form.setSenderName(rs.getString(4));
				form.setData(rs.getString(5));
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
	
	public String insert(ArrayList<SendPO> list,String tableName){
		String sql = "insert into "+tableName+"(id,goodsid,courierid,arrivetime,exe,state)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(SendPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getOrderNumber());
				pstmt.setString(3, form.getSenderName());
				pstmt.setString(4, form.getData());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public String update(ArrayList<SendPO> list,String tableName){
		String sql = "update "+tableName+" set id=?,goodsid=?,courierid=?,arrivetime=?,exe=?,state=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(SendPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getOrderNumber());
				pstmt.setString(3, form.getSenderName());
				pstmt.setString(4, form.getData());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				pstmt.setString(7,form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
//	public static void main(String[] args){
//		DBForDeliveryForm db = new DBForDeliveryForm();
//		db.init();
//	//	db.insert(db.queryByID("1511250001", "deliveryform"), "deliveryform");
//		ArrayList<DeliveryFormDO> list =db.queryByID("1511250001", "deliveryform");
//		for(DeliveryFormDO form : list){
//			form.setArrivetime("不送了，慢慢等吧");
//		}
//		db.update(list, "deliveryform");
//		db.close();
		
//	}
	
	
}
