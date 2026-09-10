import { Pipe, PipeTransform } from '@angular/core';
import { last } from 'rxjs';

@Pipe({
  name: 'customFullN',
})
export class CustomFullNPipe implements PipeTransform {
  transform(value: string): unknown {
    const arr = value.split(' ');
const first=arr[0].charAt(0).toUpperCase();
const second= arr[1].charAt(0).toUpperCase();

return `${first}.${second}`;

 }
}
