package com.tys.jdbc;

import java.sql.*;
import java.util.Scanner;

public class DynamicUpdateScan {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

			String query = "select * from emp where id=?";
			pstm = con.prepareStatement(query);
			int eid=sc.nextInt();
			pstm.setInt(1, eid);
			sc.close();
			rs=pstm.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println(rs.getString("dept"));
				System.out.println(rs.getLong("phoneno"));
			}
				

			System.out.println("Updated successfully...");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null)
				con.close();
			if (pstm != null)
				pstm.close();
		}
	}
}
