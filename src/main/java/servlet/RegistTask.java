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
@WebServlet("/RegistTask")

public class RegistTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            CategoryControl manager = new CategoryControl();
            ArrayList<Category> categories = manager.search(user);
            session.setAttribute("category", categories);
            // requestオブジェクトの文字エンコーディングの設定
            request.setCharacterEncoding("UTF-8");
            // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registtask.jsp");
            dispatcher.forward(request, response);
        }else{
            String error = "ログインできていません";
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String name = request.getParameter("task");
        String description = request.getParameter("description");
        Date date = Date.valueOf(request.getParameter("date"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String error = null;

        // taskオブジェクトに情報を格納
        Task task = new Task(id, name,description, date,0,category_id);
        // controlオブジェクトの生成
        TaskControl control = new TaskControl();
        error = control.registTask(task);
        if(error == null){
            // リダイレクト
            response.sendRedirect("./TOP");
        }else{
            request.setAttribute("Error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registtask.jsp");
            dispatcher.forward(request, response);
        }
    }
}