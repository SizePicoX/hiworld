import bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hero hero = new Hero();
        hero.id = Integer.parseInt(req.getParameter("id"));
        hero.name = req.getParameter("name");
        hero.hp = Float.parseFloat(req.getParameter("hp"));
        hero.damage = Integer.parseInt(req.getParameter("damage"));
        new HeroDAO().update(hero);
        resp.sendRedirect("/listHero");
    }
}
