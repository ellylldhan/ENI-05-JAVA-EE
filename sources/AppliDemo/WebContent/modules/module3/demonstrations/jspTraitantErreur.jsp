<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
	        
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP traitant l'erreur</title>
</head>
<body>
<h1>ERREUR !!!!</h1>
<h2>Details de l'exception :</h2>
<p><%= exception %></p>
<pre>
<%= exception.getMessage() %>
</pre>
</body>
</html>