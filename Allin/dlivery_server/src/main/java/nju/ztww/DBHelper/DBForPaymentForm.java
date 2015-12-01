package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.PaymentFormDO;

public class DBForPaymentForm extends DB{
     public ArrayList<PaymentFormDO> queryByDate(String date,String tableName){
    	 ArrayList<PaymentFormDO> list = new ArrayList<PaymentFormDO>();
    	 String sql = "select * from "+tableName + " where date='"+date+"'";
    	 
    	 try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				PaymentFormDO form = new PaymentFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setDate(rs.getString(3));
				form.setMoney(rs.getDouble(4));
				form.setPaymen(rs.getString(5));
				form.setPayaccount(rs.getString(6));
				form.setPaycat(rs.getString(7));
				form.setPs(rs.getString(8));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 return list;
     }
     
     public void insert(ArrayList<PaymentFormDO> list ,String tableName){
    	 String sql = "insert into "+tableName+"(id,date,money,paymen,payaccount,paycat,ps)values(?,?,?,?,?,?,?)";
    	 
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(PaymentFormDO form : list){
				pstmt.setString(1,form.getId());
				pstmt.setString(2, form.getDate());
				pstmt.setDouble(3,form.getMoney());
				pstmt.setString(4,form.getPaymen());
				pstmt.setString(5, form.getPayaccount());
				pstmt.setString(6, form.getPaycat());
				pstmt.setString(7, form.getPs());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
     public void update(ArrayList<PaymentFormDO> list,String tableName){
    	 String sql = "update "+tableName+" set id=?,date=?,money=?,paymen=?,payaccount=?,paycat=?,ps=? where id=?";
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(PaymentFormDO form : list){
				pstmt.setString(1,form.getId());
				pstmt.setString(2, form.getDate());
				pstmt.setDouble(3,form.getIndex());
				pstmt.setString(4,form.getPaymen());
				pstmt.setString(5, form.getPayaccount());
				pstmt.setString(6, form.getPaycat());
				pstmt.setString(7, form.getPs());
				pstmt.setString(8, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
     public ArrayList<PaymentFormDO> totalPayment(String tableName){
    	 ArrayList<PaymentFormDO> list =new ArrayList<PaymentFormDO>();
    	 
    	 String sql = " select * from "+ tableName;
    	 try {
 			Statement stmt = conn.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);
 			
 			while(rs.next()){
 				PaymentFormDO form = new PaymentFormDO();
 				form.setIndex(rs.getInt(1));
 				form.setId(rs.getString(2));
 				form.setDate(rs.getString(3));
 				form.setMoney(rs.getDouble(4));
 				form.setPaymen(rs.getString(5));
 				form.setPayaccount(rs.getString(6));
 				form.setPaycat(rs.getString(7));
 				form.setPs(rs.getString(8));
 				list.add(form);
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	 
    	 return list;
     }
}
