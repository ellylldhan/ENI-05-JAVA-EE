<%--
  Created by IntelliJ IDEA.
  User: rlizot2019
  Date: 05/03/2020
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@page import="fr.eni.javaee.tp.chifoumi_v3.bo.ActionsPossibles" %>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="TP Chifoumi v3 - Internationalisation">
    <meta name="author" content="rlizot2019">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/4-col-portfolio.css" rel="stylesheet">

    <title>Résultat Chifoumi</title>
</head>
<body>

<%
    int choixJoueur = (int) request.getAttribute("choixJoueur");
    int choixServeur = (int) request.getAttribute("choixServeur");
    int resultat = (int) request.getAttribute("resultat");
%>
<div class="container">
<h1 class="my-h4">Résultat</h1>
<h4>Choix du joueur :</h4>

    <%=request.getAttribute("choixJoueur")%>

    <%
        if (choixJoueur == ActionsPossibles.CHI) {
            %><img width="75" src="<%=request.getContextPath()%>/images/chi.png"/><%
        } else if (choixJoueur == ActionsPossibles.FOU){
            %><img width="75" src="<%=request.getContextPath()%>/images/fou.png"/><%
        } else if (choixJoueur == ActionsPossibles.MI) {
            %><img width="75" src="<%=request.getContextPath()%>/images/chi.png"/><%
        } else {
            out.print("Je ne comprend pas votre choix.");
        }
    %>

    <h4>Choix du Serveur :</h4>
        <%=request.getAttribute("choixServeur")%>
    <%
        if (choixServeur == ActionsPossibles.CHI) {
            %><img width="75" src="<%=request.getContextPath()%>/images/chi.png"/><%
        } else if (choixServeur == ActionsPossibles.FOU){
            %><img width="75" src="<%=request.getContextPath()%>/images/fou.png"/><%
        } else if (choixServeur == ActionsPossibles.MI) {
            %><img width="75" src="<%=request.getContextPath()%>/images/chi.png"/><%
        } else {
            out.print("Je ne comprend pas le choix du serveur.");
        }
    %>

    <h4>Résultat :</h4>

    <%=request.getAttribute("resultat")%>

    <%
        switch(resultat) {
            case 0:
                out.write("Egalité !");
                break;
            case 1:
                out.write("Vous avez gagné!");
                break;
            default:
                out.write("Vous avez perdu!");
        }
    %>

    <div>
        <a href="<%=request.getContextPath() %>/jouez">Rejouer</a>
    </div>

</div>
</body>
</html>
