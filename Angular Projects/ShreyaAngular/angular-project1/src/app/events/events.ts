import { Component, signal } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-events',
  styleUrl: './events.css',
  templateUrl: './events.html',
})
export class Events {
  counts=signal(0);
  // count1=10;

  // countIncre(){
  //   this.counts++;
  // }
  // countDecre(){
  //   this.count1--;
  // }

  countIncrement(){
    this.counts.update(c=>c+1);
  }

    countReset(){
    this.counts.update(c=>0);
  }
  username="";
  updateUsername(value:string){
    this.username=value;
  }


}
