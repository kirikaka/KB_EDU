<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-18
  Time: 오후 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/header.jsp"%>

<html>
<head>
    <title>500</title>
</head>
<body>
<h1>Sorry, Unexpected Error came out</h1>
<h4><c:out value="${errorMessage}"></c:out> </h4>
<ul>
    <c:forEach items="${stackTrace}" var="stack">
        <li><c:out value="${stack}"></c:out> </li>
    </c:forEach>
</ul>

</body>
</html>
