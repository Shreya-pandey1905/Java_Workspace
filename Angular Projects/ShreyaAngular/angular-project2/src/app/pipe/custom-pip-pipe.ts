import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customPip',
})
export class CustomPipPipe implements PipeTransform {
  transform(value: string): unknown {
   return value.split('').reverse().join();
  }
}
