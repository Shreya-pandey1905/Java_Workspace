import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { email } from '@angular/forms/signals';
import e from 'express';
import { Employee } from '../app/models/employee';

@Service()
export class EmployeeService {
    private http = inject(HttpClient)

    private apiUrl = "http://localhost:8080/api/employees";

    // Get All Employees
    getEmployees():Observable<Employee[]>{
        return this.http.get<Employee[]>(this.apiUrl);
    }









    
    // Create Employee
    addEmployee(employee: Employee):Observable<Employee>{
        return this.http.post<Employee>(
            this.apiUrl,
            employee
        )
    }

    // Delete Employee
   deleteEmployee(id:number): Observable<void>{
        return this.http.delete<void>(`${this.apiUrl}/${id}`)
   }


}
