package filters;

import entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter extends HttpFilter{
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        
        String url = request.getRequestURI();
        
        HttpSession session = request.getSession();
        
        User user = null;
        
        if (session != null) {
            user = (User) session.getAttribute("users");
        }
        
        if (user == null) {
            if (url.contains("ingSozluk") || url.contains("adminpage")||url.contains("documents")||url.contains("ingilizceturkceceviri")||
                    url.contains("turkceingilizceceviri")||url.contains("ingsozluk")||url.contains("turksozluk")) {
                    
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
            
        } else {
            if (url.contains("adminpage") ) {
                response.sendRedirect(request.getContextPath() + "/");
            } else if (url.contains("logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        }
    }
}
