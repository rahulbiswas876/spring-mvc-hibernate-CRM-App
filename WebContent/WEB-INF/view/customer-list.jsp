<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<p> Customer Relation Management </p>
		
		<!-- button to add new customer -->
		<input type="button"  value="Add customer" onclick="window.location.href='showFormForAdd';false;" /> 
		<br>
	</div>
	<div id="content">
		<table>
			<tr>
				<th> First Name</th>
				<th> Last Name</th>
				<th> Email</th>
				<th> Action</th>
			</tr>
			
			<c:forEach var="item" items="${customerList}">
			
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${item.id}" />
			</c:url>
			
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${item.id}" />
			</c:url>
			
			<tr>
				<td>${item.firstName}</td>
				<td>${item.lastName}</td>
				<td>${item.email}</td>
				<td>
					<a href=${updateLink}>Update |</a> 
					<a href=${deleteLink}
					   onclick="if(!confirm('Are you sure want to delete ?')) return false;">Delete</a>
				</td>
			</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>