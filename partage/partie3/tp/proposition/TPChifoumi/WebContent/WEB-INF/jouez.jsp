<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeu du CHI FOU MI</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/jeu?choix=1"><img src="<%=request.getContextPath()%>/images/pierre.png" width=25% />CHI</a>
<a href="<%=request.getContextPath()%>/jeu?choix=2"><img src="<%=request.getContextPath()%>/images/papier.png" width=25% />FOU</a>
<a href="<%=request.getContextPath()%>/jeu?choix=3"><img src="<%=request.getContextPath()%>/images/ciseaux.png" width=25% />MI</a>

</body>
</html>