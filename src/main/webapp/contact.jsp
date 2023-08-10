<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="all.css"/>

<title>Insert title here</title>
</head>
<body>
<div id="main">
	<div class="bar">
		<div class="child"><a class="childLink" href="index.jsp" >Home Page</a></div>
		<div class="child"><a class="childLink" href="courses.jsp" >Courses</a></div>
		<div class="child"><a class="childLink" href="http://localhost:8080/Aptech_Enquiry/enquiryServlet" >Enquiry</a></div>
		<div class="child"><a class="childLink" href="http://localhost:8080/Aptech_Enquiry/registrationServlet" >Registration</a></div>
		<div class="child"><a class="childLink" href="about.jsp" >About Us</a></div>
		<div class="child"><a class="childLink" href="contact.jsp" >Contact</a></div>
	</div>
	<div>
		<p>Give a missed call on 1-800-266-0666 for course-related information.</p>
		<p> Email your contact details to enquiry@aptech.ac.in</p>
	</div>

	<div >
	<% 
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
			response.getWriter().print("<b class=\"logSession\">Login Status :</b><b class=\"logSession\" style=\"color:green;\">Logged in</b>");
		}
		else
		{
			response.getWriter().print("<b class=\"logSession\">Login Status :</b><b class=\"logSession\" style=\"color:red;\">Logged out</b>");
		}
	
	%>
	</div>

</div>
</body>
</html>