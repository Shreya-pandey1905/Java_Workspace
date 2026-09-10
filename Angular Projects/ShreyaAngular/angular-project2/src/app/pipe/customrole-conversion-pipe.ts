import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customroleConversion',
})
export class CustomroleConversionPipe implements PipeTransform {
  transform(value: string): unknown {
    switch(value){
      case "admin":
        return "Administrator";
      case "user":
        return "User";
      case "guest":
        return "Guest" 
    }
    return null;
  }

  
}
