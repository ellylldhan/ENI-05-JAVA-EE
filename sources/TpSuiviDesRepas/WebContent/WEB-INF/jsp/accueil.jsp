<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Accueil</title>
</head>
<body>

	<div class="container">
		<div id="header" class="header" style="text-align: center;">
			Suivi des Repas
		</div>
		
		<div class="container" style="margin-top:20px;">
			<a href="<%=request.getContextPath()%>/ServletAjoutRepas" class="lien_ilot" role="button" target="_self">
				Ajouter un nouveau repas </a> <a
				href="<%=request.getContextPath()%>/ServletVisuRepas" class="lien_ilot"
				role="button" target="_self"> Visualiser les repas </a>
		</div>
	</div>

</body>
</html>

