<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="msg.traducteur"></fmt:message></title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/nouveauMot">
	<p>
		<fmt:message key="msg.nouveau">
			<fmt:param value="${sessionScope.prenom}"></fmt:param>
		</fmt:message>
	</p>
		<div>
			<label><fmt:message key="msg.mot"></fmt:message> :</label><input type="text" name="nouveuMot"/>
		</div>
		<div>
			<label><fmt:message key="msg.motlanguea"></fmt:message>:</label><input type="text" name="traductionEn"/>
		</div>
		<div>
			<label><fmt:message key="msg.motlangueb"></fmt:message>:</label><input type="text" name="traductionDe"/>
		</div>
		<div>
			<input type="submit" value="<fmt:message key="msg.valider"></fmt:message>">
		</div>
	</form>
</body>
</html>