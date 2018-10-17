package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "Post1", urlPatterns = {"/Post1"})
public class Post1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Writer wr = response.getWriter();
        wr.append("Witaj, ");
        wr.append(request.getParameter("name")+" "+request.getParameter("surname")+"!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().append("<a href='/index_1.html'>Formularz</a>");
    }
}
