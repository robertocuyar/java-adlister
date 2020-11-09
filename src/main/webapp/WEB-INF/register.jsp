<%--
  Created by IntelliJ IDEA.
  User: robertocuyar
  Date: 11/9/20
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Register" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Register an Account for AdLister</h1>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="username">Please Enter A Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Please Enter An Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Please Enter A Password</label>
            <input id="password" name="password" class="form-control" type="password">
            <br>
            <input type="submit" class="btn btn-primary btn-block" value="Register">
        </div>
    </form>
</div>
</body>
</html>
