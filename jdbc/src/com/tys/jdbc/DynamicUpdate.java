package com.tys.jdbc;

import java.sql.*;

public class DynamicUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");

			String query = "UPDATE employee SET name = ?, sal =?, dept='Test',phoneno=987654 where id=?";
			pstm = con.prepareStatement(query);
			pstm.setString(1, "Harsha");
			pstm.setInt(2, 23000);
			pstm.setInt(3, 3);

			//int count = pstm.executeUpdate();
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
