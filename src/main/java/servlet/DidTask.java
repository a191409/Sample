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
@WebServlet("/DidTask")

public class DidTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        int id = Integer.parseInt(request.getParameter("did"));
        Task task = new Task(id);
        String error = null;
        // taskManagerオブジェクトの生成
        TaskControl control = new TaskControl();
        error = control.didTask(task);
        if(error != null){
            request.setAttribute("Error", error);
        }
        // リダイレクト
        response.sendRedirect("./TOP");
    }
}