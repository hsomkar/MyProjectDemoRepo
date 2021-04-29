package com.tys.jdbc;

import java.sql.*;

public class DynamicInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root", null);

			String query = "insert into employee values(?,?,?,?,?)";
			pstm = con.prepareStatement(query);
			String s0=args[0];
			int id=Integer.parseInt(s0);
			pstm.setInt(1, id);
			String s1=args[1];
			pstm.setString(2, s1);
			String s2=args[2];
			int sal=Integer.parseInt(s2);
			pstm.setInt(3, sal);
			String s3=args[3];
			pstm.setString(4, s3);
			String s4=args[4];
			long phone=Long.parseLong(s4);
			pstm.setLong(5, phone);

			//int count = pstm.executeUpdate();
			System.out.println("inserted successfully...");
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
