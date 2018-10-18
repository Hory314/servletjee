package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Sess01Get", urlPatterns = "/Sess01Get")
public class Sess01Get extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Integer counter = (Integer)session.getAttribute("counter");

        if(counter == null)
        {
            response.getWriter().append("NO couter in session");
        }
        else
        {
            counter++;
            session.setAttribute("counter", counter);
            response.getWriter().append(counter + "");
        }
    }
}
