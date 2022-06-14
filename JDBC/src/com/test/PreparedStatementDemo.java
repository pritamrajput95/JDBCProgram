package com.test;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatementDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.statement object : static & dynamic `
		// 2. prepared statement
		// 3. callable statement

		// step to JDBC connection

		// 1.load & Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.Establish connection bw java app and db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Rajput", "root", "Rajput@123");

		// 3. create statement object
		Statement st = con.createStatement();

		// 4.Send & Execute SQL Query
		ResultSet rs = st.executeQuery("SELECT * FROM  emp"); 
            
		// 5.process Result from ResultSet
		while (rs.next()) {
			
	System.out.println(rs.getInt(1) + " ," + rs.getString(2) + " ," + rs.getString(3) + " ," + rs.getInt(4)+" ,"+rs.getDate(5)+","
			+ " "+rs.getInt(6)+", "+rs.getInt(7)+", "+rs.getInt(8));

		}

		// 6. Close Connection

		con.close();

	}
}
