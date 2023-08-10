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
import java.sql.PreparedStatement;
import java.util.Enumeration;

public class registrationDone extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public registrationDone() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		PrintWriter out=response.getWriter();
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
		
//			if(username.equals("Username"))
//			{
//				Enumeration<String> names=request.getParameterNames();
//				out.print("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"servlet.css\"></head><body>");
//				out.print("<div class=\"bar\">\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"index.jsp\" >Home Page</a></div>\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"courses.jsp\" >Courses</a></div>\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/enquiryServlet\" >Enquiry</a></div>\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"http://localhost:8080/Aptech_Enquiry/registrationServlet\" >Registration</a></div>\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"about.jsp\" >About Us</a></div>\r\n"
//						+ "		<div class=\"child\"><a class=\"childLink\" href=\"contact.jsp\" >Contact</a></div>\r\n"
//						+ "	</div>");
//				
//				out.print("<div id=\"div\">");
//				out.print("<h2>You are Registered</h2>");
//				out.print("<table border=\"1\"; id=\"table\">");
//				while(names.hasMoreElements())
//				{
//					String temp=names.nextElement();
//					out.print("<tr><td>"+temp+"<td>");
//					String[] value=request.getParameterValues(temp);
//					out.print("<td>");
//					if(value.length>1)
//					{
//						out.print("<ul>");
//					}
//					for(int i=0;i<value.length;i++)
//					{
//						if(value.length>1)
//						{
//							out.print("<li>");
//						}
//						out.print(value[i]+"<br>");
//						if(value.length>1)
//						{
//							out.print("</li>");
//						}
//					}
//					if(value.length>1)
//					{
//						out.print("</ul>");
//					}
//					out.print("</td></tr>");
//				}
//				out.print("</table></div>");
//				out.print("<form action=\"logout\" method=\"post\"><input type=\"Submit\" value=\"Log out\" id=\"logout\"></form></body></html>");
//			}
		
		
		if(username.equals("Username"))
		{
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

			out.print("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\"></head><body>");
			try 
			{
				//String quory="insert into aptechenquiry values("+name+","+age+","+gender+","+city+",Branch "+course+",Qualification"+contact+","+email+" Payment")";
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kuldeep","root","Password");

				PreparedStatement ps=con.prepareStatement("insert into aptechregistration (Name,Age,Gender,City,Branch,Course,Qualification,Contact,Email,Payment) values (?,?,?,?,?,?,?,?,?,?)");
				
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, gender);
				ps.setString(4, city);
				ps.setString(5, branch);
				ps.setString(6, course);
				ps.setString(7, qualification);
				ps.setString(8, contact);
				ps.setString(9, email);	
				ps.setString(10, payment);
				
				int no=ps.executeUpdate();
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
					
					out.print("<h2 style=\"margin-left:20%;\"> Dear "+name+" you are registered Successfully </h2>");
					
				}
								
			} 
			catch (Exception e) 
			{
				System.out.println("Exception is "+e);		
			}
			out.print("<form action=\"showServlet\"><input type=\"submit\" name=\"show\" value=\"Show all Registrations\" class=\"btn\"/></form>");
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
