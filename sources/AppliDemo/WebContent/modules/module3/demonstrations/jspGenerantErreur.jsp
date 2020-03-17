<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="false" errorPage="jspTraitantErreur.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page générant l'erreur</title>
</head>
<body>

<% 
// Generation d'une erreur : length de null
String maVariable = null;
maVariable.length(); %>

</body>
</html>