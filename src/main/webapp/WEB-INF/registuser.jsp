<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/03/30
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>アカウント新規作成</title>
    <%@ include file="common/common.jsp"%>
</head>
<body>
<h3>アカウント新規作成画面</h3>
<span class="label label-danger">${Error}</span>
<form action="./RegistUser" method="post">
    <div class="form-group">
        <label for="title">メールアドレス</label>
        <input type="email" class="form-control" name="email" id="title">
        <br>
        <label for="title">パスワード</label>
        <input type="text" class="form-control" name="pass" >
    </div>
    <button type="submit">送信</button>
</form>

</body>
</html>
