package com.hallTicket.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hallticket","root","root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}
	public static void cleanup() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
