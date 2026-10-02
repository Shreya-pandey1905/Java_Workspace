import { Component, inject, output } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Employee } from '../../models/employee';
import { EmployeeService } from '../../../services/employee-service';

@Component({
  imports: [ReactiveFormsModule],
  selector: 'app-employee-form',
  styleUrl: './employee-form.css',
  templateUrl: './employee-form.html',
})
export class EmployeeForm {

  private fb = inject(FormBuilder);

  private employeeService = inject(EmployeeService);

  employeeAdded = output<Employee>()

  employeeForm = this.fb.group({
    name: ['',[Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    department: ['', [Validators.required, Validators.minLength(2)]]
  })

  onSubmit(){
    if(this.employeeForm.invalid){
      return;
    }

    const employee: Employee = {
      name: this.employeeForm.value.name!,
      email: this.employeeForm.value.email!,
      department: this.employeeForm.value.department!
    }

    this.employeeService.addEmployee(employee).subscribe(savedEmployee => {
      this.employeeAdded.emit(savedEmployee);
      this.employeeForm.reset();
    })
  }
}
