package Servlets;

import dao.AuditDao;
import dao.UsersDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;
import service.AuthService;
import util.PasswordHash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/html");
        String email =req.getParameter("email");

        Users existingUser = null;
        try {
            existingUser = UsersDao.findByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (existingUser != null && existingUser.isUserLock()) {
            out.println(
                    "<html>" +
                            "<body>" +
                            "<h1 style='color:red; text-align:center'> Accoutn Locked!!!</h1>" +
                            "</body>" +
                            "</html"
            );
        }else {
            String password =req.getParameter("password");


            Users user = null;
            try {
                user = AuthService.loginUser(email, password);
                if (user == null) {
                    System.out.println("Invalid user credentials...");
                    AuditDao.create(email, "failed login", "User login failed");
                    out.println(
                            "<html>" +
                                    "<body>" +
                                    "<h1 style='color:red; text-align:center'> Invalid Credentials!!!</h1>" +
                                    "</body>" +
                                    "</html"
                    );

                    RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                    rd.include(req,resp);
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("name_key", user.getName());

                    RequestDispatcher rd = req.getRequestDispatcher("userDashboard.jsp");
                    rd.include(req,resp);
                    System.out.println("You are successfully logged in: " + user.getId());
                    AuditDao.create(user.getEmail(), "user login", "User logged in");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
