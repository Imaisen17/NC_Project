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

<form action="referenceAdd" method="post">
    <label>Full address:</label>
    <input name="fullAddress" type="text" minlength="1" maxlength="2048" required/>
    <br>
    <label>Author id:</label>
    <input name="authorId" type="text" required m />
    <br>
    <label>Link lifeTime</label>
    <input type="range" list="tickmarks" >
    <datalist id="tickmarks">
        <option value="10">
        <option value="20">
        <option value="30">
        <option value="40">
        <option value="50">
        <option value="60">
        <option value="70">
        <option value="80">
        <option value="90">
        <option value="100">
        <option value="110">
        <option value="120">
    </datalist>
    <br>
    <input type="submit" name="Send" />
</form>