<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Bookings</title>
</head>
<body>
	<h2>My Bookings</h2>
	<form method="post" action="search.do">
		<table border="1">
			<tr> <th> Booking Id </th> <th>Hotel Name</th> <th>Address</th><th>City</th><th>Country</th><th>Check-in date</th><th>Check-out date</th><th>No.of beds</th><th>Price</th></tr>
			<c:forEach items="${bookList}" var="b">
				<tr>
					<td> ${b.id} </td>
					<td> ${b.hotel.name} </td>
					<td> ${b.hotel.address}</td>
					<td> ${b.hotel.city}</td>
					<td> ${b.hotel.country} </td>
					<td> ${b.checkinDate} </td>
					<td> ${b.checkoutDate}</td>
					<td> ${b.beds}</td>
					<td> ${b.hotel.price } </td>
				</tr>
			</c:forEach>	
		</table>
		<button type="submit">Search for Hotel</button>
		</form>

</body>
</html>