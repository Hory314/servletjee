package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = {"/Get62"})
public class Get62 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();
        try
        {
            int year = Integer.parseInt(request.getParameter("year"));
            for(int i = 0; i < 5; i++)
            {
                Random random = new Random();
                int mix = random.nextInt(20 + 1) - 10;
                wr.append("<a href=\"/Get63?year=" + year + "&mix=" + mix + "\">Get63: rok " + year + ", mix " + mix + "</a><br>");
            }

        }
        catch(NumberFormatException e)
        {
            wr.append("Rok nieprawidłowy");
        }
    }
}
