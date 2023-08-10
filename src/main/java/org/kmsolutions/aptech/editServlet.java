package org.kmsolutions.aptech;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class editServlet
 */
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String type=request.getParameter("type");
		String username="";
		Cookie[] cookies=request.getCookies();
		if(cookies !=null)
		{
			for(Cookie ck:cookies)
			{
				if(ck.getName().equals("userCookie"))
				{
					username=ck.getValue();
				}
			}
		}
		
		if(username.equals("Username"))
		{
			if(type.equals("e"))
			{			
				String id=request.getParameter("id");
				String name=request.getParameter("Name");
				int age=Integer.parseInt(request.getParameter("Age"));
				String gender=request.getParameter("Gender");
				String city=request.getParameter("City");
				String course=request.getParameter("Course");
				String contact=request.getParameter("Contact");
				String email=request.getParameter("Email");
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");
				String quory="UPDATE aptechenquiry SET Sno='"+id+"', Name='"+name+"', Age='"+age+"',Gender='"+gender+"',City='"+city+"',Course='"+course+"',Contact='"+contact+"',Email='"+email+"' WHERE Sno="+id;                                  
				PreparedStatement ps=con.prepareStatement(quory);				
				ps.executeUpdate();
				response.sendRedirect("showServlet?show=Show+all+Enquiries");
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			else if(type.equals("r"))
			{
				String id=request.getParameter("id");
				String name=request.getParameter("Name");
				int age=Integer.parseInt(request.getParameter("Age"));
				String gender=request.getParameter("Gender");
				String city=request.getParameter("City");
				String branch=request.getParameter("Branch");
				String course=request.getParameter("Course");
				String qualification=request.getParameter("Qualification");
				String contact=request.getParameter("Contact");
				String email=request.getParameter("Email");
				String payment=request.getParameter("Payment");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");
					String quory="UPDATE aptechregistration SET Sno='"+id+"', Name='"+name+"', Age='"+age+"',Gender='"+gender+"',City='"+city+"',Branch='"+branch+"',Course='"+course+"',Qualification='"+qualification+"' ,Contact='"+contact+"',Email='"+email+"',Payment='"+payment+"' WHERE Sno="+id;                                  
					PreparedStatement ps=con.prepareStatement(quory);
					
					ps.executeUpdate();
					response.sendRedirect("showServlet?show=Show+all+Registrations");
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
				
			}
			
			
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
