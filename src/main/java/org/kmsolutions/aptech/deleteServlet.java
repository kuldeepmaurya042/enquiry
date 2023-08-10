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

public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		//out.print("Int delete servlet");
		
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
				String type=request.getParameter("type");
				if(type.equals("e"))
				{
					String id=request.getParameter("id");
					try 
					{
					Class.forName("com.mysql.cj.jdbc.Driver");				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");				
					PreparedStatement ps=con.prepareStatement("DELETE FROM aptechenquiry WHERE Sno="+id);				
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
					try 
					{
					Class.forName("com.mysql.cj.jdbc.Driver");				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");				
					PreparedStatement ps=con.prepareStatement("DELETE FROM aptechregistration WHERE Sno="+id);				
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
