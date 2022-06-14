package com.test;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
//
public class CreateTableStatment {
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
	       st.executeUpdate("CREATE TABLE  IF NOT EXISTS  TEST2(sno int(10), First_Name varchar(40) ,Last_Name varchar(40));");
	        System.out.println("table created succefully");
	       
		// 5. Close Connection

		con.close();

	}
}
