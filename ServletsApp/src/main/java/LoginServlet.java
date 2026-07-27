import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//import java.net.http.HttpClient;
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
                                "<h1 style='color:green; text-align:center'>" + namee +"  logged in successfully!!!!</h1>" +
                                "</body>" +
                                "</html"
                );
                req.setAttribute("name_key",namee);
                RequestDispatcher rd1= req.getRequestDispatcher("profile.jsp");
                rd1.forward(req,resp);
            }else {
                out.println("   <h3 style='color:red; text-align:center'>Invalid Credentials</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//                rd.forward(req,resp);---> this will not take a message while forwardinign
                rd.include(req,resp);


            }
         } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
    }
}
