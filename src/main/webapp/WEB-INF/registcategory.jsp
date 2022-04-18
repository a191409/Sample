<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/04/02
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>カテゴリー新規作成</title>
    <%@ include file="common/common.jsp"%>
</head>
<body>
<div class = "header">
    <header>
        <h2>カテゴリー新規作成</h2>
        <%@ include file="common/header.jsp"%>
    </header>
</div>
<div class="main">
    <span class="label label-danger">${Error}</span>
    <form action="/RegistCategory" method="post">
        <div class="form-group">
            <label for="title">カテゴリー名</label>
            <br>
            <input type="text" class="form-control" name="category" id="title">
            <br>
        </div>
        <button type="submit">送信</button>
    </form>
</div>
</body>
</html>
