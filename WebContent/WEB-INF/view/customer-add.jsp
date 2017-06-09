<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<h3>Customer Relationship Management</h3>
	</div>
	
	<div id="contents">
		<form:form method="POST" action="${pageContext.request.contextPath}/customer/saveCustomer" modelAttribute="customer">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input path="lastName"/></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>