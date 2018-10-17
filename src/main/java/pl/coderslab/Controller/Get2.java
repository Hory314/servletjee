package pl.coderslab.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get2", urlPatterns = {"/Get2"})
public class Get2 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Writer wr = response.getWriter();

        // http://localhost:8080/Get2?array=1&array=2&array=3&array=4&param2=qwer&array=test&param2=name&test=ok        Map<String, String[]> paramsMap = request.getParameterMap();
        Map<String, String[]> paramsMap = request.getParameterMap();
        Set<String> params = paramsMap.keySet();
        for(String param : params)
        {
            String[] valuesArr = paramsMap.get(param);
            for(String val : valuesArr)
            {
                wr.append(param + " = " + val + "<br>");
            }
        }
    }
}
