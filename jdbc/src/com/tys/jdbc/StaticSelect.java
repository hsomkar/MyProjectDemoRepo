package com.tys.jdbc;

import java.sql.*;

public class StaticSelect {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			// 1.load a driver
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);

			// 2.get connection via driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

			stm = con.createStatement();
			rs = stm.executeQuery("select * from employee");

			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getLong("phoneno"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null)
				con.close();
			if (stm != null)
				stm.close();
			if (rs != null)
				rs.close();
		}
	}
}
