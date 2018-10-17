package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie51", urlPatterns = "/Cookie51")
public class Cookie51 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        Cookie cookie = new Cookie("visited", "true");
        cookie.setMaxAge(1 * 60 * 60);
        response.addCookie(cookie);

        String msg = request.getParameter("msg");
        if(msg!=null)
        {
            wr.append(msg+" ");
        }
        wr.append("<a href='/Cookie52'>Teraz możesz wejść!</a>");
    }
}
