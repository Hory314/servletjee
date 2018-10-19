package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc14", urlPatterns = "/Mvc14")
public class Mvc14 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String title = request.getParameter("title1");
        String author = request.getParameter("author1");
        String isbn = request.getParameter("isbn1");
        Book book1 = new Book(title, author, isbn);
        title = request.getParameter("title2");
        author = request.getParameter("author2");
        isbn = request.getParameter("isbn2");
        Book book2 = new Book(title, author, isbn);
        title = request.getParameter("title3");
        author = request.getParameter("author3");
        isbn = request.getParameter("isbn3");
        Book book3 = new Book(title, author, isbn);
        title = request.getParameter("title4");
        author = request.getParameter("author4");
        isbn = request.getParameter("isbn4");
        Book book4 = new Book(title, author, isbn);
        title = request.getParameter("title5");
        author = request.getParameter("author5");
        isbn = request.getParameter("isbn5");
        Book book5 = new Book(title, author, isbn);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/views/form14.jsp").forward(request, response);
    }
}
