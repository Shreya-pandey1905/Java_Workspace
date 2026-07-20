package org.example;

import java.io.IOException;
import java.io.Serializable;

public class Employee2 implements Serializable {


    String name;

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    int id;
    double salary;

    public Employee2(String name, int id, double salary) throws IOException {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


}
