<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-12
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member List Page</title>
</head>
<body>
<h1>Member List</h1>
<ul>
    <c:forEach var="member" items="${memberList}">
        <li>${member.name} / ${member.email}</li>
    </c:forEach>
</ul>
</body>
</html>