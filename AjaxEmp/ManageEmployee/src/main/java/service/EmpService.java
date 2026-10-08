package service;

import dao.EmpDAO;
import dto.EmpDto;
import dto.Employee;
import models.Manager;

import java.util.List;

public class EmpService {
	EmpDAO dao=new EmpDAO();
	
	public List<Manager> getManager(){
		return dao.getAllManagers();
	}
	
	public List<Employee> getAllEmployeeSalaryGetter(){
		
		return dao.getAllEmployee()
				.stream()
				.filter(emp -> emp.getSalary() >= 5000)
				.toList();
	}

	public List<Employee> searchEmployees(String name) {
		return dao.searchEmployees(name);
	}

	public void addEmp(EmpDto employee) {
		 dao.addEmployee(employee);
	}
	
	
}
