import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Form2 } from './form2/form2';

@Component({
  imports: [FormsModule,Form2],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('masstech');

//   fn:any;
//   sc:any;
//   ch:any;
//   res:any;


// calci() {

//     if (this.ch == '+') {
//      this.res=this.fn+this.sc;
//     } 
//     else if (this.ch == '-') {

//     this.res=this.fn-this.sc;
//     } 
//     else if (this.ch == '*') {
//      this.res=this.fn*this.sc;
//     }
//      else   {
//       this.res=this.fn/this.sc;
//     }

   
//   }


}
