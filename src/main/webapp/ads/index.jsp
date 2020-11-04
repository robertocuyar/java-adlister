<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robertocuyar
  Date: 11/4/20
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ad List" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<h1>Here are your list of ads:</h1>

<c:forEach var="ad" items="${ads}">
    <div>
        <h2>${ad.title}</h2>
        <br>
        <p>${ad.description}</p>
    </div>

</c:forEach>

</body>
</html>
