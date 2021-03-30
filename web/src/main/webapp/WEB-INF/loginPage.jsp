<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 25.03.2021
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="sidenav" align="center">
    <div class="login-main-text">
        <h2>Application<br> Login Page</h2>
        <p>Login or register from here to access.</p>
    </div>
</div>
<div class="main" align="center" >
    <div class="col-md-6 col-sm-6" align="center">
        <div class="login-form" align="center">
            <form action="login" method="post">
                <div class="form-group">
                    <label>User Name</label>
                    <input type="text" class="form-control" placeholder="User Name" name="login" required maxlength="10">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="Password" name="password" required minlength="3">
                </div>
                <button type="submit" class="btn btn-black">Login</button>
            </form>
        </div>
    </div>
</div>