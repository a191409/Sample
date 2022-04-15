<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/04/14
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="common/common.jsp"%>
    <title>タスク更新</title>
</head>
<body>
<div class = "header">
    <header>
        <h2>タスク更新</h2>
        <%@ include file="common/header.jsp"%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="./UpdateTask" method="post">
        <%@ include file="common/form.jsp"%>
        <button type="submit">送信</button>
    </form>
</div>
</body>
</html>
