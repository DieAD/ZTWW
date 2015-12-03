package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.TrainFormDO;

public class DBForTrainForm extends DB{
	public ArrayList<TrainFormDO> selectAll(){
    	String sql ="select * from trainform where exe=0";
    	ArrayList<TrainFormDO> list = new ArrayList<TrainFormDO>();
    	 try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TrainFormDO form = new TrainFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setTransmethod(rs.getInt(4));
				form.setTime(rs.getString(5));
				form.setFltn(rs.getString(6));
				form.setBddress(rs.getString(7));
				form.setAddress(rs.getString(8));
				form.setContainernumber(rs.getString(9));
				form.setLoadmen(rs.getString(10));
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
	
    public ArrayList<TrainFormDO> queryByID(String ID,String tableName){
    	String sql ="select * from "+tableName+" where id="+ID;
    	ArrayList<TrainFormDO> list = new ArrayList<TrainFormDO>();
    	 try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TrainFormDO form = new TrainFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setTransmethod(rs.getInt(4));
				form.setTime(rs.getString(5));
				form.setFltn(rs.getString(6));
				form.setBddress(rs.getString(7));
				form.setAddress(rs.getString(8));
				form.setContainernumber(rs.getString(9));
				form.setLoadmen(rs.getString(10));
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
    
    public void insert(ArrayList<TrainFormDO> list,String tableName){
    	String sql = "insert into "+ tableName+"(id,goodsid,transmethod,time,fltn,bddress,address,containernumber,loadmen,cost,exe,state)"
    			+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(TrainFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setInt(3, form.getTransmethod());
				pstmt.setString(4, form.getTime());
				pstmt.setString(5, form.getFltn());
				pstmt.setString(6, form.getBddress());
				pstmt.setString(7, form.getAddress());
				pstmt.setString(8, form.getContainernumber());
				pstmt.setString(9, form.getLoadmen());
				pstmt.setDouble(10, form.getCost());
				pstmt.setInt(11,form.getExe());
				pstmt.setInt(12, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void update(ArrayList<TrainFormDO> list,String tableName){
    	//(id,goodsid,transmethod,time,fltn,bddress,address,containernumber,loadmen,cost,exe,state)
    	
    	String sql = " update "+tableName+" set id=?,goodsid=?,transmethod=?,time=?,fltn=?,bddress=?,address=?,containernumber=?,loadmen=?,cost=?,exe=?,state=? where id=? ";
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(TrainFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setInt(3, form.getTransmethod());
				pstmt.setString(4, form.getTime());
				pstmt.setString(5, form.getFltn());
				pstmt.setString(6, form.getBddress());
				pstmt.setString(7, form.getAddress());
				pstmt.setString(8, form.getContainernumber());
				pstmt.setString(9, form.getLoadmen());
				pstmt.setDouble(10, form.getCost());
				pstmt.setInt(11,form.getExe());
				pstmt.setInt(12, form.getState());
				pstmt.setString(13, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args){
    	DBForTrainForm db= new DBForTrainForm();
    	db.init();
    	ArrayList<TrainFormDO> list = db.queryByID("1511250001", "trainform");
    	for(TrainFormDO form : list){
    		form.setAddress("shanghai");
    	}
    	db.update(list, "trainform");
    //	db.insert(db.queryByID("1511250001", "trainform"), "trainform");
    	db.close();
    }
}
