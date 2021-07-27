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
import javax.servlet.http.HttpSession;
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
        System.out.println("取得したIDは"+ list.get(0).getName() + "です");
        request.setAttribute("matchlist", list);
        //userlistを作成
        ArrayList<User> user_list = new ArrayList<User>();
        UserManager user_manager = new UserManager();
        user_list = user_manager.searchUserlist();
        System.out.println("取得したIDは"+ user_list.get(0).getName() + "です");
        request.setAttribute("userlist",user_list);
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
        int opponent_id = Integer.valueOf(request.getParameter("opponent"));
        Date date = Date.valueOf(request.getParameter("date"));
        int match_id = Integer.valueOf(request.getParameter("match"));
        int round = Integer.valueOf(request.getParameter("round"));
        int score_value_1 = Integer.valueOf(request.getParameter("score_1"));
        int score_value_2 = Integer.valueOf(request.getParameter("score_2"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        // コンソールに確認するために出力
        System.out.println("取得したscore_1は" + score_value_1 + "です");
        System.out.println("取得した日付は" + date + "です");

        if(opponent_id != user.getId()) {
            Result result = new Result(id, round, date, score_value_1, score_value_2, null, null, user.getId(), opponent_id, match_id);
            ResultManager result_manager = new ResultManager();
            ArrayList<Result> check_list = new ArrayList<Result>();
            check_list = result_manager.searchResult(result);
            result_manager.registResult(result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/TOP.jsp");
            dispatcher.forward(request, response);
        }
        else{
            String error = "相手は自分以外のユーザーを選択してください。";
            request.setAttribute("Error", error);
            ArrayList<Match> list = new ArrayList<Match>();
            // MatchManagerオブジェクトの生成
            MatchManager manager = new MatchManager();
            //大会名をlistに返す
            list = manager.searchMatchlist();
            System.out.println("取得したIDは"+ list.get(0).getName() + "です");
            request.setAttribute("matchlist", list);
            //userlistを作成
            ArrayList<User> user_list = new ArrayList<User>();
            UserManager user_manager = new UserManager();
            user_list = user_manager.searchUserlist();
            System.out.println("取得したIDは"+ user_list.get(0).getName() + "です");
            request.setAttribute("userlist",user_list);
            // requestオブジェクトの文字エンコーディングの設定
            request.setCharacterEncoding("UTF-8");
            // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registresult.jsp");
            dispatcher.forward(request, response);
        }

    }
}
