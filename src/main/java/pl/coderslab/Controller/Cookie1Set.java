package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Set", urlPatterns = "/setCookie")
public class Cookie1Set extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie cookie = new Cookie("User", "CodersLab");
        cookie.setMaxAge(24*60*60);

        response.addCookie(cookie);

        response.getWriter().append("<a href='/showCookie'>pokaz ciastko</a>");
        response.getWriter().append("<a href='/deleteCookie'>usun ciastko</a>");

    }
}
