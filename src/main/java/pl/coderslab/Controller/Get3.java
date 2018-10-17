package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Get3", urlPatterns = {"/Get3"})
public class Get3 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int width;
        int height;
        try
        {
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
        }
        catch(NumberFormatException e)
        {
            width = 5;
            height = 10;
        }

        Writer wr = response.getWriter();

        //wr.append(width + " "+ height + "");
        wr.append("<table>");

        for(int i = 1; i <= height; i++)
        {
            wr.append("<tr>");
            for(int j = 1; j <= width; j++)
            {
                //System.out.print(i*j);
                wr.append("<td>" + i * j + "</td>");
            }
            wr.append("</tr>");
        }


        // http://localhost:8080/Get3?width=20&height=25
    }
}
