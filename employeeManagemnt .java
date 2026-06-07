class EmployeeManagement{

	
	public int id ;
	public String name ;
	private int salary
	public date dateOfJoining ;
	private String Departments;
	
	public EmployeeManagement(int id , String name , int salary ,int dateOfJoining,String Departments){
		this.id=id;
		this.name = name;
		this.salary=salary;
		this.dateOfJoining=dateOfJoining;
		this.Departments=Departments;
	}



    
}

class Main{

public static void main(String[]args){
	
	EmployeeManagement emp1 = new EmployeeManagement(1,"Jake",5000,"02-02-2026","IT");
	
	 Hashmap<EmployeeManagement> ob = new HashMap<>();
	 
	 map.add (emp1);
	 
	
	
}

}