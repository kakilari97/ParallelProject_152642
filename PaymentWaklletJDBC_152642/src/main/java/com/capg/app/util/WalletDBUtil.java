package com.capg.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WalletDBUtil {

	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentwalletapp","root","Capgemini123");
		return conn;
	}
}
