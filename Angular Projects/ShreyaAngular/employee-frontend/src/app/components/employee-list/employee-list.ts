import { Component, input, output } from '@angular/core';
import { Employee } from '../../models/employee';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-employee-list',
  styleUrl: './employee-list.css',
  templateUrl: './employee-list.html',
})
export class EmployeeList {
  employees = input.required<Employee[]>();







  
  deleteRequested = output<number>();

  deleteEmployee(id: number){
    this.deleteRequested.emit(id);
  }
  

}
