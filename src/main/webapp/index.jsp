<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css"/>
<title>Aptech Learning</title>
</head>
<body>
<div>
	<div>
		<form action="logout">
			<input type="submit" value="Log out" id="out" style="background-color:#ff5757;float:right;margin-top:-50px;margin-right:30px;">
		</form>
	</div>
	<div class="bar">
		<div class="child"><a class="childLink" href="index.jsp" >Home Page</a></div>
		<div class="child"><a class="childLink" href="courses.jsp" >Courses</a></div>
		<div class="child"><a class="childLink" href="http://localhost:8080/Aptech_Enquiry/enquiryServlet" >Enquiry</a></div>
		<div class="child"><a class="childLink" href="http://localhost:8080/Aptech_Enquiry/registrationServlet" >Registration</a></div>
		<div class="child"><a class="childLink" href="about.jsp" >About Us</a></div>
		<div class="child"><a class="childLink" href="contact.jsp" >Contact</a></div>
	</div>
	<img src="aptech.png" >
	<div id="form" style="margin:0 30% 0% 30%;padding:2% 5% 2% 5%; border:2px solid black; display:block;">
		<h2>Login for Registration and enquiry</h2>
		<form action="login" method="post">
			Username : <input type="text" name="username" placeholder="Enter Username" required/><br><br>
			Password : <input type="password" name="password" Placeholder="Enter Password" required/><br><br>
			<input type="submit" value="Login" id="login" style="margin-left:40%;padding:6px 11px 6px 11px;background-color:#00df00;">
		</form>
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
	