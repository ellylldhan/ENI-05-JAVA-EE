<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page affichant des voitures</title>
</head>
<body>
	<h1>Cette page affiche des voitures avec les balises JSTL</h1>

	<a href="">Rafraîchir</a>

	<h2>Affichage ou non d'une voiture</h2>

	<c:if test="${empty voiture}">

		<ul>
			<!-- notation rare -->
			<li>Marque : ${requestScope['voiture'].marque}</li>
			<!-- notation moins rare -->
			<li>Modèle : ${requestScope.voiture.marque}</li>
			<!-- notation la plus courante -->
			<li>Immat. : ${voiture.immatriculation}</li>
			<li>Odometre : ${voiture.kilometrage}</li>
		</ul>
	
	</c:if>
	
	<c:if test="${empty voiture}">
		<p>La voiture n'existe pas</p>
	</c:if>

	<h2>Affichage liste voitures</h2>
	<p>Il y a ${voitures.size()} voitures.</p>
	<ol>
		<c:forEach var="v" items="${voitures}">
		<li>${v.toString()}</li>
		</c:forEach>

	</ol>

</body>
</html>