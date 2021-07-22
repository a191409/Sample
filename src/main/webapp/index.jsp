<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String error = (String)request.getAttribute("Error");%>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  </head>
  <body>
    <h2>ログイン画面</h2>
    <span class="label label-danger">${Error}</span>
    <form action="./login" method="post">
      <div class="form-group">
          <label for="title">ログインID</label>
          <input type="text" class="form-control" name="name" id="title">
            <label for="title">パスワード</label>
            <input type="text" class="form-control" name="pass" id="title">
      </div>
      <button type="submit">OK</button>
    </form>
    <br>
    <h2>新規登録は<a href="/registUser">こちら</a>から。</h2>
  </body>
</html>
