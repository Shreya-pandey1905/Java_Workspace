import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeForm } from './components/employee-form/employee-form';
import { EmployeeList } from './components/employee-list/employee-list';

import { Employee } from './models/employee';
import { EmployeeService } from '../services/employee-service';

@Component({
  imports: [RouterOutlet, EmployeeForm, EmployeeList],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('empManagement');
  private employeeService= inject(EmployeeService);

  employees = signal<Employee[]>([]);

  ngOnInit(){
    this.loadEmployees();
  }

    loadEmployees(){
    this.employeeService.getEmployees()
    
    .subscribe(data => {
      this.employees.set(data)
    })
  }
}
 