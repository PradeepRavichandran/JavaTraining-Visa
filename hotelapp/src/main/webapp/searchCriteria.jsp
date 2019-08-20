<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Hotel</title>
</head>
<body>
<h3>Search Hotel</h3>
	<form method="get" action="Listhotels.do">
		Search criteria <input type="text" name="criteria" required /><br />
		<button type="submit">Search</button>
	</form>

</body>
</html>