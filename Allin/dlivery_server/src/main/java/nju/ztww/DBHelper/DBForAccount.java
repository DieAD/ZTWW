package nju.ztww.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nju.ztww.dao.AccountDO;

public class DBForAccount extends DB {
	public AccountDO queryByID(String id, String tableName) {
		String sql = "select * from " + tableName + " where id=" + "id";
		AccountDO account = new AccountDO();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			account.setIndex(rs.getInt(1));
			account.setId(rs.getString(2));
			account.setName(rs.getString(3));
			account.setRemain(rs.getDouble(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}

	public void update(AccountDO account, String tableName) {
		String sql = "update " + tableName
				+ " set id=? name=?  remain=? where id=? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getId());
			pstmt.setString(2, account.getName());
			pstmt.setDouble(3, account.getRemain());
			pstmt.setString(4, account.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(AccountDO account, String tableName) {
		String sql = "insert into " + tableName
				+ "(id,name,remain)values(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getId());
			pstmt.setString(2, account.getName());
			pstmt.setDouble(3, account.getRemain());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<AccountDO> selectAll(String tableName) {
		String sql = "select * from " + tableName;
		ArrayList<AccountDO> list = new ArrayList<AccountDO>();
		// AccountDO account = new AccountDO();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				AccountDO account = new AccountDO();
				account.setIndex(rs.getInt(1));
				account.setId(rs.getString(2));
				account.setName(rs.getString(3));
				account.setRemain(rs.getDouble(4));
				list.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public void updateRemain(AccountDO account,String tableName){
		String sql1 = "select * from " + "accounttable" ;
		double remain = 0;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);

			rs.next();
			remain = rs.getDouble(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remain = remain + account.getRemain();
		String sql = "update " + tableName
				+ " set   remain=?  ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, remain);
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
