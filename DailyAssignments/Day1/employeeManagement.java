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

    public static Employee addEmployee(int id,String name,String dept,int salary, LocalDate dateOfJoining){
		
		Employee e1 = new Employee(id,name,dept,salary,dateOfJoining);
		return e1;
		
	}

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

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("what you want to perform");
            System.out.println("press");
            System.out.println("1 for add Employee");
            System.out.println("2 fro show Employee");
            System.out.println("3 for update Employee");
            System.out.println("4 for delete Employee");
            int input = sc.nextInt();

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

                    break;
                }
                default:
                    System.out.println("enter valid option");
            }
        }
    }
}