import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { CustomroleConversionPipe } from '../pipe/customrole-conversion-pipe';
import { CustomFullNPipe } from '../pipe/custom-full-n-pipe';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [CommonModule, CustomroleConversionPipe,CustomFullNPipe,FormsModule],
  selector: 'app-pipeline',
  styleUrl: './pipeline.css',
  templateUrl: './pipeline.html',
})
export class Pipeline {

  upper = "Shreya";
  lower = "Pandey";

  price = 87;
  perc = 0.88;

  objects ={
    name:"Shreya",
    age:67
  }


role="admin"
username=signal<string>('shreya')

// username="shreya";

fullName= "Shreya Pandey"



}

