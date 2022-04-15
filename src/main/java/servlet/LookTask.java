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
@WebServlet("/LookTask")
public class LookTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setCharacterEncoding("UTF8");
        response.setContentType("text/html; charset=UTF8");
        if (user != null) {
            CategoryControl manager = new CategoryControl();
            ArrayList<Category> categories = manager.search(user);
            session.setAttribute("category", categories);
            int id = Integer.parseInt(request.getParameter("userid"));
            String email = request.getParameter("useremail");
            User look_user = new User(id,email,null);
            session.setAttribute("look_user", look_user);
            TaskControl task_manager = new TaskControl();
            ArrayList<Task> tasks = task_manager.search(look_user);
            session.setAttribute("task", tasks);
            // requestオブジェクトの文字エンコーディングの設定
            request.setCharacterEncoding("UTF-8");
            // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/looktask.jsp");
            dispatcher.forward(request, response);
        } else {
            String error = "ログインできていません";
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
