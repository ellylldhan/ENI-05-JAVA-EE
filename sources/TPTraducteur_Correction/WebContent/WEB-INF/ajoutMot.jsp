<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="fr.eni.javaee.traducteur.messages.messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/meta.jsp"></jsp:include>
<jsp:include page="/WEB-INF/fragments/styles.jsp"></jsp:include>

<title><fmt:message key="msg.traducteur" /></title>
</head>
<body>

	<div class="container" style="text-align: center;">

		<form method="post"
			action="${pageContext.request.contextPath}/nouveauMot"
			class="row justify-content-center mb-2">
			<p>
				<fmt:message key="msg.nouveau">
					<fmt:param value="${sessionScope.prenom}"></fmt:param>
				</fmt:message>
			</p>
			
			<div>
				<label><fmt:message key="msg.mot"></fmt:message> :</label>
				<input class="form-control" style="text-align: center;" size="10"
					type="text" name="nouveauMot" />
			</div>
			<div>
				<label for="traductionEN" class="col-2 col-form-label"> <fmt:message
						key="msg.motlanguea"></fmt:message>
				</label>
				<input class="form-control" style="text-align: center;" size="10"
					type="text" name="traductionEN" />
			</div>
			<div>
				<label for="traductionDE" class="col-2 col-form-label"> <fmt:message
						key="msg.motlangueb"></fmt:message>
				</label>
				<input class="form-control" style="text-align: center;" size="10"
					type="text" name="traductionDE" />
			</div>
			<div>
				<label for="traductionPT" class="col-2 col-form-label"> <fmt:message
						key="msg.motlanguec"></fmt:message>
				</label>
				<input class="form-control" style="text-align: center;" size="10"
					type="text" name="traductionPT" />
			</div>
					<div>
			<input type="submit" value="<fmt:message key="msg.valider"></fmt:message>">
		</div>

		</form>
	</div>


</body>
</html>