import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-pipes',
  styleUrl: './pipes.css',
  templateUrl: './pipes.html',
})
export class Pipes {
  name="jake";
  dt= new Date();
  amt=100;

  arrobj=[
    {id:101,name:'JAKE',salary:50000},
     {id:102,name:'Megan',salary:60000},
      {id:103,name:'HENRY',salary:30000},
    
  ]
}
