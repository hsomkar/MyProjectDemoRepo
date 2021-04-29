package com.tyss.junit_crud_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicUpdate {

	public Object[] update(int a, String b, double c) throws SQLException {
		Connection con = null;
		PreparedStatement pstm = null, pstm1 = null;
		ResultSet rs = null;
		Object[] arr = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&password=root");
			String query = "update crud set name=?, salary=? where id=?";
			pstm = con.prepareStatement(query);
			pstm.setString(1, b);
			pstm.setDouble(2, c);
			pstm.setInt(3, a);
			pstm.executeUpdate();
			String query2 = "select * from crud where id=?";
			pstm1 = con.prepareStatement(query2);
			pstm1.setInt(1, a);
			rs = pstm1.executeQuery();
			arr = new Object[3];
			rs.next();
			arr[0] = rs.getInt("id");
			arr[1] = rs.getString("name");
			arr[2] = rs.getDouble("salary");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
			if (pstm != null)
				pstm.close();
			if (pstm1 != null)
				pstm1.close();
			if (rs != null)
				rs.close();
		}
		return arr;
	}
}
