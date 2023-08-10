<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="all.css"/>

<title>Registration</title>
</head>
<body>
<div id="main">
	<div id="logOut">
		<form action="logout">
			<input type="submit" value="Log out" class="out">
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

	<div id="form">
		<h1>Edit Registration form :</h1>
		<form action="editServlet">
			<input type="hidden" name="type" value="<%=request.getParameter("type")%>">
			<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			Name :<input type="text" name="Name" placeholder="Enter your name" required/><br><br>
			Age :<input type="number" name="Age" min="6" max="200"required/><br><br>
			Gender :<br>
			<input type="radio" name="Gender" value="Male" required/>Male<br>
			<input type="radio" name="Gender" value="Female"/>Female<br>
			<input type="radio" name="Gender" value="Other"/>Other<br><br>
			
			City :<input type="text" name="City" placeholder="Enter your city"required/><br><br>
			Branch :<input type="text" name="Branch" placeholder="Enter Aptech Branch name"required/><br><br>
			Course :<br>
			<input type="radio" name="Course" value="Python" required/>Python<br>
			<input type="radio" name="Course" value="Java"/>Java<br>
			<input type="radio" name="Course" value="Ethical Hacking"/>Ethical Hacking<br>
			<input type="radio" name="Course" value="IOTs"/>IOTs<br>
			<input type="radio" name="Course" value="C/C++"/>C/C++<br><br>
			Highest Qualification :<br>
			<input type="radio" name="Qualification" value="Below 10th"required/>Below 10th<br>
			<input type="radio" name="Qualification" value="Maticulation"/>Maticulation<br>
			<input type="radio" name="Qualification" value="Intermediate"/>Intermediate<br>
			<input type="radio" name="Qualification" value="Graduate"/>Graduate<br>
			<input type="radio" name="Qualification" value="Post Graduate"/>Post Graduate<br>
			<input type="radio" name="Qualification" value="Above Post Graduate"/>Above Post Graduate<br><br>
			
			Contact :<input type="text" name="Contact" placeholder="+91 987654321" required/><br><br>
			Email Id :<input type="email" name="Email" placeholder="Enter you e-mail" required/><br><br>
			
			Mode of Payment : <br>
			<input type="radio" name="Payment" value="Cash" required/>Cash<br>
			<input type="radio" name="Payment" value="Online Transfer"/>Online transfer<br>
			<input type="radio" name="Payment" value="Installment"/>Installment<br><br>
			
			<input type="submit" class="btn" value="Update Changes">
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