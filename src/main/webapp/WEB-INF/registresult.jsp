<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="common/head.jsp"%>
</head>
<body>
  <h2>対戦結果新規登録画面</h2>
    <span class="label label-danger">${Error}</span>
    <form action="./registResult" method="post">
     <%@ include file="common/Result.jsp"%>
    </form>
  <h3>大会名新規登録は<a href = "/registMatch">こちら</a>から</h3>
</body>
</html>