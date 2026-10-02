package controllers;

import com.google.gson.Gson;
import dto.EmpDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmpService;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/EmpController")
public class EmpController extends HttpServlet {
	
	EmpService empservice1=new EmpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("getEmp".equals(action)) {

			var emps = empservice1.getAllEmployeeSalaryGetter();

			Gson gson = new Gson();
			String json = gson.toJson(emps);
			response.getWriter().write(json);
			return;
		}

		if ("searchEmployees".equals(action)) {

			String name = request.getParameter("name");
			var emps = empservice1.searchEmployees(name);
			Gson gson = new Gson();
			String json = gson.toJson(emps);
			response.getWriter().write(json);
			return;
		}
		if ("getManagers".equals(action)) {
			var managers = empservice1.getManager();
			Gson gson = new Gson();
			String json = gson.toJson(managers);
		    response.getWriter().write(json);
			return;
		}

		response.sendError(HttpServletResponse.SC_BAD_REQUEST,
				"Invalid or missing action");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noofrecords = Integer.parseInt(request.getParameter("noofrecord")); 
		if(noofrecords != 0) {
			
		}
		
		
		
		
		String name = request.getParameter("name");
		double salary= Double.parseDouble(request.getParameter("salary"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		System.out.println(name + salary + mid );
		if((name!= null|| !name.isBlank()) && salary>0) {
			EmpDto dto = new EmpDto();
			dto.setName(name);
			dto.setSalary(salary);
			dto.setmId(mid);
			empservice1.addEmp(dto);
			response.getWriter().write("<script> alert('Employee added')</script>");
	}
		doGet(request, response);
	}



	

}
