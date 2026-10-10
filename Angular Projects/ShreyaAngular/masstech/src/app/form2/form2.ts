import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  imports: [ReactiveFormsModule, CommonModule],
  selector: 'app-form2',
  styleUrl: './form2.css',
  templateUrl: './form2.html',
})
export class Form2 {

  emps = new FormGroup({
    name: new FormControl(''),
    email: new FormControl('')
  });

  SaveData(data: any) {
    console.log(data);
  }
}