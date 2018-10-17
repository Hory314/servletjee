package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3", urlPatterns = "/Cookie3")
public class Cookie3 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String cookieName = request.getParameter("key").trim();
            String cookieValue = request.getParameter("value");
            int cookieLifeTime = Integer.parseInt(request.getParameter("lifetime"));


            if(cookieName.length() > 0)
            {

                Cookie cookie = new Cookie(cookieName, cookieValue);
                cookie.setMaxAge(cookieLifeTime*60*60); // h
                response.addCookie(cookie);
                response.sendRedirect("/index3.html");
            }
        }
        catch(IllegalArgumentException e)
        {
            response.getWriter().append("Niedozwolone znaki w wartosci lub czasie życia ciasteczka!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.sendRedirect("/index3.html");

    }
}
