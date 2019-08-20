<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel List</title>
</head>
<body>
	<h2>Hotel List</h2>
	<form method="post" action="booking.do">
		<table border="1">
			<tr> <th> Name </th> <th>Address</th> <th>City</th> <th>State</th><th>Zipcode</th><th>Country</th><th>Price</th></tr>
			<c:forEach items="${hotels}" var="h">
				<tr>
					<td> ${h.name} </td>
					<td> ${h.address}</td>
					<td> ${h.city}</td>
					<td> ${h.state}</td>
					<td> ${h.zip} </td>
					<td> ${h.country} </td>
					<td> ${p.price } </td>
					<td> <input type="radio" name="ToBook" value="${h.id}"/></td>
				</tr>
			</c:forEach>	
		</table>
		<button type="submit">Add to Bookings</button>
		</form>

</body>
</html>