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

@WebServlet(name = "Cookie4Show", urlPatterns = "/Cookie4Show")
public class Cookie4Show extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();
        for(Cookie cookie : request.getCookies())
        {
            wr.append("<a href='/Cookie4Del?cname=" + cookie.getName() + "'>");
            wr.append(cookie.getName() + " : " + cookie.getValue());
            wr.append("</a><br>");
        }
    }
}
