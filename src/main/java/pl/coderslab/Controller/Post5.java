package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post5", urlPatterns = "/Post5")
public class Post5 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        try
        {
            String degreesStr = request.getParameter("degrees");
            double degree = Double.parseDouble(degreesStr);
            double result;

            String convertionType = request.getParameter("convertionType"); // moge tak bo tylko jeden submit moze byc klikniety

            if(convertionType.equals("celcToFahr")) // celc na far
            {
                result = celcToFahr(degree);
                wr.append(degree + " C = " + result + " F");
            }
            else if(convertionType.equals("FahrToCelc"))
            {
                result = fahrToCelc(degree);
                wr.append(degree + " F = " + result + " C");

            }
            else
            {
                wr.append("Nie można konwertować");
            }
        }
        catch(NumberFormatException e)
        {
            wr.append("Niepoprawna temperatura");
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().append("<a href='/index_5.html'>Formularz</a>");
    }

    private double fahrToCelc(double degree)
    {
        return ((5.0 * (degree - 32.0)) / (9.0));
    }

    private double celcToFahr(double degree)
    {
        return (32 + ((9 * degree) / (5)));
    }
}
