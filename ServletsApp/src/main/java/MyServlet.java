import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("this is the first servlet");
    }

//    @Override
//    public void init() throws ServletException {
//        System.out.println("this is the init");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("this is the destroy");
//    }


    //        out.println
//                         ("<html>" +
//                        "<body>" +
//                        "<h1>Name : "+name+" Email: "+email+"</h1" +
//                        "></body>" +
//                        "</html>");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/html");

        String name = req.getParameter("name");
        String username = req.getParameter("uname");
        String password = req.getParameter("pwd");
        String hashedPass = PasswordHash.hash(password);


        UserDao.createUser(name, username, hashedPass);




    }
}
