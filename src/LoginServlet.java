import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");

        if (userName.equals("admin") && password.equals("123")){
            req.getSession().setAttribute("userName",userName);
            resp.sendRedirect("CRUD Test.html");
        }
        else {

            resp.sendRedirect("login.html");
        }
    }
}
