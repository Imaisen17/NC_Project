<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 17.03.2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.math.BigInteger" %>
<html>
<head>
    <title>web app test</title>
</head>
<body>

<%@ include file="header.jsp"%>

<%
    out.println("Hello " + request.getParameter("username")+"!");
%>
</body>
</html>