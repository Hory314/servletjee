package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc12",urlPatterns = "/Mvc12")
public class Mvc12 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int start = Integer.parseInt(request.getParameter("start"));
            int end = Integer.parseInt(request.getParameter("end"));

            start += 10;
            end += 10;

            request.setAttribute("start", start);
            request.setAttribute("end", end);

            getServletContext().getRequestDispatcher("/mvc12.jsp").forward(request, response);
        }
        catch(NumberFormatException e)
        {
            response.getWriter().append("No params");
        }
    }
}
