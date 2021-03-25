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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>web app test</title>
</head>
<body>

<%@ include file="../header.jsp"%>

<ul>
    <c:forEach var="author" items="${authorList}">
        <li>Author <a href="reference?id=${author.id}">${author.name} </a> , id: ${author.id}
        <li> <a href="statistics?id=${author.id}">Statistics</a></li>
        <form action="author" method="post">
            <button type="submit" name="delete" value="${author.id}">Delete</button>
        </form>
        </li>
    </c:forEach>
</ul>
<br>


</body>
</html>