
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
@MultipartConfig
@WebServlet("/fileUploadServlet")
public class FileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String path = req.getParameter("destination");
        Part filePart = req.getPart("file");
        String filename= filePart.getSubmittedFileName().toString();

        OutputStream outputStream=null;
        InputStream inputStream= null;

        try {
            outputStream = new FileOutputStream(path+File.separator+filename);
            inputStream=filePart.getInputStream();
            int read=0;
            byte [] b = new byte[1024];
            while ((read=inputStream.read(b))!=-1){
                outputStream.write(b,0,read);
            }
            out.println("file uploaded successfully");

        }catch (Exception e){
            System.out.println("File upload Failed");
        }
    }
}
