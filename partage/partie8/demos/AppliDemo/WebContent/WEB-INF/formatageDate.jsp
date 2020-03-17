<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.GregorianCalendar" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formatage des dates</title>
</head>
<body>
<c:if test="${!empty param.langue }">
<!--  Définition de la locale à utiliser -->
<fmt:setLocale value="${param.langue}" />
</c:if>
<h2>L'heure en france</h2>
<p>Affichage de la date actuelle avec la langue par défaut</p>
<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full" />

<p>Affichage de l'heure actuelle avec la langue par défaut</p>
<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short" />
<h2>L'heure à New York</h2>
<fmt:timeZone value="America/New_York">
<p>Affichage de la date actuelle avec la langue par défaut à New-York</p>
<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full" />

<p>Affichage de l'heure actuelle avec la langue par défaut à New-York</p>
<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short" />
</fmt:timeZone>

</body>
</html>