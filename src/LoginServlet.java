import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        if (username.equals("Vamshi") && password.equals("1234")) {
            HttpSession session = request.getSession();
            Integer count = (Integer) session.getAttribute("loginCount");
            
            if (count == null) {
                count = 1;
            } else {
                count += 1;
            }

            session.setAttribute("loginCount", count);
            session.setAttribute("username", username);

            out.println(username);
            out.println("<p>User logged in to the website " + count + " time</p>");
        } else {
            out.println("<h3>Invalid username or password</h3>");
        }
    }
}
