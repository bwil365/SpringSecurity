<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Account</title>
</head>
<body>
	<form:form method="POST" action="/SpringSecurityBoilerplate/public/create" modelAttribute="userForm">
	   	<table>
		    <tr>
		        <td><form:label path="username">User Name</form:label></td>
		        <td><form:input path="username" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="password">Password</form:label></td>
		        <td><form:password path="password" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="firstName">First Name</form:label></td>
		        <td><form:input path="firstName" /></td>
		    </tr>
		     <tr>
		        <td><form:label path="lastName">Last Name</form:label></td>
		        <td><form:input path="lastName" /></td>
		    </tr>
		    <tr>
		        <td>
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>  
	</form:form>
</body>
</html>