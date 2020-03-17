<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<style>
/*the container must be positioned relative:*/
.custom-select {
	position: relative;
	font-family: Arial;
}

.custom-select select {
	display: none; /*hide original SELECT element:*/
}

.select-selected {
	background-color: DodgerBlue;
}

/*style the arrow inside the select element:*/
.select-selected:after {
	position: absolute;
	content: "";
	top: 14px;
	right: 10px;
	width: 0;
	height: 0;
	border: 6px solid transparent;
	border-color: #fff transparent transparent transparent;
}

/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
	border-color: transparent transparent #fff transparent;
	top: 7px;
}

/*style the items (options), including the selected item:*/
.select-items div, .select-selected {
	color: #ffffff;
	padding: 8px 16px;
	border: 1px solid transparent;
	border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	cursor: pointer;
	user-select: none;
}

/*style items (options):*/
.select-items {
	position: absolute;
	background-color: DodgerBlue;
	top: 100%;
	left: 0;
	right: 0;
	z-index: 99;
}

/*hide the items when the select box is closed:*/
.select-hide {
	display: none;
}

.select-items div:hover, .same-as-selected {
	background-color: rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

<form action="<%=request.getContextPath() %>/ServletGestionPreference" method="post">
<!--  Liste couleurs dispo -->
<%
List<String> couleurs = (List<String>)%>
</form>


	<div class="custom-select" style="width: 200px;">
		<select>
			<option value="0">Couleur :</option>
			<option value="1">Noir</option>
			<option value="2">Bleu</option>
			<option value="3">Rouge</option>
		</select>
		<input type="submit" value="valider">
	</div>

	
	<div class="container">
		<p>Vous êtes venu X fois</p>
	</div>
</body>
</html>