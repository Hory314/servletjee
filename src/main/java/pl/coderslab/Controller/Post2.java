package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post2", urlPatterns = {"/Post2"})
public class Post2 extends HttpServlet
{
    private String[] badwords = {"choler"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String text = request.getParameter("text");
        String accept = request.getParameter("accept");

        if(accept == null) // musze cenzurowac bo checkbox niezaznaczony
        {
            for(String word : this.badwords)
            {
                text = text.replaceAll(word, "*****");
            }
        }
        wr.append(text);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().append("<a href='/index_2.html'>Formularz</a>");
    }
}
