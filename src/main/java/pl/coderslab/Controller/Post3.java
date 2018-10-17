package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post3", urlPatterns = "/Post3")
public class Post3 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();
        try
        {
            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));
            int c = Integer.parseInt(request.getParameter("c"));
            double x1, x2, delta;


            double b2 = Math.pow((double)b, (double)2);
            delta = b2 - (4 * a * c);
            if(delta > 0.0)
            {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);

                wr.append("Pierwiastki tego dwumianu to: {" + x1 + ", " + x2 + "}");
            }
            else
            {
                wr.append("Ten dwumian nie ma rozwiązania dla podanych a, b, c.");
            }
        }
        catch(NumberFormatException e)
        {
            wr.append("Nieprawidłowe wartości liczbowe");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().append("<a href='/index_3.html'>Formularz</a>");

    }
}
