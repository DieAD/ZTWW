package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.PayeeFormDO;

public class DBForPayeeForm extends DB{
	 public ArrayList<PayeeFormDO> selectAll(){
	    	ArrayList<PayeeFormDO> list = new ArrayList<PayeeFormDO>();
	    	String sql = " select * from payeeform where exe=0";
	    	
	    	try {
				Statement stmt = conn.createStatement();
				ResultSet rs =stmt.executeQuery(sql);
				while(rs.next()){
					PayeeFormDO form = new PayeeFormDO();
					form.setIndex(rs.getInt(1));
					form.setId(rs.getString(2));
					form.setGoodsid(rs.getString(3));
					form.setCourierid(rs.getString(4));
					form.setMoney(rs.getDouble(5));
					form.setExe(rs.getInt(6));
					form.setState(rs.getInt(7));
					form.setDate(rs.getString(8));
					form.setHoll(rs.getString(9));
					list.add(form);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return list;
	    }
	
    public ArrayList<PayeeFormDO> queryByID(String ID,String tableName){
    	ArrayList<PayeeFormDO> list = new ArrayList<PayeeFormDO>();
    	String sql = " select * from "+tableName+" where id="+ID;
    	
    	try {
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()){
				PayeeFormDO form = new PayeeFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setCourierid(rs.getString(4));
				form.setMoney(rs.getDouble(5));
				form.setExe(rs.getInt(6));
				form.setState(rs.getInt(7));
				form.setDate(rs.getString(8));
				form.setHoll(rs.getString(9));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    public ArrayList<PayeeFormDO> queryByDate(String date,String holl,String tableName){
    	ArrayList<PayeeFormDO> list = new ArrayList<PayeeFormDO>();
    	String sql = " select * from "+tableName+" where date='"+date+"' and holl='"+holl+"'";
    	
    	try {
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()){
				PayeeFormDO form = new PayeeFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setCourierid(rs.getString(4));
				form.setMoney(rs.getDouble(5));
				form.setExe(rs.getInt(6));
				form.setState(rs.getInt(7));
				form.setDate(rs.getString(8));
				form.setHoll(rs.getString(9));
				
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    
    public String insert(ArrayList<PayeeFormDO> list,String tableName){
    	String sql = "insert into "+tableName+"(id,goodsid,courierid,money,exe,state,date,holl)"
    			+ "values(?,?,?,?,?,?,?,?)";
    	
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(PayeeFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3, form.getCourierid());
				pstmt.setDouble(4, form.getMoney());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				pstmt.setString(7, form.getDate());
				pstmt.setString(8, form.getHoll());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "success";
    }
    
    public String update(ArrayList<PayeeFormDO> list,String tableName){
    	String sql = "update "+tableName+" set id=?,goodsid=?,courierid=?,money=?,exe=?,state=?,date=?,holl=? where id=?";
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(PayeeFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3, form.getCourierid());
				pstmt.setDouble(4, form.getMoney());
				pstmt.setInt(5, form.getExe());
				pstmt.setInt(6, form.getState());
				pstmt.setString(7,form.getDate());
				pstmt.setString(8,form.getHoll());
				pstmt.setString(9, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail";
		}
    	return "success";
    }
    
    public ArrayList<PayeeFormDO> totalCollection(String tableName){
    	ArrayList<PayeeFormDO> list = new ArrayList<PayeeFormDO>();
    	String sql = "select * from "+tableName;
    	Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	    	while(rs.next()){
	    		PayeeFormDO form = new PayeeFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setCourierid(rs.getString(4));
				form.setMoney(rs.getDouble(5));
				form.setExe(rs.getInt(6));
				form.setState(rs.getInt(7));
				form.setDate(rs.getString(8));
				list.add(form);
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return list;
    }
    
//    public static void main(String[] args){
//    	DBForPayeeForm db = new DBForPayeeForm();
//    	db.init();
//    	//db.insert(db.queryByID("1511250001", "payeeform"), "payeeform");
//    	ArrayList<PayeeFormDO> list =db.queryByDate("15/11/25","001", "payeeform");
//    	for(PayeeFormDO form : list){
//    		form.setMoney(5.1);
//    	}
//    	db.update(list, "payeeform");
//    	db.close();
//    	
//    	
//    }
}