<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="all.css"/>

<title>Courses</title>
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
		<h2>Python</h2>
		<h3>Python course trains you in:</h3>
		<p>
		Aptech Certified Python Developer is divided into two terms.<br> The first term trains you in
		 using HTML5/CSS3/JavaScript and jQuery to develop interactive and responsive websites and apps.<br>
		  The second terms trains you in implementing software development process using Agile and DevOps
		   methodologies.
		</p><hr>
		<h2>Java</h2>
		<h3>Java Development course trains you in:</h3>
		<p>
		HTML5, CSS, and Javascript<br>
		UI/UX for Responsive Design<br>
		AngularJS<br>
		Data Management (SQL Server)<br>
		Java Programming - I<br>
		Java Programming - II<br>
		Web Component Development<br>
		Integrating Applications with Spring Framework<br>
		Project-Java Web Application Development
		</p><hr>
		<h2>Ethical Hacking</h2>
		<h3>Ethical Hacking course trains you in :</h3>
		<p>
		This training course provides you the hands-on training required to master the techniques hackers
		 leverage to penetrate network systems and fortify yours against it.<br> This ethical hacking course
		  is aligned with the latest CEH v11 by the EC-Council and will adequately prepare you to scale
		   up your blue team skills.
		</p><hr>
		<h2>IOTs</h2>
		<h3>IOTs course trains you in :</h3>
		<p>
		Programming Principles and C programming<br>
		Introduction to IoT<br>
		Working with NoSQL Database (MongoDB)<br>
		Sensors and connectivity technologies<br>
		Cloud computing and data analytics<br>
		Project
		</p><hr>
		<h2>C/C++</h2>
		<h3>C/C++ course trains you in :</h3>
		<p>
		Understand the basics of computer programming<br>
		Write, compile and debug programs in C language<br>
		Use different data types in a computer program<br>
		Learn how to use functions, methods and routines<br>
		Define the structure of a C++ program<br>
		Identify standard input and output functions<br>
		Describe private and public sections of classes with member functions<br>
		Use the objects and member functions of a class<br>
		Explain conditional constructs<br>
		Describe functions, pointers, and arrays, function overloading, inheritance, polymorphism<br>
		Describe exception handling<br>
		Develop object-oriented applications using C++
		</p>
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