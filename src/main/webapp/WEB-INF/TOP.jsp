<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import= "beans.User" %>
<% User user = (User) session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  </head>
  <body>
    <h2>ログイン完了画面</h2>
    <h3>ようこそ!<%= user.getUserName() %>さん</h3>
    <br>
    <h4><a href = "/registMatch">大会名新規登録</a></h4>
    <h4><a href = "/registResult">対戦結果新規登録</a></h4>
    <h4><a href = "/searchResult">対戦結果検索</a></h4>
    <h4><a href = "/logout">ログアウト</a></h4>
  </body>
</html>
