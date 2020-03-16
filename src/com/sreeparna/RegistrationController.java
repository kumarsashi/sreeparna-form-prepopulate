package com.sreeparna;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("do get method called");
		String getEmployeeQuery = "select * from student where username=?";
		String username = request.getParameter("username");
			
		try {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(getEmployeeQuery);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String fullname = rs.getString("name");
				String uname = rs.getString("username");
				String password = rs.getString("pass");
				String address = rs.getString("addr");
				int age = rs.getInt("age");
				
				Employee employee = new Employee();
				employee.setFullname(fullname);
				employee.setUsername(username);
				employee.setAddress(address);
				employee.setPassword(password);
				employee.setAge(age);
				System.out.println(employee);
				request.setAttribute("employee", employee);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  String name = request.getParameter("fullname");
		  String userName = request.getParameter("userName");
		  String pass = request.getParameter("pass");
		  String addr = request.getParameter("address");
		  String age = request.getParameter("age");
		  
		  

		  // validate given input
		  if (name.isEmpty() || addr.isEmpty() || age.isEmpty() ) {
		   RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		   out.println("<font color=red>Please fill all the fields</font>");
		   rd.include(request, response);
		  } else {
		   // inserting data into mysql database 
		   // create a test database and student table before running this to create table
		   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
		   try {
		    
		    // loads mysql driver

		    Connection con = ConnectionManager.getConnection();

		    String query = "insert into student values(?,?,?,?,?)";

		    PreparedStatement ps = con.prepareStatement(query); // generates sql query

		    ps.setString(1, name);
		    ps.setString(2, userName);
		    ps.setString(3, pass);
		    ps.setString(4, addr);
		    ps.setInt(5, Integer.parseInt(age));
		    

		    ps.executeUpdate(); // execute it on test database
		    System.out.println("successfuly inserted");
		    ps.close();
		    con.close();
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		System.out.println("Inside post method");
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
		
	}

}
}
