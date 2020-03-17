<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.messages" />

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/fragments/meta.jsp"></jsp:include>
<jsp:include page="/WEB-INF/fragments/styles.jsp"></jsp:include>

<title><fmt:message key="msg.traducteur"></fmt:message></title>
</head>
<body>

	<div class="container" style="text-align: center;">

		<h1 class="my-4" style="text-align: center;">
			<fmt:message key="msg.traducteur"></fmt:message>
		</h1>

		<form method="post"
			action="${pageContext.request.contextPath}/traducteur"
			class="row justify-content-center mb-2">
			<label for="nom_user" class="col-2 col-form-label"
				style="text-align: center; margin-top: 10px; margin-bottom: 10px"><fmt:message
					key="msg.votreprenom"></fmt:message></label>
			<br>
			<br>
			<input class="form-control" type="text" id="nom_user" name="nom_user"
				style="text-align: center;" size="10" />
			<br>
			<br>
			<input class="button" type="submit"
				value="<fmt:message key="msg.valider"></fmt:message>"
				style="margin-top: 20px;" />
		</form>

	</div>


</body>
</html>