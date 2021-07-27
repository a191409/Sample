package filter;
import beans.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class CheckFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        // ex) "/users/sessions/new"
        String servletPath = httpServletRequest.getServletPath();
        HttpSession session = httpServletRequest.getSession();
        User currentUser = User.getCurrentUser(httpServletRequest);
        // ログイン画面にアクセスしたとき
        if (servletPath.equals("/login")) {
            if (currentUser == null) {
                chain.doFilter(req, resp);
            } else {
                // リダイレクト
                httpServletResponse.sendRedirect("/login");
            }
        }
        else if(servletPath.equals("/registUser")){
            if (currentUser == null) {
                chain.doFilter(req, resp);
            } else {
                // リダイレクト
                httpServletResponse.sendRedirect("/login");
            }
        }
        else{
            if (currentUser == null) {
                // リダイレクト
                httpServletResponse.sendRedirect("/login");
            } else {
                chain.doFilter(req, resp);
            }
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
}