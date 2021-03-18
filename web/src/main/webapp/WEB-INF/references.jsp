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
</head>
<body>

<%@ include file="../header.jsp"%>

<ul>
    <c:forEach var="reference" items="${referenceList}">
        <li>Reference ${reference.fullAddress}, short address: ${reference.shortAddress}, date create: ${reference.dateCreate}</li>
    </c:forEach>
</ul>

</body>
</html>