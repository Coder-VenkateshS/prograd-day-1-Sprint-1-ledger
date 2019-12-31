package com.face.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//class used for establishing connection to database
public class ConnectionManager {
	static Connection conn;
public Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FaceTrips?serverTimezone=UTC","root","root");
	if(conn!=null)
	{
		System.out.println("Connection Established");
		return conn;
	}
	else
		return null;
	
}
}
