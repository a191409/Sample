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
@WebServlet("/RegistCategory")

public class RegistCategory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registcategory.jsp");
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
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String name = request.getParameter("category");
        int user_id = user.getId();
        String error = null;

        // Categoryオブジェクトに情報を格納
        Category category = new Category(id, name,user_id);
        // controlオブジェクトの生成
        CategoryControl control = new CategoryControl();
        error = control.registCategory(category);
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