package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Sess03_All", urlPatterns = "/showAllSession")
public class Sess03_All extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        HttpSession session = request.getSession();
        Enumeration<String> keysNames = session.getAttributeNames();
        while(keysNames.hasMoreElements())
        {
            String key = keysNames.nextElement();
            String value = (String)session.getAttribute(key);

            wr.append(key + " : " + value + "<br>");
        }
        wr.append("<a href='/addToSession'>dodaj nowe klucz/wartosc do sesji</a>");
    }
}
