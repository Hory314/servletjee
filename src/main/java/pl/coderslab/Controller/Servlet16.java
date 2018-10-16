package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalTime;

@WebServlet(name = "Servlet16", urlPatterns = {"/Servlet16"})
public class Servlet16 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String ip = request.getLocalAddr()+":"+request.getLocalPort();
        String browser = request.getHeader("User-Agent");
        String date = ""+LocalTime.now();

        Writer wr = response.getWriter();

        wr.append("IP: " + ip);
        wr.append("\nPrzeglądarka: " + browser);
        wr.append("\nCzas: " + date);
    }
}
