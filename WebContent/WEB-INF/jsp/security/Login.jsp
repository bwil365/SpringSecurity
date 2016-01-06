<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- This JSP is used for the custom login page.  If the user enters in an incorrect password and user name 
combination Spring Security is configured to send them back to this same JSP page with an error message.
This page also contains a link to the account creation page. --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login Yo!!!!</h1>
	<% 
		if (request.getParameter("error") != null ){
        	out.println("ERROR LOGIN");
    	}
	%>
	<form action="/SpringSecurityBoilerplate/login"  method="post">
        Username<input type="text" name="user_param"/><br/>
        Password<input type="password" name="pass_param"/><br/>
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
        <input type="submit"/>
    </form>

	<a href="/SpringSecurityBoilerplate/public/create">Create Account</a>

</body>
</html>