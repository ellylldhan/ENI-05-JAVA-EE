<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>ACCUEIL</h1>
	
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/ajoutrepas"><input type="button" value="Ajouter un nouveau repas"/></a>
	</div>
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/repas"><input type="button" value="Visualiser les repas"/></a>
	</div>
</body>
</html>