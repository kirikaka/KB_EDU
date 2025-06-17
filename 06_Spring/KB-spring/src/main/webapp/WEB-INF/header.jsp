<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-11
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation</title>
</head>
<body>
<h3>V1</h3>
<a href="/">HOME</a>
<a href="/member/list">Member List</a>
<a href="/member/add">Member Add</a>

<h3>V2</h3>
<a href="/">HOME</a>
<a href="/member/v2/list">Member List</a>
<a href="/member/v2/list2">Two Members</a>
<a href="/member/v2/add">Member Add</a>

<h3>게시판 V1</h3>
<a href="/">HOME</a>
<a href="/post/v1/list">게시판</a>
<a href="/post/v1/compare">DB(MySQL,Redis) 조회 속도 비교</a>

<h3>게시판 V2</h3>
<a href="/">HOME</a>
<a href="/post/v2/list">REST API</a>

</body>
</html>
