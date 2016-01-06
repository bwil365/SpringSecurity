<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete User</title>
</head>
<body>
	<h1>Delete User</h1>
	<p>Are you sure you want to delete your user</p>
	<form:form action="/SpringSecurityBoilerplate/public/delete" modelAttribute="deleteUserForm">
		<table>
			<tr>
				<td><form:label path="decision">Yes</form:label></td>
				<td><form:radiobutton path="decision" value="Y"/></td>
			</tr>
			<tr>
				<td><form:label path="decision">No</form:label></td>
				<td><form:radiobutton path="decision" value="N"/></td>
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