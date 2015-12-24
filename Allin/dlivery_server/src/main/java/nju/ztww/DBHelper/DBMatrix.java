package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.matrixDO;

public class DBMatrix extends DB{
   public void insert(matrixDO form){
	   String sql = "insert into matrix(id,time,men,state)values(?,?,?,?)";
	   
	   try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, form.getId());
		pstmt.setString(2, form.getTime());
		pstmt.setString(3, form.getMen());
		pstmt.setString(4, form.getState());
		
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public ArrayList<matrixDO> queryAll(){
	   ArrayList<matrixDO> list = new ArrayList<matrixDO>();
	   String sql  = "select * from matrix";
	   try {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			matrixDO form = new matrixDO();
			form.setId(rs.getString(2));
			form.setTime(rs.getString(3));
			form.setMen(rs.getString(4));
			form.setState(rs.getString(5));
			
			list.add(form);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return list;
   }
}
