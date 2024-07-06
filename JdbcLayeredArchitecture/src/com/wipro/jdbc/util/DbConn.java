package com.wipro.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	public static	Connection getConnection() throws SQLException,ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
		return con;
	}

}
