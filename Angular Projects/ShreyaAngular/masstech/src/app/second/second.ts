import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-second',
  styleUrl: './second.css',
  templateUrl: './second.html',
})
export class Second {
  block= false;
  arrobj=[
    {id:101,name:'JAKE',salary:50000},
     {id:102,name:'Megan',salary:60000},
      {id:103,name:'HENRY',salary:30000},
    
  ]
}
