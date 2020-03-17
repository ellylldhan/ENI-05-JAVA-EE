<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Une JSP affichant des informations fournies par la
	servlet</title>
</head>
<body>
	<%
String uneVariable = (String) request.getAttribute("uneCle");
%>
	<p>
		L'information fournie par la servlet est :
		<%= uneVariable %>
	</p>
	<p>
		<a
			href="<%=request.getContextPath()%>/modules/module3/demonstrations/demonstration6.html">Retour</a>
	</p>
</body>
</html>