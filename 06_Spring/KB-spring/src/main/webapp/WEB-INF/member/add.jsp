<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-11
  Time: 오후 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/header.jsp"%>

<html>
<head>
    <title>Add Member</title>
</head>
<body>
    <h1>Member Addition Page</h1>
    <form action="/member/add" method="post">
        NAME : <input type="text" id="name" name="name" required> <br>
        EMAIL : <input type="text" id="email" name="email" required><br>
        <br>
        <button type="submit">Member Addition</button>

    </form>
</body>
</html>
