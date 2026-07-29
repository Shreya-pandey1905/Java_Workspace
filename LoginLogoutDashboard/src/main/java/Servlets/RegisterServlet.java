package Servlets;

import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mailing.Operation;
import util.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/html");

        String name = req.getParameter("name");
        String email= req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String hashedPassword= PasswordUtil.hash(password);


        UserDao.createUser(name, email,hashedPassword,gender,city);

        out.println(
                "<html>" +
                        "<body>" +
                        "<h1 style='color:green; text-align:center'>" + name +"  Registered successfully!!!!</h1>" +
                        "</body>" +
                        "</html"
        );
        String to= email;
        String subject= "Registration Successfull!! ";
        String message= "You are registered Successfully";
        try {
            Operation.sendMail(to, subject,message);
            resp.getWriter().println("Mail sent successfully");

        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Fail to send message");
        }

        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.include(req,resp);
    }
}
