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
    <h2>大会名新規登録画面</h2>
    <h3>ようこそ!<%= user.getUserName() %>さん</h3>
    <form action="./registMatch" method="post">
      <div class="form-group">
          <label for="title">大会名</label>
          <input type="text" class="form-control" name="name" id="title">
      </div>
      <button type="submit">OK</button>
    </form>
    <br>
  </body>
</html>
