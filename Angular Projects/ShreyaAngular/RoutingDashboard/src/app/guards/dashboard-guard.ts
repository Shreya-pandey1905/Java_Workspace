import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';
import { inject } from '@angular/core';
import { AuthService } from '../Service/auth-service';

export const dashboardGuard: CanActivateFn = (route, state) => {

const authservice= inject(AuthService);
 const router= inject(Router);
 if(authservice.isLoggedIn()){
  return true;
 }



      return router.createUrlTree(['/login']);
};
