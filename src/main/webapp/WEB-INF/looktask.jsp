<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/03/31
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="common/common.jsp"%>
    <title>他の人のToDoリスト閲覧</title>
</head>
<body>
<div class = "header">
    <header>
        <h2>${look_user.email}</h2>
        <%@ include file="common/header.jsp"%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <c:if test="${not empty task}">
        <%@ include file="common/task.jsp"%>
    </c:if>
</div>
</body>
</html>

