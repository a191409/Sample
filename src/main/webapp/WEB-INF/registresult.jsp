<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import ="beans.Match" %>
<% ArrayList<Match> list = (ArrayList<Match>) request.getAttribute("Matchlist");%>
<% int i = 0; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script type="text/javascript" src="./bootstrap-datepicker-1/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="./bootstrap-datepicker-1/locales/bootstrap-datepicker.ja.min.js"></script>
  </head>
  <body>
    <h2>対戦結果新規登録画面</h2>
    <form action="./registResult" method="post">
      <div class="form-group">
        <div>
          <label>大会名：</label>
          <select name="match" class="form-select"><!-- プルダウンの確認 -->
            <option selected>Open this select menu</option><!-- coreタグ-->
            <% for(i=0;i < list.size() - 1;i++) { %>
            <option value="<% list.get(i).getId(); %>"><% out.print(list.get(i).getMatchName());%></option><% }%>
          </select>
        </div>
        <div class = "date">
          <label>日付：</label>
          <!-- ここにカレンダー表示用のテキストボックスを追加 -->
          <input type="date"id="date_sample" name = "date">
        </div>
        <div class = "round">
          <label>大会の段階:</label>
          <input type = "int" name = "round">
        </div>
        <div class = "opponent">
          <label>対戦相手名:</label>
          <input type = "text" name = "opponent">
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
    </form>
    <h3>大会名新規登録は<a href = "/registMatch">こちら</a>から</h3>
    <br>
    <!-- Optional JavaScript -->
    <script>
      $('#date_sample').datepicker();
    </script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

  </body>
</html>
