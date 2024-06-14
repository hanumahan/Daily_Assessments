package week2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitorCounterServlet")
public class VisitorCounterServlet extends HttpServlet {
    private static int count = 0; // Static variable to store the count

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++; // Increment the visitor count on each visit
        request.setAttribute("visitorCount", count);
        request.getRequestDispatcher("visitorCounter.jsp").forward(request, response);
    }
}
