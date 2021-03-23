<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.math.BigInteger" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>web app test</title>
</head>
<body>

<%@ include file="../header.jsp"%>

<form action="authorAdd" method="post">
    <label>Author name:</label>
    <input name="authorName" type="text" required/>
    <br>
    <input type="submit" name="Send"/>
</form>


<ul>
    <c:forEach var="author" items="${authorList}">
        <li>Author <a href="reference?id=${author.id}">${author.name} </a> , id: ${author.id}, reference count: ${author.refCount}</li>
    </c:forEach>
</ul>