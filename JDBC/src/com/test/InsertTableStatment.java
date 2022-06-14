package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTableStatment {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.statement object : static & dynamic `
		
		

		// step to JDBC connection

		// 1.load & Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.Establish connection bw java app and db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Rajput", "root", "Rajput@123");

		// 3. create statement object
		Statement st = con.createStatement();
		 char  choice;
		do {
		//reading value from keyboard
		Scanner scn=new Scanner(System.in);
		System.out.println("enter sno ");
		int sno=scn.nextInt();
		
		scn.nextLine();  // dummy 
		System.out.println("enter First Name ");
		String fname=scn.nextLine();
		
		System.out.println("enter Last Name ");
		String lname=scn.nextLine();
		
		//INSERT UPDATE DELETE

		// 4.Send & Execute SQL Query
		
		String Query="INSERT INTO TEST2 values('"+sno+"','"+fname+"','"+lname+"')";
	      
		int count=st.executeUpdate(Query);
	      
	       System.out.println(count+" inserted successfully");
		
	       System.out.println("Do You Want To Continue(Y/N)");
		
	         choice = scn.next().charAt(0);
		}
	       while(choice == 'Y'|| choice == 'y');
		
		do {
		  System.out.println("Do You Want To Print data (Y/N)");
		  Scanner scn=new Scanner(System.in);
	         choice = scn.next().charAt(0);
		}
	       while(choice == 'N'|| choice == 'n');
		
		
		System.out.println("SNo "+" FirstName "+" LastName");
		System.out.println("-------------..................");
		Statement st2 = con.createStatement();

		// 4.Send & Execute SQL Query
		ResultSet rs = st2.executeQuery("SELECT * FROM  TEST2");

		// 5.process Result from ResultSet
		while (rs.next()) {
			
	System.out.println(rs.getInt(1) + " , " + rs.getString(2)+ " , " + rs.getString(3));

		}
	    
		// 5. Close Connection

		con.close();

	}
}
