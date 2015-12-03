package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.DriverMessageDO;
import nju.ztww.po.DriverMessagePO;

public class DBForDriverMessageForm extends DB {

	public DBForDriverMessageForm() {
		// TODO Auto-generated constructor stub
	}

	public String insert(ArrayList<DriverMessagePO> list,String tableName){
   	 String sql = "insert into "+tableName+"(id,driverNumber,driverName,driverBirthday,"
   	 		+ "driverId,driverTelephone,driverSex,driverServiceDeadline,exe,state)"
   	 		+ "values(?,?,?,?,?,?,?,?,?,?)";
   	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(DriverMessagePO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getDriverNumber());
				pstmt.setString(3,form.getDriverName());
				pstmt.setString(4,form.getDriverBirthday());
				pstmt.setString(5,form.getDriverId());
				pstmt.setString(6,form.getDriverTelephone());
				pstmt.setString(7,form.getDriverSex());
				pstmt.setString(8,form.getDriverServiceDeadline());
				pstmt.setInt(9,form.getExe());
				pstmt.setInt(10,form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return "success";    	     	     	 
    }
	 
	 public ArrayList<DriverMessagePO> queryByID(String ID,String tableName){
		    //	 System.out.print(ID);
		    	 String sql = "select * from "+tableName +" where id="+ID;
		    	 ArrayList<DriverMessagePO> list = new ArrayList<DriverMessagePO>();
		    	 try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						DriverMessagePO form = new DriverMessagePO(10);
						
						form.setId(rs.getString(2));
						form.setDriverNumber(rs.getString(3));
						form.setDriverName(rs.getString(4));
						form.setDriverBirthday(rs.getString(5));
						form.setDriverId(rs.getString(6));
						form.setDriverTelephone(rs.getString(7));
						form.setDriverSex(rs.getString(8));
						form.setExe(rs.getInt(9));
						form.setState(rs.getInt(10));
			//			System.out.print(rs.getString(2));
						list.add(form);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 
		    	 return list;
		     }
	 
	 public String update(ArrayList<DriverMessagePO> list,String tableName){
   	 String sql = "update "+tableName + " set id=?,driverNumber=?,driverName=?,driverBirthday=?,"
   	 		+ "driverId=?,driverTelephone=?,driverSex=?,driverServiceDeadline=?,exe=?,state=? where id=?";
   	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(DriverMessagePO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2, form.getDriverNumber());
				pstmt.setString(3,form.getDriverName());
				pstmt.setString(4,form.getDriverBirthday());
				pstmt.setString(5,form.getDriverId());
				pstmt.setString(6,form.getDriverTelephone());
				pstmt.setString(7,form.getDriverSex());
				pstmt.setString(8,form.getDriverServiceDeadline());
				pstmt.setInt(9, form.getExe());
				pstmt.setInt(10, form.getState());
				pstmt.setString(11, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail"; 
		}
   	 return "success"; 
   	 
    }
}
