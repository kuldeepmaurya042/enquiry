package org.kmsolutions.aptech;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class showServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String show=request.getParameter("show");
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
			out.print("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\"></head><body>");
			out.print("<div class=\"bar\">\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"index.jsp\" >Home Page</a></div>\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"courses.jsp\" >Courses</a></div>\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/enquiryServlet\" >Enquiry</a></div>\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/registrationServlet\" >Registration</a></div>\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"about.jsp\" >About Us</a></div>\r\n"
					+ "	<div class=\"child\"><a class=\"childLink\" href=\"contact.jsp\" >Contact</a></div>\r\n"
					+ "	</div>");
			out.print("<div><table border=1>");
			
			try 
			{	
				Class.forName("com.mysql.cj.jdbc.Driver");				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");			
				Statement st=con.createStatement();
				
				switch (show) 
				{
				case "Show all Enquiries": //Show all enquiries
				{
					ResultSet rs=st.executeQuery("select * from aptechenquiry");		
					out.print("<tr><th>S.No</th><th>Name</th><th>Age</th><th>Gender</th><th>City</th><th>Course</th><th>Contact</th><th>Email</th><th colspan=2>Modify</th></tr>");		
					while(rs.next())
					{
						out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td><a href='enquiryEdit.jsp?id="+rs.getInt(1)+"&type=e'> Edit</a></td><td><a href='deleteServlet?id="+rs.getInt(1)+"&type=e'> Delete</a></td></tr>");
					}
					break;
				}
				
				case "Show all Registrations":
				{
												
					ResultSet rs=st.executeQuery("select * from aptechregistration");		
					out.print("<tr><th>S.No</th><th>Name</th><th>Age</th><th>Gender</th><th>City</th><th>Branch</th><th>Course</th><th>Qualification</th><th>Contact</th><th>Email</th><th>Payment</th><th colspan=2>Modify</th></tr>");		
					while(rs.next())
					{
						out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td><a href='registrationEdit.jsp?id="+rs.getInt(1)+"&type=r'> Edit</a></td><td><a href='deleteServlet?id="+rs.getInt(1)+"&type=r'> Delete</a></td></tr>");
					}
					break;
					
				}
				default :
				{
					break;
				}
				}
				
				out.print("</table></div></body></html>");		
			} 
			catch (Exception e) 
			{
				System.out.println("Exception is "+e);		
			}
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

}
