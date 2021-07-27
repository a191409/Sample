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

import beans.User;
import control.UserManager;

//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/registUser")
public class RegistUser extends HttpServlet {
  private static final long serialVersionUID = 1L;

    // doPostメソッドから呼び出される(リダイレクトされる)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
        // forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Web-INF/registuser.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        // requestオブジェクトから登録情報の取り出し
        int id = 0;
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String error = null;
        // コンソールに確認するために出力
        System.out.println("取得した文字列は" + name + "です！");
        System.out.println("取得した文字列は" + pass + "です！");

        // userオブジェクトに情報を格納
        User user = new User(id, name, pass,null,null);

        // userManagerオブジェクトの生成
        UserManager manager = new UserManager();
        User search_user = manager.searchUser(user);
        if(search_user == null){
          manager.registUser(user);
          HttpSession session = request.getSession();
          session.setAttribute("user", user);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/TOP.jsp");
          dispatcher.forward(request, response);
        }else{
          error = "アカウントがすでに作成されています。";
          request.setAttribute("Error", error);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registuser.jsp");
          dispatcher.forward(request, response);
        }
    }
}
