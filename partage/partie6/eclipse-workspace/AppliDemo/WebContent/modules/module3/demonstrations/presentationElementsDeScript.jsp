<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    private int nombreAppel;
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Presentation des elements de script</title>
</head>
<body>
<%
this.nombreAppel+=1;
%>
<p>
Nombre d'appel de la JSP = <%=this.nombreAppel %>
</p>
</body>
</html>