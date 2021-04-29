package com.tys.jdbc;

import java.sql.*;

public class StaticUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stm = null;
		// 1. Load the Driver
		try {
			// Class.forName("com.mysql.jdbc.Driver");//first method

			Driver d = new com.mysql.cj.jdbc.Driver(); // second method
			DriverManager.registerDriver(d);

			// 2.Get connection via Driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

			// 3.issue sql query via connection
			String query = "UPDATE employee SET name = 'Omk', sal = 1000.00, dept='Test',phoneno=987654 where id=1";
			stm = con.createStatement();

			// 4.Process the resultset
			int count = stm.executeUpdate(query);
			System.out.println("No. of rows updated :" + count);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null)
				con.close();
			if (stm != null)
				stm.close();
		}
	}
}
