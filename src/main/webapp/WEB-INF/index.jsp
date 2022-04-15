<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/03/26
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="common/common.jsp"%>
    <title>ログインページ</title>
</head>
<body>
<h2>ログイン画面</h2>
<span class="label label-danger">${Error}</span>
<form action="./Login" method="post">
    <div class="form-group">
        <label for="title">アカウントID</label>
        <input type="text" class="form-control" name="email" id="title">
        <br>
        <label for="title">パスワード</label>
        <input type="text" class="form-control" name="pass" >
    </div>
    <button type="submit">送信</button>
</form>
<br>
<h2>新規登録は<a href="/RegistUser">こちら</a>から。</h2>
</body>
</html>

