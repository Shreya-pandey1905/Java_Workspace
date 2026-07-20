package org.example.SerializationAndDeseralization;

import java.io.IOException;
import java.io.Serializable;

public class Employee implements Serializable {

    int id;
    String name;
    double salary;

    public Employee( int id, String name,double salary) throws IOException {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
