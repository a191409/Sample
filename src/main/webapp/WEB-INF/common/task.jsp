<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2022/04/14
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<c:set var = "category" value = "null"/>
<c:forEach items = "${task}" var = "item">
    <c:if test="${category != item.category_name}">
        <h3>${item.category_name}</h3>
        <c:set var = "category" value="${item.category_name}"/>
    </c:if>
    <div class = "task">
        <input type="radio" name = "did" value="${item.id}">
        <label for="${item.id}">${item.name}</label>
        <c:if test="${not empty item.limit}"><p>期限：${item.limit}</p></c:if>
        <c:if test="${empty item.limit}"><p>期限：--------</p></c:if>
        <c:if test="${not empty item.description}"><p>詳細：${item.description}</p></c:if>
        <c:if test="${empty item.description}"><p>詳細：--------</p></c:if>
        <c:if test="${user.id == item.user_id}"><p><a href="/UpdateTask?taskid=${item.id}">変更</a></p></c:if>
    </div>
    <br>
</c:forEach>