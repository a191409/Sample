<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <%@ include file="common/head.jsp"%>
  </head>
  <body>
    <h2>大会名新規登録画面</h2>
    <span class="label label-danger">${Error}</span>
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
