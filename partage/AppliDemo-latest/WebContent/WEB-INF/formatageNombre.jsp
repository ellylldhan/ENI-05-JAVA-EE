<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formatage des nombres</title>
</head>
<body>
Résultat de l'affichage de 125/35, avec 2 chiffres après la virgule :
 <fmt:formatNumber type="number"
 value="${125/35}"
 maxFractionDigits="10"
 minFractionDigits="1"
 ></fmt:formatNumber>
</body>
</html>