package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.HollReciFormDO;

public class DBForHollReciForm extends DB{
	 public ArrayList<HollReciFormDO> selectAll(){
		    //	 System.out.print(ID);
		    	 String sql = "select * from hollreciform where exe=0";
		    	 ArrayList<HollReciFormDO> list = new ArrayList<HollReciFormDO>();
		    	 try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						HollReciFormDO form = new HollReciFormDO();
						form.setIndex(rs.getInt(1));
						form.setId(rs.getString(2));
						form.setGoodsid(rs.getString(3));
						form.setArrivetime(rs.getString(4));
						form.setBddress(rs.getString(5));
						form.setGoodsstate(rs.getString(6));
						form.setExe(rs.getInt(7));
						form.setState(rs.getInt(8));
			//			System.out.print(rs.getString(2));
						list.add(form);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 
		    	 return list;
		     }
	
     public ArrayList<HollReciFormDO> queryByID(String ID,String tableName){
    //	 System.out.print(ID);
    	 String sql = "select * from "+tableName +" where id="+ID;
    	 ArrayList<HollReciFormDO> list = new ArrayList<HollReciFormDO>();
    	 try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				HollReciFormDO form = new HollReciFormDO();
				form.setIndex(rs.getInt(1));
				form.setId(rs.getString(2));
				form.setGoodsid(rs.getString(3));
				form.setArrivetime(rs.getString(4));
				form.setBddress(rs.getString(5));
				form.setGoodsstate(rs.getString(6));
				form.setExe(rs.getInt(7));
				form.setState(rs.getInt(8));
	//			System.out.print(rs.getString(2));
				list.add(form);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 return list;
     }
     
     public String insert(ArrayList<HollReciFormDO> list,String tableName){
    	 String sql = "insert into "+tableName+"(id,goodsid,arrivetime,bddress,goodsstate,exe,state)"
    	 		+ "values(?,?,?,?,?,?,?)";
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(HollReciFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3,form.getArrivetime());
				pstmt.setString(4, form.getBddress());
				pstmt.setString(5, form.getGoodsstate());
				pstmt.setInt(6, form.getExe());
				pstmt.setInt(7, form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		return "success";    	     	     	 
     }
     public String update(ArrayList<HollReciFormDO> list,String tableName){
    	 String sql = "update "+tableName + " set id=?,goodsid=?,arrivetime=?,bddress=?,"
    	 		+ "goodsstate=?,exe=?,state=? where id=?";
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(HollReciFormDO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getGoodsid());
				pstmt.setString(3,form.getArrivetime());
				pstmt.setString(4, form.getBddress());
				pstmt.setString(5, form.getGoodsstate());
				pstmt.setInt(6, form.getExe());
				pstmt.setInt(7, form.getState());
				pstmt.setString(8, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail"; 
		}
    	 return "success"; 
    	 
     }
     
//     public static void main(String[] args){
//    	 DBForHollReciForm db = new DBForHollReciForm();
//    	 db.init();
//    //	 db.insert(db.queryByID("1511250001", "hollreciform"), "hollreciform");
//    	 ArrayList<HollReciFormDO> list = db.queryByID("1511250001", "hollreciform");
//    	 for(HollReciFormDO form : list){
//    		 form.setBddress("hehe");
//    	 }
//    	 db.update(list, "hollreciform");
//    	 db.close();
//     }
}
