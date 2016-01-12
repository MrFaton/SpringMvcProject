<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="addOrEdit" />
<c:if test="${action == 'create'}">
	<c:set var="addOrEdit" value="Add " />
</c:if>
<c:if test="${action == 'update'}">
	<c:set var="addOrEdit" value="Edit " />
</c:if>
<sec:authentication var="principal" property="principal" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${addOrEdit}User</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<p align="right">
		Admin ${principal.username} (<a
			href="<c:url value="/j_spring_security_logout"/>">Logout</a>)
	</p>
	<h1>${addOrEdit}user</h1>
	<br>
	<form:form modelAttribute="userForm" method="POST" enctype="utf8"
		action="${pageContext.request.contextPath}/admin/manage">
		<input type="hidden" name="action" value="${action}" />
		<table align="left" border="0" cellpadding="2" cellspacing="5">
			<tr>
				<td><label>Login</label></td>
				<td><c:if test="${action == 'create'}">
						<form:input path="login" value="" />
					</c:if> <c:if test="${action == 'update'}">
						<form:input path="login" value="" readonly="true" />
					</c:if></td>
				<td><form:errors path="login" element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Password </label></td>
				<td><form:input path="password" value="" type="password" /></td>
				<td><form:errors path="password" element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Confirm password </label></td>
				<td><form:input path="matchingPassword" value=""
						type="password" /></td>
				<td><form:errors element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>First name </label></td>
				<td><form:input path="firstName" value="" /></td>
				<td><form:errors path="firstName" element="div"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Last name </label></td>
				<td><form:input path="lastName" value="" /></td>
				<td><form:errors path="lastName" element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Email </label></td>
				<td><form:input path="email" value="" /></td>
				<td><form:errors path="email" element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Birthday</label></td>
				<td><form:input path="birthDay" placeholder="25-12-1990" /></td>
				<td><form:errors path="birthDay" element="div" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Role </label></td>
				<td><form:select path="role">
						<form:option value="Admin">Admin</form:option>
						<form:option value="User">User</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Submit</button> <input type="button"
					onclick="location.href='${pageContext.request.contextPath}/';"
					value="Cancel" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>