package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nju.ztww.dao.InsDO;

public class DBForNewIns extends DB {
	 public InsDO queryByID(String id){
	    	String sql = "select * from newinstable where id ="+id;
	    	InsDO form = new InsDO();
	    	try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				form = new InsDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setName(rs.getString(3));
				form.setN1(rs.getInt(4));
				form.setN2(rs.getInt(5));
				form.setN3(rs.getInt(6));
				form.setN4(rs.getInt(7));
				form.setN5(rs.getInt(8));
				form.setN6(rs.getInt(9));
				form.setN7(rs.getInt(10));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return form;
	    }
	    
	    public void update(InsDO form){
	    	String sql = "update newinstable set id=?, name=?,number1=?,number2=?,number3=?,number4=?,number5=?,number6=?,number7=? where id=?";
	        try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getName());
				pstmt.setInt(3, form.getN1());
				pstmt.setInt(4, form.getN2());
				pstmt.setInt(5, form.getN3());
				pstmt.setInt(6, form.getN4());
				pstmt.setInt(7, form.getN5());
				pstmt.setInt(8, form.getN6());
				pstmt.setInt(9, form.getN7());
				pstmt.setString(10, form.getId());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
	    
	    public void insert(InsDO form){
	    	String sql = "insert into newinstable(id,name,number1,number2,number3,number4,number5,number6,number7)values(?,?,?,?,?,?,?,?,?)";
	    	 try {
	 			PreparedStatement pstmt = conn.prepareStatement(sql);
	 			pstmt.setString(1, form.getId());
	 			pstmt.setString(2, form.getName());
	 			pstmt.setInt(3, form.getN1());
	 			pstmt.setInt(4, form.getN2());
	 			pstmt.setInt(5, form.getN3());
	 			pstmt.setInt(6, form.getN4());
	 			pstmt.setInt(7, form.getN5());
	 			pstmt.setInt(8, form.getN6());
	 			pstmt.setInt(9, form.getN7());
	 			
	 			
	 			pstmt.executeUpdate();
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		} 
	    }
}
