package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@WebServlet(name = "Sess03_Add", urlPatterns = "/addToSession")
public class Sess03_Add extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String key = request.getParameter("key"); // biore z formularza
        String value = request.getParameter("value");
        
        session.setAttribute(key, value); // i dodaje klucz/wartosc do sesji
        doGet(request, response); // wyswietlam formularz jakby ktos chcial dodac wiecej
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        String form = "<form action=\"\" method=\"POST\">\n" + "    <label>\n" + "        Klucz:\n" + "        <input type=\"text\" name=\"key\">\n" + "    </label>\n" + "    <label>\n" + "        Wartość:\n" + "        <input type=\"text\" name=\"value\">\n" + "    </label>\n" + "    <input type=\"submit\">\n" + "</form>";

        wr.append(form + "");
        wr.append("<a href='/showAllSession'>zobacz klucze/wartosci</a>");

    }
}
