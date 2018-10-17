package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Post4", urlPatterns = "/Post4")
public class Post4 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String[] valArr = request.getParameterValues("numbers");
        List<Integer> numbersList = new ArrayList<>();

        for(String number : valArr)
        {
            try
            {
                numbersList.add(Integer.parseInt(number));
            }
            catch(NumberFormatException e)
            {
                continue;
            }
        }

        numbersList.sort((a, b) -> a - b);

        for(Integer number : numbersList)
        {
            wr.append(number + " ");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        wr.append("<form action='' method='post'>");
        Random generator = new Random();
        for(int i = 0; i < (generator.nextInt(6) + 5); i++)
        {
            wr.append("<input name='numbers' placeholder='podaj liczbe jesli mozesz'><br/>");
        }

        wr.append("<input type='submit' value='Wyslij'>");
        wr.append("</form>");
    }
}
