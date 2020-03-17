<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.GregorianCalendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo formatage des dates</title>
</head>
<body>



	<c:if test="${!empty param.langue }">
		<!--  Définition de la locale à utiliser -->
		<fmt:setLocale value="${param.langue}" />
	</c:if>
	<h2>L'heure en France</h2>
	<p>Affichage de la date actuelle avec la langue par défaut</p>
	<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}"
		dateStyle="full"></fmt:formatDate>

	<h2>L'heure actuelle avec la langue par défaut</h2>
	<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}"
		type="time" dateStyle="short"></fmt:formatDate>

	<h2>Heure avec Fuseau Horaire</h2>
	<fmt:timeZone value="America/New_York">
		<p>Heure de NY :</p>
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}"
			type="time" dateStyle="short"></fmt:formatDate>
	</fmt:timeZone>


	<fmt:timeZone value="America/Chicago">
		<p>Heure de Chicago :</p>
		<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}"
			type="time" dateStyle="short"></fmt:formatDate>
	</fmt:timeZone>



</body>
</html>