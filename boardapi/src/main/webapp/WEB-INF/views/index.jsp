<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-09
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="./layouts/header.jsp" %>
<sec:authorize access="isAnonymous()"> <!-- 로그인 안한 경우 -->
    <a href="/security/login">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()"> <!-- 로그인 한 경우 -->
    <sec:authentication property="principal.username"/>
    <form action="/security/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="로그아웃"/>
    </form>
</sec:authorize>
<%@ include file="./layouts/footer.jsp" %>