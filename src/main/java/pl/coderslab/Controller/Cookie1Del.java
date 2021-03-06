package pl.coderslab.Controller;

import pl.coderslab.Service.CookieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Cookie1Del", urlPatterns = "/deleteCookie")
public class Cookie1Del extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        Cookie cookie = CookieService.getCookie(request, "User");
        if(cookie != null)
        {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("/showCookie");
        }
        else
        {
            wr.append("Nie ma ciasteczka do usuniecia");

        }


    }
}
