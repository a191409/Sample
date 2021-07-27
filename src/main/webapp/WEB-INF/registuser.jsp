<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  </head>
  <body>
    <h2>新規登録画面</h2>
    <span class="label label-danger">${Error}</span>
    <form action="./registUser" method="post">
      <div class="form-group">
          <label for="title">ログインID</label>
          <input type="text" class="form-control" name="name" id="title">
            <label for="title">パスワード</label>
            <input type="text" class="form-control" name="pass" id="title">
      </div>
      <button type="submit">OK</button>
    </form>
    <br>
  </body>
</html>
