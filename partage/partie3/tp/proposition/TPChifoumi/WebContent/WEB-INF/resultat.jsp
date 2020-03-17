<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat du jeu CHI FOU MI</title>
</head>
<body>
<%
int resultat=(int)request.getAttribute("resultat");
int choixJoueur=(int)request.getAttribute("choixJoueur");
int choixOrdinateur=(int)request.getAttribute("choixOrdi");
if(resultat==0)
{
	%>
	<p>Egalité, vous et l'ordinateur avez joué <%=choixJoueur %></p>
	<%
}
else
{
	if(resultat==1)
	{
		%>
		<p>Vous avez gagné, vous avez joué <%=choixJoueur %>  et l'ordinateur a joué <%=choixOrdinateur %> </p>
		<%
	}
	else
	{
		%>
		<p>Vous avez perdu, vous avez joué <%=choixJoueur %>  et l'ordinateur a joué <%=choixOrdinateur %></p>
		<%
	}
}
%>
<a href="<%=request.getContextPath()%>/jeu">Rejouez</a>
</body>
</html>