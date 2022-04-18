<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/04/14
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-group">
    <label for="title">タスク名</label>
    <br>
    <input type="text" class="form-control" name="task" id="title">
    <br>
    <label for="title">タスク詳細</label><%--テキストボックス--%>
    <br>
    <textarea name = "description" rows = "5" cols = "20"></textarea>
    <br>
    <div class = "date">
        <label>日付</label>
        <br>
        <input type="date" id="date_sample" name = "date">
    </div>
    <br>
    <label for="title">カテゴリー</label><%--プルダウン--%>
    <br>
    <select name="category_id">
        <c:forEach var="category" items="${category}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
</div>