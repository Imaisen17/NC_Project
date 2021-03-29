<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 17.03.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.math.BigInteger" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>web app test</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<%@ include file="../header.jsp"%>

<c:forEach var="statistic" items="${statistics}">
    <li>Statistic Id: ${statistic.id}, Short Address: ${statistic.refShortAdr}, Last Transaction: ${statistic.lastTrans} Number of Transaction: ${statistic.numbOfTrans}, Author Id: ${statistic.authorId}</li>
</c:forEach>

</body>
</html>