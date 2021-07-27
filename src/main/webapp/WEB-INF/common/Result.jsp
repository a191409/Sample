<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: kimurahana
  Date: 2021/07/23
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<div class="form-group">
    <div>
      <label>大会名：</label>
      <select name="match" class="form-select"><!-- プルダウンの確認 -->
        <option selected>Open this select menu</option><!-- coreタグ-->
        <c:forEach var="matchlist" items="${matchlist}">
          <option value="${matchlist.id}"><c:out value="${matchlist.name}"/></option>
        </c:forEach>
      </select>
    </div>
    <div class = "date">
      <label>日付：</label>
      <!-- ここにカレンダー表示用のテキストボックスを追加 -->
      <input type="date" id="date_sample" name = "date">
    </div>
    <div class = "round">
      <label>大会の段階:</label>
      <input type = "int" name = "round">
    </div>
    <div class = "opponent" class="form-select">
      <label>対戦相手名:</label>
        <select name="opponent" class="form-select"><!-- プルダウンの確認 -->
            <option selected>Open this select menu</option><!-- coreタグ-->
            <c:forEach var="userlist" items="${userlist}">
                <option value="${userlist.id}"><c:out value="${userlist.name}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class = "score">
      <label>自分の得点：</label>
      <input type = "int" name = "score_1">
    </div>
    <div class = "score">
      <label>相手の得点：</label>
      <input type = "int" name = "score_2">
    </div>
  </div>
<button type="submit">OK</button>
