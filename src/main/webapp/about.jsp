<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="all.css"/>

<title>About us</title>
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
		<h2>About Aptech Learning</h2>
	<p> Aptech Learning is a brand under Aptech Ltd, a premiere training institute pioneering in individual segments 
	such as IT Learning Solutions, Banking and Finance and English Communication.
	
	Under Digital and Information Technology domain, the institute provides a wide variety of career, professional, 
	short term and certification courses, designed by our expert academicians after careful market study and research.
	 All the courses are taught by experienced and certified faculty. Our trainers constantly update their technical 
	 skills to maintain their expertise.
	
	Aptech also organizes various events like Techno Minds, placement workshops, job fairs, and seminars to encourage 
	student interaction and prepare them for job interviews and make them industry-ready.
	
	In a nutshell, Aptech creates skilled IT professionals through a variety of courses delivered using the latest 
	teaching methodology.</p>
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