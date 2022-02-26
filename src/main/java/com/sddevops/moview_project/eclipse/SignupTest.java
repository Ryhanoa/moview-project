package com.sddevops.moview_project.eclipse;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SignupTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Signuptest() {
		String username = "Junittest";
		String password = "Junittest";
		String email = "junittest@test.com";
		String contact = "12345678";
		String address = "junittest yes";
		ResultSet rs = null;

		
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/moview", "root", "password");
		
		 //Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
		 PreparedStatement ps = con.prepareStatement("insert into moview.account values(?,?,?,?,?)");
		
		 //Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
		 ps.setString(1, username);
		 ps.setString(2, password);
		 ps.setString(3, email);
		 ps.setString(4, contact);
		 ps.setString(5, address);
		
		 
		 PreparedStatement check = con.prepareStatement("select * from moview.account where username = ? OR email = ?");
		 check.setString(1, username);
		 check.setString(2, email);
		 rs = check.executeQuery();
		 
		 if(rs.next()) {
			 System.out.println("BIG NONO");
		 }
		 else {

				// Step 6: perform the query on the database using the prepared statement
   	         int i = ps.executeUpdate();
   	       		 
   			 //Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
   	       		if (i > 0){
   				 System.out.println("BIG YES");
   	       		}
		 }
		 

		

		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
		 System.out.println(exception);
		}
	}
	
	void Signintest() {
			
			String username = "ryhano";
			String password = "ryhan321";
			ResultSet rs = null;
			
			//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
			try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/moview", "root", "password");
			
			 //Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			 PreparedStatement ps = con.prepareStatement("select * from moview.account where username = ? AND password = ?");
			
			 //Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
			 ps.setString(1, username);
			 ps.setString(2, password);

			 rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 System.out.println("Correct Password");
				 
			 }
			 else {
				 System.out.println("Wrong Password");
			 }
			 
		
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
			 System.out.println(exception);
			}


	}
	
}
