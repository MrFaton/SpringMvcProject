<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<H1>Hi new user, please register</H1>
	<form:form modelAttribute="user" method="POST" enctype="utf8">
		<br>
		<tr>
			<td><label>Login</label></td>
			<td><form:input path="login" value="" /></td>
			<form:errors path="login" element="div" />
		</tr>
		<tr>
			<td><label>Password </label></td>
			<td><form:input path="password" value="" type="password" /></td>
			<form:errors path="password" element="div" />
		</tr>
		<tr>
			<td><label>Confirm password </label></td>
			<td><form:input path="matchingPassword" value="" type="password" /></td>
			<form:errors element="div" />
		</tr>
		<tr>
			<td><label>First name </label></td>
			<td><form:input path="firstName" value="" /></td>
			<form:errors path="firstName" element="div" />
		</tr>
		<tr>
			<td><label>Last name </label></td>
			<td><form:input path="lastName" value="" /></td>
			<form:errors path="lastName" element="div" />
		</tr>
		<tr>
			<td><label>Email </label></td>
			<td><form:input path="email" value="" /></td>
			<form:errors path="email" element="div" />
		</tr>
		<tr>
			<form:select path="role">
				<form:option value="Admin">Admin</form:option>
				<form:option value="User">User</form:option>
			</form:select>
		</tr>

		<button type="submit">Submit</button>
	</form:form>
	<br>
	<a href="<c:url value="login" />">Login </a>
</body>
</html>