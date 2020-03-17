<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page affichant des voitures</title>
</head>
<body>
<h1>Cette page affiche des voitures avec les balises JSTL</h1>
<a href="">Rafraichir</a>
<h2>Affichage ou non d'une voiture</h2>

<c:if test="${!empty voiture}">
<ul>
<li>
Marque : ${voiture.marque}
</li>
<li>
Modèle : ${voiture.modele}
</li>
<li>
Immatriculation : ${voiture.immatriculation}
</li>
<li>
Kilométrage : ${voiture.kilometrage}
</li>
</ul>
</c:if>
<c:if test="${empty voiture}">
<p>La voiture n'existe pas</p>
</c:if>

<h2>Affichage de plusieurs voitures</h2>
<p>Il y a ${voitures.size()} voitures</p>
<ol>
<c:forEach var="v" items="${voitures}">
<li>${v.toString()}</li>
</c:forEach>
</ol>
</body>
</html>