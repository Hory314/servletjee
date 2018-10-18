package pl.coderslab.Controller;

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

@WebServlet(name = "Sess04", urlPatterns = "/Sess04")
public class Sess04 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart"); // z sesji
        String name = request.getParameter("name"); // z pól formularza
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        if(cart == null)
        {
            cart = new ArrayList<>();
        }

        CartItem item = new CartItem(name, quantity, price);
        cart.add(item);

        session.setAttribute("cart", cart);

        doGet(request, response); // wyswietl koszyk
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();
        HttpSession session = request.getSession();

        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
        double total = 0.0;
        if(cart != null)
        {
            for(CartItem item : cart)
            {
                double price = item.getPrice();
                int quantity = item.getQuantity();
                wr.append(item.getName() + " - " + quantity + " x " + price + " = " + (price * quantity) + "<br>");
                total += (quantity * price);
            }
            wr.append("Do zapłaty: " + total + "<br>");
        }
        else
        {
            wr.append("Koszyk jest pusty<br>");
        }

        wr.append("<a href='/index_sess_04.html'>Dodaj kolejną rzecz do koszyka</a>");
    }
}
