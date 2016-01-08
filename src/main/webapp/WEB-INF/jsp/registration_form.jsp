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
	<H1>
		Hi new user, here you can register or you can try to <a
			href="<c:url value="/login"/>">login</a>
	</H1>
	<br>
	<table align="left" border="0" cellpadding="2" cellspacing="5">
		<form:form modelAttribute="userForm" method="POST" enctype="utf8">
			<tr>
				<td><label>Login</label></td>
				<td><form:input path="login" value="" /></td>
				<td><form:errors path="login" element="div" /></td>
			</tr>
			<tr>
				<td><label>Password </label></td>
				<td><form:input path="password" value="" type="password" /></td>
				<td><form:errors path="password" element="div" /></td>
			</tr>
			<tr>
				<td><label>Confirm password </label></td>
				<td><form:input path="matchingPassword" value=""
						type="password" /></td>
				<td><form:errors element="div" /></td>
			</tr>
			<tr>
				<td><label>First name </label></td>
				<td><form:input path="firstName" value="" /></td>
				<td><form:errors path="firstName" element="div" /></td>
			</tr>
			<tr>
				<td><label>Last name </label></td>
				<td><form:input path="lastName" value="" /></td>
				<td><form:errors path="lastName" element="div" /></td>
			</tr>
			<tr>
				<td><label>Email </label></td>
				<td><form:input path="email" value="" /></td>
				<td><form:errors path="email" element="div" /></td>
			</tr>
			<tr>
				<td><label>Birthday</label></td>
				<td><form:input path="birthDay" placeholder="25-12-1990" /></td>
				<td><form:errors path="birthDay" element="div" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Submit</button>
					<button type="reset">Cancel</button>
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>