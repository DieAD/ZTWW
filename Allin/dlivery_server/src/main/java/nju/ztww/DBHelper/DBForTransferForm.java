package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.HollReciFormDO;
import nju.ztww.po.CarManagePO;
import nju.ztww.po.TransferPO;

public class DBForTransferForm extends DB{

	public DBForTransferForm() {
		
	}
	
	
	 
	 public ArrayList<TransferPO> queryByID(String ID,String tableName){
		    //	 System.out.print(ID);
		    	 String sql = "select * from "+tableName +" where id="+ID;
		    	 ArrayList<TransferPO> list = new ArrayList<TransferPO>();
		    	 try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						TransferPO form = new TransferPO(8);
						form.setId(rs.getString(2));
						form.setMethod(rs.getString(3));
						form.setCarData(rs.getString(4));
						form.setTransferData(rs.getString(5));
						form.setMethodNumber(rs.getString(6));
						form.setSendPlace(rs.getString(7));
						form.setArrivePlace(rs.getString(8));
						form.setCounterNumber(rs.getString(9));
						form.setJianZhuangName(rs.getString(10));
						form.setSendNumber(rs.getString(11));
						form.setMoney(rs.getDouble(12));
						form.setExe(rs.getInt(13));
						form.setState(rs.getInt(14));
			//			System.out.print(rs.getString(2));
						list.add(form);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 
		    	 return list;
		     }
	 public String insert(ArrayList<TransferPO> list,String tableName){
    	 String sql = "insert into "+tableName+"(id,transferMethod,data,transferNumber,airNumber,"
    	 		+ "sendPlace,arrive,counter,jianZzhuangYuan,order,money,exe,state)"
    	 		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(TransferPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getMethod());
				pstmt.setString(3,form.getCarData());
				pstmt.setString(4,form.getTransferData());
				pstmt.setString(5,form.getMethodNumber());
				pstmt.setString(6,form.getSendPlace());
				pstmt.setString(7,form.getArrivePlace());
				pstmt.setString(8,form.getCounterNumber());
				pstmt.setString(9,form.getJianZhuangName());
				pstmt.setString(10,form.getSendNumber());
				pstmt.setDouble(11,form.getMoney());
				pstmt.setInt(12,form.getExe());
				pstmt.setInt(13,form.getState());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return "success";    	     	     	 
     }
	 
	 public String update(ArrayList<TransferPO> list,String tableName){
    	 String sql = "update "+tableName + " set id=?,transferMethod=?,data=?,transferNumber=?,"
    	 		+ "airNumber=?,sendPlace=?,arrive=?,counter=?,jianZzhuangYuan=?,order=?,money=?,exe=?,state=? where id=?";
    	 try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(TransferPO form : list){
				pstmt.setString(1, form.getId());
				pstmt.setString(2,form.getMethod());
				pstmt.setString(3,form.getCarData());
				pstmt.setString(4,form.getTransferData());
				pstmt.setString(5,form.getMethodNumber());
				pstmt.setString(6,form.getSendPlace());
				pstmt.setString(7,form.getArrivePlace());
				pstmt.setString(8,form.getCounterNumber());
				pstmt.setString(9,form.getJianZhuangName());
				pstmt.setString(10,form.getSendNumber());
				pstmt.setDouble(11,form.getMoney());
				pstmt.setInt(12,form.getExe());
				pstmt.setInt(13,form.getState());
				pstmt.setString(14, form.getId());
				
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "fail"; 
		}
    	 return "success"; 
    	 
     }

}
