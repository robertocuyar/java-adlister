<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robertocuyar
  Date: 11/3/20
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<%String username = "Sera";%>--%>
<%--    <%String password = "password";%>--%>

<form method="post" action="/login.jsp">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username">
    <br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password">
    <br>
    <button type="submit">Submit</button>
</form>

<h1>The username is <%=request.getParameter("username")%> and the password is <%=request.getParameter("password")%></h1>
<c:if test = '${param.username.equalsIgnoreCase("Admin") && param.password.equalsIgnoreCase("password") }'>
    <c:redirect url="/profile.jsp" />
</c:if>

</body>
</html>
