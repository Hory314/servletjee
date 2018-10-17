package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2", urlPatterns = "/addToCookie")
public class Cookie2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String cookieName = request.getParameter("key").trim();
        String cookieValue = request.getParameter("value");

        if(cookieName.length() > 0)
        {
            try
            {
                Cookie cookie = new Cookie(cookieName, cookieValue);
                response.addCookie(cookie);
                response.sendRedirect("/index2.html");
            }
            catch(IllegalArgumentException e)
            {
                response.getWriter().append("Niedozwolone znaki w wartosci ciasteczka!");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("/index2.html");

    }
}
