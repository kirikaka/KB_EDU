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
<a href="/post/v1/error">Error</a>

<h3>V2</h3>
<a href="/">HOME</a>
<a href="/member/v2/list">Member List</a>
<a href="/member/v2/list2">Two Members</a>
<a href="/member/v2/add">Member Add</a>

<h3>게시판 V1</h3>
<a href="/">HOME</a>
<a href="/post/v1/list">게시판</a>

<a href="/post/v1/compare">DB(MySQL,Redis) 조회 속도 비교</a>
<a href="/post/v1/404">404 에러</a>
<a href="/post/v1/error">500 에러</a>

<h3>게시판 V2</h3>
<a href="/">HOME</a>
<a href="/post/v2/list">REST API</a>


<h3>Security V1</h3>
<a href="/">HOME</a>
<a href="/user/register">회원가입</a>
<a href="/user/login">로그인</a>
<a href="/admin">admin</a>
<a href="/member">member</a>

<a href="#" onclick="document.getElementById('logout-form').submit();">로그아웃</a>
<form id="logout-form" action="/user/logout" method="post" style="display: none;">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
