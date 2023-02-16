package com.amplo.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLiteJDBC {

	/**
	 * @author Evandro
	 */
	public static void test() throws ClassNotFoundException, SQLException {
	
			String driver = "org.sqlite.JDBC";
			Class.forName(driver);
			String dbName = "cp2.db"; 
			String dbUrl = "jdbc:sqlite:" + dbName;
			Connection conn = DriverManager.getConnection(dbUrl);
	        //create table 
	        Statement st = conn.createStatement();
	        st.executeUpdate("CREATE table village (id int, name varchar(20))");
	        //insert row
	        st.executeUpdate("INSERT INTO village VALUES (111, 'Concretepage')");
	        //select
	        String query = "SELECT id, name from village";
	        ResultSet rs = null;
	        rs = st.executeQuery(query);
	        while(rs.next()) {
	           int id = rs.getInt(1);
	           String name = rs.getString(2);
	           System.out.println("id:"+ id+ ", name: "+ name);
	         }
	         //delete
	         st.executeUpdate("DELETE from village");
		     rs.close();
	}
} 