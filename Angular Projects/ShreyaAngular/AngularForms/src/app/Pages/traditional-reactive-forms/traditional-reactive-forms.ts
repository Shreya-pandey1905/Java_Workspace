import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { email } from '@angular/forms/signals';

@Component({
  imports: [ReactiveFormsModule],
  selector: 'app-traditional-reactive-forms',
  styleUrl: './traditional-reactive-forms.css',
  templateUrl: './traditional-reactive-forms.html',
})
export class TraditionalReactiveForms {
  fb= inject(FormBuilder);
  studentForm= this.fb.group({
    name: [
        '',
    [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(20),
     ]
    ],
    email:[
      '',
      [Validators.required,
      Validators.email]
    ],
    password:[
      '',
      
      [Validators.required,
      Validators.minLength(6)
    ]
      
    ]
  
  
  });
}
