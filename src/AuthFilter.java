import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String uri = request.getRequestURI();
        //当访问登录页面时直接放行
        if (uri.endsWith("login.html") || uri.endsWith("login")){
            System.out.println("访问login.html");
            filterChain.doFilter(request,response);
            return;
        }
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName == null){
            response.sendRedirect("login.html");
        }else {
            filterChain.doFilter(request,response);
        }
    }
}
