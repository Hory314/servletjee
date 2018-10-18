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

@WebServlet(name = "Sess05", urlPatterns = "/Sess05")
public class Sess05 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();
        try
        {
            HttpSession session = request.getSession();
            int captcha_answer = (int)session.getAttribute("captcha");
            int captcha_user = Integer.parseInt(request.getParameter("captcha"));
            if(captcha_answer == captcha_user)
            {
                wr.append("Weryfikacja ok");
            }
            else
            {
                response.getWriter().append("Niepoprawna odpowiedz captcha!");
            }
            session.setAttribute("captcha",-1); // zabezpieczenie przed cofaniem w przeglądarce
            // pokaze te same wylosowane liczby co przedtem ale w sesji zapiszemy bledna odpowiedz
            // wiec zawsze odrzuci odpowiedz usera (dopóki uczciwie nie odświeży)
        }
        catch(NumberFormatException e)
        {
            //e.printStackTrace();
            wr.append("Podana wartosc captcha nie jest liczbą");
        }
        catch(IOException e)
        {
            //e.printStackTrace();
            wr.append("IOException!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Writer wr = response.getWriter();

        Random generator = new Random();
        int rand1 = generator.nextInt(100) + 1; // od 1 do 100
        int rand2 = generator.nextInt(100) + 1;
        HttpSession session = request.getSession();
        session.setAttribute("captcha", (rand1 + rand2));


        String form = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n" + "</head>\n" + "<body>\n" + "<form action=\"/Sess05\" method=\"POST\">\n" + "    <label>\n" + "        imie:\n" + "        <input type=\"text\" name=\"name\">\n" + "    </label><br>\n" + "    <label>\n" + "        nazwisko:\n" + "        <input type=\"text\" name=\"surname\">\n" + "    </label><br>\n" + "    <label>\n" + "        email:\n" + "        <input type=\"email\" name=\"email\">\n" + "    </label><br>\n";
        String formCd = "<label>Wpisz wynik dzialania : " + rand1 + " + " + rand2 + "=<input type='number' name='captcha'></label><br><input type=\"submit\"></form></body>";

        wr.append(form + formCd);
    }
}
