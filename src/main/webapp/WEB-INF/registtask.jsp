<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/03/31
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>タスク新規作成</title>
    <%@ include file="common/common.jsp"%>
</head>
<body>
<div class = "header">
    <header>
        <h2>タスク新規作成</h2>
        <%@ include file="common/header.jsp"%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="./RegistTask" method="post">
        <%@ include file="common/form.jsp"%>
        <button type="submit">送信</button>
    </form>
</div>
</body>
</html>
