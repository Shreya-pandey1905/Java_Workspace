package repo;

import dto.EmpDto;
import dto.Employee;
import models.Manager;

import java.util.List;

public interface IEmpService {
	
	void addEmployee(EmpDto employee);
	List<Manager> getManager();
	//void connectionCheck();
	List<Employee> getAllEmployee();
	
	

}