
import bean.Hero;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HeroListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");



        int start = 0,count = 5;
        int total = new HeroDAO().getTotal();
        try {
            start = Integer.parseInt(request.getParameter("start"));
        }catch (NumberFormatException e){
            // 当浏览器没有传参数start时
        }
        int next = start + count;
        int pre = start - count;
        int last;
        if (total % count == 0)
            last = total - count + 1;
        else
            last = total - total % count;
        List<Hero> heros = new HeroDAO().list(start,count);
        request.setAttribute("heros",heros);
        request.setAttribute("next",next);
        request.setAttribute("pre",pre);
        request.setAttribute("last",last);
        request.getRequestDispatcher("listHero.jsp").forward(request,response);
    }
}