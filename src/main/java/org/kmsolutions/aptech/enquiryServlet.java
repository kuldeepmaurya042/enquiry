package org.kmsolutions.aptech;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class enquiryServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public enquiryServlet()
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
		
			if(username.equals("Username"))
			{
				response.sendRedirect("enquiry.jsp");
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
