package com.tys.jdbc;
 
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class TestConnection {
 
	public static Properties loadPropertiesFile() throws Exception {
 
		Properties prop = new Properties();
		InputStream in = new FileInputStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
 
	public static void main(String[] args) {
 
		System.out.println("create jdbc connection using properties file");
		
		Connection con = null;
 
		try {
 
		Properties prop = loadPropertiesFile();
 
		String driverClass = prop.getProperty("MYSQLJDBC.driver");
		String url = prop.getProperty("MYSQLJDBC.url");
		String username = prop.getProperty("MYSQLJDBC.username");
		String password = prop.getProperty("MYSQLJDBC.password");
 
		Class.forName(driverClass);
 
		con = DriverManager.getConnection(url, username, password);
 
		if (con != null) {
		System.out.println("connection created successfully using properties file");
		}
 
		else {
		System.out.println(" unable to create connection");
		}
 
		}catch (SQLException e) {
		e.printStackTrace();
		} 
		catch (Exception e) {
		e.printStackTrace();
		} finally {
 
		try {
		if (con != null) {
		con.close();
		}
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		}
	}
 
}