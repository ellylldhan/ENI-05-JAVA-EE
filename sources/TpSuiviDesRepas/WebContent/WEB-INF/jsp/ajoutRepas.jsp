<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.eni.javaee.suivirepas.bo.Repas"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/styles.css" rel="stylesheet">
<title>Ajout repas</title>
</head>
<body>
	<div class="container">

		<div id="header" class="header" style="text-align: center;">
			Ajouter un repas</div>


		<div class="container" id="output">

			<%
				Repas repas = (Repas) request.getAttribute("aliments");

				if (request.getAttribute("succes").toString() == "true") {
			%>
			<p style="color: green;">Le repas a été ajouté avec succès :</p>
			<p><%=repas%></p>
			<%
				} else {
			%>
			<p style="color: red;">Le repas n'a pas été ajouté.</p>

			<%
				}
			%>


		</div>


		<div class="container">
			<form action="<%=request.getContextPath()%>/ServletAjoutRepas"
				method="post">

				<table>
					<tr>
						<td><label for="idDate">Date : </label></td>
						<td><input type="date" id="idDate" name="dateRepas"
								style="margin-left: 15px;" /></td>
					</tr>
					<tr>
						<td><label for="idHeure">Heure : </label></td>
						<td><input type="time" id="idHeure" name="heureRepas"
								style="margin-left: 15px;" /></td>
					</tr>
					<tr>
						<td><label for="idRepas">Repas : </label></td>
						<td><textarea id="idRepas" name="aliments" rows="5" cols="33"
								style="margin-left: 15px;"></textarea></td>
					</tr>
					<tr>
						<td><input type="submit" value="Valider" /></td>

						<td><a href="<%=request.getContextPath()%>/ServletAccueil"
							role="button">Annuler</a></td>
					</tr>
				</table>

			</form>

		</div>
	</div>

</body>
</html>

