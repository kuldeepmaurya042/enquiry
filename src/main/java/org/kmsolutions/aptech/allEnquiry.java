//package org.kmsolutions.aptech;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class allEnquiry extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public allEnquiry() 
//    {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		PrintWriter out=response.getWriter();
//		response.setContentType("text/html");
//		enquiryDone ed=new enquiryDone();
//		int x=ed.enqArray.size();
//		System.out.println(ed.enqArray.size());
//		out.print("No. of Enquiries : "+x);
//		out.print("<html><body><table>");
//		for(int i=0;i<x;i++)
//		{
//			out.print("<tr><th colspan=\"2\" style=\"text-align:center;\">Student "+i+" </th></tr><tr><td>Name</td><td>"+ed.enqArray.get(i).name+"</td></tr><tr><td>Age</td><td>"+ed.enqArray.get(i).age+"</td></tr><tr><td>Gender</td><td>"+ed.enqArray.get(i).gender+"</td></tr><tr><td>Course</td><td>"+ed.enqArray.get(i).course+"</td></tr><tr><td>City</td><td>"+ed.enqArray.get(i).city+"</td></tr><tr><td>Contact</td><td>"+ed.enqArray.get(i).contact+"</td></tr><tr><td>E-mail</td><td>"+ed.enqArray.get(i).email+"</td></tr>");
//		}
//		
//		out.print("</table></body></html>");
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		doGet(request, response);
//	}
//
//}
