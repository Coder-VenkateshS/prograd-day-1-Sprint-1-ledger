package com.face.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.face.model.UserAccount;
import com.face.utility.ConnectionManager;

public class UserDAO {

	public boolean save(UserAccount user, ConnectionManager conn) throws ClassNotFoundException, SQLException {
	String sql="insert into UserAccount(firstname,lastname,username,password,email,mobile)values(?,?,?,?,?,?)";
		PreparedStatement ps=conn.getConnection().prepareStatement(sql);
		ps.setString(1, user.getFirstname());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getUsername());
		ps.setString(4,user.getPassword());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getMobile());
		int result=ps.executeUpdate();
		if(result!=0)
			{
			conn.getConnection().close();
			return true;
			}else
			return false;
	}

	
}
