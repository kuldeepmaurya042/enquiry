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
import java.util.Enumeration;
public class enquiryDone extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public enquiryDone()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
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
				String name=request.getParameter("Name");
				int age=Integer.parseInt(request.getParameter("Age"));
				String gender=request.getParameter("Gender");
				String city=request.getParameter("City");
				String course=request.getParameter("Course");
				String contact=request.getParameter("Contact");
				String email=request.getParameter("Email");

				out.print("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\"></head><body>");
				try 
				{
					//String quory="insert into aptechenquiry values("+name+","+age+","+gender+","+city+","+course+","+contact+","+email+")";
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");

					PreparedStatement ps=con.prepareStatement("insert into aptechenquiry (Name,Age,Gender,City,Course,Contact,Email) values (?,?,?,?,?,?,?)");
					
					ps.setString(1, name);
					ps.setInt(2, age);
					ps.setString(3, gender);
					ps.setString(4, city);
					ps.setString(5, course);
					ps.setString(6, contact);
					ps.setString(7, email);												
					
					int no=ps.executeUpdate();
					
					System.out.println(no);
					if(no>0)
					{
						out.print("<div class=\"bar\">\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"index.jsp\" >Home Page</a></div>\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"courses.jsp\" >Courses</a></div>\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/enquiryServlet\" >Enquiry</a></div>\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/registrationServlet\" >Registration</a></div>\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"about.jsp\" >About Us</a></div>\r\n"
								+ "	<div class=\"child\"><a class=\"childLink\" href=\"contact.jsp\" >Contact</a></div>\r\n"
								+ "	</div>");
						out.print("<h2 style=\"margin-left:20%;\">Enquiry Successful About "+course+"<br>We will contact you soon</h2>");
						
					}
									
				} 
				catch (Exception e) 
				{
					System.out.println("Exception is "+e);		
				}
				out.print("<form action=\"showServlet\"><input type=\"submit\" name=\"show\" value=\"Show all Enquiries\" class=\"btn\"/></form>");
				out.print("</div></body></html>");
				
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
