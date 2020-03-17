<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<h1 class="my-4" style="text-align: center;">
			<fmt:message key="msg.traducteur"></fmt:message>
		</h1>

		<p>
			<fmt:message key="msg.accueil">
				<fmt:param value="${sessionScope.prenom}"></fmt:param>
			</fmt:message>
		</p>


		<form method="POST"
			action="${pageContext.request.contextPath}/ServletChangerLangue">
			<p>
				<select name="langueinitiale" onchange="document.form[0].submit();">
					<option value=""><fmt:message key="msg.langueinitiale" /></option>
					<option value="fr"
						${sessionScope.langueinitiale=="fr"?"selected":""}><fmt:message
							key="msg.fr"></fmt:message></option>
					<option value="de"
						${sessionScope.langueinitiale=="de"?"selected":""}><fmt:message
							key="msg.de"></fmt:message></option>
					<option value="en"
						${sessionScope.langueinitiale=="en"?"selected":""}><fmt:message
							key="msg.en"></fmt:message></option>
					<option value="pt"
						${sessionScope.langueinitiale=="pt"?"selected":""}><fmt:message
							key="msg.pt"></fmt:message></option>
				</select>
			</p>
			<p>
				<input type="submit"
					formaction="${pageContext.request.contextPath}/CollabCommunaute"
					value="<fmt:message key="msg.collab"></fmt:message>" />
			</p>
		</form>

		<fmt:setLocale value="${sessionScope.langueinitiale}" />
		<fmt:setBundle
			basename="fr.eni.javaee.traducteur.messages.dictionnaire"
			var="r_langueinitiale" />
		<fmt:setLocale value="${sessionScope.languecible}" />
		<fmt:setBundle
			basename="fr.eni.javaee.traducteur.messages.dictionnaire"
			var="r_languecible" />


		<table>
		<thead>
			<tr>
				<th><fmt:message key="msg.langueinitiale" />:${sessionScope.langueinitiale}</th>
				<th><fmt:message key="msg.languecible" />:{sessionScope.languecible}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="key"
				items="${r_langueinitiale.getResourceBundle().getKeys()}">
				<tr>
					<td><fmt:message bundle="${r_langueinitial}" key="${key}"></fmt:message></td>
					<td><fmt:message bundle="${r_languecible}" key="${key}"></fmt:message></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>


</body>
</html>