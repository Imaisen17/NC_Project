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

<ul>
    <c:forEach var="statistics" items="${statisticsRefList}">
        <li>Statistic ${statistics.idAuthor}, shortRef: ${statistics.refShortAdr}, number of trans: ${statistics.numbOfTrans}, last: ${statistics.lastTrans}</li>
    </c:forEach>
</ul>

</body>
</html>