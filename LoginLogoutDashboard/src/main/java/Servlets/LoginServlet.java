package Servlets;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/html");

        String email= req.getParameter("email");
        String password = req.getParameter("password");
        String hashedPassword= PasswordUtil.hash(password);


        try {
            UserDao.findbyNameAndPassword(email,hashedPassword);
            if (email!=null){

                HttpSession session = req.getSession();
                session.setAttribute("email_key",email);
//                out.println(
//                        "<html>" +
//                                "<body>" +
//                                "<h1 style='color:green; text-align:center'>" + email +"  Logged in successfully!!!!</h1>" +
//                                "</body>" +
//                                "</html"
//                );

                RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
                rd.include(req,resp);

            }else {
                out.println(
                        "<html>" +
                                "<body>" +
                                "<h1 style='color:red; text-align:center'>" + email +" Invalid Credentials!!!</h1>" +
                                "</body>" +
                                "</html"
                );

                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.include(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
