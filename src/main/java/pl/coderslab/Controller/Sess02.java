package pl.coderslab.Controller;

import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sess02", urlPatterns = "/Sess02")
public class Sess02 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        List<Double> grades = (List<Double>)session.getAttribute("grades");
        if(grades == null)
        {
            grades = new ArrayList<>();
        }

        try
        {
            double grade = Double.parseDouble(request.getParameter("grade"));
            if(grade<1 || grade >6)
            {
                throw new Exception("Podaj wartość miedzy 1 a 6");
            }
            grades.add(grade);
            session.setAttribute("grades", grades);
        }
        catch(Exception e)
        {
            response.getWriter().append("Wrong data "+e.getMessage());
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();
        HttpSession session = request.getSession();

        wr.append("<form method='post'>");
        wr.append("<input type='text' name='grade' placeholder='ocena'>");
        wr.append("<input type='submit'>");
        wr.append("<form>");

        List<Double> grades = (List<Double>)session.getAttribute("grades");
        if(grades != null)
        {
            double sum = 0.0;
            wr.append("<ul>");
            for(Double grade : grades)
            {
                sum += grade;
                wr.append("<li>" + grade + "</li>");
            }
            wr.append("</ul>");
            double avg = sum / grades.size();
            wr.append("<p>Średnia: " + avg + "</p>");
        }
    }
}
