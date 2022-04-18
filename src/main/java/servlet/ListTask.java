package servlet;
//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;
import java.sql.Date;
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
@WebServlet("/ListTask")

public class ListTask extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            UserControl manager = new UserControl();
            ArrayList<User> list = manager.list();
            // 情報表示画面を表示する
            session.setAttribute("list", list);
            // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listtask.jsp");
            dispatcher.forward(request, response);
        }else{
            String error = "ログインできていません";
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}