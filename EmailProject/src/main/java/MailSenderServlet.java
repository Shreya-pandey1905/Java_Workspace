import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sendmail")

public class MailSenderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to= req.getParameter("to");
        String subject= req.getParameter("subject");
        String message= req.getParameter("message");
        try {
            Operation.sendMail(to, subject,message);
            resp.getWriter().println("Mail sen  t successfully");
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Fail to send message");
        }

    }
}
