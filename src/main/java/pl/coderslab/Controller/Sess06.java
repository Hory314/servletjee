package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

@WebServlet(name = "Sess06", urlPatterns = "/Sess06")
public class Sess06 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        try
        {
            HttpSession session = request.getSession();
            int number1 = (int)session.getAttribute("number1");
            int number2 = (int)session.getAttribute("number2");

            int addResult = Integer.parseInt(request.getParameter("add"));
            int subResult = Integer.parseInt(request.getParameter("sub"));
            int multResult = Integer.parseInt(request.getParameter("mult"));

            wr.append(number1 + " + " + number2 + " = " + addResult + " -> " + ((number1 + number2) == addResult ? "Correct" : "Wrong") + "<br>");
            wr.append(number1 + " - " + number2 + " = " + subResult + " -> " + ((number1 - number2) == subResult ? "Correct" : "Wrong") + "<br>");
            wr.append(number1 + " * " + number2 + " = " + multResult + " -> " + ((number1 * number2) == multResult ? "Correct" : "Wrong") + "<br>");
        }
        catch(NumberFormatException e)
        {
            System.err.println("Podane dane nie są liczbami.");
            wr.append("Podane dane nie są liczbami.");
            doGet(request, response);
        }
        catch(NullPointerException e)
        {
            System.err.println("Nie ma utworzonej sesji.");
            wr.append("Nie ma utworzonej sesji.");
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        Random generator = new Random();
        int rand1 = generator.nextInt(981) + 20; // [20 - 1000]
        int rand2 = generator.nextInt(981) + 20; // [20 - 1000]

        HttpSession session = request.getSession();
        session.setAttribute("number1", rand1);
        session.setAttribute("number2", rand2);

        wr.append("<form method='post'>");
        wr.append("<label>" + rand1 + " + " + rand2 + " = <input type='number' name='add'></label><br>");
        wr.append("<label>" + rand1 + " - " + rand2 + " = <input type='number' name='sub'></label><br>");
        wr.append("<label>" + rand1 + " * " + rand2 + " = <input type='number' name='mult'></label><br>");
        wr.append("<input type='submit'><br>");
        wr.append("</form>");
//todo 7 zad
    }
}
