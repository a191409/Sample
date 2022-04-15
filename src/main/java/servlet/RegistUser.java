package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import beans.*;
import control.*;

@WebServlet("/RegistUser")

public class RegistUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registuser.jsp");
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
        System.out.println("取得した文字列は" + email + "です！");
        System.out.println("取得した文字列は" + pass + "です！");

        // userオブジェクトに情報を格納
        User user = new User(id, email, pass);

        // userManagerオブジェクトの生成
        UserControl manager = new UserControl();
        user = manager.registUser(user);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //カテゴリー初期値作成
            Category initial = new Category(0,"その他", user.getId());
            CategoryControl categoryControl = new CategoryControl();
            initial = categoryControl.initialCategory(initial);
            // リダイレクト
            response.sendRedirect("./TOP");
        }else{
            error = "同名アカウントが登録されています";
            request.setAttribute("Error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registuser.jsp");
            dispatcher.forward(request, response);
        }
    }
}