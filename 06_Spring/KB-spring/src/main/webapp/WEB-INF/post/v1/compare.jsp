<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-16
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/header.jsp" %>
<html>
<head>
    <title>DB Compare</title>
</head>
<body>
<h1>DB Comparison</h1>
<h2>데이터 ${count}건 조회</h2>
<h3>MySQL 속도 : ${mysqlTime} ms</h3>
<h3>Redis 속도 : ${redisTime} ms</h3>
</body>
</html>