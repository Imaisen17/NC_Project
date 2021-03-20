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

<form action="/referenceAdd" method="post">
    <label>Full address:</label>
    <input name="fullAddress" type="text" minlength="1" maxlength="2048" required/>
    <br>
    <label>Author id:</label>
    <input name="authorId" type="text" required m />
    <br>
    <input type="submit" name="Send"/>
</form>