package controller;

import Repo.IempService;
import Service.EmpService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.emp;

import java.io.IOException;
import java.util.List;


@WebServlet("/emp")

public class empServlet extends HttpServlet {


    private IempService employeeService = new EmpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<emp> emps = employeeService.getAllEmp();
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if ("add".equals(action)) {

       String eName = req.getParameter("eName");
       double esal = Double.parseDouble(req.getParameter("esal"));
       int mid = Integer.parseInt(req.getParameter("mid"));

           emp employee = new emp(0, eName, esal, mid);
           employeeService.addEmp(employee);



            resp.sendRedirect("emp");



        }

    }
}
