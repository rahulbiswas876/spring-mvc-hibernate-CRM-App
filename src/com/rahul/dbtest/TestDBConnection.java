package com.rahul.dbtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId="springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSLL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			PrintWriter writer = response.getWriter();
			writer.println("Testing Connection :" + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, userId, password);
			writer.print("<br>");
			writer.println("SUCCESSFULL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
