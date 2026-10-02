import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../Service/auth-service';

export const coursesGuard: CanActivateFn = (route, state) => {

  const authservice= inject(AuthService);
 const router= inject(Router);
 if(authservice.isLoggedIn()){
  return true;
 }

  return false;
};
