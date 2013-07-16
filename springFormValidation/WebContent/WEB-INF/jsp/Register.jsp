<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Registration Form</title>
</head>
<body>
	<center>
		<div style="color: teal; font-size: 30px">Being Java Guys |
			Registration Form</div>
		<br>
		<br>
		<form:form action="submit.html" commandName="student" method="post">
			<table>
				<tr>
					<td>Id:</td>
					<td><form:input path="id" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="id" />
					</td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="name" />
					</td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" value="Male" /> Male
						&nbsp; <form:radiobutton path="gender" value="Female" /> Female</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="gender" />
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="email" />
					</td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><form:input path="phone" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="phone" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="password" />
					</td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><form:password path="confirmPassword" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="confirmPassword" />
					</td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:select path="city">
							<form:option value="select">---select---</form:option>
							<form:options items="${cityList}" />
						</form:select>
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="city" />
					</td>
				</tr>
				<tr>
					<td>Overview:</td>
					<td><form:textarea path="overview" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="overview" />
					</td>
				</tr>
				<tr>
					<td>Interest:</td>
					<td><form:checkboxes items="${interestList}" path="interest" />
					</td>
					<td style="color: red; font-style: italic;"><form:errors
							path="interest" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
