import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private String dept;
    private int salary;
    private LocalDate dataOfJoining;

    public Employee(int id, String name, String dept, int salary, LocalDate dataOfJoining) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.dataOfJoining = dataOfJoining;
    }

    public int getId() {
        return id;
    }
	
	public int getSalary() {
		return salary;
	}

	public LocalDate getDateOfJoining() {
		return dataOfJoining;
	}
    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
	

    public String toString() {
        return "id= " + id + " name= " + name + " dept= " + dept + " salary= " + salary + " dataofjoining= " + dataOfJoining;
    }
}

public class employeeManagement {
	
	//add Employee

    public static Employee addEmployee(int id,String name,String dept,int salary, LocalDate dateOfJoining){
		
		Employee e1 = new Employee(id,name,dept,salary,dateOfJoining);
		return e1;
		
	}

//update employee
    public static void updateEmployee(
            List<Employee> list,
            int id,
            int salary) {
        for (Employee emp : list) {
            if (emp.getId() == id) {
                emp.setSalary(salary);

                break;
            }
        }
    }

//delete employee
    public static void deleteEmployee(List<Employee> list, int id) {
        Employee empToRemove = null;

        for (Employee emp : list) {
            if (emp.getId() == id) {
                empToRemove = emp;
                break;
            }
        }

        list.remove(empToRemove);
    }
	
	//search by id 
	
	public static Employee searchEmployeeById(
        List<Employee> list,
        int id) {

    for (Employee emp : list) {
        if (emp.getId() == id) {
            return emp;
        }
    }

    return null;
	
	
}

//get highest paid employee
	public static Employee highestPaidEmployee(
        List<Employee> list) {

			

				Employee highest = list.get(0);

				for (Employee emp : list) {

					if (emp.getSalary() > highest.getSalary()) {
						highest = emp;
					}
				}

				return highest;
			}

	//search by doj
			
	public static void searchByDOJ(
			List<Employee> list,
			LocalDate doj) {

		boolean found = false;

		for (Employee emp : list) {

			if (emp.getDateOfJoining().equals(doj)) {
				System.out.println(emp);
				found = true;
			}
		}

	
	}		
	
	//sort by Salaary
	public static void sortBySalary(
				List<Employee> list) {

			list.sort(
					(e1, e2) ->
							e1.getSalary()
							- e2.getSalary());

			System.out.println(list);
		}
		
	//sort by DOJ	
	public static void sortByJoiningDate(
        List<Employee> list) {

			list.sort(
				(e1, e2) ->
				e1.getDateOfJoining()
				.compareTo(
					e2.getDateOfJoining()
				)
			);

			System.out.println(list);
		}


    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
		int input;
        do {
			
            System.out.println("what you want to perform");
            System.out.println("press");
            System.out.println("1 for add Employee");
            System.out.println("2 fro show Employee");
            System.out.println("3 for update Employee");
            System.out.println("4 for delete Employee");
			System.out.println("5 for searching Employee by id");
			System.out.println("6 for Highest Paid Employee");
			System.out.println("7 for Search By DOJ");
			System.out.println("8 for Sort By Salary");
			System.out.println( "9 for Sort By Joining Date");
			System.out.println( "10 for Exit");

             input = sc.nextInt();

            switch (input) {
                case 1: {
                    System.out.println("enter id:");
                    int id = sc.nextInt();
                    System.out.println("enter name");
                    String name = sc.next();
                    System.out.println("enter department");
                    String dept = sc.next();
                    System.out.println("enter salary");
                    int salary = sc.nextInt();
                    System.out.println("enter date of joining in yyyy-mm-dd format");
                    String inputdate = sc.next();
                    LocalDate dataOfJoining = LocalDate.parse(inputdate);

                    list.add(addEmployee(id, name, dept, salary, dataOfJoining));
                    break;
                }
                case 2: {
                    System.out.println(list);
                    break;

                }
                case 3: {
                    System.out.println("Enter Employee Id");
                    int id = sc.nextInt();

                    System.out.println("Enter New Salary");
                    int salary = sc.nextInt();

                    updateEmployee(list, id, salary);

                    break;
                }
                case 4: {
                    System.out.println("Enter Employee Id");
                    int id = sc.nextInt();

                    deleteEmployee(list, id);
					  System.out.println("Employee data is ddeleted");

                    break;
                }
				
				case 5: {

				System.out.println("Enter Employee Id");
				int id = sc.nextInt();

				Employee emp = searchEmployeeById(list, id);

				if (emp != null) {
					System.out.println(emp);
				} else {
					System.out.println(" Not Found");
				}

				break;
			}
			
			case 6: {

				Employee highest = highestPaidEmployee(list);
			    System.out.println("Highest paid employee is: " + highest);


				break;
			}
			
			case 7: {

				System.out.println(
					"Enter DOJ (yyyy-mm-dd)");

				String inputDate = sc.next();

				LocalDate doj =
						LocalDate.parse(inputDate);

				searchByDOJ(list, doj);

				break;
			}
			
			case 8: {

				sortBySalary(list);

				break;
			}
			
			case 9: {

				sortByJoiningDate(list);

				break;
			}
			
			case 10:
			{
				System.out.println("Thank you for using our system, ");
				break;
			}
						
			
			
                default:
				{
					System.out.println("enter valid option");
				}
                    
            }
		}while(input!=10);
        
    }
}
