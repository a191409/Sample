package servlet;
//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.*;
import control.*;
@WebServlet("/Login")

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String error = null;
        // コンソールに確認するために出力
        System.out.println("取得したemailは" + email + "です！");
        System.out.println("取得したpassは" + pass + "です！");

        // Userオブジェクトに情報を格納
        User user = new User(id, email, pass);

        // controlオブジェクトの生成
        UserControl control = new UserControl();

        // ログインID・パスワードが合致するか検索する
        user = control.login(user);
        if(user != null){
            // 成功画面を表示する
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // 情報表示画面を表示する
            TaskControl manager = new TaskControl();
            ArrayList<Task> tasks = manager.search(user);
            session.setAttribute("task", tasks);
            // リダイレクト
            response.sendRedirect("./TOP");
        }
        else{
            error = "アカウントが作成されていないか、アカウントが一致しません。";
            request.setAttribute("Error", error);
            //forward
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}