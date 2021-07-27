//　自分が格納されているフォルダ名
package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;

import control.*;
import beans.*;

//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/registMatch")

public class RegistMatch extends HttpServlet {
  private static final long serialVersionUID = 1L;

    // doPostメソッドから呼び出される(リダイレクトされる)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registmatch.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String name = request.getParameter("name");
        Match match = new Match(id,name,null,null);
        // MatchManagerオブジェクトの生成
        MatchManager manager = new MatchManager();

        // アカウント新規作成
        Match return_match = new Match();
        return_match = manager.searchMatch(match);
        if(return_match == null){
          manager.registMatch(match);
          // 成功画面を表示する
          // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
          RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/TOP.jsp");
          dispatcher.forward(request, response);
        }else{
            String error = "大会名がすでに登録されています。";
            request.setAttribute("Error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registmatch.jsp");
            dispatcher.forward(request, response);
        }
    }
}
