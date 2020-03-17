<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage d'un attribut d'application</title>
</head>
<body>
<p>
Voici notre attribut d'application :
<%=application.getAttribute("attributDapplication") %>
</p>
<p>
Voici l'email de l'administrateur :
<%=application.getInitParameter("EMAIL_ADMINISTRATEUR") %>
</p>
</body>
</html>