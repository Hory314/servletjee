package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get4", urlPatterns = {"/Get4"})
public class Get4 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try
        {
            int value = Integer.parseInt(request.getParameter("page"));


            wr.append("Dzielniki całkowite liczby " + value + " to:");

            wr.append("<ul>");
            for(int i = -Math.abs(value); i <= Math.abs(value); i++)
            {
                try
                {
                    if(value % i == 0)
                    {
                        wr.append("<li>" + i + "</li>");
                        // wr.append("<li>" + -i + "</li>");
                    }
                }
                catch(ArithmeticException e)
                {
                    continue;
                }
            }
            wr.append("</ul>");


        }
        catch(NumberFormatException e)
        {
            wr.append("Liczba całkowita nie została przesłana");
        }
        // http://localhost:8080/Get4?page=-1001 // lub localhost:8080 i wypelnic
    }
}
