import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule, CommonModule],
  selector: 'app-forms',
  styleUrl: './forms.css',
  templateUrl: './forms.html',
})
export class Forms {
  SaveEmp(data:any){
    console.log(data)
  }
}
