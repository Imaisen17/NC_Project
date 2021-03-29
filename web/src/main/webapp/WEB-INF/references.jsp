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
<%--<ul>
    <c:forEach var="reference" items="${referenceList}">
        <li>Reference - Full address: ${reference.fullAddress} short address: ${reference.shortAddress}, date create: ${reference.dateCreate}</li>
    </c:forEach>
</ul>--%>

<ul>
    <c:forEach var="reference" items="${referenceList}">
        <li>Reference - Full address:  <a href="referenceUpdate?shortAddress=${reference.shortAddress}"> ${reference.fullAddress} </a> Short Address: ${reference.shortAddress}, Date create: ${reference.dateCreate}, Author ID : ${reference.authorId}</li>
        <li> <a href="referenceStatistic?refShortAdr=${reference.shortAddress}&authorId=${reference.authorId}">Statistics</a></li>
        <li> <a href="referenceRedirect?shortAddress=${reference.shortAddress}">Redirect</a></li>
        <form action="reference" method="post">
            <button type="submit" name="delete" value="${reference.shortAddress}">Delete</button>
        </form>
    </c:forEach>
</ul>

</body>
</html>