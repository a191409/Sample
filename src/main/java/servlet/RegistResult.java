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
import java.util.ArrayList;

import beans.*;
import control.*;

//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/registResult")

public class RegistResult extends HttpServlet {
  private static final long serialVersionUID = 1L;

    // doPostメソッドから呼び出される(リダイレクトされる)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Match> list = new ArrayList<Match>();
        // MatchManagerオブジェクトの生成
        MatchManager manager = new MatchManager();
        //大会名をlistに返す
        list = manager.searchMatchlist();
        System.out.println("取得したIDは"+ list.get(0).getMatchName() + "です");
        request.setAttribute("Matchlist", list);
        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registresult.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String opponent_name = request.getParameter("opponent");
        Date date = Date.valueOf(request.getParameter("date"));
        int match_id = Integer.valueOf(request.getParameter("match"));
        int round = Integer.valueOf(request.getParameter("round"));
        int score_value_1 = Integer.valueOf(request.getParameter("score_1"));
        int score_value_2 = Integer.valueOf(request.getParameter("score_2"));
        //セッションの値を取得する方法は？下のコードだとエラーが出る
        //User user = (User) session.getAttribute("user");

        // コンソールに確認するために出力
        System.out.println("取得したscore_1は" + score_value_1 + "です");
        System.out.println("取得した日付は" + date + "です");
        //相手のuser_idを検索
        UserManager usermanager = new UserManager();
        User opponent = new User(0,opponent_name,null);
        User return_opponent = usermanager.searchUser(opponent);
        if(return_opponent != null) {

            ScoreManager scoremanager = new ScoreManager();
            Score score_1 = new Score(0, score_value_1, 0);//自分のスコア。user_idの取り出し方不明
            Score score_2 = new Score(0, score_value_2, return_opponent.getId());
            score_1 = scoremanager.registScore(score_1);
            score_2 = scoremanager.registScore(score_2);
        }
    }
}
