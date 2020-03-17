<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Presentation des principaux objets disponibles</title>
</head>
<body>
	<h1>request</h1>
	<p>
		<%= request.getContextPath() %>
		</p>
		
	<h1>response</h1>
	<p>
		<%=response.getStatus()%></p>
	<p>
		<%
			out.println("Bonjour");
		%>
	</p>

	<a
		href="<%=request.getContextPath()%>/modules/module3/demonstrations/demonstration5.html">Retour</a>
</body>
</html>