import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        System.out.println("login servlet is runnign");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out= resp.getWriter();
        resp.setContentType("Text/html");
        String username = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String hashedPass = PasswordHash.hash(password);
         try {
            String namee= UserDao.findbyNameAndPassword(username,hashedPass);
            if (namee!=null){
                out.println(
                        "<html>" +
                                "<body>" +
                                "<h1> login " + namee + "successfylly!!!!</h1>" +
                                "</body>" +
                                "</html"
                );         }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
    }
}
