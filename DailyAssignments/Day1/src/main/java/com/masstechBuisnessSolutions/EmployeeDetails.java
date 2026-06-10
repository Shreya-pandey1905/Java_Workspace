package com.masstechBuisnessSolutions;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.math.BigInteger;
import java.time.LocalDate;

class EmployeeInformationSystem {

    int employeeId;
    String employeeName;
    String department;
    LocalDate dateOfJoining;
    BigInteger salary;

    public EmployeeInformationSystem(int employeeId, String employeeName, String department, LocalDate dateOfJoining, BigInteger salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "EmployeeInformationSystem{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {

        EmployeeInformationSystem emp = new EmployeeInformationSystem(1, "Jake Gyllenhaal", "IT", LocalDate.of(2026, 2, 2), BigInteger.valueOf(800000));
        System.out.println(emp);
    }
}


