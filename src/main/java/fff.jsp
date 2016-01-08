


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
form, form div {
	display: inline;
	padding: 2px;
}

table, th, td {
	border-collapse: collapse;
	border: 2px solid black;
}
</style>
<title>Hello Admin</title>
</head>
<body>
	<p align="right">
		Admin Admin (<a href="j_spring_security_logout">Logout</a>)
	</p>
	<p>
		<a href="/SpringMvcProject/admin/create">Add new user</a>
	</p>
	<div align="center">
		<table>
		
		<td><c:if test="${edit==null}">
                        <form:input path="login" value="" />
                    </c:if> <c:if test="${edit!=null}">
                        <form:input path="login" value="" readonly="" />
                    </c:if></td>
		
		
			<tr>
				<th>Login</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Role</th>
				<th>Actions</th>
			</tr>
			<tr>
				<td>Admin</td>
				<td>Administrator</td>
				<td>Administratorovich</td>
				<td>25</td>
				<td>Admin</td>
				<td><a href="/SpringMvcProject/admin/edit?login=Admin">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="Admin" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>User</td>
				<td>User</td>
				<td>Userovich</td>
				<td>23</td>
				<td>User</td>
				<td><a href="/SpringMvcProject/admin/edit?login=User">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="User" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>User2</td>
				<td>q</td>
				<td>q</td>
				<td>25</td>
				<td>Admin</td>
				<td><a href="/SpringMvcProject/admin/edit?login=User2">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="User2" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>Doo</td>
				<td>qq</td>
				<td>qq</td>
				<td>25</td>
				<td>Admin</td>
				<td><a href="/SpringMvcProject/admin/edit?login=Doo">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="Doo" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>Ddd</td>
				<td>ddssd</td>
				<td>asda</td>
				<td>26</td>
				<td>Admin</td>
				<td><a href="/SpringMvcProject/admin/edit?login=Ddd">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="Ddd" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>ffff</td>
				<td>rrr</td>
				<td>rr</td>
				<td>24</td>
				<td>User</td>
				<td><a href="/SpringMvcProject/admin/edit?login=ffff">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="ffff" /><input type="submit"
								value="Delete" onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>ffff,ffff</td>
				<td>rrrqqqqqqqqq</td>
				<td>rrqqqqqqqq</td>
				<td>24</td>
				<td>Admin</td>
				<td><a href="/SpringMvcProject/admin/edit?login=ffff,ffff">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="ffff,ffff" /><input
								type="submit" value="Delete"
								onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
			<tr>
				<td>ffff,ffff,ffff,ffff</td>
				<td>rrrqqqqqqqqqaa</td>
				<td>rrqqqqqqqqaa</td>
				<td>24</td>
				<td>User</td>
				<td><a
					href="/SpringMvcProject/admin/edit?login=ffff,ffff,ffff,ffff">Edit</a>
				<form action="/SpringMvcProject/admin/user_operations.do"
						method="post">
						<div>
							<input type="hidden" name="action" value="delete" /><input
								type="hidden" name="login" value="ffff,ffff,ffff,ffff" /><input
								type="submit" value="Delete"
								onclick="return confirm('Are you sure?');" />
						</div>
					</form>
			</tr>
		</table>

	</div>
</body>
</html>