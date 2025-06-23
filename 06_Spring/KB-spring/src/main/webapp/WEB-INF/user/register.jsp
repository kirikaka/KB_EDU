<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-23
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>SECURITY 가입</h1>
<form action="/user/register" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    아이디: <input type="text" name="username"><br>
    비밀번호: <input type="password" name="password"><br>
    <input type="submit" value="회원 가입"/>
</form>
</body>
</html>