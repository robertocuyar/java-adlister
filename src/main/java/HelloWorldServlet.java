import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet (name = "HelloWorld Servlet", urlPatterns = "/hello")
//public class HelloWorldServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        String name = req.getParameter("name");
//        if(name != null){
//            name = name.substring(0,1).toUpperCase() + name.substring(1);
//            out.println("<h1> Hello " + name + "!</h1>");
//        } else {
//            out.println("<h1> Hello World!</h1>");
//        }
//    }
//}
@WebServlet (name = "HelloWorld Servlet", urlPatterns = "/count")
public class HelloWorldServlet extends HttpServlet {
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


