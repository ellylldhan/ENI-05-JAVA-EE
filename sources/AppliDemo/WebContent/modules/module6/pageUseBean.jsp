<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Voiture JSP BEAN</title>
</head>
<body>
	<h1>Cette page affiche une voiture si elle a été créée</h1>

	<jsp:useBean id="voiture" scope="request"
		class="fr.eni.javaee.modules.module6.bo.Voiture">
	</jsp:useBean>

	<ul>
		<li>Marque : <jsp:getProperty property="marque" name="voiture" /></li>
		<li>Modèle : <jsp:getProperty property="modele" name="voiture" /></li>
		<li>Immat. : <jsp:getProperty property="immatriculation"
				name="voiture" /></li>
		<li>Odometre : <jsp:getProperty property="kilometrage"
				name="voiture" /></li>
	</ul>

</body>
</html>