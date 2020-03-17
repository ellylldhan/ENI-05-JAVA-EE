<%@page import="fr.eni.javaee.tp.chifoumi_v3.bo.ActionsPossibles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <title>Jouez au chifoumi</title>
</head>
<body>

<div class="container">
    <h1 class="my-4">Jouez!</h1>

    <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <div class="card-body">
                <h4 class="card-title">
                    <a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.CHI%>">
                        <img width="75" src="<%=request.getContextPath()%>/images/chi.png" alt="chi"/>
                    </a>
                </h4>
            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <div class="card-body">
                <h4 class="card-title">
                    <a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.FOU%>">
                        <img width="75" src="<%=request.getContextPath()%>/images/fou.png" alt="fou"/>
                    </a>
                </h4>
            </div>
        </div>
    </div>

    <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
        <div class="card h-100">
            <div class="card-body">
                <h4 class="card-title">
                    <a href="<%=request.getContextPath()%>/jouez?choix=<%=ActionsPossibles.MI%>">
                        <img width="75" src="<%=request.getContextPath()%>/images/mi.png" alt="mi"/>
                    </a>
                </h4>
            </div>
        </div>
    </div>

    <h1 class="my-4">Jouez!</h1>
    <form action="<%=request.getContextPath()%>/jouez" method="post">
        <ul>
            <li>
                <label for="choix<%=ActionsPossibles.CHI%>">
                    <img width="75"  src="<%=request.getContextPath()%>/images/chi.png" alt="chi"/>
                </label>
                <input type="radio" id="choix<%=ActionsPossibles.CHI%>" name="choix" value="<%=ActionsPossibles.CHI%>"/>
            </li>
            <li>
                <label for="choix<%=ActionsPossibles.FOU%>">
                    <img width="75"  src="<%=request.getContextPath()%>/images/fou.png" alt="fou"/>
                </label>
                <input type="radio" id="choix<%=ActionsPossibles.FOU%>" name="choix" value="<%=ActionsPossibles.FOU%>"/>
            </li>
            <li>
                <label for="choix<%=ActionsPossibles.MI%>">
                    <img width="75"  src="<%=request.getContextPath()%>/images/mi.png" alt="mi"/>
                </label>
                <input type="radio" id="choix<%=ActionsPossibles.MI%>" name="choix" value="<%=ActionsPossibles.MI%>"/>
            </li>
        </ul>
        <input type="submit" value="Valider">
    </form>


</div>
</body>
</html>