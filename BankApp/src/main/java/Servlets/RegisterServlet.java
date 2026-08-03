    package Servlets;

    import dao.AuditDao;
    import jakarta.servlet.RequestDispatcher;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import model.Users;
    import service.AuthService;
    import util.PasswordHash;

    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.SQLException;
    import java.util.Random;
    import java.util.Scanner;

    @WebServlet("/register")
    public class RegisterServlet extends HttpServlet {
           public static String ifsc(String branch) {

            String ifscc= switch (branch) {
                case "Andheri" -> "ubin00122";
                case "Vasai" -> "ubin123";
                case "Churchgate" -> "ubin54555";
                default -> "Invalid choice";
            };
            return ifscc;
        }
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter out = resp.getWriter();
            resp.setContentType("Text/html");
            Random random = new Random();
            long AccountNo = random.nextLong(879598864);
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String bankBranch = req.getParameter("branch");
            String ifsccode =ifsc(bankBranch);

            Users user = null;
            try {
                user = AuthService.registerUser(name,email,password,bankBranch,AccountNo,ifsccode);
                AuditDao.create(user.getEmail(),"user signup","New user created");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            out.println(
                    "<html>" +
                            "<body>" +
                            "<h1 style='color:green; text-align:center'>" + name +"  Registered successfully!!!!</h1>" +
                            "</body>" +
                            "</html"
            );


            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req,resp);




        }
    }
