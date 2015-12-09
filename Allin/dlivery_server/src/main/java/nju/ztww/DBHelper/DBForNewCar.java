package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.po.CarManagePO;

public class DBForNewCar extends DB{

	 public String insert(ArrayList<CarManagePO> list,String tableName){
   	 String sql = "insert into "+tableName+"(id,carNumber,plateNUmber,serviceTime,carState,exe,state)"
   	 		+ "values(?,?,?,?,?,?,?)";
   	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(CarManagePO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getCarNumber());
				pstmt.setString(3,form.getPlateNUmber());
				pstmt.setString(4,form.getServiceTime());
				pstmt.setString(5,form.getCarState());
				pstmt.setInt(6,form.getExe());
				pstmt.setInt(7,form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return "success";    	     	     	 
    }
	 
	 public ArrayList<CarManagePO> queryByID(String ID,String tableName){
		    //	 System.out.print(ID);
		    	 String sql = "select * from "+tableName +" where id="+ID;
		    	 ArrayList<CarManagePO> list = new ArrayList<CarManagePO>();
		    	 try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						CarManagePO form = new CarManagePO(9);
						
						form.setId(rs.getString(2));
						form.setCarNumber(rs.getString(3));
						form.setPlateNUmber(rs.getString(4));
						form.setServiceTime(rs.getString(5));
						form.setCarState(rs.getString(6));
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
	 
	 public String update(ArrayList<CarManagePO> list,String tableName){
   	 String sql = "update "+tableName + " set id=?,carNumber=?,plateNUmber=?,serviceTime=?,"
   	 		+ "carState=?,exe=?,state=? where id=?";
   	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(CarManagePO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getCarNumber());
				pstmt.setString(3,form.getPlateNUmber());
				pstmt.setString(4,form.getServiceTime());
				pstmt.setString(5,form.getCarState());
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
}
