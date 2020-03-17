<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.GregorianCalendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo Formatage Nombre</title>
</head>
<body>
<p>125 / 35 = <fmt:formatNumber type="number" value="${125/1}" minFractionDigits="2" maxFractionDigits="2"></fmt:formatNumber>
</p>
</body>
</html>