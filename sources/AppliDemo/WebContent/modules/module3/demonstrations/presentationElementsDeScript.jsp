<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%!
    private int nombreAppel;
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Présentation des éléments de script</title>
</head>
<body>

<% 
this.nombreAppel++;

%>

<p>Nombre d'appel de la JSP : <%=this.nombreAppel%></p>
</body>
</html>