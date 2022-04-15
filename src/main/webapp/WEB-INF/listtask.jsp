<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/04/14
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="common/common.jsp"%>
    <title>他の人のToDoリスト閲覧</title>
</head>
<body>
<div class = "header">
    <header>
        <h2>他の人のToDoリスト閲覧</h2>
        <%@ include file="common/header.jsp"%>
    </header>
</div>
<div class="main">
    <h3>登録しているユーザー一覧</h3>
    <form>
        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="list" varStatus="status">
                <p><a href="/LookTask?userid=${list.id}&useremail=${list.email}">${list.email}</a></p>
            </c:forEach>
        </c:if>
    </form>
</div>
</body>
</html>