import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "Counter Servlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    int counter = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String confirm = req.getParameter("reset");
        if (confirm != null) {
            counter = 1;
            out.println("<h1>Counter reset</h1>");
        } else {
            out.printf("<h1>%d</h1>", counter);
            counter++;
        }


    }
}
