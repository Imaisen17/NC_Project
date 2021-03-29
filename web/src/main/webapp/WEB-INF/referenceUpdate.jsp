<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.math.BigInteger" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>web app test</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>


<%@ include file="../header.jsp"%>
<body>
<li> Short address: ${reference.shortAddress}:: Full address: ${reference.fullAddress} :: Date create: ${reference.dateCreate} :: Author id: ${reference.authorId}</li>
<form action="referenceUpdate" method="post">
    <label>Short address:</label>
    <input value="${reference.shortAddress}" name="shortAddress" type="text" readonly/>
    <br>
    <label>Full address:</label>
    <input name="fullAddress" type="text" required maxlength="2048"/>
    <br>
    <label>Author id:</label>
    <input value="${reference.authorId}" name="authorId" type="text"  readonly />
    <br>
    <button type="submit">Update</button>
</form>
</body>