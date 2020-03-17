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



	<ul>
		<!-- notation rare -->
		<li>Marque : ${requestScope['voiture'].marque}</li>
		<!-- notation moins rare -->
		<li>Modèle : ${requestScope.voiture.marque}</li>
		<!-- notation la plus courante -->
		<li>Immat. : ${voiture.immatriculation}</li>
		<li>Odometre : ${voiture.kilometrage}</li>
	</ul>

</body>
</html>