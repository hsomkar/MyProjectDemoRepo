package com.tyss.junit_crud_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicDelete {

	public Object delete(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstm = null, pstm1 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&password=root");
			String query = "delete from crud where id=?";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			String query2 = "select * from crud where id=?";
			pstm1 = con.prepareStatement(query2);
			pstm1.setInt(1, id);
			rs = pstm1.executeQuery();
			rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstm1 != null)
				try {
					pstm1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return rs.getInt("id");
	}
}
